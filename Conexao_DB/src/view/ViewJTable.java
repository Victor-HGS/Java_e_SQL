package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.FuncionariosDAO;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewJTable {

	private JFrame frame;
	public static JTextField campoPriNome;
	public static JTextField campoUltNome;
	public static JTextField campoCpf;
	public static JTextField campoTelefone;
	public static JTextField campoEmail;
	public static JTable table;
	public static JTextField campoBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewJTable window = new ViewJTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public ViewJTable() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Titulo = new JLabel("CADASTRO DE FUNCIONÁRIOS");
		Titulo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Titulo.setBounds(191, 11, 210, 14);
		frame.getContentPane().add(Titulo);
		
		JLabel SubTitulo1 = new JLabel("DADOS PESSOAIS");
		SubTitulo1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		SubTitulo1.setBounds(21, 95, 126, 14);
		frame.getContentPane().add(SubTitulo1);
		
		JLabel Label1 = new JLabel("PRIMEIRO NOME:");
		Label1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Label1.setBounds(21, 131, 103, 14);
		frame.getContentPane().add(Label1);
		
		JLabel Label3 = new JLabel("CPF:");
		Label3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Label3.setBounds(21, 167, 46, 14);
		frame.getContentPane().add(Label3);
		
		JLabel Label2 = new JLabel("ÙLTIMO NOME:");
		Label2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Label2.setBounds(279, 131, 103, 14);
		frame.getContentPane().add(Label2);
		
		JLabel SubTitulo2 = new JLabel("DADOS DE CONTATO");
		SubTitulo2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		SubTitulo2.setBounds(21, 212, 171, 14);
		frame.getContentPane().add(SubTitulo2);
		
		campoPriNome = new JTextField();
		campoPriNome.setBounds(133, 128, 117, 20);
		frame.getContentPane().add(campoPriNome);
		campoPriNome.setColumns(10);
		
		campoUltNome = new JTextField();
		campoUltNome.setColumns(10);
		campoUltNome.setBounds(380, 128, 117, 20);
		frame.getContentPane().add(campoUltNome);
		
		campoCpf = new JTextField();
		campoCpf.setColumns(10);
		campoCpf.setBounds(59, 164, 133, 20);
		frame.getContentPane().add(campoCpf);
		
		JLabel Label4 = new JLabel("TELEFONE:");
		Label4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Label4.setBounds(21, 240, 73, 14);
		frame.getContentPane().add(Label4);
		
		campoTelefone = new JTextField();
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(92, 237, 133, 20);
		frame.getContentPane().add(campoTelefone);
		
		JLabel Label5 = new JLabel("E-MAIL:");
		Label5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Label5.setBounds(279, 240, 46, 14);
		frame.getContentPane().add(Label5);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(334, 240, 163, 20);
		frame.getContentPane().add(campoEmail);
		
		// Botão de Inserção de dados
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
				
				try {
					funcionariosDAO.insert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCadastrar.setBounds(21, 282, 117, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
				
				if(table.getSelectedRow() != -1) {
					try {
						funcionariosDAO.update();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnAtualizar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAtualizar.setBounds(158, 282, 117, 23);
		frame.getContentPane().add(btnAtualizar);
		
		// Pesquisa dos dados		
		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
				
				try {
					funcionariosDAO.select();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPesquisar.setBounds(304, 282, 117, 23);
		frame.getContentPane().add(btnPesquisar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
				
				if(table.getSelectedRow() != -1) {
					try {
						funcionariosDAO.delete();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
				}
			}
		});
		btnExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnExcluir.setBounds(453, 282, 117, 23);
		frame.getContentPane().add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.addKeyListener(new KeyAdapter() {			
		});
		scrollPane.setBounds(21, 316, 549, 172);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			// Ao selecionar um registro da tabela, os campos são preenchidos com os referentes dados
			@Override
			public void mouseReleased(MouseEvent e) {
				if(table.getSelectedRow() != -1) {
					campoPriNome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					campoUltNome.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					campoCpf.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
					campoTelefone.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
					campoEmail.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um registro para atualizar");
				}	
			}
		});
		table.setFillsViewportHeight(true);
		table.addKeyListener(new KeyAdapter() {
			
			
		});
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Primeiro Nome", "Ultimo Nome", "CPF", "Telefone", "E-mail"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(34);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(126);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(129);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(103);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(127);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		campoBuscar = new JTextField();
		campoBuscar.setColumns(10);
		campoBuscar.setBounds(21, 64, 385, 20);
		frame.getContentPane().add(campoBuscar);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
				
				try {
					funcionariosDAO.readRegEsp(campoBuscar.getText(), campoBuscar.getText(), campoBuscar.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnBuscar.setBounds(424, 65, 84, 20);
		frame.getContentPane().add(btnBuscar);
	}
}
