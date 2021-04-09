package demotcpclienttranslation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JButton;
import democlientview.ClientTranslationFrame;
import demotcptranslationdata.MessageToTranslate;

/**
 * This is class ClientTranslationApplication.
 * 
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

		// Launch GUI
		ClientTranslationFrame frame = new ClientTranslationFrame();
		frame.setVisible(true);

		// Setup button with actionListener
		JButton btnTranslate = frame.getBtnTranslate();
		btnTranslate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					// Connect to the server at localhost, port 4228
					Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

					// Get the output stream from the socket
					OutputStream outputStream = socket.getOutputStream();

					// Create an object output stream form the output stream so we can send an
					// object through it.
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

					// TODO Auto-generated method stub
					String message = frame.getMessageField().getText();
					String targetLanguage = (String) frame.getTargetLanguageBox().getSelectedItem();

					// Create new wrapper class to store message and target language
					MessageToTranslate messageToTranslate = new MessageToTranslate();

					messageToTranslate.setMessage(message);
					messageToTranslate.setTargetLanguage(targetLanguage);

					// Write the object into the output stream to send to server
					objectOutputStream.writeObject(messageToTranslate);

					// Create buffered reader to read from input stream
					DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

					// Read from the network and display the data received
					String text = dataInputStream.readUTF();

					frame.updateTranslatedText(text);

					socket.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

	}

}
