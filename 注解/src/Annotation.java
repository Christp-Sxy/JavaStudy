/**
 * @author Christp
 * @version 1.0
 * @ClassName Annotation
 * @Description TODO
 * @date 2021/9/14 14:23
 */

/*
 * 一、自定义注解
     * 参照@SuppressWarning
     * ① 注解声明为@interface
     * ② 内部定义成员，通常用value表示
     * ③ 可以指定成员的默认值，使用default定义
     * ④ 如果自定义注解没有成员，表明是一个表示作用
 *
 * 如果注解有成员，在使用注解时，需要指定成员的值
 * 自定义注解通常都会制定两个元注解：Retention和Target
 *
 * 二、jdk提供的4种元注解
 * 元注解：对现有的注解进行解释说明的注解
     * ① Retention：用于指定所修饰的Annotation的生命周期：SOURCE/CLASS(默认行为)/RUNTIME
     *              只有通过RUNTIME生命周期的注解，才能通过反射获取
     * ② Target：用于指定所修饰的Annotation能用于修饰哪些元素
     * ③ Documented：用于指定所修饰的Annotation的Annotation将被javadoc提取成文档，通常javadoc是不包含注解的（将在结息时保留下来）
     * ④ Inherited：被它修饰的Annotation将具有继承性。如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注解
  *
  * 三、通过反射获取注解信息
  *
  * 四、jdk 8的新特性：可重复注解、类型注解
    * ① 可重复注解：1.在MyAnnotation上声明@Reperatable,成员值为MyAnnotations.class
                  2.MyAnnotation的@Retention和@Target等元注解与MyAnnotations相同
    * ② 类型注解：1.ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如泛型变量）
    *            2.ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中
*/

@MyAnnotation
public class Annotation {

}