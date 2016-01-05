package com.trello.service;

import java.util.List;

import com.trello.model.Table;

public interface TableService {
	public List<Table> getTables();
	public void addTable(Table t);
	public void deleteTable(int tableIndex);
	public void editTable(int tableIndex, String name);
}
