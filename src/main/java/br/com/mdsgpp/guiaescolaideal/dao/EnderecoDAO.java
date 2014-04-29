package br.com.mdsgpp.guiaescolaideal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.mdsgpp.guiaescolaideal.model.Endereco;

public class EnderecoDAO {
	
	private Connection connection;
	
	public EnderecoDAO(Connection connection){
		this.connection = connection;
	}
	
	public Endereco pesquisarPorID(int id) throws SQLException {
		String sql = "select * from endereco where COD_ENDERECO = ?";
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			
			Endereco endereco = new Endereco();
			
			endereco.setBairro(rs.getString("BAIRRO"));
			endereco.setRua(rs.getString("RUA"));
			endereco.setCep(Integer.getInteger(rs.getString("CEP")));
			endereco.setNumero(rs.getString("NUMERO"));
			endereco.setComplemento(rs.getString("COMPLEMENTO"));
			
			stmt.close();
			
			return endereco;
		}
		
		stmt.close();

		return null;
					
	}
		

	
}
