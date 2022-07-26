package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class cliente {

	
	
	public static void main(String[] args) {
		try {
			
			Socket socket = new Socket("localhost", 4444);
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream output =  new ObjectOutputStream(socket.getOutputStream());
			
			String msg ="TESTE" ;
			output.writeUTF(msg);
			
			msg = input.readUTF();
			JOptionPane.showMessageDialog(null,"Resposta:" + msg);
			
			
			input.close();
			output.close();
			socket.close();
			
			
		} catch (Exception e) {
			
		}

	}

}
