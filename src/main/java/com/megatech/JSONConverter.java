package com.megatech;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.megatech.model.EnergyTimeData;

public class JSONConverter {

	static List newList;
	static List<String> finalJson;
	static Gson gson;

	public static Map<Date, Map<String, Float>> groupbyDate(List<EnergyTimeData> results) {

		Map<Date, Map<String, Float>> requiredJson = results.stream()
				.collect(Collectors.groupingBy(EnergyTimeData::getTimestamps, TreeMap::new,
						Collectors.toMap(EnergyTimeData::getTagid, EnergyTimeData::getValue)));
		return requiredJson;

	}

	public static void checkMapKeyandTagId(Map<String, Float> tagValueMap, Date timeStampKey, List<String> tagId) {

		newList = new ArrayList();
		String timeStampKeyAsString = String.valueOf(timeStampKey);
		newList.add(timeStampKey);
		for (String key : tagId) {

			if (tagId.contains(key)) {

				String tagValueasString = String.valueOf(tagValueMap.get(key));
				newList.add(tagValueMap.get(key));

			} else {
				newList.add(null);
			}

		}

	}

	public static String returnJson() {
		gson = new Gson();
		String jsonCartList = gson.toJson(newList);
		// System.out.println("jsonCartList: " + jsonCartList);
		return jsonCartList;
	}

	public static String outputJson(List<EnergyTimeData> results, List<String> tagId) {

		finalJson = new ArrayList<String>();
		finalJson.add("{ \"Result\": [{\"elementId\":" + 1 + ",\"values\": [");

		Map<Date, Map<String, Float>> requiredJson = groupbyDate(results);

		requiredJson.forEach((timeStampKey, tagValueMap) -> {
			// Map<String, Float> sortedMapByKeys = new TreeMap<String,
			// Float>();
			// sortedMapByKeys.putAll(tagValueMap);
			checkMapKeyandTagId(tagValueMap, timeStampKey, tagId);
			String returnJson = returnJson();
			finalJson.add(returnJson);

		});

		finalJson.add("]}]}");
		String listJsonString = (String) finalJson.stream().collect(Collectors.joining(","));
		String finalJsonString = listJsonString.replace("[,", "[");
		finalJsonString = finalJsonString.replace(",]", "]");
		System.out.println(finalJsonString);

		return finalJsonString;
	}

}