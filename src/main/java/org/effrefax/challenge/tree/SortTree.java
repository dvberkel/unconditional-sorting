package org.effrefax.challenge.tree;

import java.util.List;

public interface SortTree<T> {

	public SortTree<T> add(T word);
	public void collect(List<T> aList);
}
