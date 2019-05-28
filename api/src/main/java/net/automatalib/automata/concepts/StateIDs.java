/* Copyright (C) 2013-2019 TU Dortmund
 * This file is part of AutomataLib, http://www.automatalib.net/.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.automatalib.automata.concepts;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * An interface for translating between automaton states and their primitive representations as integers.
 *
 * @param <S>
 *         state type of the automaton
 */
@ParametersAreNonnullByDefault
public interface StateIDs<S> {

    /**
     * Returns for a given state of the automaton an integer uniquely identifying the state.
     *
     * @param state
     *         the state whose id should be retrieved
     *
     * @return the (positive) id of the given automaton state. May return a negative value, if {@code state} does not
     * belong to the automaton.
     */
    int getStateId(S state);

    /**
     * Return for a given id the state of the automaton identified by it.
     *
     * @param id
     *         the id of the state to be returned
     *
     * @return the automaton state identified by the given {@code id}. May return {@code null} if the given {@code id}
     * does not identify a state of the automaton.
     */
    S getState(int id);
}

