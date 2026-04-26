package com.airtribe.libraryManagementSystem.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	
private static final AtomicInteger bookIdCounter = new AtomicInteger(1000);

private static final AtomicInteger membershipId = new AtomicInteger(1000);
	
	
	public static int getNextBookId() {
		 return bookIdCounter.incrementAndGet();
	}
	
	public static int getMembershipId() {
		 return membershipId.incrementAndGet();
	}

}
