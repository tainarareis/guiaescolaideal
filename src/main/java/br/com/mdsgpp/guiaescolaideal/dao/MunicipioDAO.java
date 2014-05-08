package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mdsgpp.guiaescolaideal.model.Municipio;

public class MunicipioDAO {

	private Connection connection;

	public MunicipioDAO(Connection connection) {
		this.connection = connection;
	}

	public Municipio pesquisarPorId(int id) throws SQLException {

		String sql = "select * from municipio where COD_MUNICIPIO = ?";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		Municipio municipio = null;

		if (rs.next()) {
			municipio = new Municipio();
			municipio.setNome(rs.getString("DESCRICAO"));
			municipio.setCodigoDDD(rs.getString("DDD"));
		}

		stmt.close();
		return municipio;
	}

}
