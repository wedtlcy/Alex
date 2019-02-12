package design.pattern.singleton;

/**
 *
 * 懒汉单例模块 - 兼顾线程安全和效率的写法
 *
 * @author chuanyin.li
 * @create 2019-01-22 5:40 PM
 **/
public class OkHttpSingleton2 {

    private static volatile OkHttpSingleton2 okHttpSingleton2 = null;

    private OkHttpSingleton2() {
    }

    public static OkHttpSingleton2 getInstance(){
        if(okHttpSingleton2 == null){
            synchronized (OkHttpSingleton2.class){
                if(okHttpSingleton2 == null){
                    okHttpSingleton2 = new OkHttpSingleton2();
                }
            }
        }
        System.out.println("懒汉单例模块 - 兼顾线程安全和效率的写法");
        return okHttpSingleton2;
    }
}
