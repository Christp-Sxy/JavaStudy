import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* @author Christp
* @Description
* @date 15:12 2021/9/14
* @param
* @return
**/

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    MyAnnotation[] value();
}
