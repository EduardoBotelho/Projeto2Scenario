package View;


	
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

import com.conexao.ProjetoDAO;

import DTO.ProjetoDTO;

import javax.swing.JButton;
	import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
	import javax.swing.JTextField;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class viewCliente extends JFrame{	

		private JPanel contentPane;
		private JTextField txtNome;
		private JTable tblProjeto;
		private JTextField txtCodigo;
		private JTextField txtDescricao;
		private JComboBox<String> cbxAmbiente;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			
			try {
				for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
				
				}
			} catch(ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException  ex) {
				System.err.println(ex);
			}
			
			
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						viewCliente frame = new viewCliente();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public viewCliente() {
			
			
			//listarValores();
		//	restauraDadosComboBox();
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 511);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int codigo;
					String nome;
					String descricao;
					
					codigo = Integer.parseInt(txtCodigo.getText());
					nome = txtNome.getText();
					descricao = txtDescricao.getText();
					
					ProjetoDTO objProjetoDTO = new ProjetoDTO();
					
					objProjetoDTO.setCodigo(codigo);
					objProjetoDTO.setNome(nome);
					objProjetoDTO.setDescricao(descricao);
					
					ProjetoDAO objProjetoDAO = new ProjetoDAO();
					objProjetoDAO.cadastrarProjeto(objProjetoDTO);
					
					
					JOptionPane.showMessageDialog(null, "Nome: " + txtNome.getText());
					
					//funcao compara nome do projeto colocado
					
					
				}
			});
			
			btnCadastrar.setBounds(299, 31, 89, 23);
			contentPane.add(btnCadastrar);
			
			txtNome = new JTextField();
			txtNome.setBounds(103, 32, 109, 20);
			contentPane.add(txtNome);
			txtNome.setColumns(10);
			
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(10, 35, 46, 14);
			contentPane.add(lblNome);
			
			JLabel labelProjeto = new JLabel("Projeto");
			labelProjeto.setBounds(47, 35, 46, 14);
			contentPane.add(labelProjeto);
			
			JLabel lblNewLabel = new JLabel("Ambiente");
			lblNewLabel.setBounds(10, 109, 46, 14);
			contentPane.add(lblNewLabel);
			
			JComboBox<ProjetoDAO> cbxAmbiente = new JComboBox<ProjetoDAO>();
			cbxAmbiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					restauraDadosComboBox();
				}
			});
			cbxAmbiente.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
			cbxAmbiente.setSelectedIndex(0);
			cbxAmbiente.setBounds(103, 105, 109, 22);
			contentPane.add(cbxAmbiente);
			
			JButton btnLimpar = new JButton("Limpar");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbxAmbiente.setSelectedIndex(-1);
				}
			});
			
			
			tblProjeto = new JTable();
			tblProjeto.setCellSelectionEnabled(true);
			tblProjeto.setColumnSelectionAllowed(true);
			tblProjeto.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Id", "Nome", "Descricao"
				}
			));
			tblProjeto.setBounds(10, 193, 378, 141);
			contentPane.add(tblProjeto);
			
			JButton btnCarregaCampos = new JButton("Carrega Campos");
			btnCarregaCampos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					carregarCampos();
					restauraDadosComboBox();
				}
			});
			btnCarregaCampos.setBounds(299, 378, 133, 23);
			contentPane.add(btnCarregaCampos);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo");
			lblNewLabel_1.setBounds(10, 11, 46, 14);
			contentPane.add(lblNewLabel_1);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(103, 8, 109, 20);
			contentPane.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtDescricao = new JTextField();
			txtDescricao.setBounds(103, 66, 109, 20);
			contentPane.add(txtDescricao);
			txtDescricao.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Descricao");
			lblNewLabel_2.setBounds(10, 69, 46, 14);
			contentPane.add(lblNewLabel_2);
			
			JButton btnAlterar = new JButton("Alterar");
			btnAlterar.setBounds(299, 65, 89, 23);
			contentPane.add(btnAlterar);
			
			btnAlterar.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		alterarProjeto();
		    		listarValores();
		    		
		    		
		    	}
		    });
		    
			
			
			JButton btnExcluir = new JButton("Excluir");
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					excluirProjeto();
				}
			});
			btnExcluir.setBounds(299, 105, 89, 23);
			contentPane.add(btnExcluir);
			
			JButton btnNewButton = new JButton("Limpar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limparCampos();
				}
			});
			btnNewButton.setBounds(299, 139, 89, 23);
			contentPane.add(btnNewButton);
			
			
		}
		
		
		private void excluirProjeto() {
			 String nome_projeto;
			 
			 nome_projeto=txtNome.getText();
			 
			 ProjetoDTO objProjetoDTO = new ProjetoDTO();
			 objProjetoDTO.setNome(nome_projeto);
			 
			 ProjetoDAO objProjetoDAO = new ProjetoDAO();
			 objProjetoDAO.excluirProjeto(objProjetoDTO);
			 
		 }
		
		
		 private void alterarProjeto() {
			 
			 String nome_projeto;
			 
			 nome_projeto= txtNome.getText();
			 
			 ProjetoDTO objProjetoDTO = new ProjetoDTO();
			 
			 objProjetoDTO.setNome(nome_projeto);
			 
			 ProjetoDAO objProjetoDAO = new ProjetoDAO();
			 
			 objProjetoDAO.alterarProjeto(objProjetoDTO);
			 
			 
			  
		 }
		
		
		
		
		private void listarValores() {
			
			
			try {
				ProjetoDAO objprojetoDao = new ProjetoDAO();
				DefaultTableModel model = (DefaultTableModel) tblProjeto.getModel();
				model.setNumRows(0);
				
				ArrayList<ProjetoDTO> lista = objprojetoDao.PesquisarProjeto();
				for(int num = 0;num < lista.size();num++) {
					model.addRow(new Object[]{
						lista.get(num).getNome(),
					});
				}
				
				
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null," Listar Valores View:" + erro);
			}
		}
		
		
		
		
		
		Vector<Integer> id_ambiente = new Vector<Integer>();
		
		public void restauraDadosComboBox() {
			try {
				
				ProjetoDAO objprojetoDAO = new ProjetoDAO();
				ResultSet rs = objprojetoDAO.listarAmbiente();
				
				while(rs.next()) {
					id_ambiente.addElement(rs.getInt(1));
					cbxAmbiente.addItem(rs.getString(2));
					
					}
			
				
			} catch (SQLException erro) {
				
				JOptionPane.showMessageDialog(null, " Carregar ComboBox: " +  erro);
			}
		}
		
		private void carregarCampos() {
			int setar = tblProjeto.getSelectedRow();
			
			txtCodigo.setText(tblProjeto.getModel().getValueAt(setar, 0).toString());
			txtNome.setText(tblProjeto.getValueAt(setar, 1).toString());
			txtDescricao.setText(tblProjeto.getValueAt(setar, 2).toString());
			
			}
		
		
		private void limparCampos() {
			txtCodigo.setText("");
			txtNome.setText("");
			txtDescricao.setText("");
			txtCodigo.requestFocus();
			
		}
	}






