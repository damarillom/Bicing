/**
 * 
 */
package org.escoladeltreball.bicing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * @author iaw26509397
 *
 */
public class Principal {

	public static void main(String[] args) throws IOException {

		double MyLatitude = 41.39;
		double MyLongitude = 2.15;
		String json = "";
		BufferedReader inReader = null;
		try {
			inReader = new BufferedReader(new FileReader("bicing.json"));
			String line;
			while ((line = inReader.readLine()) != null) {
				json+= line;
			}
		} finally {
			if (inReader != null) {
				inReader.close();
			}
		}
		
		Gson gson = new Gson();
		System.out.println(json);
		
		
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(json);		
		JsonObject obj = element.getAsJsonObject();			
		//System.out.println(obj.get("stations").getAsJsonArray());
		JsonArray jsonArray = obj.get("stations").getAsJsonArray();
		List<Station> stations = new ArrayList<>();
		int id = 0;
		String type = "";
		double latitude = 0;
		double longitude = 0;
		String streetName = "";
		String streetNumber = "";
		int altitude= 0;
		int slots = 0;
		int bikes= 0;
		String nearbyStations = "";
		String status = "";
		double dist = 0;
		int counter;
		for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
			JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
			id = aux.get("id").getAsInt();
			type = aux.get("type").getAsString();
			latitude = aux.get("latitude").getAsDouble();
			longitude = aux.get("longitude").getAsDouble();
			streetName = aux.get("streetName").getAsString();
			streetNumber = aux.get("streetNumber").getAsString();
			altitude = aux.get("altitude").getAsInt();
			slots = aux.get("slots").getAsInt();
			bikes = aux.get("bikes").getAsInt();
			nearbyStations = aux.get("nearbyStations").getAsString();
			status = aux.get("status").getAsString();
			Station station = new Station(id, type, latitude, longitude, streetName, streetNumber, altitude, slots, bikes, nearbyStations, status);
			stations.add(station);
		}
		//Estaciones con una latitud mayor a 41.38
		stations.stream().filter(p -> p.getLatitude() > 41.38).forEach(station -> System.out.println("id: " + station.getId() + "   Latitude: " + station.getLatitude()));
		System.out.println("*******************");
		//Escaciones con una altura mayor a 50 metros
		stations.stream().filter(p -> p.getAltitude() > 50).forEach(station -> System.out.println("id: " + station.getId() + "   Latitude: " + station.getAltitude()));
		System.out.println("*******************");
		//Estaciones con mas de una bici
		stations.stream().filter(p -> p.getBikes() > 1).forEach(station -> System.out.println("id: " + station.getId() + "   Bikes: " + station.getBikes()));
		System.out.println("*******************");
		//Estaciones cerradas
		stations.stream().filter(p -> p.getStatus().equals("CLS")).forEach(station -> System.out.println("id: " + station.getId() + "   Status: " + station.getStatus()));
		System.out.println("*******************");
		//Estaciones abiertas ordenadas por calle y numero

		
		
		
		System.out.println("*******************");
		//3 estaciones mas cercanas a la estacion de metro de hospital clinit
		List<DistStation> distStations = new ArrayList<>();
		for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
			JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
			id = aux.get("id").getAsInt();
			type = aux.get("type").getAsString();
			latitude = aux.get("latitude").getAsDouble();
			longitude = aux.get("longitude").getAsDouble();
			dist = Math.sqrt(Math.pow((MyLatitude - latitude), 2) + Math.pow((MyLongitude - longitude), 2));
			bikes = aux.get("bikes").getAsInt();
			status = aux.get("status").getAsString();
			DistStation distStation = new DistStation(id, dist, type, bikes, status);
			distStations.add(distStation);
		}
		//distStations.stream().filter(p -> p.getStatus().equals("OPN")).forEach(distStation -> System.out.println("id: " + station.getId() + "   Status: " + station.getStatus()));

//		if (jsonArray.isJsonArray()) {			
//
//			//Estaciones con una latitud mayor a 41.38
//			for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
//				JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
//				if (aux.get("latitude").getAsDouble() > 41.38) {
//					id = aux.get("id").getAsInt();
//					latitude = aux.get("latitude").getAsDouble();
//					System.out.println("Id: " + id + "  Latitude: " + latitude);
//					
//				}
//			}
//			System.out.println("\n**************************\n");
//			//Estaciones con una altura mayor a 50 metros
//			for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
//				JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
//				if (aux.get("altitude").getAsInt() > 50) {
//					id = aux.get("id").getAsInt();
//					altitude = aux.get("altitude").getAsInt();
//					System.out.println("Id: " + id + "  Altitude: " + altitude);
//					
//				}
//			}
//			System.out.println("\n**************************\n");
//			//Estaciones con una bici o mas
////			for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
////				JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
////				if (aux.get("bikes").getAsInt() >= 1) {
////					id = aux.get("id").getAsInt();
////					bikes = aux.get("bikes").getAsInt();
////					System.out.println("Id: " + id + "  Bikes: " + bikes);
////					
////				}
////			}
//			
//			System.out.println("\n**************************\n");
//			//Estaciones cerradas
//			for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
//				JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
//				if (aux.get("status").getAsString().equals("CLS")) {
//					id = aux.get("id").getAsInt();
//					status = aux.get("status").getAsString();
//					System.out.println("Id: " + id + "  Status: " + status);
//					
//				}
//			}
//			System.out.println("\n**************************\n");
//			//Estaciones abiertas
//			List<Station> stations = new ArrayList<>();
//			for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
//				JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
//				if (aux.get("status").getAsString().equals("OPN")) {
//					id = aux.get("id").getAsInt();
//					type = aux.get("type").getAsString();
//					latitude = aux.get("latitude").getAsDouble();
//					longitude = aux.get("longitude").getAsDouble();
//					streetName = aux.get("streetName").getAsString();
//					streetNumber = aux.get("streetNumber").getAsString();
//					altitude = aux.get("altitude").getAsInt();
//					slots = aux.get("slots").getAsInt();
//					bikes = aux.get("bikes").getAsInt();
//					nearbyStations = aux.get("nearbyStations").getAsString();
//					status = aux.get("status").getAsString();
//					Station station = new Station(id, type, latitude, longitude, streetName, streetNumber, altitude, slots, bikes, nearbyStations, status);
//					stations.add(station);
//					
//				}
//			}
//			//Collections.sort(stations, new Comparator<Station>() {
//			//	@Override
//			//	public int compare(Station s1, Station s2) {
//			//		return s1.getStreetNumber().compareTo(s2.getStreetNumber());
//			//	}
//			//});
//			Collections.sort(stations, new Comparator<Station>() {
//				@Override
//				public int compare(Station s1, Station s2) {
//					return s1.getStreetName().compareTo(s2.getStreetName());
//				}
//			});
//
//			for (Station sta : stations) {
//				System.out.println("Id: " + sta.getId() + "   Street Name: " + sta.getStreetName() + "   Street Number: " + sta.getStreetNumber());
//			}
//			
//			System.out.println("\n**************************\n");
//			//Las 3 estaciones más cercanas a la parada de metro de Hospital Clínit (Latitud: 41.39, Longitud: 2.15)
//			List<DistStation> DistStations = new ArrayList<>();
//			for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
//				JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
//				if (aux.get("status").getAsString().equals("OPN")) {
//					id = aux.get("id").getAsInt();
//					type = aux.get("type").getAsString();
//					latitude = aux.get("latitude").getAsDouble();
//					longitude = aux.get("longitude").getAsDouble();
//					dist = Math.sqrt(Math.pow((41.39 - latitude), 2) + Math.pow((2.15 - longitude), 2));
//					bikes = aux.get("bikes").getAsInt();
//					DistStation distStation = new DistStation(id, dist, type, bikes);
//					DistStations.add(distStation);
//					
//				}
//			}
//			Collections.sort(DistStations, new Comparator<DistStation>() {
//				@Override
//				public int compare(DistStation d1, DistStation d2) {
//					return Double.compare(d1.getDist(),d2.getDist());
//				}
//			});
//			counter = 0;
//			for (DistStation sta : DistStations) {
//				if (counter < 3) {
//					System.out.println("Id: " + sta.getId() + "     Dist: " + sta.getDist() + "    Type: " + sta.getType());
//				} 
//				counter++;
//			}
//			System.out.println("\n**************************\n");
//			//Las 3 estaciones más cercanas a la parada de metro de Hospital Clínit (Latitud: 41.39, Longitud: 2.15)
//			List<DistStation> DistStations2 = new ArrayList<>();
//			for (int i = 0; i < jsonArray.getAsJsonArray().size();i++) {
//				JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
//				if (aux.get("status").getAsString().equals("OPN")) {
//					if (aux.get("type").getAsString().equals("BIKE-ELECTRIC")) {
//						id = aux.get("id").getAsInt();
//						type = aux.get("type").getAsString();
//						latitude = aux.get("latitude").getAsDouble();
//						longitude = aux.get("longitude").getAsDouble();
//						dist = Math.sqrt(Math.pow((41.39 - latitude), 2) + Math.pow((2.15 - longitude), 2));
//						bikes = aux.get("bikes").getAsInt();
//						DistStation distStation = new DistStation(id, dist, type, bikes);
//						DistStations2.add(distStation);
//					}
//					
//				}
//			}
//			Collections.sort(DistStations2, new Comparator<DistStation>() {
//				@Override
//				public int compare(DistStation d1, DistStation d2) {
//					return Double.compare(d1.getDist(),d2.getDist());
//				}
//			});
//			counter = 0;
//			for (DistStation sta : DistStations2) {
//				if (counter < 1) {
//					System.out.println("Id: " + sta.getId() + "     Dist: " + sta.getDist() + "    Type: " + sta.getType() + "    Bikes: " + bikes);
//				} 
//				counter++;
//			}
//		} else {
//			System.out.println("no array");
//		}
		
	}
	

}
