package View;


	
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

import com.conexao.ProjetoDAO;

import DTO.ProjetoDTO;

import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JTextField;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class viewCliente extends JFrame{	

		private JPanel contentPane;
		private JTextField txtNome;
		private JTable tblProjeto;
		private JTextField txtCodigo;

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
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 511);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnAo = new JButton("Cadastrar");
			btnAo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int codigo;
					String nome;
					//String descricao;
					codigo = txtCodigo.getText();
					
					nome = txtNome.getText();
					ProjetoDTO objProjetoDTO = new ProjetoDTO();
					
					
					objProjetoDTO.setNome(nome);
					//objProjetoDTO.setDescricao(descricao);
					
					ProjetoDAO objProjetoDAO = new ProjetoDAO();
					objProjetoDAO.cadastrarProjeto(objProjetoDTO);
					
					
					JOptionPane.showMessageDialog(null, "Nome: " + txtNome.getText());
					
					//funcao compara nome do projeto colocado
					
					if(txtNome.getText() == "teste") //nomeArmazenadoProjeto()))
					{
						//showprojectinfo
					}
				}
			});
			
			btnAo.setBounds(299, 31, 89, 23);
			contentPane.add(btnAo);
			
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
			lblNewLabel.setBounds(10, 71, 46, 14);
			contentPane.add(lblNewLabel);
			
			JComboBox cbxAmbiente = new JComboBox();
			cbxAmbiente.setBounds(103, 67, 109, 22);
			contentPane.add(cbxAmbiente);
			
			JButton btnNewButton = new JButton("Limpar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbxAmbiente.setSelectedIndex(-1);
				}
			});
			
			btnNewButton.setBounds(299, 65, 89, 23);
			contentPane.add(btnNewButton);
			
			tblProjeto = new JTable();
			tblProjeto.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Id", "Nome", "Descricao", "Ambientes"
				}
			));
			tblProjeto.setBounds(10, 193, 378, 141);
			contentPane.add(tblProjeto);
			
			JButton btnCarregaCampos = new JButton("Carrega Campos");
			btnCarregaCampos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnCarregaCampos.setBounds(299, 105, 89, 23);
			contentPane.add(btnCarregaCampos);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo");
			lblNewLabel_1.setBounds(10, 11, 46, 14);
			contentPane.add(lblNewLabel_1);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(103, 8, 109, 20);
			contentPane.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			
		}
		
		public void carregarCampos() {
			int setar = tblProjeto.getSelectedRow();
			
			txtCodigo.setText(tblProjeto.getModel().getValueAt(setar, 0).toString());
			txtNome.setText(tblProjeto.getValueAt(setar, 1).toString());
			
			}
	}



