package org.effrefax.challenge;

import static org.effrefax.challenge.util.ComparatorFactory.naturalOrder;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.effrefax.challenge.tree.Leaf;
import org.effrefax.challenge.tree.SortTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SortTreeTest<T extends Comparable<T>> {

	private final Class<T> aClass;
	private final Comparator<T> naturalOrder;
	private final List<T> expected;

	public SortTreeTest(Class<T> aClass, T[] expected) {
		this.aClass = aClass;
		this.naturalOrder = naturalOrder(aClass);
		this.expected = Arrays.asList(expected);
	}

	@Test
	public void shouldCreateCorrectSortTree() {
		SortTree<T> tree = new Leaf<T>(naturalOrder);
		List<T> actual = new ArrayList<T>();

		for(T word : expected) {
			tree = tree.add(word);
		}
		tree.collect(actual);

		Collections.sort(expected, naturalOrder);
		assertEquals(expected, actual);
	}

	@Parameters
	public static Collection<Object[]> data() {
		List<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[]{String.class, new String[]{}});
		data.add(new Object[]{String.class, new String[]{"a"}});
		data.add(new Object[]{String.class, new String[]{"b"}});
		data.add(new Object[]{String.class, new String[]{"a", "b"}});
		data.add(new Object[]{String.class, new String[]{"b", "a"}});
		data.add(new Object[]{String.class, new String[]{"a", "b", "c"}});
		data.add(new Object[]{String.class, new String[]{"a", "c", "b"}});
		data.add(new Object[]{String.class, new String[]{"b", "a", "c"}});
		data.add(new Object[]{String.class, new String[]{"b", "c", "a"}});
		data.add(new Object[]{String.class, new String[]{"c", "a", "b"}});
		data.add(new Object[]{String.class, new String[]{"c", "b", "a"}});
		return data;

	}

}
