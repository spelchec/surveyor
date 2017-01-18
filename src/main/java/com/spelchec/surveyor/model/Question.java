package com.spelchec.surveyor.model;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.spelchec.surveyor.MD5;

public class Question {
	public String question;
	public String type;
	public Integer selectionLimit;
	public List options;
	public Boolean allowOther;

	public String getHashCode() {
		try {
			return MD5.toHash(question);
		} catch (NoSuchAlgorithmException e) {
			return "error";
		}
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSelectionLimit() {
		return selectionLimit;
	}
	public void setSelectionLimit(Integer selectionLimit) {
		this.selectionLimit = selectionLimit;
	}
	public List getOptions() {
		return options;
	}
	public void setOptions(List options) {
		this.options = options;
	}
	public Boolean getAllowOther() {
		return allowOther;
	}
	public void setAllowOther(Boolean allowOther) {
		this.allowOther = allowOther;
	}
	
	
}
