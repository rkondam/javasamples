package com.learning.consult.domain.model;


public class AgentSetting {

	private int id;
	private String agentId;
	private String name;
	private int isAvailable;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
