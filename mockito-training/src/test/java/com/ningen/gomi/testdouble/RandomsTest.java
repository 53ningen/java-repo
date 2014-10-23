package com.ningen.gomi.testdouble;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandomsTest {

    @Test
    public void choiceをAで返すスタブを用いたテスト() throws Exception {
        List<String> options = new ArrayList<String>();
        options.add("a");
        options.add("b");
        Randoms sut = new Randoms();

        // inject stab
        sut.randomNumberGenerator = new RandomNumbergeneratorFixedResultStub();

        assertThat(sut.choice(options), is("b"));
    }

    @Test
    public void choiceをAで返す匿名クラスでスタブを注入したテスト() throws Exception {
        List<String> options = new ArrayList<String>();
        options.add("a");
        options.add("b");
        Randoms sut = new Randoms();

        // inject stab
        sut.randomNumberGenerator = new RandomNumberGeneratorImpl() {
            @Override
            public int nextInt() {
                return 0;
            }
        };

        assertThat(sut.choice(options), is("a"));
    }

}