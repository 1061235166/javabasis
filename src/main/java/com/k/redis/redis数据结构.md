- string
>字符串，最基本的数据类型，

- list
> 列表，能够从左右插入删除元素，还支持阻塞插入删除

- map，散列表 
>和java的hashmap类似，只能存字符串
 

- set，无序set
>就是map的一个实现，key相当于map的key，value是null


- zset 有序set
>存数据的时候可以指定一个分值，可以通过分值的从大到小进行排序


- hyperhyperlog
>用来对数据进去去重，然后进行不同数据的聚合统计，好处是占用空间小，缺点是有0.81%的统计误差
用法就是pfadd和pfcount这两个api，用来添加数据和统计数据
pfmerge可以把两个hll数据的结果合并到一起


- bitmap
>操作对应的数据类型就是字符串，可以用过getbit和setbit操作每一个位上的数据（0和1）

- geo
>用来将某个经纬度经过计算转换成一维整数的过程，它只是一个普通的 zset 结构。

- redis的事务
>redis的事务是先执行指令后执行日志，执行之后不知道执行前的数据，如果失败的话没法回滚的
在事务中有多条指令执行，如果其中一条报错，后面的还会继续执行，所以无法被称为原子性（要么全部成功，要么全部失败）'\n'
 discard指令用于丢弃exec之前的所有指令，相当于multi和exec之间什么都没发生过

- bloom filter
>布隆姆过滤器，用于检测一个元素是否在一个集合中，优点是空间效率和查询时间都远远超过一般算法，缺点是有一定的误识别率和
删除困难


- Redis 为何这么快？聊聊它的数据结构~
>https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247486329&idx=1&sn=4af604d616d05000fa875e4c482def3d&chksm=fa4974c8cd3efdde4959c9e0f8db12b2ebc463881c0cc299cfdb0091bd60a0ef65ec30d19540&mpshare=1&scene=1&srcid=0219BapddIgoAPhfuOt95xJJ&key=7c2de03dd17390135495118cf5998bb3ce40417f95ff7d1111b74d4fac4da32d7a15a31b5b6f36cc04542740214c31e38e6b434ad8534a420f13e886c9e4e90200f324f9b189d807ac263063c45efc7c&ascene=1&uin=MTg1ODkzNTkyMg%3D%3D&devicetype=Windows+10&version=62060720&lang=zh_CN&pass_ticket=knJbPBc4GZv2kKCeqJXP1TfbvJqC5BYkIo8nu2NfzFRvMdXsSyoteARFuiQ8KkKy

- 老钱的redis基础数据结构
>https://juejin.im/post/5b53ee7e5188251aaa2d2e16

- redis为什么那么快
>1.大多数操作都是在内存里完成,而且redis是一个key-value类似于hashmap的结构,增删改查复杂度都是O(1),
>2.是单线程,没有加锁解锁,切换上下文的开销
>3.