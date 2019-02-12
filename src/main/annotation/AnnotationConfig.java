package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解实现
 *
 * @author chuanyin.li
 * @create 2019-02-12 10:15 AM
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationConfig {

    String description() default "";

    Class type() default String.class;

    String min() default "";

    String max() default "";

    boolean notNull() default true;
}
