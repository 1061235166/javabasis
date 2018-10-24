- aspejctj
>在编译的时候生成了一个被增强的新类，一般都是使用java命令让其生成一个新的类

- springAOP
> 首先要在配置文件引入<aop:aspectj-autoproxy/>标签开启springaop，
springaop分为两种，一种是动态代理，一种是cglib。动态代理是使用Invocationhandler，因此实现增强类需要提供接口，但是cglib不需要
<aop:aspectj-autoproxy proxy-target-class="true"/>开启cglib代理
- cglib
>动态修改字节码。