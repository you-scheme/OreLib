package you.mine.lib;
import java.util.*;

public class CombinationIterator<E> implements Iterator<Pair<E, E>>{
	private List<E> list;
	private int src_index;
	private int desc_index;
	private boolean isEmpty;
	CombinationIterator(List<E> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
		src_index = 0;
		desc_index = 1;
		isEmpty = (list == null ||list.size() == 0);
	}
	@Override
	public boolean hasNext() {
		return !isEmpty && ((src_index != list.size() -1) && (desc_index != list.size()));
	}

	@Override
	public Pair<E, E> next() {
		// TODO Auto-generated method stub
		Pair<E, E> comb = new Pair<E, E>(list.get(src_index), list.get(desc_index));
		if (desc_index == list.size()-1) {
			src_index++;
			desc_index = src_index + 1;
		} else {
			desc_index++;
		}
		return comb;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new RuntimeException("this method isn't implemented");
	}

}
