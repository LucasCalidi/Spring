package com.trello.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Table {
	private String name;
	private TableVisibility visibility;
	private boolean starred; //tablice oznaczone jako star sa pokazywane na samej górze.
	private List<TableList> lists;
	
	public enum TableVisibility {
		PRIVATE,
		TEAM,
		PUBLIC
	}

	public Table(String name, TableVisibility visibility) {
		super();
		this.name = name;
		this.visibility = visibility;
		this.lists = new ArrayList<TableList>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TableVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(TableVisibility visibility) {
		this.visibility = visibility;
	}

	public boolean isStarred() {
		return starred;
	}

	public void setStarred(boolean starred) {
		this.starred = starred;
	}

	public void addList(TableList list) {
		lists.add(list);
	}

	public void editList(int listIndex, String name) {
		lists.get(listIndex).setName(name);
	}
	
	public void deleteList(int listIndex) {
		lists.remove(listIndex);
	}

	public List<TableList> getLists() {
		return lists;
	}

	public void setLists(List<TableList> lists) {
		this.lists = lists;
	}

	public void addCard(int listIndex, Card card) {
		lists.get(listIndex).addCard(card);
	}
	
	public void editCard(int listIndex, int cardIndex, String name) {
		lists.get(listIndex).editCard(cardIndex, name);
	}

	public void deleteCard(int listIndex, int cardIndex) {
		lists.get(listIndex).deleteCard(cardIndex);
	}
	
	public ArrayList<Comment> getComments(int listIndex, int cardIndex) {
		return lists.get(listIndex).getComments(cardIndex);
	}

	public void addComment(int listIndex, int cardIndex, String commentText) {
		lists.get(listIndex).addComment(cardIndex, commentText);
	}
	
	public void editComment(int listIndex, int cardIndex, int commentIndex, String commentText) {
		lists.get(listIndex).editComment(cardIndex, commentIndex, commentText);
	}
	
	public void deleteComment(int listIndex, int cardIndex, int commentIndex) {
		lists.get(listIndex).deleteComment(cardIndex, commentIndex);
	}
	
	public ArrayList<String> getFileNames(int listIndex, int cardIndex) {
		return lists.get(listIndex).getFileNames(cardIndex);
	}
	
	public void addFile(File file, int listIndex, int cardIndex) {
		lists.get(listIndex).addFile(file, cardIndex);
	}
}
