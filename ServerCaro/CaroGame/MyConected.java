package CaroGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConected {
	private final String classname = "com.mysql.jdbc.Driver";
	private Connection connection;
	private final String url = "jdbc:mysql://localhost:3306/user_info";
	private final String user = "root";
	private final String pass = "Ndayeur10";
	private final String table = "user";

	private void connect() {
		try {
			Class.forName(classname);

			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connect success!");
		} catch (ClassNotFoundException e) {
			System.out.println("fail");
		} catch (SQLException e) {
			System.out.println("Class not found");
		}
	}

	private void showData(ResultSet rs) {
		try {
			while (rs.next())
				System.out.printf("%5.1f %20s %20s \n", rs.getDouble(1), rs.getString(2), rs.getString(3));
		} catch (SQLException e) {
		}
	}

	private ResultSet getData() {
		ResultSet rs = null;
		String sqlCommand = "select * from " + table;
		Statement ts;
		try {
			ts = connection.createStatement();
			rs = ts.executeQuery(sqlCommand);

		} catch (SQLException e) {
			System.out.println("Select error");
		}
		return rs;
	}
	private ResultSet getDataid(String id) {
		ResultSet rs = null;
		String sqlCommand = "select * from " + table +" where `ID_User` = ?";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sqlCommand);

			pst.setString(1, id);
			rs = pst.executeQuery();

		} catch (SQLException e) {
			System.out.println("Select error");
		}
		return rs;
	}

	public static void main(String[] args) {
		MyConected myconect = new MyConected();
		myconect.connect();
		myconect.showData(myconect.getDataid("2"));
	}
}
