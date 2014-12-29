package com.ningen.gomi.automaton.dfa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DFA {
    
    private State state;
    final private Set<State> acceptState;
    final private RuleBook rules;
    public DFA(State startState, Set<State> acceptState, RuleBook rules) {
        this.state = startState;
        this.acceptState = acceptState;
        this.rules = rules;
    }
    
    public DFA input(char character) {
        state = rules.next(state, character).orElseThrow(IllegalArgumentException::new);
        return this;
    } 
    
    public State getState() {
        return state;
    }
    
    public boolean isAcceptState() {
        return acceptState.contains(state);
    }
    
    static class RuleBook {
        
        Set<Rule> rules = new HashSet<>();
        public RuleBook setRule(Rule rule) {
            rules.add(rule);
            return this;
        }
        
        public Optional<State> next(State state, char character) {
            return rules.stream().filter(r -> r.isApplicableTo(state, character)).map(Rule::next).findFirst();
        }
        
    }
    
    static class Rule {
        final private State state;
        final private char character;
        final private State nextState;
        
        public Rule(State state, char character, State nextState) {
            this.state = state;
            this.character = character;
            this.nextState = nextState;
        }
        
        public State next() {
            return nextState;
        }
        
        public boolean isApplicableTo(State state, char character) { 
            return this.state.equals(state) && this.character == character;
        }
        
        @Override
        public String toString() {
            return String.format("{Rule: %s -- %s --> %s}", state, character, nextState);
        }
    } 
    
    static enum State {
        ON,
        OFF
    }
}
