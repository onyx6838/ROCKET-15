package com.vti.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.net.*;
import java.io.FileOutputStream;

public class FileUtils {
	public static final String FILE_EXISTS = "File is exits!";
	public static final String FILE_NOT_EXISTS = "Error! File Not Exist.";
	public static final String FOLDER_EXISTS = "Folder is exits!";
	public static final String FOLDER_NOT_EXISTS = "Folder is not exits!";
	public static final String PATH_NOT_FOLDER = "Error! Path is not folder.";
	public static final String SOURCE_FILE_NOT_EXISTS = "Source File is not exits!";
	public static final String DESTINATION_FILE_EXISTS = "Destination File is exits!";
	public static final String NEW_FILE_EXISTS = "Error! New File Exist.";
	public static final String CREATE_FILE_SUCCESS = "Create file success!";
	public static final String CREATE_FILE_FAIL = "Create file fail!";
	public static final String DELETE_FILE_SUCCESS = "Delete file success!";
	public static final String DELETE_FILE_FAIL = "Delete file fail!";
	public static final String FOLDER_NOT_EXIST_OR_NOT_FOLDER = "Folder Not Exist Or Not Folder!";
	public static final String DOWNLOAD_FILE_SUCCESS = "Download File Success!";

	public static boolean isFileExists(String pathFile) {
		return new File(pathFile).exists() ? true : false;
	}

	// Check folder is exists
	public static boolean isFolderExists(String pathFolder) {
		return new File(pathFolder).exists() ? true : false;
	}

	// Create file
	public static void createNewFile(String pathFile) throws Exception {
		if (isFileExists(pathFile)) {
			throw new Exception(FILE_EXISTS);
		}
		boolean result = new File(pathFile).createNewFile();
		System.out.println(result ? CREATE_FILE_SUCCESS : CREATE_FILE_FAIL);
	}

	public static void createNewFile(String path, String fileName) throws Exception {
		String pathFile = path + "//" + fileName;
		createNewFile(pathFile);
	}

	// Delete file
	public static void deleteFile(String pathFile) throws Exception {
		if (!isFileExists(pathFile)) {
			throw new Exception(FILE_NOT_EXISTS);
		}
		boolean result = new File(pathFile).delete();
		System.out.println(result ? DELETE_FILE_SUCCESS : DELETE_FILE_FAIL);
	}

	// Check path is File or Folder
	public static void isFolderOrFile(String pathFile) {
		File file = new File(pathFile);
		if (file.isDirectory()) {
			System.out.println("Đây là 1 Foder");
		} else if (file.isFile()) {
			System.out.println("Đây là 1 file");
		} else {
			System.out.println("Đây không phải đường dãn, cũng không phải file");
		}
	}

	// Check path is Folder
	public static boolean isFolder(String pathFile) {
		File file1 = new File(pathFile);
		return file1.isDirectory();
	}

	// Get all file name of folder
	public static String[] getAllFileName(String path) {
		File file = new File(path);
		if (!isFolder(path)) {
			System.out.println("Đây không phải là đường dẫn!!");
			return null;
		} else {
			return file.list();
		}
	}

	// Copy File
	public static void copyFile(String sourceFile, String destinationPath) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception(SOURCE_FILE_NOT_EXISTS);
		}
		String[] s = sourceFile.split("/");
		String nameFile = s[s.length - 1];
		String destinationFile = destinationPath + "//" + nameFile;
		if (isFileExists(destinationFile)) {
			throw new Exception(DESTINATION_FILE_EXISTS);
		}
		File source = new File(sourceFile);
		File dest = new File(destinationPath);
		Files.copy(source.toPath(), dest.toPath());
	}

	// Moving file
	public static void moveFile(String sourceFile, String destinationPath) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception(SOURCE_FILE_NOT_EXISTS);
		}
		File source = new File(sourceFile);
		File dest = new File(destinationPath);
		Files.move(source.toPath(), dest.toPath());
	}

	// Rename File
	public static void renameFile(String pathFile, String newName) throws Exception {
		if (!isFileExists(pathFile)) {
			throw new Exception(FILE_NOT_EXISTS);
		}
		if (isFileExists(newName)) {
			throw new Exception(NEW_FILE_EXISTS);
		}
		File oldFile = new File(pathFile);
		File newFile = new File(newName);
		oldFile.renameTo(newFile);
	}

	// Create New Folder
	public static void createNewFolder(String newPathFolder) throws Exception {
		if (isFolderExists(newPathFolder)) {
			throw new Exception(FOLDER_EXISTS);
		}
		new File(newPathFolder).mkdir();
	}

	public boolean downloadFile(String link, String folderSave) throws MalformedURLException, IOException {
		// if folder not Exist or not folder
		File folder = new File(folderSave);
		if (!folder.exists() || !folder.isDirectory()) {
			// show message error
			System.out.println(FOLDER_NOT_EXIST_OR_NOT_FOLDER);
			return false;
		}
		// if folder exist get name file
		String s[] = link.split("/");
		String name = s[s.length - 1];
		folderSave = folderSave + "/" + name;

		// create connection to URL
		URL url = new URL(link);
		// open connection
		URLConnection connection = url.openConnection();
		// get size of file
		int size = connection.getContentLength();

		// read file from Internet use InputStream
		InputStream in = connection.getInputStream();
		// save file use FileOutput.Stream!

		FileOutputStream output = new FileOutputStream(folderSave);
		int byteDownloaded = 0;
		byte[] b = new byte[1024];
		// get length of file. If not read then length
		int length = in.read(b);
		while (length != -1) {
			byteDownloaded += length;
			// print . byte downloaded
			System.out.println(byteDownloaded * 100f / size + "%");
			// write content downloaded from 0 -> length to output
			output.write(b, 0, length);
			length = in.read(b);
		}
		// close
		output.close();
		in.close();
		// show message
		System.out.println(DOWNLOAD_FILE_SUCCESS);
		return true;
	}
}
