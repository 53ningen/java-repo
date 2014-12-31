package com.ningen.gomi.automaton.nfa;

import com.ningen.gomi.automaton.RuleBook;
import com.ningen.gomi.automaton.State;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NFA<T> {
    final private State state;
    final private RuleBook<T> ruleBook;
    public NFA(State startState, RuleBook<T> ruleBook) {
        this.state = startState;
        this.ruleBook = ruleBook;
    }
    
    public boolean isAcceptable(List<T> inputs) {
        Set<State> states = new HashSet<>();
        states.add(state);
        for(T i: inputs)
            states = getNextStates(states, i);
        return states.stream().anyMatch(State::isAcceptState);
    }
    
    public Set<State> getNextStates(final Set<State> states, final T input) {
        return states.stream().map(s -> ruleBook.next(s, input)).reduce((x, y) -> {x.addAll(y); return x;}).get();
    }
}
