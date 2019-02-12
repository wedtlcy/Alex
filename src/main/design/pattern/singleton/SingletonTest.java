package design.pattern.singleton;

/**
 * 懒汉单例模式test
 * @author chuanyin.li
 * @create 2019-01-22 5:48 PM
 **/
public class SingletonTest {

    public static void main(String[] args) {
        OkHttpSingleton1 okHttpSingleton1 = OkHttpSingleton1.getInstance();
        OkHttpSingleton2 okHttpSingleton2 = OkHttpSingleton2.getInstance();
        System.out.println("懒汉单例模式test!");
    }
}
