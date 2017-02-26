package iterator;

import iterator.Collection;

public class LinkedList implements Collection {
	private Node head = null;
	private Node tail = null;
	private int size = 0;

	public void add(Object o) {
		Node n = new Node(o, null);
		if (head == null) {
			head = n;
			tail = n;
		}

		tail.setNext(n);
		tail = n;
		size++;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {
		
		return new Iterator() {
			Node currentNode=null;
			@Override
			public Object next() {
				if(currentNode==null) {
					currentNode=head;
				}else{
					currentNode=currentNode.getNext();
				}
				return currentNode.getData();
			}
			
			@Override
			public boolean hasNext() {
				return currentNode!=tail;
			}
		};
	}
}
