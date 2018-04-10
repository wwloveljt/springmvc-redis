package com.redis.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	 private int id;
     private String userName;
     private String  password;
     private int  age;
}
