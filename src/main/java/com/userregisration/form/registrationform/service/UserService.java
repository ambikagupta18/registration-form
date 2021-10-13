package com.userregisration.form.registrationform.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.userregisration.form.registrationform.model.User;
import com.userregisration.form.registrationform.repository.UserRepository;

@Service
public interface UserService  {

	
	List<User>getAllUser();
	
  void saveUser(User user);
    User getUserById(long id);
 public void saveUserToDB(String Name,String Email, String Phonenumber,String Gender, String State, String Skills, MultipartFile file);

void saveUsers(User user);
    

    }
