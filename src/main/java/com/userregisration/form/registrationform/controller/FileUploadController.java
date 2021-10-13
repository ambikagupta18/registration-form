package com.userregisration.form.registrationform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.userregisration.form.registrationform.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		try{
			
		
		if(file.isEmpty())
		{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");	
		}
		if(file.getContentType().equals("image/jpeg,image/png"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg content type allow");
			
		}
		
		boolean f= fileUploadHelper.uploadFile(file);
		if(f)
		{
		return ResponseEntity.ok("File is successfully upload");	
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong! try again");
	}

}
