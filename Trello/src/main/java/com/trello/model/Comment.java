package com.trello.model;

import java.util.Date;

public class Comment {
	public String name;
	public String date;
	public Comment(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		String[] splitDate = date.split(" ");
		return splitDate[2] + " " + splitDate[1] + " " + splitDate[5] + " " + splitDate[3];
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
