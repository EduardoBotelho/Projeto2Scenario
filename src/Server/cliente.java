package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class cliente {

	
	
	public static void main(String[] args) {
		try {
			
			Socket socket = new Socket("localhost", 4444);
			
			ObjectOutputStream output =  new ObjectOutputStream(socket.getOutputStream());
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				
			String msg ="TESTE" ;
			
			
			msg = input.readUTF();
			
			output.writeUTF(msg);
			output.flush();
			
			JOptionPane.showMessageDialog(null,"Resposta:" + msg);
			
			
			input.close();
			output.close();
			socket.close();
			
			
		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null, "Problema no tratamento da excecao " + erro);
			
			
		} finally {
			fechaSocket(socket);
			
		}

	}

}
