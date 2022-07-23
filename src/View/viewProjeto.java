package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.conexao.ProjetoDAO;
import com.scenario.projeto2.projeto;

import DTO.ProjetoDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class viewProjeto extends JFrame {
	
	

	protected static final ProjetoDTO ProjetoDTO = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtCadastro;
	private JButton btnCadastro;
	private JTable TabelaProjeto;
	private JButton btnPesquisar;
	private JButton btnAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewProjeto frame = new viewProjeto();
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
	public viewProjeto() {
		
		ListarValores();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
	    btnCadastro = new JButton("Cadastro");
	    btnCadastro.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    	}
	    });
	    
	    btnAlterar = new JButton("Alterar");
	    btnAlterar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		alterarProjeto(ProjetoDTO);
	    		ListarValores();
	    		
	    		
	    	}
	    });
	    panel.add(btnAlterar);
	    panel.add(btnCadastro);
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel);
		
		txtCadastro = new JTextField();
		panel.add(txtCadastro);
		txtCadastro.setColumns(10);
	  
	  btnPesquisar = new JButton("Pesquisar");
	  btnPesquisar.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  		ListarValores();
	  	}
	  });
	  panel.add(btnPesquisar);
		
	  TabelaProjeto = new JTable();
		panel.add(TabelaProjeto);
	}
	
	private void ListarValores() {
		try {
			ProjetoDAO objprojetoDao = new ProjetoDAO();
			DefaultTableModel model = (DefaultTableModel) TabelaProjeto.getModel();
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
	
	
	
	
	
	
	 private void alterarProjeto(ProjetoDTO objProjetodto) {
		 
		 try {
			 ProjetoDAO objProjetoDAO = new ProjetoDAO();
			 objProjetoDAO.alterarProjeto(objProjetodto);
						 
			
		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null,"Alterar Valores: " + erro);		}
		 
	 }
		
}
