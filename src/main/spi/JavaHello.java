package spi;

/**
 * @author chuanyin.li
 * @create 2019-01-22 4:41 PM
 **/
public class JavaHello implements HelloInterface{
    @Override
    public void sayHello() {
        System.out.println("java say hello!");
    }
}
