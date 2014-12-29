package com.ningen.gomi.automaton.dfa;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DFATest {
    
    @Test
    public void DFASampleTest() {
        final DFA.RuleBook rules = new DFA.RuleBook();
        rules.setRule(new DFA.Rule(DFA.State.OFF, '1', DFA.State.ON)).setRule(new DFA.Rule(DFA.State.OFF, '0', DFA.State.OFF));
        rules.setRule(new DFA.Rule(DFA.State.ON, '1', DFA.State.ON)).setRule(new DFA.Rule(DFA.State.ON, '0', DFA.State.OFF));

        final Set<DFA.State> acceptStates = new HashSet<>();
        acceptStates.add(DFA.State.ON);
        final DFA automaton = new DFA(DFA.State.OFF, acceptStates, rules);
        
        automaton.input('0');
        assertThat(automaton.getState(), is(DFA.State.OFF));
        assertThat(automaton.isAcceptState(), is(false));

        automaton.input('1');
        assertThat(automaton.getState(), is(DFA.State.ON));
        assertThat(automaton.isAcceptState(), is(true));
    }
}
