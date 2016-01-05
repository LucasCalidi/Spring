package com.trello.model;

import java.util.ArrayList;


public class History {
	private ArrayList<String> activities;
	
	public History() {
		activities = new ArrayList<String>();
	}
	
	public enum ActivityType {
		TABLE_ADDITION,
		LIST_ADDITION,
		CARD_ADDITION,
		TABLE_EDITION,
		LIST_EDITION,
		CARD_EDITION,
		TABLE_DELETION,
		LIST_DELETION,
		CARD_DELETION
	}
	
	public ArrayList<String> getActivities() {
		return activities;
	}
	
	public String getActivity(int index) {
		return activities.get(index);
	}
	
	public void deleteActivity(int index) {
		activities.remove(index);
	}

	public void addActivity(ActivityType activityType, String name) {
		if(activityType == ActivityType.TABLE_ADDITION) {
			activities.add("Table \"" + name + "\" has been added.");	
		} else if(activityType == ActivityType.TABLE_DELETION) {
			activities.add("Table \"" + name + "\" has been deleted.");	
		}
	}

	public void addActivity(ActivityType activityType, String name1, String name2) {
		if(activityType == ActivityType.TABLE_EDITION) {
			activities.add("Name of table \"" + name1 + "\" has been changed to \"" + name2 + "\".");
		} else if(activityType == ActivityType.LIST_ADDITION) {
			activities.add("List named \"" + name2 + "\" has been added to \"" + name1 + "\" table.");
		} else if(activityType == ActivityType.LIST_DELETION) {
			activities.add("List named \"" + name2 + "\" has been removed from \"" + name1 + "\" table.");
		}
	}

	public void addActivity(ActivityType activityType, String name, String name2, String name3) {
		if(activityType == ActivityType.LIST_EDITION) {
			activities.add("Name of list \"" + name2 + "\" in \"" + name + "\" table has been changed to \"" + name3 + "\".");
		} else if(activityType == ActivityType.CARD_ADDITION) {
			activities.add("Card named \"" + name3 + "\" has been added to \"" + name2 + "\" list in \"" + name + "\" table.");
		} else if(activityType == ActivityType.CARD_DELETION) {
			activities.add("Card named \"" + name3 + "\" has been removed from \"" + name2 + "\" list in \"" + name + "\" table.");
		}
	}

	public void addActivity(ActivityType activityType, String name, String name2, String name3, String name4) {
		if(activityType == ActivityType.CARD_EDITION) {
			activities.add("Name of card \"" + name3 + "\" in \"" + name2 + "\" list and \"" + name + "\" table has been changed to \"" + name4 + "\".");
		}
	}
}