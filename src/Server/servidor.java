package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class servidor {
	
	
	private ServerSocket serverSocket;


	private void criarServerSocket( int porta) throws IOException {
		serverSocket = new ServerSocket(porta);
	}
	
	private Socket esperaConexao() throws IOException{
		Socket socket = new Socket();
		return socket;
	}
	
	private void fechaSocket(Socket s) throws IOException {
		s.close();
	}
	
	private void trataConexao(Socket socket) throws IOException {
		
		try {
			
				
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			
			String msg = input.readUTF();
			output.writeUTF(msg);
			output.flush();
			
			input.close(); 	
			output.close();
			socket.close();
			
			
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Tratando conexao : " + erro);
		}finally {
			fechaSocket(socket);
		}
		
		
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		servidor servidor = new servidor();
		servidor.criarServerSocket(4444);
		
		try {
			while(true) {
			Socket socket = servidor.esperaConexao();//protocolo
			
			
			servidor.trataConexao(socket); 	
			
			}
			
		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null,"Criacao servidor " + erro);
		}
		
	}

}
