package learnCollection;

/**
 * 自定义实现一个链表
 * @author qizidog
 *
 */
public class MyLinkedList {
	private NodeT first;
	private NodeT last;
	private int size;
	
	private void checkRange(int index) {
		if(index<0 || index>size-1) {
			throw new RuntimeException("incorrect index: "+index);
		}
	}
	
	public void add(Object obj) {
		NodeT node = new NodeT(obj);
		
		if(first==null) {
//			node.previous = null;
//			node.next = null;
			first = node;
			last = node;
		}else {
			node.previous = last;
			last.next = node;
			last = node;
		}
		size++;
	}
	
	private NodeT getNode(int index) {
		NodeT nd = null;
		if(index<=(size>>2)) {
			nd = first;
			for(int i=0; i<index; i++) {
				nd = nd.next;
			}
		}else {
			nd = last;
			for(int i=size-1; i>index; i--) {
				nd = nd.previous;
			}
		}
		return nd;
	}
	
	public Object get(int index) {
		checkRange(index);
		
		NodeT nd = getNode(index);
		
		return nd==null?null:nd.element;
	}
	
	public void set(int index, Object obj) {
		checkRange(index);
		
		NodeT nd = getNode(index);
		
		nd.element = obj;
	}
	
	public void insert(int index, Object obj) {
		checkRange(index);
		NodeT nd = getNode(index);
		
		NodeT node = new NodeT(nd.previous, nd, obj);
		if(nd.previous!=null) {
			nd.previous.next = node;
		}
		nd.previous = node;
		if(index==0) {
			first = node;
		}else if (index==size-1) {
			last = node;
		}
		size++;
	}
	
	public void remove(int index) {
		checkRange(index);
		
		NodeT nd = getNode(index);
		if(nd.previous!=null) {
			nd.previous.next = nd.next;
		}
		if(nd.next!=null) {
			nd.next.previous = nd.previous;
		}
		if(index==0) {
			first = nd.next;
		}else if (index==size-1) {
			last = nd.previous;
		}
		size--;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		NodeT nd = first;
		for (int i = 0; i < size; i++) {
			sb.append(nd.element+",");
			nd = nd.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.add("a");  // 测试add
		ll.add("b");
		ll.add("c");
		ll.add("d");
		ll.add("e");
		ll.add("f");
		
		
		System.out.println(ll.toString());  // 测试toString
		System.out.print(ll.get(0));  // 测试get
		System.out.print(ll.get(1));
		System.out.print(ll.get(2));
		System.out.print(ll.get(3));
		System.out.print(ll.get(4));
		System.out.println(ll.get(5));
		
		ll.set(2, "qizi");  // 测试set
		ll.set(4, "test");
		System.out.println(ll);
		
		ll.remove(0);  // 测试remove
		ll.remove(2);
		ll.remove(3);
		System.out.println(ll);
		
		ll.insert(0, "aa");  // 测试insert
		ll.add(new NodeT("1231"));  // 因为没有加泛型，所以我可以在LinkedList里面添加不同种类的元素
		ll.add(123456);
		System.out.println(ll);
	}
	
}


class NodeT{
	NodeT previous;  // 上一个节点 
	NodeT next;  // 下一个节点
	Object element; //元素数据
	
	public NodeT(NodeT previous, NodeT next, Object element) {
		super();
		this.previous = previous;
		this.next = next;
		this.element = element;
	}

	public NodeT(Object element) {
		super();
		this.element = element;
	}
}
