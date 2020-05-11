package com.learning.consult.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.learning.consult.repository.AgentSettingRepositoryImpl;
import com.learning.consult.repository.contract.AgentSettingRepository;

@Configuration
public class RepositoryConfig {
	
	@Bean
	public AgentSettingRepository agentSettingRepository(NamedParameterJdbcTemplate jdbcTemplate_db1,NamedParameterJdbcTemplate jdbcTemplate_db2) {
		return new AgentSettingRepositoryImpl(jdbcTemplate_db1, jdbcTemplate_db2);
	}
}
