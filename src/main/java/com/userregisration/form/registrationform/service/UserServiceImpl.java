package com.userregisration.form.registrationform.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.userregisration.form.registrationform.model.User;
import com.userregisration.form.registrationform.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
    public List < User> getAllUser() {
        return repo.findAll();
    }

	@Override
	public void saveUser(User user) {
		this.repo.save(user);
		
	}
	@Override
	public void saveUsers(User user) {
		this.repo.save(user);
		
	}
	
	@Override
    public User getUserById(long id) {
        Optional < User > optional = repo.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + id);
        }
        return user;
    }


	public void saveUserToDB(String name, String email, String gender, String phonenumber, String state, String skills,MultipartFile file) {
		User user=new User();
		String fileName= StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")){
			{
		  		System.out.println("not a valid file");
			}
		}
		try {
			user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//user.setImage(file);
		user.setName(name);
		user.setEmail(email);
		user.setPhonenumber(phonenumber);
		user.setGender(gender);
		user.setState(state);
		user.setSkills(skills);
		
		repo.save(user);
		
	}
}
