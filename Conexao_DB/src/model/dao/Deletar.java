package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.funcionarios.Funcionarios;

public class Deletar {
	// Exclusão de registro dos funcionários 
		public void delete(Funcionarios f) throws SQLException {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				PreparedStatement st = con.prepareStatement("USE atividade_conexao_db");
				stmt = con.prepareStatement("DELETE FROM funcionarios WHERE id = ?");
				stmt.setInt(1, f.getId());			
				
				st.executeUpdate();
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Dados Excluídos com Sucesso!");
				
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir dados: " +error);
			} finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
			
		}
}
