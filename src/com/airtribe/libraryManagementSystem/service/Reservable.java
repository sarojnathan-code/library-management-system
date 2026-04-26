package com.airtribe.libraryManagementSystem.service;

public interface Reservable {
	
	void registerObserver(Reserver observer);
    void removeObserver(Reserver observer);
    void notifyObservers(String message);
}
