package fit5042.tutex.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Customer;

/**
 * @author Zou
 */
@Remote
public interface CustomerRepository {
	public void initialiseCustomerList();

	public ArrayList<Customer> getCustomerList();

	public void setCustomerList(ArrayList<Customer> customerList);
	
	public void removeCustomer(int customerId);
    
    public void addCustomer(Customer customer);
    
    public void editCustomer(Customer customer);

	public int getCustomerId();
	
	public Customer searchCustomerById(int customerId);
	
	public List<ContactPerson> getAllContactPeople();
	
	public Set<Customer> searchCustomerByContactPerson(ContactPerson contactPerson);
	
}
