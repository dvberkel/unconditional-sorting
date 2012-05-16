package org.effrefax.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UnconditionalSorter<T> implements Sorter<T> {

	public UnconditionalSorter(Comparator<T> comparator) {
	}

	@Override
	public List<T> sort(List<T> aList) {
		List<T> copy = new ArrayList<T>(aList);
		return copy;
	}

}
