package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent { //MyIncludeComponent 얘가 붙은 건 ComponentScan에 추가할 거야!

}
