SPI 简介SPI 全称为 (Service Provider Interface) ,是JDK内置的一种服务提供发现机制。 
目前有不少框架用它来做服务的扩展发现， 简单来说，它就是一种动态替换发现的机制， 
举个例子来说， 有个接口，想运行时动态的给它添加实现，你只需要添加一个实现，
通过一个简单例子来说明SPI是如何使用的。 首先通过一张图来看看，用SPI需要遵循哪些规范，
因为spi毕竟是JDK的一种标准。





而后，把新加的实现，描述给JDK知道就行啦（通过改一个文本文件即可）公司内部，
目前Dubbo框架就基于SPI机制提供扩展功能。





我们首先需要一个目录，META-INF\services 如下，最终的目录路径就像这样：





文件名字为 
接口/抽象类： 全名 文件内容： 接口/抽象类 
实现类就像这样：com.spi.impl.TextHellocom.chaochao.spi.impl.ImageHello





实现类：





最后，来看看，如果使用SPI机制，客户端代码：最后的输出：Text Hello.Image Hello。dubbo的扩展机制和java的SPI机制非常相似，但是又增加了如下功能：1 可以方便的获取某一个想要的扩展实现，java的SPI机制就没有提供这样的功能2 对于扩展实现IOC依赖注入功能：举例来说：接口A，实现者A1、A2。接口B，实现者B1、B2。现在实现者A1含有setB()方法，会自动注入一个接口B的实现者，此时注入B1还是B2呢？都不是，而是注入一个动态生成的接口B的实现者B$Adpative，该实现者能够根据参数的不同，自动引用B1或者B2来完成相应的功能3 对扩展采用装饰器模式进行功能增强，类似AOP实现的功能





以下面的例子为例来分析下：





其中Protocol接口定义如下：





对应的实现者如下：ExtensionLoader中含有一个静态属性：ConcurrentMap, ExtensionLoader>EXTENSION_LOADERS = new ConcurrentHashMap, ExtensionLoader>();用于缓存所有的扩展加载实例，这里加载Protocol.class，就以Protocol.class为key，创建的ExtensionLoader为value存储到上述EXTENSION_LOADERS中这里没有进行任何的加载操作。我们来看下，ExtensionLoader实例是如何来加载Protocol的实现类的：1 先解析Protocol上的Extension注解的name,存至String cachedDefaultName属性中，作为默认的实现2 到类路径下的加载 META-INF/services/com.alibaba.dubbo.rpc.Protocol文件
