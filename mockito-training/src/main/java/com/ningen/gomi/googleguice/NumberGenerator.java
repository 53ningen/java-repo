package com.ningen.gomi.googleguice;

import com.google.inject.ImplementedBy;

/**
 * hoge.
 */
@ImplementedBy(NumberGeneratorImpl.class)
public interface NumberGenerator {

    /**
     * hoge.
     * @return hoge
     */
    int nextInt();

}
