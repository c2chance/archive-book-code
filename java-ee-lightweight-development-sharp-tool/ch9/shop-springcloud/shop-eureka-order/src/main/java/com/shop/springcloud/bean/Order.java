package com.shop.springcloud.bean;

public class Order {
	private String id;
	private Double price;
	private String name;
	private String address;
	private String phone;
	private String sku;
	private String integral;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", sku=" + sku + ", integral=" + integral + "]";
	}
	
	
	

}
