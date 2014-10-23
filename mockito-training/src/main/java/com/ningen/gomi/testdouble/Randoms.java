package com.ningen.gomi.testdouble;

import java.util.List;

public class Randoms {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

    public <T> T choice(List<T> options) {
        if(options.size() == 0) return null;
        int index = randomNumberGenerator.nextInt() % options.size();
        return options.get(index);
    }
}
