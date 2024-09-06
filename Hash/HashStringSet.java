package Hash;


// A HashIntSet object represents a set of integers using a hash table
// as the internal data structure.
// The hash table uses separate chaining (a linked list in each hash bucket
// index) to resolve collisions.

public class HashStringSet {
	private static final double MAX_LOAD = 0.5;   // load factor on which to rehash

	private Node[] elementData;
	private int size;
    private int numChars;
	private int buckets;

	// Constructs a new empty set of integers.
	public HashStringSet() {
		elementData = (Node[]) new HashStringSet.Node[100];
		buckets = elementData.length;
		size = 0;
	}

	// Constructs a new set of integers.
	@SuppressWarnings("unchecked")
	public HashStringSet(String... values) {
		this();
		for (String value : values) {
			add(value);
		}
	}

    public int getBuckets(){
        return buckets;
    }

    public double getOverhead(){
        return 4 + 40 + (4 * elementData.length);
    }

    public double getData(){
        return numChars;
    }

	// Adds the given value to this set,
	// if it was not already contained in the set.
	public void add(String value) {
		// linear probing to find proper index
		if (!contains(value)) {
			int h = hash(value);
			Node newNode = new Node(value);
			newNode.next = elementData[h];
			elementData[h] = newNode;
			size++;
            numChars += 4 + value.length();
		}

		// resize if necessary
		if (loadFactor() > MAX_LOAD) {
			rehash();
		}
	}

	// Returns true if o refers to another HashIntSet with the same elementData as this set.
	public boolean equals(Object o) {
		return equalsIgnoringSize(o) && size == ((HashStringSet) o).size();
	}

	// Returns true if o refers to another HashIntSet with the same elementData as this set,
	// ignoring the value of the size field.
	public boolean equalsIgnoringSize(Object o) {
		if (o instanceof HashStringSet) {
			HashStringSet other = (HashStringSet) o;
			for (Node front : elementData) {
				Node current = front;
				while (current != null) {
					if (!other.contains(current.data)) {
						return false;
					}
					current = current.next;
				}
			}
			for (Node front : other.elementData) {
				Node current = front;
				while (current != null) {
					if (!this.contains(current.data)) {
						return false;
					}
					current = current.next;
				}
			}
			return true;
		} else {
			return false;
		}
	}



	// Returns whether the given value is found in this set.
	public boolean contains(String value) {
		// linear probing to find proper index
		int h = hash(value);
		Node current = elementData[h];
		while (current != null) {
			if (current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Returns true if there are no elementData in this set.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns the hash table's "load factor", its ratio of size to capacity.
	public double loadFactor() {
		return (double) size / elementData.length;
	}

	// Removes the given element value from this set,
	// if it was found in the set.
	public void remove(String value) {
		// linear probing to find proper index
		int h = hash(value);

		if (elementData[h] != null) {
			// front case
			if (elementData[h].data == value) {
				elementData[h] = elementData[h].next;
				size--;
			} else {
				// non-front case
				Node current = elementData[h];
				while (current.next != null &&
						current.next.data != value) {
					current = current.next;
				}

				// current.next == null
				// || current.next.data == value
				if (current.next != null) {
					current.next = current.next.next;
					size--;
				}
			}
		}
	}

	// Returns the number of elementData in this set.
	public int size() {
		return size;
	}

	// Returns a text representation of this set.
	public String toString() {
		String result = "[";
		boolean first = true;
		for (Node node : elementData) {
			Node current = node;
			while (current != null) {
				if (!first) {
					result += ", ";
				}
				result += current.data;
				first = false;
				current = current.next;
			}
		}
		result += "]";
		return result;
	}

	// Debugging helper that prints the inner hash table.
	public void debug() {
		System.out.println("debug() output:");
		System.out.printf("index   data\n");
		for (int i = 0; i < elementData.length; i++) {
			System.out.printf("%5d   ", i);
			Node node = elementData[i];
			if (node == null) {
				System.out.printf("%6s\n", "null");
			} else {
				boolean first = true;
				while (node != null) {
					if (!first) {
						System.out.print("  --> ");
					}
					System.out.printf("%8s", node.data);
					node = node.next;
					first = false;
				}
				System.out.println();
			}
		}
		System.out.printf("size   %d\n\n", size);
	}

	// hash function for mapping values to indexes
	private int hash(String value) {
        char[] chars = value.toCharArray();
        int num = 0;
        for(int i = 0; i < chars.length; i++){
            //minus ten as the lowest return is a 10;
			if(i % 2 == 0) {
				num *= Character.getNumericValue(chars[i]) - 10;
			} else num += Character.getNumericValue(chars[i]) - 10;
        }
        return Math.abs(num) % elementData.length;
	}

	// Resizes the hash table to twice its original capacity.
	@SuppressWarnings("unchecked")
	private void rehash() {
		Node[] newelementData = (Node[]) new HashStringSet.Node[5 * elementData.length / 4];
		Node[] old = elementData;
		elementData = newelementData;
		size = 0;
		for (Node node : old) {
			while (node != null) {
				add(node.data);
				node = node.next;
			}
		}
	}
	public void getAllData(){
		for(int i = 0; i < elementData.length; i++){
			System.out.println(i);
			Node node = elementData[i];
			while(node != null){
				System.out.print(node.data);
				node = node.next;
			}
			System.out.println();
		}
	}
	public String getAllDataFast(){
		String output = "";
		Thread[] threads = new Thread[elementData.length];
		for(int i = 0; i < elementData.length; i++){
			if(elementData[i] != null){
				threads[i] = new Thread(new search(elementData[i]));
				threads[i].start();
			}
		}
		
		
		return output;
	}


	private class Node {
		public String data;
		public Node next;

		public Node(String data) {
			this.data = data;
		}
	}

	public class search implements Runnable{
		String output;
		Node node;
		public search(Node _data){
			node = _data;
			output = "";
		}
		@Override
		public void run() {
			if(node == null){
				return;
			}
			while(node != null){
				System.out.print(" " + node.data);
				node = node.next;
			}
			System.out.println();
			
		}

		public String getOutPut(){
			return output;
		}

	}
// YOUR CODE GOES HERE

}