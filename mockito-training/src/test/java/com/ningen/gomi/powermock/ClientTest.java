package com.ningen.gomi.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Static.class)
public class ClientTest {
    
    Client client;

    @Test
    public void clientMockStaticTest() {
        PowerMockito.mockStatic(Static.class);
        Mockito.when(Static.getInstance()).thenReturn(new Static() {
            @Override public String sayHello() {
                return "hello, work!";
            }

        });

        client = new Client();
        assertThat(client.getMessage(), is("hello, work!"));
    }

    @Test
    public void clientTest() {
        PowerMockito.mockStatic(Static.class);
        Mockito.when(Static.getInstance()).thenReturn(new Static());
        client = new Client();
        assertThat(client.getMessage(), is("hello, work!"));
    }
}
