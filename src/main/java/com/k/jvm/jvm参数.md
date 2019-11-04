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

- 类加载7个步骤
>加载（Loading）
 验证（Verification）
 准备（Preparation）
 解析（Resolution）
 初始化（Initialization）
 使用（Using）
 卸载（Unloading）

> 具体可看 https://github.com/TangBean/understanding-the-jvm