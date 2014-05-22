package ioedata.data.controller;

import ioedata.data.model.DataValue;
import ioedata.data.service.DataService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/data")
public class DataController {
	@Resource(name = "dataServiceImpl")
	private DataService dataService;
	
	int i = 0;
	private Socket clientSocket;

	private static final String HOST_ADDRESS = "192.168.0.9";
	private static final int PORT = 80;

	private String command = "GET /sensorData/outsideHome/all HTTP/1.1";
	
	JSONObject jsonObj;

	private class ClientWork implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			BufferedReader br;
			PrintWriter pw;
			try {
				pw = new PrintWriter(clientSocket.getOutputStream(), true);
				//while (true) {
					pw.println(command);
					br = new BufferedReader(new InputStreamReader(
							clientSocket.getInputStream()));
					String msgFirstLine = br.readLine();
					System.out.println("FIRSTLINE "+msgFirstLine);
					String[] strSplit = null;
					if (msgFirstLine != null) {
						strSplit = msgFirstLine.split(" ", 3);
						for(int i=0;i<3;i++){
							System.out.println(strSplit[i]);
						}
						if (strSplit[1].equals("200")
								&& strSplit[2].equals("OK")) {
							for(int i = 0; i<3; i++){
								br.readLine();
							}
							String msgLine = br.readLine();
							while (msgLine != null) {
								jsonObj = new JSONObject(msgLine);
								System.out.println(jsonObj.toString());
								msgLine = br.readLine();
							}
						}
					}
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*clientSocket = new Socket(HOST_ADDRESS, PORT);
	System.out.println("Connected to /" + HOST_ADDRESS + ":" + PORT);

	ClientWork worker = new ClientWork();
	Thread thread = new Thread(worker);
	thread.start();*/
	@RequestMapping(value = "/retrieve/{deviceId}/{sensorType}/{retrieveType}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String retrieveData(@PathVariable("deviceId") String deviceId, @PathVariable("sensorType") String sensorType, @PathVariable("retrieveType") String retrieveType) throws UnknownHostException, IOException {
		//System.out.println(deviceId+" "+retrieveType);
		DataValue dataVal = this.dataService.retrieveData(deviceId, retrieveType);
		JSONObject json = new JSONObject();
		json.put("deviceId", dataVal.getDeviceId());
		json.put("timestamp", dataVal.getSensorDataTimestampStr());
		json.put("dataValue", dataVal.getSensorDataValue());
		json.put("sensorType", dataVal.getSensorValue().getSensorType());
		json.put("unit", dataVal.getSensorValue().getUnit());
		//System.out.println(json.toString());
		return json.toString();
	}
	
	@RequestMapping(value = "/collect/{deviceId}/{sensorType}/{dataCollectionIntervalType}", method = RequestMethod.POST)
	@ResponseBody
	public String collectData(@PathVariable("deviceId") String deviceId, @PathVariable("sensorType") String sensorType, @PathVariable("dataCollectionIntervalType") String dataCollectionIntervalType){
		System.out.println(deviceId+" "+sensorType+" "+dataCollectionIntervalType);
		boolean flag = this.dataService.collectData(deviceId, sensorType, dataCollectionIntervalType);
		return new JSONObject().put("flag", flag).toString();
	}
	
}
















