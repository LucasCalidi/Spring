package com.trello.service;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trello.model.Card;
import com.trello.model.Comment;
import com.trello.model.History;
import com.trello.model.History.ActivityType;
import com.trello.model.Table;
import com.trello.model.TableList;

@Service
public class TableServiceImpl implements TableService{
	private List<Table> tables;
	private History history;
	
	TableServiceImpl() {
		tables  = new LinkedList<Table>();
		history = new History();
	}
	
	
	public List<Table> getTables()
	{
		return tables;
	}
	
	public void addTable(Table t)
	{
		tables.add(t);
		history.addActivity(ActivityType.TABLE_ADDITION, t.getName());
	}
	
	public void deleteTable(int tableIndex)
	{
		if(tableIndex>=0 && tableIndex<tables.size())
		{
			history.addActivity(ActivityType.TABLE_DELETION, tables.get(tableIndex).getName());
			tables.remove(tableIndex);
		}
	}
	
	public void editTable(int tableIndex, String name)
	{
		if(tableIndex>=0 && tableIndex<tables.size())
		{
			history.addActivity(ActivityType.TABLE_EDITION, tables.get(tableIndex).getName(), name);
			tables.get(tableIndex).setName(name);
		}
	}			
		
	public void addListToTable(int tableIndex, TableList list) {
		tables.get(tableIndex).addList(list);
		history.addActivity(ActivityType.LIST_ADDITION, tables.get(tableIndex).getName(), list.getName());
	}

	public void editList(int tableIndex, int listIndex, String name) {
		history.addActivity(ActivityType.LIST_EDITION, tables.get(tableIndex).getName(), tables.get(tableIndex).getLists().get(listIndex).getName(), name);
		tables.get(tableIndex).editList(listIndex, name);
	}
	
	public void deleteList(int tableIndex, int listIndex) {
		history.addActivity(ActivityType.LIST_DELETION, tables.get(tableIndex).getName(), tables.get(tableIndex).getLists().get(listIndex).getName());
		tables.get(tableIndex).deleteList(listIndex);
	}			
	
	public void addCardToList(int tableIndex, int listIndex, Card card) {
		tables.get(tableIndex).addCard(listIndex, card);
		history.addActivity(ActivityType.CARD_ADDITION, tables.get(tableIndex).getName(), tables.get(tableIndex).getLists().get(listIndex).getName(), card.getName());
	}
	
	public void editCard(int tableIndex, int listIndex, int cardIndex, String name) {
		history.addActivity(ActivityType.CARD_EDITION, tables.get(tableIndex).getName(), tables.get(tableIndex).getLists().get(listIndex).getName(), tables.get(tableIndex).getLists().get(listIndex).getCards().get(cardIndex).getName(), name);
		tables.get(tableIndex).editCard(listIndex, cardIndex, name);
	}
	
	public void deleteCard(int tableIndex, int listIndex, int cardIndex) {
		history.addActivity(ActivityType.CARD_DELETION, tables.get(tableIndex).getName(), tables.get(tableIndex).getLists().get(listIndex).getName(), tables.get(tableIndex).getLists().get(listIndex).getCards().get(cardIndex).getName());
		tables.get(tableIndex).deleteCard(listIndex, cardIndex);
	}
	
	public ArrayList<Comment> getComments(int tableIndex, int listIndex, int cardIndex) {
		return tables.get(tableIndex).getComments(listIndex, cardIndex);
	}

	public void addComment(int tableIndex, int listIndex, int cardIndex, String commentText) {
		tables.get(tableIndex).addComment(listIndex, cardIndex, commentText);
	}
	
	public void editComment(int tableIndex, int listIndex, int cardIndex, int commentIndex, String commentText) {
		tables.get(tableIndex).editComment(listIndex, cardIndex, commentIndex, commentText);
	}
	
	public void deleteComment(int tableIndex, int listIndex, int cardIndex, int commentIndex) {
		tables.get(tableIndex).deleteComment(listIndex, cardIndex, commentIndex);
	}
	
	public ArrayList<String> getFileNames(int tableIndex, int listIndex, int cardIndex) {
		return tables.get(tableIndex).getFileNames(listIndex, cardIndex);
	}
	
	public void addFile(File file, int tableIndex, int listIndex, int cardIndex) {
		tables.get(tableIndex).addFile(file, listIndex, cardIndex);
	}
	
	public History getHistory() {
		return history;
	}
}
