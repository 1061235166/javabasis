> mysql自增长主键

> redis incrBy

> 雪花算法 snowFlake

41-bit的时间可以表示（1L<<41）/(1000L*3600*24*365)=69年的时间，10-bit机器可以分别表示1024台机器。如果我们对IDC划分有需求，还可以将10-bit分5-bit给IDC，分5-bit给工作机器。这样就可以表示32个IDC，每个IDC下可以有32台机器，可以根据自身需求定义。12个自增序列号可以表示2^12个ID，理论上snowflake方案的QPS约为409.6w/s，这种分配方式可以保证在任何一个IDC的任何一台机器在任意毫秒内生成的ID都是不同的。

这种方式的优缺点是：

优点：

毫秒数在高位，自增序列在低位，整个ID都是趋势递增的。
不依赖数据库等第三方系统，以服务的方式部署，稳定性更高，生成ID的性能也是非常高的。
可以根据自身业务特性分配bit位，非常灵活。

![雪花算法](snowflake.png)

> 美团 leaf

> 百度的雪花算法变种

以上几个都是能保证自增长的，也就是至少都是long的返回类型


>mongodb ObjectId

>java UUID

以上都是字符串类型的


https://mp.weixin.qq.com/s?__biz=MzI3MDI5MjI1Nw==&mid=2247483838&idx=1&sn=b225a433d4cfe96db4e4b9fee95eeea7