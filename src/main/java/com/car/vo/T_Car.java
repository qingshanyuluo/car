package com.car.vo;

import java.sql.Timestamp;

public class T_Car {
	
	private int C_ID;
	private int C_VIN;
    private String C_Type;
    private Timestamp C_Time;
    private String U_Name;
    private String U_Address;
    private String U_Tel;
    private String U_Email;
    private Timestamp U_Time;
    private int CarTypeCount;
    
    
	public int getCarTypeCount() {
		return CarTypeCount;
	}
	public void setCarTypeCount(int carTypeCount) {
		CarTypeCount = carTypeCount;
	}
	
	public Timestamp getU_Time() {
		return U_Time;
	}
	public void setU_Time(Timestamp u_Time) {
		U_Time = u_Time;
	}
	public String getU_Email() {
		return U_Email;
	}
	public void setU_Email(String u_Email) {
		U_Email = u_Email;
	}
	public String getU_Tel() {
		return U_Tel;
	}
	public void setU_Tel(String u_Tel) {
		U_Tel = u_Tel;
	}
	public String getU_Name() {
		return U_Name;
	}
	public void setU_Name(String u_Name) {
		U_Name = u_Name;
	}
	public String getU_Address() {
		return U_Address;
	}
	public void setU_Address(String u_Address) {
		U_Address = u_Address;
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
	public String getC_Type() {
		return C_Type;
	}
	public void setC_Type(String c_Type) {
		C_Type = c_Type;
	}
	public Timestamp getC_Time() {
		return C_Time;
	}
	public void setC_Time(Timestamp c_Time) {
		C_Time = c_Time;
	} 
    

}
