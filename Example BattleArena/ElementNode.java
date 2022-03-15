
public class ElementNode<T> implements ListADTNode<T> {
	private T b;
	private ListADTNode<T> nextNode;
	
	public ElementNode(T p, ListADTNode<T> nextNode) {
		this.b = p;
		this.nextNode = nextNode;
	}

	@Override
	public int count() {
		return 1+this.nextNode.count();
	}

	@Override
	public int countHelp(int acc) {
		return countHelp(0);
	}

	@Override
	public ListADTNode<T> addFront(T b) {
		return new ElementNode<T>(b,this);
	}

	@Override
	public ListADTNode<T> addBack(T b) {
		this.nextNode = this.nextNode.addBack(b);
		return this;
	}

	@Override
	public ListADTNode<T> add(int index, T b) throws IllegalArgumentException {
		if(index == 0) {
			return addFront(b);
		}else {
			this.nextNode = this.nextNode.add(index-1, b);
			return this;
		}
	}

	@Override
	public ListADTNode<T> remove(T b) {
		if(this.b.equals(b)) {
			return this.nextNode;
		}else {
			this.nextNode = this.nextNode.remove(b);
			return this;
		}
	}
	
	public String toString() {
		String objstring = this.b.toString();
		String nextNode = this.nextNode.toString();
		if(nextNode.length()>0) {
			return objstring+nextNode;
		}else
			return objstring;
	}
	
	  @Override
	  public T get(int index) throws IllegalArgumentException{
	    if (index==0) return this.b;
	    return this.nextNode.get(index-1);
	  }
}
