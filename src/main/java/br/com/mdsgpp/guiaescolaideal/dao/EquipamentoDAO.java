package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mdsgpp.guiaescolaideal.model.Equipamento;

public class EquipamentoDAO {

	private Connection connection;

	public EquipamentoDAO(Connection connection) {
		this.connection = connection;
	}

	public Equipamento pesquisarPorID(int id) throws SQLException {
		String sql = "select * from equipamento where COD_EQUIPAMENTO = ?";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			Equipamento equipamento = new Equipamento();
			String aparelho = rs.getString("DESCRICAO");

			equipamento.setAparelho(aparelho);
			equipamento.setCodEquipamento(id);

			stmt.close();

			return equipamento;
		}

		stmt.close();
		return null; // criar uma exception ???

	}

}
