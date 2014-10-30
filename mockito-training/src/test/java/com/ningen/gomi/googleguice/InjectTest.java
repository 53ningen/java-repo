package com.ningen.gomi.googleguice;

import com.google.inject.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 3種類のInjection方法を理解する
 */
public class InjectTest {

    @Inject
    private Speaker john;

    @Inject
    private Speaker ken;

    @Test
    public void 基本的なインジェクション() throws Exception {
        Injector injector = Guice.createInjector();
        InjectTest injectTest = injector.getInstance(InjectTest.class);
        assertThat(injectTest.john.getHello(), is("Hello"));
    }

    @Test
    public void InjectorにModuleを渡してインターフェースの実装を指定する() throws Exception {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Speaker.class).to(Japanese.class);
            }
        });
        InjectTest injectTest = injector.getInstance(InjectTest.class);
        assertThat(injectTest.john.getHello(), is("こんにちは"));
    }

    @Test
    public void mockのresetの挙動を確認する() throws Exception {
        Speaker speaker = mock(Speaker.class);
        when(speaker.getHello()).thenReturn("Hola!");
        assertThat(speaker.getHello(), is("Hola!"));

        reset(speaker);
        assertThat(speaker.getHello(), is(nullValue()));
    }

    @Inject
    private String getHello(Speaker speaker) {
        return speaker.getHello();
    }

}

@ImplementedBy(English.class)
interface Speaker {

    public String getHello();

}

class Japanese implements Speaker {

    @Override
    public String getHello() {
        return "こんにちは";
    }

}

class English implements Speaker {

    @Override
    public String getHello() {
        return "Hello";
    }

}
