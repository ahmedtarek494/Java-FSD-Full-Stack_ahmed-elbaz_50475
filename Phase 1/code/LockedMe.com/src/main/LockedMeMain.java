package main;

import java.util.Scanner;

import service.FileProcessing;
import service.SearchingAlgorithm;

public class LockedMeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test.txt".compareToIgnoreCase("test4.txt"));
		FileProcessing file= new FileProcessing();
		SearchingAlgorithm search =new SearchingAlgorithm();
		String [] files= file.readAllFiles();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Plz enter the file name which you want to create");
		String fileName = sc.next();
		//file.deleteFile(fileName);
	
		search.binarySearch(files, fileName);
	}

}
