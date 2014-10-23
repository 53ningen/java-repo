package com.ningen.gomi.googleguice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.logging.Logger;

import static org.mockito.Mockito.when;

public class NumbersTest {

    Logger logger = Logger.getLogger(NumbersTest.class.getName());

    @Mock
    private NumberGenerator numberGenerator;

    @InjectMocks
    private Numbers numbers;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void NumberGeneratorが使える() throws Exception {

        when(numberGenerator.nextInt()).thenReturn(0);

        Integer num = numbers.getInt();
        logger.info(num.toString());
    }

}
