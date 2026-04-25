package com.airtribe.libraryManagementSystem.service;

public interface Notify {
	
	void reserve(Reservable s);
    void unreserve(Reservable s);
    void notifySubscribers();

}
