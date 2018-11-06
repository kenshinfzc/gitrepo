package com.czf.model;

public class Orders {
	private int orderId;
	private int orderType;
	private int state;
	private String staff;
	/**
	 * @return the ordereId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param ordereId the ordereId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderType
	 */
	public int getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	/**
	 * @return the staff
	 */
	public String getStaff() {
		return staff;
	}
	/**
	 * @param staff the staff to set
	 */
	public void setStaff(String staff) {
		this.staff = staff;
	}
	
}
