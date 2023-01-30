package service;

import java.util.Arrays;

public class SearchingAlgorithm {

	public  void binarySearch(String arr[], String key) {
		Arrays.sort(arr);
		for (String s:arr)
			System.out.println(s);
		int f=0,l= arr.length - 1;;
					
		while(f <= l) {
			int mid = f + (l - f) / 2;
			System.out.println("first : "+f+" last : "+l);
			System.out.println("mid : "+mid);
			 int res = key.compareToIgnoreCase(arr[mid]);
			 System.out.println("s :"+res);
			 if(res==0) {
				System.out.println("File Exist");
				break;
			}else if(res>0) {
				f=mid+1;
			}
			 else {
				l = mid-1;
			}
			
		}
		if(f>l) {
			System.out.println("File not Exists");
		}
	}
}
