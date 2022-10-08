package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.funcionarios.Funcionarios;

public class Inserir {
	// Inclusão de dados no DB
		public void create(Funcionarios f) throws SQLException {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				PreparedStatement st = con.prepareStatement("USE atividade_conexao_db");
				stmt = con.prepareStatement("INSERT INTO funcionarios(primeiro_nome, ultimo_nome, cpf, telefone, email) VALUES (?,?,?,?,?)");
				stmt.setString(1, f.getPrimeiro_nome());
				stmt.setString(2, f.getUltimo_nome());
				stmt.setString(3, f.getCpf());
				stmt.setString(4, f.getTelefone());
				stmt.setString(5, f.getEmail());
				
				st.executeUpdate();
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!");
				
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir dados: " +error);
			} finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
			
		}
}
