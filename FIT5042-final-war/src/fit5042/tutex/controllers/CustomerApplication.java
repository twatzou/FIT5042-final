package fit5042.tutex.controllers;

import java.util.ArrayList;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.el.ELContext;

import fit5042.tutex.mbeans.CustomerManagedBean;
import fit5042.tutex.repository.entities.Customer;

import javax.faces.context.FacesContext;

/**
 * The class is a demonstration of how the application scope works. You can
 * change this scope.
 *
 */
@Named(value = "customerApplication")
@ApplicationScoped

public class CustomerApplication {
    CustomerManagedBean customerManagedBean;

    private static final ArrayList<Customer> customers = new ArrayList<>();

    private boolean showForm = true;

    public boolean isShowForm() {
        return showForm;
    }

    // Add some customer data from db to app 
    public CustomerApplication() throws Exception {
        //instantiate customerManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "customerManagedBean");
        
        if (customers != null && customers.size() > 0)
        {
        } else {
            //get customers from db 
            updateCustomerList();
        }
    }
    
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private void setCustomers(ArrayList<Customer> newCustomers) {
        //this.customers = newCustomers;
    }

    //when loading, the customer list needs to be populated if customers not present 
    public void updateCustomerList() {
        if (customers != null && customers.size() > 0)
        {
            
        }
        else
        {
            customers.clear();

            for (Customer customer : customerManagedBean.getAllCustomers()) {
                customers.add(customer);
            }

            setCustomers(customers);
        }
    }

    public void searchCustomerById(int customerId) {
        customers.clear();

        customers.add(customerManagedBean.searchCustomerById(customerId));
    }


    public void searchCustomerByContactPersonId(int contactPersonId) {
        customers.clear();
        Set<Customer> customersByContactPerson = customerManagedBean.searchCustomerByContactPersonId(contactPersonId);
        for (Customer customer : customersByContactPerson) {
            customers.add(customer);
        }

    }
    
    public void searchAll()
    {
        customers.clear();

        for (Customer customer : customerManagedBean.getAllCustomers()) {
            customers.add(customer);
        }

        setCustomers(customers);
    }
    
}
