package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessing {

	private String folderName = "files";

	public String[] readAllFiles() {
		String[] ss = null;
		try {
			File ff = new File(folderName);
			ss = ff.list();
			if (ss.length == 0) {
				System.out.println("Folder is empty, no files founded");
			} else {
				System.out.println("There are " + ss.length + " files founded");

			}
		} catch (Exception e) {
			System.out.println("There's error while trying to fetch file, please try again later");
		}

		return ss;

	}

	public void createNewFile(String fileName) {
		String filePath = folderName + "/" + fileName;
		File ff = new File(filePath);

		if (ff.exists()) {
			System.out.println("File already exists");
		} else {
			// ff.createNewFile();
			FileWriter fw;
			try {
				fw = new FileWriter(filePath);
				fw.write("Welcome user your create file with name as " + fileName);
				fw.flush();
			} catch (IOException e) {
				System.out.println("Error while creating this file in this path");

			}

			System.out.println("File created...");
		}
	}

	public void deleteFile(String fileName) {
		String filePath = folderName + "/" + fileName;
		File ff = new File(filePath);
		if (ff.exists()) {

			ff.delete();

			System.out.println("File deleted...");

		} else {
			System.out.println("File not found");
		}
	}
}
