package org.effrefax.challenge.tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Root<T> implements SortTree<T> {

	private final Map<Integer, LeafTransformer<T>> transformers = new HashMap<Integer, LeafTransformer<T>>();
	private final Comparator<T> comparator;
	private final T word;
	private SortTree<T> right;
	private SortTree<T> left;

	{
		transformers.put(-1, new LeafTransformer<T>() {

			@Override
			public void transform(T word) {
				right = right.add(word);

			}
		});
		transformers.put(0, new LeafTransformer<T>() {

			@Override
			public void transform(T word) {
				// Do nothing

			}
		});
		transformers.put(1, new LeafTransformer<T>() {

			@Override
			public void transform(T word) {
				left = left.add(word);

			}
		});
	}

	public Root(Comparator<T> comparator, T word) {
		this.word = word;
		this.comparator = comparator;
		this.left = new Leaf<T>(this.comparator);
		this.right = new Leaf<T>(this.comparator);
	}

	@Override
	public SortTree<T> add(T word) {
		LeafTransformer<T> transformer = selectTransformer(comparator.compare(this.word, word));
		transformer.transform(word);
		return this;
	}

	private LeafTransformer<T> selectTransformer(int compare) {
		return transformers.get(Integer.signum(compare));
	}

	@Override
	public void collect(List<T> aList) {
		left.collect(aList);
		aList.add(word);
		right.collect(aList);

	}
}

interface LeafTransformer<U> {
	public void transform(U word);
}
