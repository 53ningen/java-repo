package com.ningen.gomi.googleguice;

import com.google.inject.Inject;

public class Numbers {

    @Inject
    NumberGenerator numberGenerator;

    public int getInt() {
        return numberGenerator.nextInt();
    }

}
