package service;

import java.util.Arrays;

public class SearchingAlgorithm {

	public  void binarySearch(String arr[], String key) {
		Arrays.sort(arr);
		
		int f=0,l= arr.length - 1;;
					
		while(f <= l) {
			int mid = f + (l - f) / 2;

			 int res = key.compareTo(arr[mid]);
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
