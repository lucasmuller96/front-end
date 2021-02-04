package br.edu.unoesc.java.eleicao.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
	private static Connection conn;

	public static void conectar(String url, String usuario, String senha, String driver) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna uma conexão JDBC
	 * 
	 * @return Connection Implementa pattern singleton
	 */
	public static Connection getConnection() {
		if (conn == null) {
			// this.conectar(url, usuario, senha, driver);
		}
		return conn;
	}

	public static void destroy() {
		try {
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getAutoInc(String sequence) {
		int codigo = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select nextval('" + sequence + "_sq')");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			codigo = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codigo;
	}
}
