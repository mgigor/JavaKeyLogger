package handlers;

public class KeyStorage {

	private int keyCode;
	private boolean pressed;
	private boolean capslockPressed;
	private long systemTimePressedMillis;
	
	public KeyStorage(int keyCode, boolean pressed, boolean capslockPressed, long systemTimePressedMillis) {
		this.keyCode = keyCode;
		this.pressed = pressed;
		this.capslockPressed = capslockPressed;
		this.systemTimePressedMillis = systemTimePressedMillis;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public boolean isPressed() {
		return pressed;
	}

	public boolean isCapslockPressed() {
		return capslockPressed;
	}
	
	public long getSystemTimePressedMillis() {
		return systemTimePressedMillis;
	}
	
}
