#Design pattern

##Flyweight

Java中的String和Integer类都是享元模式的应用的例子，String类内部对所有的字符串对象进行缓存，相同的字符串在内存中只会保留一个版本。

###参考实现

Integer的缓存
类似的，Integer类在内部对小于255的整数也进行了缓存。

为提高效率，JDK将[-128,127]之间的这些常用的int值的Integer对象进行了缓存。

这是通过一个静态内部类来实现的。代码如下：

private static class IntegerCache {
    private IntegerCache(){}

    static final Integer cache[] = new Integer[-(-128) + 127 + 1];

    static {
        for(int i = 0; i < cache.length; i++)
        cache[i] = new Integer(i - 128);
    }
}