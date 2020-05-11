package com.learning.consult.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.consult.domain.AgentSettingServiceImpl;
import com.learning.consult.domain.contract.AgentSettingService;
import com.learning.consult.repository.contract.AgentSettingRepository;

@Configuration
public class DomainConfig {
	
	@Bean
	public AgentSettingService agentSettingService(AgentSettingRepository agentSettingRepository) {		
		return new AgentSettingServiceImpl(agentSettingRepository);
		
	}

}
