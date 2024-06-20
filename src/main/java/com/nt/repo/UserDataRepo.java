package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.UserData;

public interface UserDataRepo extends JpaRepository<UserData,Integer> {

	@Query("select id from  UserData where userId=?1 and password=?2")
	Integer checkingRecord(int id,String password);
}
