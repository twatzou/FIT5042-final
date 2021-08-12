package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.tutex.repository.entities.Customer;
import fit5042.tutex.mbeans.CustomerManagedBean;
import fit5042.tutex.repository.entities.ContactPerson;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guan
 */
@RequestScoped
@Named("searchCustomer")
public class SearchCustomer {
    private boolean showForm = true;

    private Customer customer;

    CustomerApplication app;

    private int searchByInt;
    private double searchByDouble;

    private int contactPersonId;

    public int getContactPersonId() {

        return contactPersonId;
    }

    public void setContactPersonId(int contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public CustomerApplication getApp() {
        return app;
    }

    public void setApp(CustomerApplication app) {
        this.app = app;
    }
    private double searchByBudget;

    public double getSearchByDouble() {
        return searchByDouble;
    }

    public void setSearchByDouble(double searchByDouble) {
        this.searchByDouble = searchByDouble;
    }

    public int getSearchByInt() {
        return searchByInt;
    }

    public void setSearchByInt(int searchByInt) {
        this.searchByInt = searchByInt;
    }

    public double getSearchByBudget() {
        return searchByBudget;
    }

    public void setSearchByBudget(double searchByBudget) {
        this.searchByBudget = searchByBudget;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public SearchCustomer() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (CustomerApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "customerApplication");

        app.updateCustomerList();
    }

    /**
     * @param customer Id
     */
    public void searchCustomerById(int customerId) {
        try {
            //search this customer then refresh the list in CustomerApplication bean
            app.searchCustomerById(customerId);
        } catch (Exception ex) {

        }
        showForm = true;

    }



    public void searchCustomerByContactPersonId(int contactPersonId) {
        try {
        	int p = contactPersonId;
            //search all properties by contact person from db via EJB 
            app.searchCustomerByContactPersonId(contactPersonId);
        } catch (Exception ex) {

        }
        showForm = true;
    }

    public void searchAll() {
        try {
            //return all properties from db via EJB
            app.searchAll();
        } catch (Exception ex) {

        }
        showForm = true;
    }
}
