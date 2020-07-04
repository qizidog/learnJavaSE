package learnCollection;

public class MyHashMap<K, V> {
	
	private Node[] table;
	private int size;
	
	public void put(K key, V value) {
		int hshcode = key.hashCode();
		int hsh = myHash(hshcode, table.length);
		
		Node newNode = new Node(hsh, key, value);
		Node temp = table[hsh];

		if(temp==null) {  // 如果此处数组的元素为null，则将新的节点添加为第一个元素
			table[hsh] = newNode;
			size++;
		}else {  // 遍历该处链表，如果有相同的key存在，替换value；否则追加节点至链表末端
			boolean exist = false;
			while (temp.next!=null) {
				if(temp.key.hashCode()==hshcode) {
					temp.value = value;
					exist = true;
//					System.out.println(""+temp.hash+" "+temp.key+" "+temp.value);
					break;
				}
				temp = temp.next;
			}
			if(!exist) {
				temp.next = newNode;
				size++;
			}
		}
		
	}
	
	
	public V get(K key) {
		int hsh = myHash(key.hashCode(), table.length);
		Node temp = table[hsh];
		while(temp!=null) {
			if(temp.key.equals(key)) {
				return (V) temp.value;
			}
			temp = temp.next;
		}
//		throw new RuntimeException("KeyError");
		return null;
	}
	
	
	public int myHash(int v, int length) {
		// 对hashcode求余
		return v&(length-1);  // 相当于v%length
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder("{ ");
		Node temp = null;
		for(int i=0; i<table.length; i++) {
			temp = table[i];
			while (temp!=null) {
				sb.append(""+temp.key+":"+temp.value+"; ");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length()-2, ' ');
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	
	
	public MyHashMap() {
		super();
		table = new Node[16];  // 长度是2的整数幂
	}

	
	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		map.put(1001, "17");
		map.put(1002, "16");
		map.put(1003, "111");
		map.put(1017, "222");
		map.put(1033, "333");
		map.put(1001, "qizi");
		System.out.println(map);
		System.out.println(map.get(1001));
		System.out.println(map.get(1004));
		System.out.println(map.size);
	}
	
	
}



class Node<K, V>{
	int hash;
	Node next;
	K key;
	V value;
	
	
	public Node(int hash, Node next, K key, V value) {
		super();
		this.hash = hash;
		this.next = next;
		this.key = key;
		this.value = value;
	}
	
	public Node(int hash, K key, V value) {
		super();
		this.hash = hash;
		this.key = key;
		this.value = value;
	}
}
