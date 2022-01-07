package com.chebyshev.generation.factory;

import com.chebyshev.generation.scanner.ColumnScanner;

/**
 * @author zwk
 * @date 2022/1/5
 * @description TODO
 **/
public interface ColumnScannerFactory {
    ColumnScanner createScanner();
}
