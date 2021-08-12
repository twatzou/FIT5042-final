/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Zou
 */
@RequestScoped
@Named(value = "customer")
public class Customer implements Serializable {
	private int customerId;
	private String product;
	private double price;
	//private String customerName;
	private String customerPhoneNumber;

	private Address address;
	private ContactPerson contactPerson;


	private String streetNumber;
	private String streetAddress;
	private String suburb;
	private String postcode;
	private String state;

	private int conactPersonId;
	private String name;
	private String phoneNumber;


	public Customer() {}
	// non-defaut constructor
	public Customer(int customerId, String product, double price, String customerPhoneNumber, 
			ContactPerson contactPerson, Address address) {
		this.customerId = customerId;
		this.product= product;
		this.price = price;
		//this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.address = address;

		this.contactPerson = contactPerson;
	}

	// =================================================================================	
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getConactPersonId() {
		return conactPersonId;
	}

	public void setConactPersonId(int conactPersonId) {
		this.conactPersonId = conactPersonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	// ==================================================================================


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getProduct() {
		return product;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	/*
	 * public String getCustomerName() { return this.customerName; }
	 * 
	 * public void setCustomerName(String customerName) { this.customerName =
	 * customerName; }
	 */
	
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}


	@Override
	public String toString() {
		return "Property{" + "customerId=" + customerId + ", product=" + product
				+ ", price=" + price + ", address=" + address + ", contactPerson=" + contactPerson +
				+ '}';
	}
}
