package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.funcionarios.Funcionarios;

public class Buscar {
	// Pesquisa de registro específico
		public List<Funcionarios> readEsp(String prinome, String ultnome, String cpf) throws SQLException {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			List<Funcionarios> fnc = new ArrayList<>();
			
			try {
				PreparedStatement st = con.prepareStatement("USE atividade_conexao_db");
				stmt = con.prepareStatement("SELECT * FROM funcionarios WHERE "
						+ "primeiro_nome LIKE ? or "
						+ "ultimo_nome LIKE ? or "
						+ "cpf LIKE ?");
				
				stmt.setString(1, "%"+prinome+"%");
				stmt.setString(2, "%"+ultnome+"%");
				stmt.setString(3, "%"+cpf+"%");
				
				st.executeUpdate();
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					Funcionarios funcionarios = new Funcionarios();
					
					funcionarios.setId(rs.getInt("id"));
					funcionarios.setPrimeiro_nome(rs.getString("primeiro_nome"));
					funcionarios.setUltimo_nome(rs.getString("ultimo_nome"));
					funcionarios.setCpf(rs.getString("cpf"));
					funcionarios.setTelefone(rs.getString("telefone"));
					funcionarios.setEmail(rs.getString("email"));
					fnc.add(funcionarios);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(con, stmt, rs);
			}
			
			return fnc;
			
		}
}
