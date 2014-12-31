package com.ningen.gomi.automaton;

public interface State {
    default boolean isAcceptState() {
        return false;
    }
}
