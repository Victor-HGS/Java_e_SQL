package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.funcionarios.Funcionarios;

public class Pesquisar {
	// Select da tabela funcionarios
		public List<Funcionarios> read() throws SQLException {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			List<Funcionarios> fnc = new ArrayList<>();
			
			try {
				PreparedStatement st = con.prepareStatement("USE atividade_conexao_db");
				stmt = con.prepareStatement("SELECT * FROM funcionarios");
				
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
