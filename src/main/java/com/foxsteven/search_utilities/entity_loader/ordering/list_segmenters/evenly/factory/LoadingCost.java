package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LoadingCost {
    int value() default 1;
}
