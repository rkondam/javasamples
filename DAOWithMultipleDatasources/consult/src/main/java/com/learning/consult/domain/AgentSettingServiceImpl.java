package com.learning.consult.domain;

import com.learning.consult.domain.contract.AgentSettingService;
import com.learning.consult.domain.model.AgentSetting;
import com.learning.consult.repository.contract.AgentSettingRepository;

public class AgentSettingServiceImpl implements AgentSettingService {

	private AgentSettingRepository agentSettingRepository;
	
	public AgentSettingServiceImpl(AgentSettingRepository agentSettingRepository) {
		this.agentSettingRepository=agentSettingRepository;		
	}
	
	
	@Override
	public void addAgentSetting(AgentSetting agentSetting) {
		// TODO Auto-generated method stub
		agentSettingRepository.addAgentSetting(agentSetting);
		//agentSettingRepository.addAgentSetting(agentSetting);
	}

}
