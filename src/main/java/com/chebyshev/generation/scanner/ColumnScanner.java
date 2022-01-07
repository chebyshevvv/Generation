package com.chebyshev.generation.scanner;

import java.lang.reflect.Field;

/**
 * @author zwk
 * @date 2022/1/5
 * @description TODO
 **/
public interface ColumnScanner {
    Field[] scannFieldInClass(Class clazz);
}
