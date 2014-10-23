package com.ningen.gomi.testdouble;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class RandomsMockitoTest {

    @Mock
    private List<String> ops;

    @Mock
    private RandomNumberGenerator randomNumberGenerator;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void choiceでAを返すMockitoを用いたテスト() throws Exception {

        List<String> options = new ArrayList<String>();
        options.add("a");
        options.add("b");
        Randoms sut = new Randoms();

        RandomNumberGenerator generator = Mockito.mock(RandomNumberGenerator.class);
        when(generator.nextInt()).thenReturn(0);
        sut.randomNumberGenerator = generator;

        assertThat(sut.choice(options), is("a"));
        verify(sut.randomNumberGenerator).nextInt();
    }

    @Test
    public void choiceでAを返すMockitoを用いたテスト2() throws Exception {

        List<String> options = new ArrayList<String>();
        options.add("a");
        options.add("b");
        Randoms sut = new Randoms();

        RandomNumberGenerator generator = spy(new RandomNumberGeneratorImpl());
        when(generator.nextInt()).thenReturn(0);
        sut.randomNumberGenerator = generator;

        assertThat(sut.choice(options), is("a"));
        verify(sut.randomNumberGenerator).nextInt();

    }

    @Test
    public void choiceでAを返すMockitoを用いたテストwithMockアノテーション() throws Exception {

        when(ops.get(0)).thenReturn("a");
        when(ops.get(1)).thenReturn("b");
        when(ops.size()).thenReturn(2);
        when(randomNumberGenerator.nextInt()).thenReturn(0);

        Randoms sut = new Randoms();
        sut.randomNumberGenerator = randomNumberGenerator;

        assertThat(sut.choice(ops), is("a"));

    }

}
