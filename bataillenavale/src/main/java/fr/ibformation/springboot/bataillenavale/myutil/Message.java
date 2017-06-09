package fr.ibformation.springboot.bataillenavale.myutil;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Message implements Serializable {

	String value;

	@Override
	public String toString() {
		return "Message [value=" + value + "]";
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
