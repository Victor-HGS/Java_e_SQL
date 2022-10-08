package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.funcionarios.Funcionarios;

public class Atualizar {
	// Atualização dos dados
		public void update(Funcionarios f) throws SQLException {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				PreparedStatement st = con.prepareStatement("USE atividade_conexao_db");
				stmt = con.prepareStatement("UPDATE funcionarios SET primeiro_nome = ?, ultimo_nome = ?, cpf = ?, telefone = ?, email = ? WHERE id = ?");
				stmt.setString(1, f.getPrimeiro_nome());
				stmt.setString(2, f.getUltimo_nome());
				stmt.setString(3, f.getCpf());
				stmt.setString(4, f.getTelefone());
				stmt.setString(5, f.getEmail());
				stmt.setInt(6, f.getId());			
				
				st.executeUpdate();
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!");
				
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " +error);
			} finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
			
		}
}
