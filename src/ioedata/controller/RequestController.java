package ioedata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class RequestController {
	int i=0;
	private Socket clientSocket;
	private BufferedReader br;
	private PrintWriter pw;
	
	private static final String HOST_ADDRESS = "192.168.1.113";
	private static final int PORT = 80;
	
	private String command = "GET /sensorData/insideHome/all HTTP/1.1";
	
	private class ClientWork implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println(command);
				pw = new PrintWriter(clientSocket.getOutputStream(), true);
				while (true) {
					pw.println(command);

					br = new BufferedReader(new InputStreamReader(
							clientSocket.getInputStream()));
					String msgLine = br.readLine();
					while (msgLine != null) {
						System.out.println(msgLine);
						JSONObject jsonObj = new JSONObject(msgLine);
						System.out.println(jsonObj.toString());
						msgLine = br.readLine();
					}
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value="/test.ioedata")
	public ModelAndView test(String input) throws UnknownHostException, IOException{
		System.out.println(input+(i++));
		
		clientSocket = new Socket(HOST_ADDRESS, PORT);
		System.out.println("Connected to /" + HOST_ADDRESS + ":" + PORT);
		
		ClientWork worker = new ClientWork();
		Thread thread = new Thread(worker);
		thread.start();
		
		return new ModelAndView("test.jsp");
	}
}
