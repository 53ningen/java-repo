package com.ningen.gomi.googleguice;

import com.google.inject.ImplementedBy;

@ImplementedBy(NumberGeneratorImpl.class)
public interface NumberGenerator {

    public int nextInt();

}
