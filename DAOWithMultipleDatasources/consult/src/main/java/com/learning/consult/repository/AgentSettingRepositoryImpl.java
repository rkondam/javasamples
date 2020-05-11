package com.learning.consult.repository;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.annotation.Transactional;

import com.learning.consult.domain.model.AgentSetting;
import com.learning.consult.repository.contract.AgentSettingRepository;

@Transactional
public class AgentSettingRepositoryImpl implements AgentSettingRepository {

	private static final Logger logger = LoggerFactory.getLogger(AgentSettingRepositoryImpl.class);

	private NamedParameterJdbcTemplate jdbcTemplate_db1;
	private NamedParameterJdbcTemplate jdbcTemplate_db2;

	private static final String INSERT_AGENT_SETTING_SQL = "INSERT INTO AGENTSETTINGS ( AGENTID, NAME, ISAVAILABLE) VALUES (:agentID,:name,:isAvailable)";

	public AgentSettingRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate_db1,
			NamedParameterJdbcTemplate jdbcTemplate_db2) {
		this.jdbcTemplate_db1 = jdbcTemplate_db1;
		this.jdbcTemplate_db2 = jdbcTemplate_db2;
	}

	@Override
	public void addAgentSetting(AgentSetting agentSetting) {
		// TODO Auto-generated method stub

		try {

			Map<String, Object> paramMap = new HashMap<>();

			// paramMap.put("id", agentSetting.getId());
			paramMap.put("agentID", agentSetting.getAgentId());
			paramMap.put("name", agentSetting.getName());
			paramMap.put("isAvailable", agentSetting.getIsAvailable());

			if (null != agentSetting.getAgentId() && Integer.parseInt(agentSetting.getAgentId()) % 2 == 0) {
				jdbcTemplate_db1.update(INSERT_AGENT_SETTING_SQL, paramMap);
			} else if (null != agentSetting.getAgentId() && Integer.parseInt(agentSetting.getAgentId()) % 2 != 0) {
				jdbcTemplate_db2.update(INSERT_AGENT_SETTING_SQL, paramMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// Prints what exception has been thrown
			System.out.println(e);
		}
		;
	}
}
