package fit5042.tutex.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;

import fit5042.tutex.repository.constants.CommonInstance;
import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Customer;

@Stateless
public class JPACustomerRepositoryImpl implements CustomerRepository {
	private ArrayList<Customer> customerList;
	
	public JPACustomerRepositoryImpl() {
		customerList = new ArrayList<Customer>();
    	this.initialiseCustomerList();
    }
	
	public void initialiseCustomerList() {
		customerList.clear();
    	
		customerList.add(CommonInstance.PROPERTY_FIRST);
		customerList.add(CommonInstance.PROPERTY_SECOND);
		customerList.add(CommonInstance.PROPERTY_THIRD);
		customerList.add(CommonInstance.PROPERTY_FOURTH);
    }

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
	public void removeCustomer(int customerId) {
    	for (Customer p : customerList) {
    		if (p.getCustomerId() == customerId) {
    			customerList.remove(p);
    			break;
    		}
    	}
    }
    
    public void addCustomer(Customer customer) {
    	customerList.add(customer);
    }
    
    public void editCustomer(Customer customer) {
    	for (Customer p : customerList) {
    		int id = customer.getCustomerId() - 1; //+1 in jsf edit, so should -1 here
    		if (p.getCustomerId() == id) {
    			customerList.set(id, customer);
    			break;
    		}
    	}
    }

	public int getCustomerId() {
		return customerList.get(customerList.size() - 1).getCustomerId();
	}
	
	public Customer searchCustomerById(int customerId) {
		for (Customer p : customerList) {
    		if (p.getCustomerId() == customerId) {
    			return p;
    		}
    	}
		return null;
	}
	
	public List<ContactPerson> getAllContactPeople() {
		Set<ContactPerson> contactPersonSet = new HashSet<>();
		
		for (Customer p : customerList) {
			contactPersonSet.add(p.getContactPerson());
    	}
		
		List<ContactPerson> contactPersonList = new ArrayList<>();
		for (ContactPerson c : contactPersonSet) {
			contactPersonList.add(c);
		}
		
		return contactPersonList;
	}
	
	public Set<Customer> searchCustomerByContactPerson(ContactPerson contactPerson) {
		Set<Customer> customerSet = new HashSet<>();
		
		for (Customer p : customerList) {
			if (p.getContactPerson().equals(contactPerson)) {
				customerSet.add(p);
			}
    	}
		
		return customerSet;
	}
	

}
