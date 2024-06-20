package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.UserData;
import com.nt.repo.UserDataRepo;

@Service
public class ExamService {

	@Autowired
	private UserDataRepo repo;
	
	public String userAndPassSaveing(UserData obj) {
		  UserData save = repo.save(obj);
		  System.out.println("saved "+save);
		  return "Registered Sucessfully";
	}
	
}
