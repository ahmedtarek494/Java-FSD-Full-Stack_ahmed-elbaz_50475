package main;

import java.util.Scanner;

import service.FileProcessing;

public class LockedMeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileProcessing file= new FileProcessing();
		file.readAllFiles();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Plz enter the file name which you want to create");
		String fileName = sc.next();
		file.createNewFile(fileName);
	}

}
