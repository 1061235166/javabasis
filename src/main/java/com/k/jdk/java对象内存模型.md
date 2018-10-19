- 内存模型抽象

- 重排序
>编译器，cpu等为了提高代码执行效率的一种手段

- 内存屏障 

- happens before规则
>一个操作的结果要对另一个操作可见，可以在不同线程，也能在一个线程

>程序顺序规则：一个线程中的每个操作，happens-before 于该线程中的任意后续操作。

>监视器锁规则：对一个监视器的解锁，happens-before 于随后对这个监视器的加锁。

>volatile 变量规则：对一个 volatile 域的写，happens-before 于任意后续对这个 volatile 域的读。

>传递性：如果 A happens-before B，且 B happens-before C，那么 A happens-before C。

-  数据依赖性
>

- AS-IF-SERIAL 语义
>在单线程中，不管怎么重排序，程序的执行结果不能被改变

- 顺序一致性
>一个线程中的所有操作必须按照程序的顺序来执行。
 
>（不管程序是否同步）所有线程都只能看到一个单一的操作执行顺序。在顺序一致性内存模型中，每个操作都必须原子执行且立刻对所有线程可见。


- volatile语义


- 锁的实现

- final


-多线程同步的几种方法
>1.synchrozied关键字和可JUC的可重入锁
>2.volatile关键字
>3.threadlocal
