package learnCollection;

import javax.management.RuntimeErrorException;

/**
 * 自定义实现一个ArrayList
 * @author qizidog
 *
 */

public class MyArrayList<E> {
	
	private Object[] elementData;
	private int size=0;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int capacity) {
		if(capacity<0) {
			throw new RuntimeException();
		}else{
			elementData = new Object[capacity];
		}
	}
	
	private boolean checkCapacity() {
		if(size>=elementData.length) {
			return true;
		}else {
			return false;
		}
	}
	
	private void checkRange(int idx) {
		if(0<=idx && idx<size) {
			return;
		}else {
			throw new RuntimeException("incorrect index: "+idx);
		}
	}
	
	private void enlargeCapacity() {
		Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
		System.arraycopy(elementData, 0, newArray, 0, elementData.length);
		elementData = newArray;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0; i<size; i++) {
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	public void add(E e) {
		if(checkCapacity()) {
			enlargeCapacity();
		}
		elementData[size++] = e;
	}
	
	public E get(int idx) {
		checkRange(idx);
		return (E)elementData[idx];
	}
	
	public void set(int idx, E e) {
		checkRange(idx);
		elementData[idx] = e;		
	}
	
	public void remove(int idx) {
		checkRange(idx);
		int num2move = elementData.length-idx-1;
		if(num2move>0) {
			System.arraycopy(elementData, idx+1, elementData, idx, num2move);
		}
		elementData[--size] = null;
	}
	
	public void remove(E e) {
		for (int i = 0; i < size; i++) {
			if(e.equals(elementData[i])) {
				remove(i);
				break;
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
//		if(size>0) {
//			return false;
//		}else {
//			return true;
//		}
		return size==0?true:false;
	}
	
	public static void main(String[] args) {
		MyArrayList<String> arr = new MyArrayList<String>(20);
		arr.add("aa");
		arr.add("bb");
		arr.add("qizi");
		
		// get、set测试
		System.out.println(arr);
		System.out.println("get: "+arr.get(1));
		arr.set(2, "cc");
		
		// 自动扩容测试
//		for (int i = 0; i < 20; i++) {
//			arr.add("num:"+i);  // add测试
//		}
		
//		System.out.println(arr.size);
		System.out.println(arr);
		
		// remove测试
		arr.remove(1);
//		arr.remove(5);
		arr.remove("aa");
		arr.remove("douglas");
		System.out.println(arr);
		System.out.println(arr.size);
	}
}


