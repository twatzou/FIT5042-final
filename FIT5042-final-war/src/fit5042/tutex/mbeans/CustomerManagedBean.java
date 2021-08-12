/*
 * To change this license header, choose License Headers in Project Customers.
 */
package fit5042.tutex.mbeans;

import fit5042.tutex.repository.CustomerRepository;
import fit5042.tutex.repository.entities.Address;
import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Customer;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *

 *
 */
@ManagedBean(name = "customerManagedBean", eager = true)
@SessionScoped

public class CustomerManagedBean implements Serializable {
	
	@EJB
	private CustomerRepository customerRepository;
	
    private int bestPerRoom;
    private int selectedId;

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public int getBestPerRoom() {
        return bestPerRoom;
    }

    public void setBestPerRoom(int bestPerRoom) {
        this.bestPerRoom = bestPerRoom;
    }
    
    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
        selectedId = 0;
//        compareCustomer = new CompareCustomerSessionBean();
    }

    public List<Customer> getAllCustomers() {
        try {
            List<Customer> properties = customerRepository.getCustomerList();
            return properties;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addCustomer(Customer customer) {
    	Customer p = convertCustomerToEntity(customer);

        try {
        	customerRepository.addCustomer(p);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Search a customer by Id
     */
    public Customer searchCustomerById(int id) {
        try {
            return customerRepository.searchCustomerById(id);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Set<Customer> searchCustomerByContactPersonId(int contactPersonId) {
        try {
            //retrieve contact person by id
            for (ContactPerson contactPerson : customerRepository.getAllContactPeople()) {
                if (contactPerson.getConactPersonId() == contactPersonId) {
                    return customerRepository.searchCustomerByContactPerson(contactPerson);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<ContactPerson> getAllContactPeople() throws Exception {
        try {
            return customerRepository.getAllContactPeople();
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void removeCustomer(int customerId) {
        try {
        	customerRepository.removeCustomer(customerId);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCustomer(Customer customer) {
        try {
            String s = customer.getAddress().getStreetNumber();
            Address address = customer.getAddress();
            address.setStreetNumber(s);
            customer.setAddress(address);

            customerRepository.editCustomer(customer);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Customer convertCustomerToEntity(Customer localCustomer) {
        try {
            Customer customer = new Customer(); //entity
            String streetNumber = localCustomer.getStreetNumber();
            String streetAddress = localCustomer.getStreetAddress();
            String suburb = localCustomer.getSuburb();
            String postcode = localCustomer.getPostcode();
            String state = localCustomer.getState();
            Address address = new Address(streetNumber, streetAddress, suburb, postcode, state);
            customer.setAddress(address);
            
            customer.setCustomerId(localCustomer.getCustomerId());
            customer.setProduct(localCustomer.getProduct());
            customer.setPrice(localCustomer.getPrice());
            customer.setCustomerPhoneNumber(localCustomer.getCustomerPhoneNumber());
            //customer.setCustomerName(localCustomer.getCustomerName());
            
            
            customer.setContactPerson(localCustomer.getContactPerson());
            return customer;
        } catch (Exception ex) {

        }
        return null;
    }
    
    public int getFinalCustomerId() {
    	return customerRepository.getCustomerId();
    }
    
}
