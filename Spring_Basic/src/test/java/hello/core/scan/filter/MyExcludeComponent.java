package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent { //MyIncludeComponent 얘가 붙은 건 ComponentScan에서 제외할 거야!

}
