https://segmentfault.com/a/1190000003063859
- 阻塞IO
    内核写数据，写完了之后用户读数据都被阻塞
    https://segmentfault.com/img/bVm1c3
- 非阻塞IO
    用户需要不断向内核查询数据是否好了没有
- IO多路复用
    当用户进程调用了select，那么整个进程会被block
    内核会监视所有select管理的线程，任意一个线程处于就读状态，select就能返回，
    相当于一个select用来管理多个socket，java NIO就是这样
    
-   异步 I/O
    