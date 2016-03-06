package org.gjoko.javabrains.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class NamedParameterJdbcTemplateImpl extends NamedParameterJdbcDaoSupport {
	
	

	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

}
