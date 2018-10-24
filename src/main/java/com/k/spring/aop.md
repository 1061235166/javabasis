- aspejctj
>在编译的时候生成了一个被增强的新类，一般都是使用java命令让其生成一个新的类

- springAOP
> 首先要在配置文件引入<aop:aspectj-autoproxy/>标签开启springaop，
如果使用了@Aspectj注解，就会使用aspejctj来生成代理，如果被增强类使用了接口，会切换成jdk动态代理来实现aop
也可以使用 <aop:aspectj-autoproxy proxy-target-class="true"/> 开启cglib代理

- cglib
> 动态修改字节码，属于动态代理，不需要接口就能生成增强类