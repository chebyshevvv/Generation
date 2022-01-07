package com.chebyshev.generation.factory;

import com.chebyshev.generation.scanner.TableScanner;

/**
 * @author zwk
 * @date 2022/1/5
 * @description TODO
 **/
public interface TableScannerFactory {
    TableScanner createScanner();
}
