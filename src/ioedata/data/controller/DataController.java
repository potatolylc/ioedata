package ioedata.data.controller;

import ioedata.data.model.DataValue;
import ioedata.data.service.DataService;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class provides client requests analysis of all services about sensor data,
 * such as triggering or pausing sensor data collection, data retrieval from sensor database 
 * or sensor data analysis 
 * @author ajou
 *
 */
@Controller
@RequestMapping(value = "/data")
public class DataController {
	@Resource(name = "dataServiceImpl")
	private DataService dataService;
	
	@RequestMapping(value = "/retrieve/{deviceId}/{sensorType}/{retrieveType}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String retrieveData(@PathVariable("deviceId") String deviceId, @PathVariable("sensorType") String sensorType, @PathVariable("retrieveType") String retrieveType) throws UnknownHostException, IOException {
		//System.out.println(deviceId+" "+retrieveType);
		DataValue dataVal = this.dataService.retrieveData(deviceId, sensorType, retrieveType);
		JSONObject json = new JSONObject();
		if(dataVal != null){
			json.put("dataValue", dataVal.getSensorDataValue());
			json.put("timestamp", dataVal.getSensorDataTimestamp());
			json.put("timestampStr", dataVal.getSensorDataTimestampStr());
			json.put("sensorType", dataVal.getSensorValue().getSensorTypeValue().getSensorType());
			json.put("deviceId", deviceId);
		}
		//System.out.println(json.toString());
		return json.toString();
	}
	
	@RequestMapping(value = "/collect/{deviceId}/{sensorType}/{dataCollectionIntervalType}", method = RequestMethod.POST)
	@ResponseBody
	public String collectData(@PathVariable("deviceId") String deviceId, @PathVariable("sensorType") String sensorType, @PathVariable("dataCollectionIntervalType") String dataCollectionIntervalType){
		System.out.println(deviceId+" "+sensorType+" "+dataCollectionIntervalType);
		boolean flag = this.dataService.collectData(deviceId, sensorType, dataCollectionIntervalType);
		//System.out.println(flag);
		return new JSONObject().put("flag", flag).toString();
	}
	
}
















