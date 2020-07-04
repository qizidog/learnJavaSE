package learnArray;

/**
 * 
 * @author qizidog
 *
 */
public class TestArrayCopy {

	
	public static void main(String[] args) {
//		learn to copy array
//		arrcopy();
//		arrcopy2();
		
//		test delete some elements from a certain position in array
//		int[] arr = {1,2,3,4,5};
//		deletArrEle(arr, 2, 2);
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
//		test insert an array to another array
		int[] arr1 = {1,2,3,4,7,8,9};
		int[] arr2 = {5,6};
		int[] ret;
		ret = insertArr(arr1, arr2, 4);
		for (int i = 0; i < ret.length; i++) {
			System.out.print(ret[i]+", ");
		}
	}
	
	
	public static void arrcopy(){
		int[] num_list = {1,2,3,4,5};
		int[] arr = new int[10];
		
		System.arraycopy(num_list, 1, arr, 4, 4);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	public static void arrcopy2() {
		String str[] = {"11", "22", "33", "44", "55"};
		String str2[] = new String[5];
		
		int pos = 3;
		System.arraycopy(str, pos, str2, pos-1, str.length-pos);
		System.arraycopy(str2, pos-1, str, pos-1, str.length-pos+1);
		for (int i = 0; i < str2.length; i++) {
			System.out.println(str[i]);
		}
	}
	
	
	// 测试利用数组拷贝的方式从数组中删除指定个数的元素
	public static void deletArrEle(int[] ori_arr, int pos, int num) {
		System.arraycopy(ori_arr, pos+num, ori_arr, pos, ori_arr.length-pos-num);
		for(int i=ori_arr.length-num; i<ori_arr.length; i++) {
			ori_arr[i] = 0;
		}
	}
	
	public static int[] insertArr(int[] arr1, int[] arr2, int pos) {
		int[] ret = new int[arr1.length+arr2.length];
		System.arraycopy(arr1, 0, ret, 0, pos);
		System.arraycopy(arr2, 0, ret, pos, arr2.length);
		System.arraycopy(arr1, pos, ret, pos+arr2.length, arr1.length-pos);
		return ret;
	}
}
