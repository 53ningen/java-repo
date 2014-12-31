package com.ningen.gomi.automaton;

public class Rule<T> {
    final private State state;
    final private T input;
    final private State nextState;
    public Rule(State state, T input, State nextState) {
        this.state = state;
        this.input = input;
        this.nextState = nextState;
    }

    public State next() {
        return nextState;
    }

    public boolean isApplicableTo(State state, T input) {
        return this.state.equals(state) && this.input.equals(input);
    }

    @Override
    public String toString() {
        return String.format("{Rule: %s -- %s --> %s}", state, input, nextState);
    }
}
