package demotcpservertranslation;

import java.util.HashMap;
import java.util.Map;
import demotcptranslationdata.MessageToTranslate;

/**
 * This is the translation controller to translate message to target language
 * 
 * @author Cecilia
 *
 */
public class TranslationController {

	private Map bahasaMalaysiaTranslation;
	private Map arabicTranslation;
	private Map koreanTranslation;
	private Map languageMap;

	public TranslationController() {

		// Populate Bahasa Malaysia Translation
		bahasaMalaysiaTranslation = new HashMap();
		bahasaMalaysiaTranslation.put("good morning", "Selamat pagi");
		bahasaMalaysiaTranslation.put("good night", "Selamat malam");
		bahasaMalaysiaTranslation.put("how are you?", "Apa khabar?");
		bahasaMalaysiaTranslation.put("thank you", "Terima kasih");
		bahasaMalaysiaTranslation.put("goodbye", "Selamat tinggal");
		bahasaMalaysiaTranslation.put("what's up?", "Ada apa?");

		// Populate Arabic Translation
		arabicTranslation = new HashMap();
		arabicTranslation.put("good morning", "صباح الخير");
		arabicTranslation.put("good night", "طاب مساؤك");
		arabicTranslation.put("how are you?", "كيف حالك؟");
		arabicTranslation.put("thank you", "شكرا لك");
		arabicTranslation.put("goodbye", "مع السالمة");
		arabicTranslation.put("what's up?", "ما أخبارك؟");

		// Populate Korean Translation
		koreanTranslation = new HashMap();
		koreanTranslation.put("good morning", "좋은 아침");
		koreanTranslation.put("good night", "안녕히 주무세요");
		koreanTranslation.put("how are you?", "어떻게 지내세요?");
		koreanTranslation.put("thank you", "감사합니다");
		koreanTranslation.put("goodbye", "안녕");
		koreanTranslation.put("what's up?", "뭐야?");

		// Populate translation map
		languageMap = new HashMap();
		languageMap.put("bahasa malaysia", bahasaMalaysiaTranslation);
		languageMap.put("arabic", arabicTranslation);
		languageMap.put("korean", koreanTranslation);

	}

	public String getTranslation(MessageToTranslate message) {

		// Get the correct translation map
		Map translationMap = (Map) languageMap.get(message.getTargetLanguage().toLowerCase());
		return (String) translationMap.get(message.getMessage().toLowerCase());

	}

}
