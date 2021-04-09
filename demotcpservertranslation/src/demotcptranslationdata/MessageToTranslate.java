package demotcptranslationdata;

import java.io.Serializable;

/**
 * This is the wrapper class for message to translate
 * 
 * @author Cecilia
 *
 */

public class MessageToTranslate implements Serializable {

	// message to be translated
	private String message;

	// language to be translated into
	private String targetLanguage;

	public MessageToTranslate(String message, String targetLanguage) {
		this.message = message;
		this.targetLanguage = targetLanguage;
	}
	
	public MessageToTranslate() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the targetLanguage
	 */
	public String getTargetLanguage() {
		return targetLanguage;
	}

	/**
	 * @param targetLanguage the targetLanguage to set
	 */
	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

}
