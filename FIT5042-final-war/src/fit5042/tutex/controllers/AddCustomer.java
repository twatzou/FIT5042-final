package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.tutex.mbeans.CustomerManagedBean;
import fit5042.tutex.repository.entities.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guan & zou
 */
@RequestScoped
@Named("addCustomer")
public class AddCustomer {
    CustomerManagedBean customerManagedBean;

    private boolean showForm = true;

    private Customer customer;

    CustomerApplication app;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public AddCustomer() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (CustomerApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "customerApplication");

        //instantiate customerManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "customerManagedBean");
    }

    public void addCustomer(Customer localCustomer) {
        //this is the local customer, not the entity
        try {
        	localCustomer.setCustomerId(customerManagedBean.getFinalCustomerId() + 1);
            //add this customer to db via EJB
            customerManagedBean.addCustomer(localCustomer);

            //refresh the list in CustomerApplication bean
            app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been added succesfully"));
            //refresh the customer list in customerApplication bean
        } catch (Exception ex) {

        }
        showForm = true;
    }

}
