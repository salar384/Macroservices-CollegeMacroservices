package com.demo.microservices.entity;

public class Address {

	private int id;
	private String add;
	private int postcode;

	public Address() {

	}

	public Address(int id, String add, int postcode) {

		this.id = id;
		this.add = add;
		this.postcode = postcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

}
