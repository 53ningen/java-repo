package com.ningen.gomi.testdouble;

public interface UserDao {
    User find(String userId) throws IllegalArgumentException;
}
