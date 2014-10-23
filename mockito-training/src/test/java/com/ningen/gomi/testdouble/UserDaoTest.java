package com.ningen.gomi.testdouble;

import org.junit.Test;

public class UserDaoTest {

    UserDao dao = new UserDaoStab();

    @Test(expected = IllegalArgumentException.class)
    public void ユーザーが存在しないときに例外を投げる() throws Exception {
        dao.find("hogehoge");
    }

}