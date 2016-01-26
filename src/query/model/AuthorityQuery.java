package query.model;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

public class AuthorityQuery {

	public List<HashMap<String, String>> getResultList(String user_code,
			String program_id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ps = DBConnection.createPreparedStatement("select "
				+ "'' user_group_code, user_authority "
				+ "from edp_base:usrath " + "where user_code = ? "
				+ "and program_id = ? " 
				+ "union " 
				+ "select "
				+ "user_group_code,user_authority " 
				+ "from edp_base:grpath "
				+ "where user_group_code in " 
				+ "(select user_group_code "
				+ "from edp_base:usrgrp " 
				+ "where user_code = ?) "
				+ "and program_id = ?");

		DBConnection.setPreparedStatementString(ps, 1, user_code);
		DBConnection.setPreparedStatementString(ps, 2, program_id);
		DBConnection.setPreparedStatementString(ps, 3, user_code);
		DBConnection.setPreparedStatementString(ps, 4, program_id);
		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(ps));
		DBConnection.closeStatement(ps);
		return list;
	}
}
