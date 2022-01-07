package com.chebyshev.generation.factory;

import com.chebyshev.generation.resolver.TableResolver;

/**
 * @author zwk
 * @date 2022/1/5
 * @description TODO
 **/
public interface TableResolverFactory {
    TableResolver createResolver(Class clazz);
}
