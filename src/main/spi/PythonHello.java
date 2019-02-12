package spi;

/**
 * @author chuanyin.li
 * @create 2019-01-22 4:41 PM
 **/
public class PythonHello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("python say hello!");
    }
}
