package com.example.estudiante.cliente;

import android.util.Log;

import java.io.*;
import java.net.Socket;


public class Receptor extends Thread{
	Socket socket;
	OnMessage observer;
	
	public Receptor(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			BufferedReader reader = new BufferedReader( new InputStreamReader(is) );
		
			while(true){
				String line = reader.readLine();
				Log.e("RECIBIDO", line);


				observer.OnReceived(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Siempre quiero que este en funcionamiento
		
	}


	public interface OnMessage{

public void  OnReceived(String mensaje);


	}

	public void setObserver (OnMessage observer){
		this.observer=observer;

	}

}
