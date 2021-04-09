package demotcpservertranslation;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import demoserverview.ServerTranslationApplicationFrame;
import demotcptranslationdata.MessageToTranslate;

/**
 * @author Cecilia
 *
 */
public class ServerTranslationApplication {

	/**
	 * Main entry point
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Launch GUI
		ServerTranslationApplicationFrame frame = new ServerTranslationApplicationFrame();
		frame.setVisible(true);

		ServerSocket serverSocket = null;

		try {
			// Bind Server socket to a port
			int portNo = 4228;
			serverSocket = new ServerSocket(portNo);

			System.out.println("Waiting for request");

			while (true) {

				frame.updateServerStatus(false);

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();

				// Get the input stream from the connected socket
				InputStream inputStream = clientSocket.getInputStream();

				// Create Object input stream to read object from the input stream
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

				// Initialize the message object from reading the input stream
				MessageToTranslate message = (MessageToTranslate) objectInputStream.readObject();

				// Create new translation controller
				TranslationController translationController = new TranslationController();

				// Get translated message
				String translatedMessage = translationController.getTranslation(message);

				// Create stream to write data on the network
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

				// Send current date back to the client
				outputStream.writeUTF(translatedMessage);

				// CLose the socket
				clientSocket.close();

				// Update request status
				frame.updateRequestStatus("Data sent to client: " + translatedMessage);

			}

			// Closing is not necessary because the code is unreachable

		} catch (IOException ioe) {

			if (serverSocket != null) {
				serverSocket.close();
			}

			ioe.printStackTrace();

		}
	}
}
