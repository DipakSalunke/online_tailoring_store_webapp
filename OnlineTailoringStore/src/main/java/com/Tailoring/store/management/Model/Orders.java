package com.Tailoring.store.management.Model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Orders {
	private int order_id;
	private Date placed_date;
	private Date exp_delivery_date;
	private Date delivered_date;
	private String order_status;
	private float amount;
	private int pattern_id;
	private int user_id;
	private int tailor_id;
	private int pattern_idpat;
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getPlaced_date() {
		return placed_date;
	}
	public void setPlaced_date(Date placed_date) {
		this.placed_date = placed_date;
	}
	public Date getExp_delivery_date() {
		return exp_delivery_date;
	}
	public void setExp_delivery_date(Date exp_delivery_date) {
		this.exp_delivery_date = exp_delivery_date;
	}
	public Date getDelivered_date() {
		return delivered_date;
	}
	public void setDelivered_date(Date delivered_date) {
		this.delivered_date = delivered_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getPattern_id() {
		return pattern_id;
	}
	public void setPattern_id(int pattern_id) {
		this.pattern_id = pattern_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTailor_id() {
		return tailor_id;
	}
	public void setTailor_id(int tailor_id) {
		this.tailor_id = tailor_id;
	}
	public int getPattern_idpat() {
		return pattern_idpat;
	}
	public void setPattern_idpat(int pattern_idpat) {
		this.pattern_idpat = pattern_idpat;
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", placed_date=" + placed_date + ", exp_delivery_date="
				+ exp_delivery_date + ", delivered_date=" + delivered_date + ", order_status=" + order_status
				+ ", amount=" + amount + ", pattern_id=" + pattern_id + ", user_id=" + user_id + ", tailor_id="
				+ tailor_id + ", pattern_idpat=" + pattern_idpat + "]";
	}
	public Orders(int order_id, Date placed_date, Date exp_delivery_date, Date delivered_date, String order_status,
			float amount, int pattern_id, int user_id, int tailor_id, int pattern_idpat) {
		super();
		this.order_id = order_id;
		this.placed_date = placed_date;
		this.exp_delivery_date = exp_delivery_date;
		this.delivered_date = delivered_date;
		this.order_status = order_status;
		this.amount = amount;
		this.pattern_id = pattern_id;
		this.user_id = user_id;
		this.tailor_id = tailor_id;
		this.pattern_idpat = pattern_idpat;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
