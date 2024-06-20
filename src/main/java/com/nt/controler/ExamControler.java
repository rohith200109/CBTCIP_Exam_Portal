package com.nt.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.UserData;
import com.nt.model.LoginDetails;
import com.nt.model.QuizForm;
import com.nt.model.QuizFormAnswers;
import com.nt.repo.UserDataRepo;
import com.nt.service.ExamService;



@Controller
public class ExamControler {

	@Autowired
private ExamService es;
	
	@Autowired
	UserDataRepo repo;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("/examportal")
	public String loginValidate(@ModelAttribute("LoginDetails") LoginDetails obj) {
		Integer checkingRecord = repo.checkingRecord(Integer.parseInt(obj.getId()), obj.getPassword());
		if(checkingRecord!=null)  return "portal";
	else  return"wrong";
	}
	
	
	@GetMapping("updateProfile")
	public String getMethodName(@ModelAttribute("LoginDetails") LoginDetails obj) {
		return "editProfile";
	}
	@PostMapping("updateprofile")
	public String updateProfile(@ModelAttribute("LoginDetails") LoginDetails ld ) {
		UserData obj = new UserData();
		obj.setPassword(ld.getPassword());
		obj.setUserId(Integer.parseInt(ld.getId()));
		es.userAndPassSaveing(obj);
		return "portal";
	}
	
	@GetMapping("takeTest")
	public String test() {
		return "test";
	}
	
	@GetMapping("quiz")
	public String evaluateMarks(@ModelAttribute("QuizForm") QuizForm quiz,Model model) {
		int marks=0;
		QuizFormAnswers ans = new QuizFormAnswers();
		System.out.println(ans);
		System.out.println(ans.getA1());
		System.out.println(quiz.getQ1());
		if(quiz.getQ1().equalsIgnoreCase(ans.getA1())) marks++;
		if(quiz.getQ2().equalsIgnoreCase(ans.getA2())) marks++;
		if(quiz.getQ3().equalsIgnoreCase(ans.getA3())) marks++;
		if(quiz.getQ4().equalsIgnoreCase(ans.getA4())) marks++;
		if(quiz.getQ5().equalsIgnoreCase(ans.getA5())) marks++;
		if(quiz.getQ6().equalsIgnoreCase(ans.getA6())) marks++;
		if(quiz.getQ7().equalsIgnoreCase(ans.getA7())) marks++;
		if(quiz.getQ8().equalsIgnoreCase(ans.getA8())) marks++;
		if(quiz.getQ9().equalsIgnoreCase(ans.getA9())) marks++;
		if(quiz.getQ10().equalsIgnoreCase(ans.getA10())) marks++;
		model.addAttribute("marks",marks);
		return "quizResult";
	}
	
	@GetMapping("logout")
	public String getMethodName() {
		return "index";
	}
	
	@GetMapping("/registerform")
	public String getRegisterPage() {
		return "Register";
	}
	@PostMapping("/registerdata")
	public String registeringData(@ModelAttribute("UserData") UserData obj,Model model) {
	System.out.println(obj.getPassword()+" "+obj.getUserId());
		String msg = es.userAndPassSaveing(obj);
		model.addAttribute("msg",msg);
		return "redirect:/";
	}
}
