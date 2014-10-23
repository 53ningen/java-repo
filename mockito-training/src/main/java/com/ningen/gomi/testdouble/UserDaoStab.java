package com.ningen.gomi.testdouble;

public class UserDaoStab implements UserDao {

    @Override
    public User find(String userId) throws IllegalArgumentException {
        throw new IllegalArgumentException("指定されたuserId:" + userId + "に該当するユーザーは存在しません");
    }
}
