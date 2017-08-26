/* Copyright (C) 2013-2017 TU Dortmund
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
package net.automatalib.commons.util.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AllTuplesTest {

    private static final List<Integer> domain = Arrays.asList(1, 2, 3, 7);

    @Test
    public static void testEmptyDomain() {
        int count = count(CollectionsUtil.allTuples(Collections.emptySet(), 1), null);
        Assert.assertEquals(count, 0);

        count = count(CollectionsUtil.allTuples(Collections.emptySet(), 0), null);
        Assert.assertEquals(count, 1);

        count = count(CollectionsUtil.allTuples(Collections.emptySet(), 0, 5), null);
        Assert.assertEquals(count, 1);
    }

    private static int count(Iterable<? extends List<?>> iterable, Set<Object> distinct) {
        if (distinct != null) {
            distinct.clear();
        }
        Iterator<? extends List<?>> it = iterable.iterator();
        int count = 0;
        while (it.hasNext()) {
            count++;
            List<?> l = it.next();
            if (distinct != null) {
                distinct.add(new ArrayList<Object>(l));
            }
        }
        return count;
    }

    @Test
    public static void testAllTuples() {
        int count = count(CollectionsUtil.allTuples(domain, 0), null);
        Assert.assertEquals(count, 1);

        Set<Object> set = new HashSet<>();
        count = count(CollectionsUtil.allTuples(domain, 1), set);
        Assert.assertEquals(count, domain.size());
        Assert.assertEquals(set.size(), count);

        count = count(CollectionsUtil.allTuples(domain, 0, 1), set);
        Assert.assertEquals(count, domain.size() + 1);
        Assert.assertEquals(set.size(), count);

        count = count(CollectionsUtil.allTuples(domain, 3), set);
        Assert.assertEquals(count, (int) Math.pow(domain.size(), 3));
        Assert.assertEquals(set.size(), count);

        for (List<?> lst : CollectionsUtil.allTuples(domain, 3)) {
            Assert.assertEquals(lst.size(), 3);
        }
    }
}