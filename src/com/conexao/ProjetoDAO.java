package com.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.ProjetoDTO;

public class ProjetoDAO {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<ProjetoDTO> lista = new ArrayList<>();
	
	
	public void cadastrarProjeto(ProjetoDTO objProjetoDTO) {
		
		String sql = "insert into Projeto(nome) values(?) ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objProjetoDTO.getNome());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null,"ProjetoDAO" + erro);
			// TODO: handle exception
		}
		
	}
	
	public ArrayList<ProjetoDTO> PesquisarProjeto(){

		
		String sql="select * from projeto";
		conn = new ConexaoDAO().conectaBD();
		
		
		try {
			
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ProjetoDTO objProjetoDTO = new ProjetoDTO();
				objProjetoDTO.setNome(rs.getString("nome"));
				
				lista.add(objProjetoDTO);
			}
			
		} catch (SQLException erro) {
			
			JOptionPane.showMessageDialog(null,"ProjetoDAO Pesquisar" +  erro);
		}
		
		return lista;
		
	}


public void alterarProjeto(ProjetoDTO objProjetodto) {
	
	String sql ="update nome set nome = ? where nome = ? ";
	conn = new ConexaoDAO().conectaBD();
	
	try {
		pstm = conn.prepareStatement(sql);
		pstm.setString(0, objProjetodto.getNome());
		
		pstm.execute();
		pstm.close();
		
	} catch (Exception erro) {
		
		JOptionPane.showMessageDialog(null,"ProjetoDAO Alterar" + erro);
		// TODO: handle exception
	}
	
	
}

}
