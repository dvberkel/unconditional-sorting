package org.effrefax.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.effrefax.challenge.tree.Leaf;
import org.effrefax.challenge.tree.SortTree;

public class UnconditionalSorter<T> implements Sorter<T> {

	private final Comparator<T> comparator;

	public UnconditionalSorter(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public List<T> sort(List<T> aList) {
		return collectResultFrom(sortTreeOf(aList));
	}

	private SortTree<T> sortTreeOf(List<T> aList) {
		SortTree<T> tree = new Leaf<T>(comparator);
		for (T word : aList) {
			tree = tree.add(word);
		}
		return tree;
	}

	private List<T> collectResultFrom(SortTree<T> tree) {
		List<T> result = new ArrayList<T>();
		tree.collect(result);
		return result;
	}
}