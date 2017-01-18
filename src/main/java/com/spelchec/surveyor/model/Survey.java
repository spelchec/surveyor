package com.spelchec.surveyor.model;

import java.util.List;

public class Survey {
	public String title;
	public String description;
	public List questions;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List getQuestions() {
		return questions;
	}
	public void setQuestions(List questions) {
		this.questions = questions;
	}
	
	
}
