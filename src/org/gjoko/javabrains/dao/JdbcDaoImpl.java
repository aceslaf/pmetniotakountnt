package org.gjoko.javabrains.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.gjoko.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JdbcDaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	/*
	 * public Circle getCircle(int circleId) {
	 * 
	 * Connection conn = null; PreparedStatement ps = null; ResultSet rs = null;
	 * Circle circle = null;
	 * 
	 * try { conn = dataSource.getConnection();
	 * 
	 * ps = conn.prepareStatement("SELECT * FROM CIRCLE WHERE ID = ?");
	 * ps.setInt(1, circleId); rs = ps.executeQuery();
	 * 
	 * if (rs.next()) { circle = new Circle(circleId, rs.getString("name")); }
	 * 
	 * rs.close(); ps.close();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try {
	 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return circle; }
	 */

	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getCircleName(int circleId) {
		String sql = "SELECT NAME FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, String.class);
	}

	public Circle getCircleForId(int circleId) {
		String sql = "SELECT * FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, new CircleMapper());
	}

	public List<Circle> getAllCircles() {
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {

			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}

	}
	
	public void insertCircleUsingNameParameters(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES(:id, :name)";
		SqlParameterSource namedParameteres = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameteres);
	}

	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES(?, ?)";
		jdbcTemplate.update(sql, new Object[] { circle.getId(), circle.getName() });
	}

	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE (ID integer, NAME varchar(50))";
		jdbcTemplate.execute(sql);
	}
}
