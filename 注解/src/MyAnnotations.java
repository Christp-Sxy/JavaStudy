import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @param
 * @author Christp
 * @Description
 * @date 15:12 2021/9/14
 * @return
 **/

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    MyAnnotation[] value();
}
