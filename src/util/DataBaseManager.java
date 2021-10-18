package util;

import java.sql.SQLException;

import totalcross.db.sqlite.SQLiteUtil;
import totalcross.sql.Connection;
import totalcross.sys.Settings;
import totalcross.sys.Vm;


public class DataBaseManager {
	public static SQLiteUtil sqLiteUtil;
	static {
		try {
			sqLiteUtil = new SQLiteUtil(Settings.appPath, "app.db");
		}catch (SQLException e) {
			Vm.debug(e.getMessage());
		}
	}
	
	
	public static Connection getConnection() throws SQLException{
		return sqLiteUtil.con();
	}
	
}
