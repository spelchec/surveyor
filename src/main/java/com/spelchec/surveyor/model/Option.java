package com.spelchec.surveyor.model;

public class Option {
	public String answer;
	public String value;
	public Boolean checked;
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getChecked() {
		return this.checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
