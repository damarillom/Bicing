package org.escoladeltreball.bicing;

public class DistStation {
	private double dist;
	private int id;
	private String type;
	private int bikes;
	public DistStation(int id, double dist, String type, int bikes) {
		super();
		this.dist = dist;
		this.id = id;
		this.type = type;
		this.bikes = bikes;
	}
	public double getDist() {
		return dist;
	}
	public void setDist(double dist) {
		this.dist = dist;
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
	public int getBikes() {
		return bikes;
	}
	public void setBikes(int bikes) {
		this.bikes = bikes;
	} 
	
	

}
