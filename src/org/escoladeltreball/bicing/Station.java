package org.escoladeltreball.bicing;

import org.escoladeltreball.bicing.Station;

public class Station {
	private int id;
	private String type;
	private double latitude;
	private double longitude;
	private String streetName;
	private String streetNumber;
	private int altitude;
	private int slots;
	private int bikes;
	private String nearbyStations;
	private String status;
	public Station(int id, String type, double latitude, double longitude, String streetName, String streetNumber,
			int altitude, int slots, int bikes, String nearbyStations, String status) {
		super();
		this.id = id;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.altitude = altitude;
		this.slots = slots;
		this.bikes = bikes;
		this.nearbyStations = nearbyStations;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public int getSlots() {
		return slots;
	}
	public void setSlots(int slots) {
		this.slots = slots;
	}
	public int getBikes() {
		return bikes;
	}
	public void setBikes(int bikes) {
		this.bikes = bikes;
	}
	public String getNearbyStations() {
		return nearbyStations;
	}
	public void setNearbyStations(String nearbyStations) {
		this.nearbyStations = nearbyStations;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
