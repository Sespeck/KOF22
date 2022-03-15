
public class ListADTImpl<T> implements ListADT<T> {
	private ListADTNode<T> head;
	
	public ListADTImpl() {
		head = new EmptyNode<T>();
		
	}

	@Override
	public void addFront(T b) {
		this.head = this.head.addFront(b);
		
	}

	@Override
	public void addBack(T b) {
		this.head = this.head.addBack(b);
		
	}

	@Override
	public void add(int index, T b) {
		this.head = this.head.add(index, b);
		
	}

	@Override
	public int getSize() {
		return this.head.count();
	}

	@Override
	public void remove(T b) {
		this.head = this.head.remove(b);
		
	}
	
	public String toString() {
		return "(\n" + this.head.toString()+ ")";
	}
	
	 @Override
	 public T get(int index) throws IllegalArgumentException{
		 if ((index>=0) && (index<getSize())) {
			 return this.head.get(index);
	    } else throw new IllegalArgumentException("Invalid index");

	  }

}
