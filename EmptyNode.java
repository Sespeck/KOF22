
public class EmptyNode<T> implements ListADTNode<T> {

	@Override
	public int count() {
		return 0;
	}

	@Override
	public int countHelp(int acc) {
		return acc;
	}

	@Override
	public ListADTNode<T> addFront(T b) {

		return new ElementNode<T>(b,this);
	}

	@Override
	public ListADTNode<T> addBack(T b) {
		return addFront(b);
	}

	@Override
	public ListADTNode<T> add(int index, T b) throws IllegalArgumentException {
		if (index==0){
		      return addFront(b);
		    }
		    throw new IllegalArgumentException("Invalid index to add an element");
	}

	@Override
	public ListADTNode<T> remove(T b) {
		return this;
	}
	
	public String toString() {
		return "";
	}
	
	@Override
	  public T get(int index) throws IllegalArgumentException {
	    throw new IllegalArgumentException("Wrong index");
	  }

}
