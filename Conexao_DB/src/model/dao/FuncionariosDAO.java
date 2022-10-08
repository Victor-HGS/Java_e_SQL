package model.dao;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import model.funcionarios.Funcionarios;
import view.ViewJTable;

public class FuncionariosDAO {
	
	// Método de inserção dos dados
	public void insert() throws SQLException {
		Funcionarios f = new Funcionarios();
		Inserir dao = new Inserir();
		
		// Coletando dados inseridos nos campos
		f.setPrimeiro_nome(ViewJTable.campoPriNome.getText());
		f.setUltimo_nome(ViewJTable.campoUltNome.getText());
		f.setCpf(ViewJTable.campoCpf.getText());
		f.setTelefone(ViewJTable.campoTelefone.getText());
		f.setEmail(ViewJTable.campoEmail.getText());
		
		dao.create(f);
		
		// Limpeza dos campos do formulário
		ViewJTable.campoPriNome.setText("");
		ViewJTable.campoUltNome.setText("");
		ViewJTable.campoCpf.setText("");
		ViewJTable.campoTelefone.setText("");
		ViewJTable.campoEmail.setText("");
	}
	
	// Método select dos dados
		public void select() throws SQLException {
			DefaultTableModel modelo = (DefaultTableModel) ViewJTable.table.getModel();
			modelo.setNumRows(0);
			Pesquisar fdao = new Pesquisar();		
			
			// Realizando a leitura as linhas da tabela funcionarios
			for(Funcionarios f: fdao.read()) {
				modelo.addRow(new Object[] {
						f.getId(),
						f.getPrimeiro_nome(),
						f.getUltimo_nome(),
						f.getCpf(),
						f.getTelefone(),
						f.getEmail()
				});
			}
		}
	
		// Método de atualização dos dados
		public void update() throws SQLException {
			Funcionarios f = new Funcionarios();
			Atualizar dao = new Atualizar();
			
			// Coletando dados inseridos nos campos
			f.setPrimeiro_nome(ViewJTable.campoPriNome.getText());
			f.setUltimo_nome(ViewJTable.campoUltNome.getText());
			f.setCpf(ViewJTable.campoCpf.getText());
			f.setTelefone(ViewJTable.campoTelefone.getText());
			f.setEmail(ViewJTable.campoEmail.getText());
			f.setId((int)ViewJTable.table.getValueAt(ViewJTable.table.getSelectedRow(), 0));
			
			dao.update(f);
			
			// Limpeza dos campos do formulário
			ViewJTable.campoPriNome.setText("");
			ViewJTable.campoUltNome.setText("");
			ViewJTable.campoCpf.setText("");
			ViewJTable.campoTelefone.setText("");
			ViewJTable.campoEmail.setText("");
		}
	
		// Método de deleção dos dados
		public void delete() throws SQLException {
			Funcionarios f = new Funcionarios();
			Deletar dao = new Deletar();
			
			// Coletando dados inseridos nos campos
			
			f.setId((int)ViewJTable.table.getValueAt(ViewJTable.table.getSelectedRow(), 0));
			
			dao.delete(f);
			
			// Limpeza dos campos do formulário
			ViewJTable.campoPriNome.setText("");
			ViewJTable.campoUltNome.setText("");
			ViewJTable.campoCpf.setText("");
			ViewJTable.campoTelefone.setText("");
			ViewJTable.campoEmail.setText("");
		}
	
		// Método select específico
		public void readRegEsp(String prinome, String ultnome, String cpf) throws SQLException {
			DefaultTableModel modelo = (DefaultTableModel) ViewJTable.table.getModel();
			modelo.setNumRows(0);
			Buscar fdao = new Buscar();		
			
			// Realizando a leitura as linhas da tabela funcionarios
			for(Funcionarios f: fdao.readEsp(prinome, ultnome, cpf)) {
				modelo.addRow(new Object[] {
						f.getId(),
						f.getPrimeiro_nome(),
						f.getUltimo_nome(),
						f.getCpf(),
						f.getTelefone(),
						f.getEmail()
				});
			}
			
			ViewJTable.campoBuscar.setText("");
		}
	
}
