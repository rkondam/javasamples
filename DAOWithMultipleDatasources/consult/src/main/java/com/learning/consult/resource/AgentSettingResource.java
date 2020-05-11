package com.learning.consult.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.consult.domain.contract.AgentSettingService;
import com.learning.consult.domain.model.AgentSetting;

@RestController
@RequestMapping("/consult/agentsetting")
public class AgentSettingResource {

	private AgentSettingService agentSettingService;
	
	public AgentSettingResource(AgentSettingService agentSettingService) {
		this.agentSettingService=agentSettingService;		
	}
	
	
	@PostMapping("/add")
	public void addAgentSetting(@RequestBody AgentSetting agentSetting) {	
		agentSettingService.addAgentSetting(agentSetting);		
	}
	
	
}
