package com.car.vo;

import java.sql.Timestamp;

public class T_C_Status {
	private int C_ID;
	private int C_VIN;
	private int C_Status;
	private int Charge_Status;
	private int M_Status;
	private int B_Status;
	private int GPS_Status;
	private int C_Speed;
	private int C_Voltage;
	private int C_Electricity;
	private int  Cs_Speed;//曲轴转速
	private float C_longitude;
    private float C_latitude;
    private Timestamp C_Time;
    private int CarStatusCount;
    
    
    
	public int getCarStatusCount() {
		return CarStatusCount;
	}
	public void setCarStatusCount(int carStatusCount) {
		CarStatusCount = carStatusCount;
	}
	public int getC_ID() {
		return C_ID;
	}
	public void setC_ID(int c_ID) {
		C_ID = c_ID;
	}
	public int getC_VIN() {
		return C_VIN;
	}
	public void setC_VIN(int c_VIN) {
		C_VIN = c_VIN;
	}
	public int getC_Status() {
		return C_Status;
	}
	public void setC_Status(int c_Status) {
		C_Status = c_Status;
	}
	public int getCharge_Status() {
		return Charge_Status;
	}
	public void setCharge_Status(int charge_Status) {
		Charge_Status = charge_Status;
	}
	public int getM_Status() {
		return M_Status;
	}
	public void setM_Status(int m_Status) {
		M_Status = m_Status;
	}
	public int getB_Status() {
		return B_Status;
	}
	public void setB_Status(int b_Status) {
		B_Status = b_Status;
	}
	public int getGPS_Status() {
		return GPS_Status;
	}
	public void setGPS_Status(int gPS_Status) {
		GPS_Status = gPS_Status;
	}

	public int getC_Speed() {
		return C_Speed;
	}
	public void setC_Speed(int c_Speed) {
		C_Speed = c_Speed;
	}
	public int getC_Voltage() {
		return C_Voltage;
	}
	public void setC_Voltage(int c_Voltage) {
		C_Voltage = c_Voltage;
	}
	public int getC_Electricity() {
		return C_Electricity;
	}
	public void setC_Electricity(int c_Electricity) {
		C_Electricity = c_Electricity;
	}
	public int getCs_Speed() {
		return Cs_Speed;
	}
	public void setCs_Speed(int cs_Speed) {
		Cs_Speed = cs_Speed;
	}
	
	public Timestamp getC_Time() {
		return C_Time;
	}
	public void setC_Time(Timestamp c_Time) {
		C_Time = c_Time;
	}
	public float getC_longitude() {
		return C_longitude;
	}
	public void setC_longitude(float c_longitude) {
		C_longitude = c_longitude;
	}
	public float getC_latitude() {
		return C_latitude;
	}
	public void setC_latitude(float c_latitude) {
		C_latitude = c_latitude;
	}
	
	

}
