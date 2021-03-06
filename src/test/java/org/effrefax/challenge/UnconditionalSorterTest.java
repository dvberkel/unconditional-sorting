package org.effrefax.challenge;

import static org.effrefax.challenge.util.ComparatorFactory.naturalOrder;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UnconditionalSorterTest<U extends Comparable<U>> {
	private final Comparator<U> naturalOrder;
	private final List<U> expected;

	public UnconditionalSorterTest(Class<U> aClass, U[] expected) {
		this.naturalOrder = naturalOrder(aClass);
		this.expected = Arrays.asList(expected);
	}

	@Test
	public void shouldCorrectlySortStrings() {
		Sorter<U> sorter = new UnconditionalSorter<U>(naturalOrder);

		List<U> actual = sorter.sort(expected);

		Collections.sort(expected, naturalOrder);
		assertEquals(expected, actual);
	}

	@Parameters
	public static Collection<Object[]> data() {
		List<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[]{String.class, new String[]{"a", "b"}});
		data.add(new Object[]{String.class, new String[]{"b", "a"}});
		data.add(new Object[]{String.class, new String[]{"a", "b", "c"}});
		data.add(new Object[]{String.class, new String[]{"a", "c", "b"}});
		data.add(new Object[]{String.class, new String[]{"b", "a", "c"}});
		data.add(new Object[]{String.class, new String[]{"b", "c", "a"}});
		data.add(new Object[]{String.class, new String[]{"c", "a", "b"}});
		data.add(new Object[]{String.class, new String[]{"c", "b", "a"}});
		data.add(new Object[]{Integer.class, new Integer[]{0, 1}});
		data.add(new Object[]{Integer.class, new Integer[]{1, 0}});
		data.add(new Object[]{Integer.class, new Integer[]{0, 1, 2}});
		data.add(new Object[]{Integer.class, new Integer[]{0, 2, 1}});
		data.add(new Object[]{Integer.class, new Integer[]{1, 0, 2}});
		data.add(new Object[]{Integer.class, new Integer[]{1, 2, 0}});
		data.add(new Object[]{Integer.class, new Integer[]{2, 0, 1}});
		data.add(new Object[]{Integer.class, new Integer[]{2, 1, 0}});
		return data;

	}
}
