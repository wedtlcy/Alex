package design.pattern.singleton;

/**
 * 懒汉单例模块 - 静态内部类法
 * OkHttp静态Singleton
 *
 * @author chuanyin.li
 * @create 2019-01-22 5:32 PM
 **/
public class OkHttpSingleton1 {

    private OkHttpSingleton1() {
    }

    private static class Hodler{
        public static OkHttpSingleton1 okHttpSingleton1 = new OkHttpSingleton1();
    }

    public static OkHttpSingleton1 getInstance(){
        System.out.println("懒汉单例模块 - 静态内部类法");
        return Hodler.okHttpSingleton1;
    }
}
