package com.trello.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Card {
	private int id;
	private int listId;
	private String name;
	private String description;
	private ArrayList<Comment> comments;
	private ArrayList<File> files;
		
	public Card(String cardName, int listId) {
		super();
		this.name = cardName;
		this.comments = new ArrayList<Comment>();
		this.files = new ArrayList<File>();
		this.listId = listId;
	}
	

	public int getId() {
		return id;
	}
	
	public int getListId() {
		return listId;
	}


	public void setListId(int listId) {
		this.listId = listId;
	}


	public void setId(int id) {
		this.id = id;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void addComment(String commentText) {
		comments.add(new Comment(commentText, new Date().toString()));
	}
	
	public void editComment(int commentIndex, String commentText) {
		//comments.set(commentIndex, commentText);
	}
	
	public void deleteComment(int commentIndex) {
		comments.remove(commentIndex);
	}
	
	public ArrayList<File> getFiles() {
		return files;
	}
	
	public ArrayList<String> getFileNames() {
		ArrayList<String> fileNames = new ArrayList<>();
		for(File file : files) {
			fileNames.add(file.getName());
		}
		return fileNames;
	}

	public void addFile(File file) {
		files.add(file);
	}
}
