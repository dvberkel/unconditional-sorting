package org.effrefax.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnconditionalSorter<T> implements Sorter<T> {

	private final Map<Integer, ListTransformer> transformers = new HashMap<Integer, ListTransformer>();
	private final Comparator<T> comparator;

	{
		transformers.put(1, new SwapTransformer());
		transformers.put(0, new IdentityTransformer());
		transformers.put(-1, new IdentityTransformer());
	}

	public UnconditionalSorter(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public List<T> sort(List<T> aList) {
		List<T> copy = new ArrayList<T>(aList);
		for (int run = copy.size() - 1; run >= 0; run--) {
			for (int index = 0; index < copy.size() - 1; index++) {
				ListTransformer transformer = selectTransfer(comparator.compare(copy.get(index), copy.get(index + 1)));
				transformer.transform(copy, index, index + 1);
			}
		}
		return copy;
	}

	private ListTransformer selectTransfer(int compare) {
		return transformers.get(Integer.signum(compare));
	}
}

interface ListTransformer {
	public <T> void transform(List<T> aList, int first, int second);
}

class IdentityTransformer implements ListTransformer {

	@Override
	public <T> void transform(List<T> aList, int first, int second) {
		// Do nothing
	}
}

class SwapTransformer implements ListTransformer {

	@Override
	public <T> void transform(List<T> aList, int first, int second) {
		T temporary = aList.get(first);
		aList.set(first, aList.get(second));
		aList.set(second, temporary);
	}
}
