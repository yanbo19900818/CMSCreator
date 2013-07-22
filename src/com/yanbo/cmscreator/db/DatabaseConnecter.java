package com.yanbo.cmscreator.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.yanbo.cmscreator.util.PropertiesManager;
import com.yanbo.cmscreator.vo.ColumInfo;
import com.yanbo.cmscreator.vo.TableInfo;

public class DatabaseConnecter {
	public  Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String ip = PropertiesManager.getValue("ip");
			String port = PropertiesManager.getValue("port");
			String username = PropertiesManager.getValue("username");
			String pwd = PropertiesManager.getValue("pwd");
			String dbName = PropertiesManager.getValue("dbname");
			connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":"
					+ port + "/" + dbName, username, pwd);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("数据库连接出错!");
		}
		return connection;
	}

	public List<TableInfo> createTableInfo() {
		Connection conn = getConnection();
		DatabaseMetaData databaseMetaData;
		List<TableInfo> tableInfos = new ArrayList<TableInfo>();
		try {

			databaseMetaData = conn.getMetaData();
			ResultSet tableSet = databaseMetaData.getTables(null, "%", "%",
					new String[] { "TABLE" });
			while (tableSet.next()) {
				TableInfo tableInfo = new TableInfo();
				String tableName = tableSet.getString("TABLE_NAME");
				tableInfo.setTableName(tableName);
				ResultSet columnSet = databaseMetaData.getColumns(null, "%",
						tableName, "%");
				ResultSet primaryKeySet = databaseMetaData.getPrimaryKeys(null,
						"%", tableName);
				String primaryKeyNameString="";
				while (primaryKeySet.next()) {
					primaryKeyNameString=primaryKeySet.getString("COLUMN_NAME");
				}
				while (columnSet.next()) {
					String colName = columnSet.getString("COLUMN_NAME");
					int colTypeNum = columnSet.getShort("DATA_TYPE");
					String colType = getJavaType(colTypeNum);
					ColumInfo info = new ColumInfo(colType, colName);
					if(primaryKeyNameString.equals(colName))
						info.setPrimary(true);
					tableInfo.addColumInfo(info);
				}
				tableInfos.add(tableInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableInfos;
	}

	private static String getJavaType(int jdbcType) {
		if (jdbcType == Types.BIGINT || jdbcType == Types.FLOAT
				|| jdbcType == Types.DECIMAL || jdbcType == Types.DOUBLE
				|| jdbcType == Types.NUMERIC || jdbcType == Types.REAL)
			return "java.lang.Float";
		else if (jdbcType == Types.CHAR || jdbcType == Types.LONGNVARCHAR
				|| jdbcType == Types.LONGVARCHAR || jdbcType == Types.NCHAR
				|| jdbcType == Types.NVARCHAR || jdbcType == Types.VARCHAR)
			return "java.lang.String";
		else if (jdbcType == Types.BIT || jdbcType == Types.BOOLEAN)
			return "java.lang.Boolean";
		else if (jdbcType == Types.INTEGER || jdbcType == Types.SMALLINT
				|| jdbcType == Types.TINYINT)
			return "java.lang.Integer";
		else if (jdbcType == Types.TIMESTAMP)
			return "java.sql.Timestamp";
		else if (jdbcType == Types.DATE)
			return "java.sql.Date";
		else if (jdbcType == Types.TIME)
			return "java.sql.Time";
		else
			return "java.sql.String";
	}
}
