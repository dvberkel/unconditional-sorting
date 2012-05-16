package org.effrefax.challenge.util;

import java.util.Comparator;

public class ComparatorFactory {
	public static <U extends Comparable<U>> Comparator<U> naturalOrder(Class<U> aClass) {
		return new Comparator<U>() {
			@Override
			public int compare(U o1, U o2) {
				return o1.compareTo(o2);
			}
		};
	}
}
