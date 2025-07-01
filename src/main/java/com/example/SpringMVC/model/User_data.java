package com.example.SpringMVC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User_data {
	
	@Id
	private int uid;
	private String uname;

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUname() {
		return uname;
	}

	@Override
	public String toString() {
		return "User[ id : "+uid+", name : "+uname+" ]";
	}
}
