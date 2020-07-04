package learnArray;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr1 = {7,6,5,9,7,2,4,6,8,2,1,5,7,9,0,3};
		
		// 测试冒泡排序法
		bubbleSort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		// 测试二分法
		int ret = binarySearch(3, arr1);
		System.out.println(ret);
	}
	
	public static void bubbleSort(int[] arr) {
		int temp;
		for(int i=0; i<arr.length-1; i++) {
			boolean flag = true;
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag) { // 如果一次小循环结束，没有发生元素换位，说明已经完成排序，提前结束循环
				break;
			}
		}
		return;
	}
	
	public static int binarySearch(int tar, int[] arr) {
		bubbleSort(arr);
		int low = 0;
		int high = arr.length-1;
		
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr[mid] == tar) {
				return mid;
			}else if (arr[mid] < tar) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
