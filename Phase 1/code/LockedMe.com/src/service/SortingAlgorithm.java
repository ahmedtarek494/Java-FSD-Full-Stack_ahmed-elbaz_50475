package service;

public class SortingAlgorithm {

	public String [] bubbleSortAsc(String arr[]) {
	int	size=arr.length;
		for(int i=0;i<size;i++) {			
			for(int j=0;j<size-1-i;j++) {
				if(arr[j].compareTo(arr[j+1])>0)    {
					String  temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
					
				}
			}

		}
		return arr;
	}
}
