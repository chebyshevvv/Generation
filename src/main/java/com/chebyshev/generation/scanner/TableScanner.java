package com.chebyshev.generation.scanner;

/**
 * @author zwk
 * @date 2022/1/5
 * @description TODO
 **/
public interface TableScanner {
    Class[] scanClassInPackage(String... packagePath);
}
