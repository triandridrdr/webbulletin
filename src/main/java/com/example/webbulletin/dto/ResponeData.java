package com.example.webbulletin.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponeData<T> {
	
	private boolean status;
	private List<String> messages = new ArrayList<>();
	private T payLoad;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public T getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(T payLoad) {
		this.payLoad = payLoad;
	}
	
	
}
