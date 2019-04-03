package com.onemile.bms.datasource.annotation;

import java.lang.annotation.*;

/**
 * @author Eric
 * 切换数据源
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface SwitchDs {
    DbMsEnum ms() default DbMsEnum.BMS;
}
