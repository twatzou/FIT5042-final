package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.inject.Named;

import fit5042.tutex.repository.entities.Customer;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 */
@Named(value = "customerController")
@RequestScoped
public class CustomerController {
    CustomerApplication customerApplication;
    
    private int customerId; //this customerId is the index, don't confuse with the Customer Id

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    private Customer customer;

    public CustomerController() throws Exception {
        //this customerID is the index, don't confuse with the Customer Id
        customerId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("customerID"));

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerApplication = (CustomerApplication) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "customerApplication");
        
        customer = getCustomer();

    }

    public Customer getCustomer() throws Exception {
        if (customer == null) 
            return customerApplication.getCustomers().get(--customerId); //this customerId is the index, don't confuse with the Customer Id
        
        return customer;
    }
}
