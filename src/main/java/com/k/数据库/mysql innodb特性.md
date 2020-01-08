
FEDERATED	NO	Federated MySQL storage engine			
MRG_MYISAM	YES	Collection of identical MyISAM tables	NO	NO	NO
MyISAM	YES	MyISAM storage engine	NO	NO	NO
BLACKHOLE	YES	/dev/null storage engine (anything you write to it disappears)	NO	NO	NO
CSV	YES	CSV storage engine	NO	NO	NO
MEMORY	YES	Hash based, stored in memory, useful for temporary tables	NO	NO	NO
ARCHIVE	YES	Archive storage engine	NO	NO	NO
InnoDB	DEFAULT	Supports transactions, row-level locking, and foreign keys	YES	YES	YES
PERFORMANCE_SCHEMA	YES	Performance Schema	NO	NO	NO

show engins
只有innodb支持事务，xa（全局事务管理）,行级锁，外键，savepoint安全点，这也是mysql默认引擎
当然还有mvcc的支持(multiverion concurrecy control)多版本并发控制

关于mvcc

对于事务操作，只有在完成数据变更后才会写入bin_log
事务是由redolog和undolog完成的
- redolog:记录了事务完成后被变更的数据的值(来记录已成功提交事务的修改信息，并且会把redo log持久化到磁盘)
- 所以redo log是用来恢复数据的 用于保障已提交事务的持久化特性。
- undolog:记录了本次事务失败前被变更数据的值(是用来回滚数据的用于保障 未提交事务的原子性)

资料：https://dwz.cn/Fv0zvGEL

脏读 幻读等概念

脏读（Dirty read）: 当一个事务正在访问数据并且对数据进行了修改，而这种修改还没有提交到数据库中，这时另外一个事务也访问了这个数据，然后使用了这个数据。因为这个数据是还没有提交的数据，那么另外一个事务读到的这个数据是“脏数据”，依据“脏数据”所做的操作可能是不正确的。

丢失修改（Lost to modify）: 指在一个事务读取一个数据时，另外一个事务也访问了该数据，那么在第一个事务中修改了这个数据后，第二个事务也修改了这个数据。这样第一个事务内的修改结果就被丢失，因此称为丢失修改。 例如：事务1读取某表中的数据A=20，事务2也读取A=20，事务1修改A=A-1，事务2也修改A=A-1，最终结果A=19，事务1的修改被丢失。

不可重复读（Unrepeatableread）: 指在一个事务内多次读同一数据。在这个事务还没有结束时，另一个事务也访问该数据。那么，在第一个事务中的两次读数据之间，由于第二个事务的修改导致第一个事务两次读取的数据可能不太一样。这就发生了在一个事务内两次读到的数据是不一样的情况，因此称为不可重复读。

幻读（Phantom read）: 幻读与不可重复读类似。它发生在一个事务（T1）读取了几行数据，接着另一个并发事务（T2）插入了一些数据时。在随后的查询中，第一个事务（T1）就会发现多了一些原本不存在的记录，就好像发生了幻觉一样，所以称为幻读。


本出发点是想讲一下Mysql的事务的实现原理。

实现事务采取了哪些技术以及思想？

原子性：使用 undo log ，从而达到回滚

持久性：使用 redo log，从而达到故障后恢复

隔离性：使用锁以及MVCC,运用的优化思想有读写分离，读读并行，读写并行

一致性：过回通滚，以及恢复，和在并发环境下的隔离做到一致性。

innodb的锁
record lock：记录锁，锁定单行
gap lock:间隙锁，锁定一定范围的数据，不包含记录本身
next-key lock:记录锁和间隙锁的一个整合，锁定一定范围的数据，包含记录自己


MVCC比单纯的加锁更高效;MVCC只在 READ COMMITTED 和 REPEATABLE READ 两个隔离级别下工作;MVCC可以使用 乐观(optimistic)锁 和 悲观(pessimistic)锁来实现;各数据库中MVCC实现并不统一。推荐阅读：MySQL-InnoDB-MVCC多版本并发控制
https://segmentfault.com/a/1190000012650596

READ-UNCOMMITTED(读取未提交)： 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读。

READ-COMMITTED(读取已提交)： 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生。

REPEATABLE-READ(可重复读)： 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生。

SERIALIZABLE(可串行化)： 最高的隔离级别，完全服从ACID的隔离级别。所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。