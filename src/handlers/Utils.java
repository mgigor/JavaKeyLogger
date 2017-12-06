package handlers;

import java.awt.event.KeyEvent;
import java.util.List;

public final class Utils {
	
	private Utils() {}
	
	public static String prettyPrint(List<KeyStorage> storage) {
		if(storage.isEmpty())
			return "{NOTHING}";
		
		StringBuilder sb = new StringBuilder();
		boolean[] caps = new boolean[256];
		for (KeyStorage keyStorage : storage) {
			caps[keyStorage.getKeyCode()] = keyStorage.isPressed();
			String key = processKeyABNT2( keyStorage.getKeyCode(), caps[KeyEvent.VK_SHIFT] );
			
			if(keyStorage.isPressed()) {
	
				if(caps[KeyEvent.VK_SHIFT] != keyStorage.isCapslockPressed()) {
					sb.append(key.toUpperCase());
				}else {
					sb.append(key.toLowerCase());
				}
			}
		}
		return sb.toString();
	}
	


	private static String processKeyABNT2(int keycode, boolean shifted) {
		  String key = KeyEvent.getKeyText(keycode);
		  if (key.length() != 1) {
		   key = "{" + KeyEvent.getKeyText(keycode) + "}";
		  }
		 
		  switch (keycode) {
			case KeyEvent.VK_SHIFT:	key = ""; break;
			case KeyEvent.VK_SPACE: key = " "; break;
			case KeyEvent.VK_BACK_QUOTE: if(shifted) key = "\""; else key ="'"; break;
			case KeyEvent.VK_1: if(shifted) key = "!"; break;
			case KeyEvent.VK_2: if(shifted) key = "@"; break;
			case KeyEvent.VK_3: if(shifted) key = "#"; break;
			case KeyEvent.VK_4: if(shifted) key = "$"; break;
			case KeyEvent.VK_5: if(shifted) key = "%"; break;
			case KeyEvent.VK_6: if(shifted) key = "¨"; break;
			case KeyEvent.VK_7: if(shifted) key = "&"; break;
			case KeyEvent.VK_8: if(shifted) key = "*"; break;
			case KeyEvent.VK_9: if(shifted) key = "("; break;
			case KeyEvent.VK_0: if(shifted) key = ")"; break;
			case KeyEvent.VK_SEMICOLON: if(shifted) key = "Ç"; else key ="ç"; break;
			case KeyEvent.VK_COMMA: if(shifted) key = "<"; else key =","; break;
			case KeyEvent.VK_PERIOD: if(shifted) key = ">"; else key ="."; break;
			case KeyEvent.VK_DEAD_ACUTE: if(shifted) key = ":"; else key =";"; break;
			case KeyEvent.VK_QUOTE: if(shifted) key = "^"; else key ="~"; break;
			case KeyEvent.VK_BACK_SLASH: if(shifted) key = "}"; else key ="]"; break;
			case KeyEvent.VK_OPEN_BRACKET: if(shifted) key = "`"; else key ="´"; break;
			case KeyEvent.VK_CLOSE_BRACKET: if(shifted) key = "{"; else key ="["; break;
			case KeyEvent.VK_MINUS: if(shifted) key = "-"; else key ="_"; break;
			case KeyEvent.VK_EQUALS: if(shifted) key = "+"; else key ="="; break;
			case KeyEvent.VK_UNDEFINED: key = "{unknow}"; break;
			}
		  
		  return key;
	 }


}
