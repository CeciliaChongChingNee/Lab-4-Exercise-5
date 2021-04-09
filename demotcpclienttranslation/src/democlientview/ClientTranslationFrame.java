package democlientview;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ClientTranslationFrame extends JFrame {

	private JTextField messageField;
	private JComboBox targetLanguageBox;
	private JTextArea translatedTextArea;
	private JButton btnTranslate;

	/**
	 * Initialize layout
	 */
	public ClientTranslationFrame() {

		this.setTitle("TCP Application: Client Side");
		this.getContentPane().setLayout(null);

		this.setSize(new Dimension(537, 273));

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 506, 216);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Please enter your message: ");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel.setBounds(60, 23, 173, 20);
		panel.add(lblNewLabel);

		messageField = new JTextField();
		messageField.setFont(new Font("Serif", Font.PLAIN, 15));
		messageField.setBounds(280, 23, 150, 19);
		panel.add(messageField);
		messageField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Language that you want to translate: ");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 53, 225, 20);
		panel.add(lblNewLabel_1);

		targetLanguageBox = new JComboBox();
		targetLanguageBox.setModel(new DefaultComboBoxModel(new String[] { "Bahasa Malaysia", "Arabic", "Korean" }));
		targetLanguageBox.setFont(new Font("Serif", Font.PLAIN, 15));
		targetLanguageBox.setBounds(280, 55, 150, 21);
		panel.add(targetLanguageBox);

		translatedTextArea = new JTextArea();
		translatedTextArea.setBounds(60, 98, 346, 70);
		panel.add(translatedTextArea);

		btnTranslate = new JButton("Translate");
		btnTranslate.setBounds(201, 175, 89, 23);
		panel.add(btnTranslate);
	}

	// Update the text area with the translated text
	public void updateTranslatedText(String translatedText) {
		this.translatedTextArea.setText(translatedText);
	}

	/**
	 * @return the messageField
	 */
	public JTextField getMessageField() {
		return messageField;
	}

	/**
	 * @return the targetLanguageBox
	 */
	public JComboBox getTargetLanguageBox() {
		return targetLanguageBox;
	}

	/**
	 * @return the translatedTextArea
	 */
	public JTextArea getTranslatedTextArea() {
		return translatedTextArea;
	}

	/**
	 * @return the btnTranslate
	 */
	public JButton getBtnTranslate() {
		return btnTranslate;
	}

}
