package com.ningen.gomi.googleguice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import org.junit.Test;

import java.util.logging.Logger;

public class Numbers2Test {

    Logger logger = Logger.getLogger(Numbers2Test.class.getName());

    @Test
    public void 正しくNumbergeneratorImplがInject出来ているか() throws Exception {

        Injector injector = Guice.createInjector(Stage.PRODUCTION);
        Numbers nums = injector.getInstance(Numbers.class);
        Integer num = nums.getInt();
        logger.info(num.toString());

    }

}
