package annotation;

import java.lang.reflect.Field;

/**
 * 注解测试
 *
 * @author chuanyin.li
 * @create 2019-02-12 10:26 AM
 **/
public class AnnotationTest {

    public static void main(String[] args) {
        Field[] fields = UserDTO.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {

        }
        for (Field field : fields) {
            String fieldName = field.getName();
            AnnotationConfig annotationConfig = field.getAnnotation(AnnotationConfig.class);
            if(annotationConfig == null){
                return;
            }

            String desc = annotationConfig.description();
            String max = annotationConfig.max();
            String min = annotationConfig.min();
            boolean notNull = annotationConfig.notNull();
            System.out.println(String.format("fieldName=%s,desc=%s,max=%s,min=%s,notNull=%s",fieldName,desc,max,min,notNull));

        }
    }
}
