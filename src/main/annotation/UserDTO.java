package annotation;

/**
 * @author chuanyin.li
 * @create 2019-02-12 10:22 AM
 **/
public class UserDTO {

    @AnnotationConfig(description = "年龄",notNull = true)
    private String name;

    @AnnotationConfig(description = "年龄", max = "150", min = "1",notNull = false)
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
