#类锁的介绍

##偏向锁/轻量级锁/重量级锁
>synchronized的偏向锁、轻量级锁以及重量级锁是通过Java对象头实现的。
博主在Java对象大小内幕浅析中提到了Java对象的内存布局分为：对象头、实例数据和对齐填充，
而对象头又可以分为”Mark Word”和类型指针klass。”Mark Word”是关键，默认情况下，其存储对象的HashCode、分代年龄和锁标记位。


##锁种类

- 阻塞锁 
>synchronized，同步块，同一时间只能有一个线程进入同步块，可以锁定对象和类，也可以修饰在方法上，修饰在静态方法上锁定一个类，修饰在成员方法上锁定当前对象

>reentrantlock，可重入锁，手动调用lock和unlock用来加锁解锁
    
- 自旋锁
> CAS，compare and swap

##公平锁和非公平锁

##锁消除,锁粗化


##共享锁，独占锁
>共享锁允许同一个时间有个多个线程进入临界区域，比如reentrantreadwritelock
>独占锁同一个时间只能有一个线程进入临界区域，比如reentrantlock


##可重入锁
>synchronized，同步块自带可重入功能，一个线程可以尝试获取多次锁。

>java JUC的reentrantlock，一个线程可以尝试获取多次锁，每次获取后value会加一，释放锁value减一

##悲观锁和乐观锁
>悲观锁认为每次都会有其他线程来竞争资源，所以每次都给资源上锁。
乐观锁认为每次都只有他自己一个线程尝试获取锁，就采用无锁的方式获取资源，比如使用CAS方法获取资源

##死锁
>两个线程尝试同时获取或释放同一把锁，可能会造成死锁