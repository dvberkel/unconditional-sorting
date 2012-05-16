package org.effrefax.challenge.tree;

import java.util.Comparator;
import java.util.List;

public class Leaf<T> implements SortTree<T> {

	private final Comparator<T> comparator;

	public Leaf(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public SortTree<T> add(T word) {
		return new Root<T>(comparator, word);
	}

	@Override
	public void collect(List<T> aList) {
		// Do nothing
	}
}
