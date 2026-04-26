package com.airtribe.libraryManagementSystem.entity;

public enum Genre {
	
	FICTION("Fiction"),
	NON_FICTION("Non Fiction"),
	FINANCE("Finance"),
	POLITICS("Politics"), 
	HISTORY("History"), 
	GEOGRAPHY("Geography"), 
	ANOTOMY("Anatomy"), 
	HEALTH("Health"),
	OTHERS("Others"),
	TECHNOLOGY("Technology"),
	SELF_HELP("Self Help");

	private final String genre;

    private Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
    
    public static Genre fromString(String value) {
        for (Genre genre : Genre.values()) {
            if (genre.name().equalsIgnoreCase(value)) return genre;
        }
        return OTHERS;
        
    }
}
