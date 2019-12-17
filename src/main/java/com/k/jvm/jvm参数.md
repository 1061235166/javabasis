- -Xmx 
> 堆内存最大大小

- -Xms
> 堆内存初始化大小

- Xmn
> 年轻代大小

- MaxPermSize
> 持久代最大大小，1.8取消了持久代，用元空间代替了

- MaxTenuringThreshold
> 晋升到老年代需要被gc的次数

- Xss
> 线程大小

- AutoBoxCacheMax
> integer缓存大小

- -XX:+PrintStringTableStatistics
> 打印观察字符串常量池

- 类加载7个步骤
>加载（Loading)
>>默认都是懒加载,即到了使用的时候才会加载到内存,一般都是遇到几个关键字的时候才会去加载,
 验证（Verification）
 准备（Preparation）
 解析（Resolution）
 初始化（Initialization）
 使用（Using）
 卸载（Unloading）

> 具体可看 https://github.com/TangBean/understanding-the-jvm

>内存泄漏和内存溢出
>>泄漏,对象在虚拟机中可达,但是一直没有被使用到,也不会被回收,一直占着内存
>>溢出,堆内存溢出,创建对象时可用内存不够,导致无法分配对象储存空间,需要调整-xmx和-xms的值
栈内存溢出,
方法区和运行时常量池溢出:增加元数据空间大小

>OutOfMemoryError（在虚拟机栈可以动态扩展的情况下，扩展时无法申请到足够的内存）；
>所以说内存溢出不会影响到以前程序的执行,而是程序可能无法正常处理相应的请求