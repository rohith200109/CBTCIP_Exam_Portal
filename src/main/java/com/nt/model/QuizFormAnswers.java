package com.nt.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component("q")
@ConfigurationProperties(prefix = "quiz")
public class QuizFormAnswers 
{
//	@Value("${a1}")
	String a1="B";
//	@Value("${a2}")
	String a2="A";
//	@Value("${a3}")
	String a3="B";
//	@Value("${a4}")
	String a4="A";
//	@Value("${a5}")
	String a5="B";
//	@Value("${a6}")
	String a6="C";
//	@Value("${a7}")
	String a7="B";
//	@Value("${a8}")
	String a8="D";
//	@Value("${a9}")
	String a9="B";
//	@Value("${a10}")
	String a10="C";

}
