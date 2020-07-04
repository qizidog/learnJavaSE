package learnArray;

import java.util.Arrays;

public class arrayHomework {
	public static void main(String[] args) {
		work3();
	}
	
	public static void work1() {
		String tar = "homework1";
		String[] str = {"abc", "abcd2", "homework", "sljfld", "aiwoegn"};
		
		for (int i = 0; i < str.length-1; i++) {
			if (tar.equals(str[i])) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}
	
	public static void work3() {
		 int[] arr = {4,5,6,3,2,1,8,9,5,6};
		 int len = arr.length;
		 int temp;
		 
		 for (int i = 0; i < len/2; i++) {
			temp = arr[i];
			arr[i] = arr[len-1-i];
			arr[len-i-1] = temp;
		}
		 System.out.println(Arrays.toString(arr));
	}
}
