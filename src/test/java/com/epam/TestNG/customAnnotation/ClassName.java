package com.epam.TestNG.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Mariya_Belemenko on 6/23/2016.
 */

@Target({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ClassName {
}
