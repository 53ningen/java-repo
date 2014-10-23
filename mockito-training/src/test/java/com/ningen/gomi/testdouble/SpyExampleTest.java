package com.ningen.gomi.testdouble;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpyExampleTest {

    @Test
    public void SpyLoggerを利用したテスト() {
        SpyExample sut = new SpyExample();
        SpyLogger spy = new SpyLogger(sut.logger);
        sut.logger = spy;
        sut.doSomething();
        assertThat(spy.log.toString(), is("doSomething"));
    }

}