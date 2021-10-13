package com.userregisration.form.registrationform.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.userregisration.form.registrationform.helper.FileUploadHelper;
import com.userregisration.form.registrationform.model.User;
import com.userregisration.form.registrationform.repository.UserRepository;
import com.userregisration.form.registrationform.service.UserService;

@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listUser", userService.getAllUser());
        return "index";
    }
    
    @GetMapping("/showNewUserForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        List<String> stateList= Arrays.asList("Andaman & Nicobar", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra & Nagar Haveli", "Daman & Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Pondicherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttar Pradesh", "Uttaranchal", "West Bengal");
        model.addAttribute("stateList", stateList);
        return "new_user";
    }
   @PostMapping("/saveUsers")
    public String saveUsers(@ModelAttribute("user") User user) {
        // save employee to database
        userService.saveUsers(user);
        return "redirect:/";
    }
 
    
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
     
     // get employee from the service
     User user  = userService.getUserById(id);
     
     // set employee as a model attribute to pre-populate the form
     model.addAttribute("user", user);
     return "update_user";
    }
    
    
    
    @PostMapping("/saveUser")
    public String saveUser(@RequestParam("file") MultipartFile file,
    		@RequestParam("name") String name,
    		@RequestParam("email") String email,
    		@RequestParam("phonenumber") String phonenumber,
    @RequestParam("gender") String gender,
 @RequestParam("state") String state,
 @RequestParam("skills") String skills)

    { String filepath= "C:\\Users\\Ayush\\Desktop\\New folder\\registration-form\\registration-form\\src\\main\\resources\\static\\image";
	 //String filepath= C:\Users\Ayush\Desktop\New folder\registration-form\registration-form\src\main\resources\static\image
	 String filename=file.getOriginalFilename(); 
	 System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
      
	 boolean f=false;
	 try {
	 InputStream is=file.getInputStream();
	 byte data[]=new byte[is.available()];
	 is.read(data);
	 
	 FileOutputStream fos=new FileOutputStream(filepath+File.separator+file.getOriginalFilename());
	 fos.write(data);
	 
	 fos.flush();
	 fos.close();
	 f=true;}
	 catch (Exception e) {
			
		 e.printStackTrace();
	}
    	userService.saveUserToDB(name, email, gender, phonenumber, state, skills, file);
    	return "redirect:/";
    }

  /*  @PostMapping("/saveUsers")
    public ModelAndView saveUsers(@RequestParam("file") MultipartFile file,
    		@RequestParam("name") String name,
    		@RequestParam("email") String email,
    		@RequestParam("phonenumber") String phonenumber,
    @RequestParam("gender") String gender,
  @RequestParam("state") String state,
  @RequestParam("skills") String skills)
    {
    	User user=new User(name,email,phonenumber,gender,state,skills,ServletUriComponentsBuilder.fromCurrentContextPath().path("C:\\Users\\Ayush\\Desktop\\New folder\\registration-form\\registration-form\\src\\main\\resources\\static\\image").path(file.getOriginalFilename()).toUriString());
    	
    			userService.saveUsers(user);
    			ModelAndView mv=new ModelAndView();
    			mv.addObject("user", user);
    			mv.setViewName("redirect:/");
    			
    	return mv;
    }*/
    
     
  
}























