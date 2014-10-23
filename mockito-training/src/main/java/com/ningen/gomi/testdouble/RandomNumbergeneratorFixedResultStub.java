package com.ningen.gomi.testdouble;

public class RandomNumbergeneratorFixedResultStub implements RandomNumberGenerator {
    @Override
    public int nextInt() {
        return 1;
    }
}
