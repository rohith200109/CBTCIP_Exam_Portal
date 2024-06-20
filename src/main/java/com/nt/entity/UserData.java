package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserData {

	@Id
	Integer userId;
	@Column(length = 25)
	String password;
}
