package com.ningen.gomi.testdouble;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandomsMockTest {

    @Test
    public void choiceでAを返す() throws Exception {
        List<String> options = new ArrayList<String>();
        options.add("a");
        options.add("b");
        Randoms sut = new Randoms();

        // mock
        final AtomicBoolean isCallNextIntMethod = new AtomicBoolean(false);
        sut.randomNumberGenerator = new RandomNumberGenerator() {
            @Override
            public int nextInt() {
                isCallNextIntMethod.set(true);
                return 0;
            }
        };

        assertThat(sut.choice(options), is("a"));
        assertThat(isCallNextIntMethod.get(), is(true));
    }

}