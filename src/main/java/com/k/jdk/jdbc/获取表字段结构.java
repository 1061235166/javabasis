package com.k.jdk.jdbc;

import java.sql.*;

/**
 * @author wyk
 * @date 2019/4/12 17:34
 **/
public class 获取表字段结构 {
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("url","username","password");
		DatabaseMetaData metaData = connection.getMetaData();
		//输入数据库名和表名
		ResultSet rs = metaData.getColumns(null, "databaseName", "tableName", "%");
		while (rs.next()) {
			//获取字段名
			String column_name = rs.getString("COLUMN_NAME");
			//字段类型
			String type_name = rs.getString("TYPE_NAME");
			//字段长度
			int column_size = rs.getInt("COLUMN_SIZE");
			//备注
			String remarks = rs.getString("REMARKS");
			//是否可以为空
			boolean r = 0 == rs.getInt("NULLABLE") ? false : true;
		}
	}
}
