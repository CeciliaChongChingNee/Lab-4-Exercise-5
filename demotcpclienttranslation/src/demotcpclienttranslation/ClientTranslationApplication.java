package demotcpclienttranslation;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import demotcptranslationdata.MessageToTranslate;

/**
 * @author Cecilia
 *
 */
public class ClientTranslationApplication {

	/**
	 * Main entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

			// Get the output stream from the socket
			OutputStream outputStream = socket.getOutputStream();

			// Create an object output stream form the output stream so we can send an
			// object through it.
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			
			// Create new wrapper class to store message and target language
			MessageToTranslate message = new MessageToTranslate();
			
			// Get message to be translate and target language from user
			Scanner input = new Scanner(System.in);
			System.out.print("Please enter your message: ");
			message.setMessage(input.nextLine());;
			System.out.print("Please enter your target langauge (Bahasa Malaysia/Arabic/Korean) :");
			message.setTargetLanguage(input.nextLine());
			
			// Write the object into the output stream to send to server
			objectOutputStream.writeObject(message);

			// Create buffered reader to read from input stream
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			
			// Read from the network and display the data received
			String text = dataInputStream.readUTF();
			System.out.println(text);

			// Close everything
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
