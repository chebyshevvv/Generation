package com.chebyshev.generation.factory;

import com.chebyshev.generation.resolver.ColumnResolver;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author zwk
 * @date 2022/1/5
 * @description TODO
 **/
public interface ColumnResolverFactory {
    List<ColumnResolver> createResolver(Field[] fields);
}
