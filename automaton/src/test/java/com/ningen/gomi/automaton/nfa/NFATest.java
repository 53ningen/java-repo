package com.ningen.gomi.automaton.nfa;

import com.ningen.gomi.automaton.Rule;
import com.ningen.gomi.automaton.RuleBook;
import com.ningen.gomi.automaton.State;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NFATest {
    static enum NFAState implements State {
        ONE,
        TWO,
        THREE {
            @Override
            public boolean isAcceptState() {
                return true;
            }
        }
    }
    final RuleBook<Character> rules = new RuleBook<>();
    final NFA<Character> nfa = new NFA<>(NFAState.ONE, rules);
    @Before
    public void before() {
        rules.setRule(new Rule<>(NFAState.ONE, '0', NFAState.ONE));
        rules.setRule(new Rule<>(NFAState.ONE, '1', NFAState.ONE));
        rules.setRule(new Rule<>(NFAState.ONE, '1', NFAState.TWO));
        rules.setRule(new Rule<>(NFAState.TWO, '0', NFAState.THREE));
        rules.setRule(new Rule<>(NFAState.TWO, '1', NFAState.THREE));
    }
    
    @Test
    public void NFASample10Test() {
        final List<Character> input = Stream.of('1', '0').collect(Collectors.toList());
        assertThat(nfa.isAcceptable(input), is(true));
    }
    @Test
    public void NFASample00010Test() {
        final List<Character> input = Stream.of('0', '0', '0', '1', '0').collect(Collectors.toList());
        assertThat(nfa.isAcceptable(input), is(true));
    }
    @Test
    public void NFASample01010101010Test() {
        final List<Character> input = Stream.of('0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0').collect(Collectors.toList());
        assertThat(nfa.isAcceptable(input), is(true));
    }
    @Test
    public void NFASample01Test() {
        final List<Character> input = Stream.of('0', '1').collect(Collectors.toList());
        assertThat(nfa.isAcceptable(input), is(false));
    }
    @Test
    public void NFASample1001Test() {
        final List<Character> input = Stream.of('1', '0', '0', '1').collect(Collectors.toList());
        assertThat(nfa.isAcceptable(input), is(false));
    }
}
