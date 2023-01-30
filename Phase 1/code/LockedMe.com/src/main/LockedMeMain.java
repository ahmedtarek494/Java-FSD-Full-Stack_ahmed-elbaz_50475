package main;

import java.util.Scanner;

import service.FileProcessing;
import service.SearchingAlgorithm;
import service.SortingAlgorithm;

public class LockedMeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileProcessing file= new FileProcessing();
		SearchingAlgorithm search =new SearchingAlgorithm();
		SortingAlgorithm sort = new SortingAlgorithm();
		System.out.println("Welcome to LockedMe.com , This application developed by ahmed elbaz");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("                                                                ");
		String menuPointer = null;
		do{
			System.out.println("                     Main Menu Options :                                           ");
			System.out.println("                                                                ");
			System.out.println("- Press 1 to retrieve all the folder  items                                                                ");
			System.out.println("- Press 2 for processing operations                                                              ");
			System.out.println("- press (e) to exit the program                                                             ");
			Scanner sc = new Scanner(System.in);
			menuPointer = sc.next();
			switch(menuPointer) {
			case "1":
				
				System.out.println("------------");
			String [] files =sort.bubbleSortAsc(file.readAllFiles());
				for (String s:files)
					System.out.println(s);
					break;
			case "2":
				int i=-1;
				do{
					System.out.println("                     Processing Operations :                                           ");
					System.out.println("                                                                ");
					System.out.println("- Press 1 to add new file.                                                                 ");
					System.out.println("- Press 2 to delete any file.                                                              ");
					System.out.println("- press 3 to search for any file.      ");
					System.out.println("- press 0 to return to main menu.      ");
					Scanner sc2 = new Scanner(System.in);
					i = sc2.nextInt();
					switch(i) {
					case 1:
						System.out.println("--------Enter the name of the file you want to create------");
						Scanner sc3 = new Scanner(System.in);
						String fileName = sc3.next();
						file.createNewFile(fileName);
							break;
					case 2:
						System.out.println("--------Enter the name of the file you want to delete------");
						Scanner sc4 = new Scanner(System.in);
						String fileName1 = sc4.next();
						file.deleteFile(fileName1);
							break;
					case 3:
						System.out.println("--------Enter the name of the file you want to search------");

						Scanner sc5 = new Scanner(System.in);
						String fileName2 = sc5.next();
						search.binarySearch(file.readAllFiles(), fileName2);
							break;
					case 0:
						System.out.println("Returning to Main men ");

							break;
					default:System.out.println("wrong choice please choose the correct option");
					         break;
					}
				}while(i!=0);
					break;
			case "e":
				System.out.println("closing the application , see you again bye!!!!");
			break;		
			default:System.out.println("wrong choice please choose the correct option");
			         break;
			}
		}while(!menuPointer.equals("e"));
		
		
		
		

	}

}
