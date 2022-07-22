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

public class viewCliente extends JFrame{	

		private JPanel contentPane;
		private JTextField txtNome;

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
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnAo = new JButton("Cadastrar");
			btnAo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String nome;
					nome = txtNome.getText();
					ProjetoDTO objProjetoDTO = new ProjetoDTO();
					
					objProjetoDTO.setNome(nome);
					
					ProjetoDAO objProjetoDAO = new ProjetoDAO();
					objProjetoDAO.cadastrarProjeto(objProjetoDTO);
					
					JOptionPane.showMessageDialog(null, "Nome: "+txtNome.getText());
					
					//funcao compara nome do projeto colocado
					
					if(txtNome.getText() == "teste") //nomeArmazenadoProjeto()))
					{
						//showprojectinfo
					}
				}
			});
			btnAo.setBounds(66, 133, 89, 23);
			contentPane.add(btnAo);
			
			txtNome = new JTextField();
			txtNome.setBounds(69, 59, 109, 20);
			contentPane.add(txtNome);
			txtNome.setColumns(10);
			
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(10, 62, 46, 14);
			contentPane.add(lblNome);
			
			JLabel labelProjeto = new JLabel("Projeto");
			labelProjeto.setBounds(176, 22, 46, 14);
			contentPane.add(labelProjeto);
		}
	}



