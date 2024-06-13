package com.vtiger.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public Object getDataFromJsonFile(String key) throws IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		FileReader fr=new FileReader("./configAppdata/appCommondata.json");
		Object obj = parser.parse(fr);
		
		//step2 convert java obj into Json using downcasting
		JSONObject map=(JSONObject) obj;
		return map.get(key);
	}
	public Object getDoubleTypeDataFromJsonFile(String key) throws IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		FileReader fr=new FileReader("./configAppdata/appCommondata.json");
		Object obj = parser.parse(fr);
		
		//step2 convert java obj into Json using downcasting
		JSONObject map=(JSONObject) obj;
		double d=Double.valueOf(map.toString());
		return map.get(key);
	}


}
