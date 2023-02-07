package com.douzone.fileupload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/fileupload-files";
	private static String URL_PATH = "/images";
	
	public String restore(MultipartFile file) {
		String url = null;
		
		try {
			File uploadDirectory = new File(SAVE_PATH);
			if(!uploadDirectory.exists()) {
				uploadDirectory.mkdirs();
			}
			
			if(file.isEmpty()) {
				return url;
			}
			
			String originfilename = file.getOriginalFilename();
			String extName = originfilename.substring(originfilename.lastIndexOf(".")+1);
			String saveFilename = generateSaveFilename(extName);
			Long filesize = file.getSize();
			
			
			System.out.println("#############" + originfilename);
			System.out.println("#############" + filesize);
			System.out.println("#############" + saveFilename);
			
			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();
			
			url = URL_PATH + "/" + saveFilename;
		} catch(IOException ex) {
			throw new FileuploadServiceException(ex.toString());
		}
		
		return url;
	}

	private String generateSaveFilename(String extName) {
		String filename = "";
		
		Calendar calenda = Calendar.getInstance();
		filename += calenda.get(Calendar.YEAR);
		filename += calenda.get(Calendar.MONTH);
		filename += calenda.get(Calendar.DATE);
		filename += calenda.get(Calendar.HOUR);
		filename += calenda.get(Calendar.MINUTE);
		filename += calenda.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}

}
