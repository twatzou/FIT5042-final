package fit5042.tutex.repository.constants;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import fit5042.tutex.repository.CustomerRepository;
import fit5042.tutex.repository.JPACustomerRepositoryImpl;
import fit5042.tutex.repository.entities.Address;
import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Customer;

public class CommonInstance {
	private final static ContactPerson CONTACT_PERSON_FIRST = new ContactPerson(1, "Eddie Leung", "0411234567");
	private final static ContactPerson CONTACT_PERSON_SECOND = new ContactPerson(2, "Sunil Panda", "0422334335");
	private final static ContactPerson CONTACT_PERSON_THIRD = new ContactPerson(3, "Jian Liew", "0409233432");
	
	private final static Address ADDRESS_FIRST = new Address("24", "Boston Avenue", "Malvern East", "3145", "Victoria");
	private final static Address ADDRESS_SECOND = new Address("11", "Bettina Street", "Clayton", "3168", "Victoria");
	private final static Address ADDRESS_THIRD = new Address("3", "Wattle Avenue", "Glen Huntly", "3163", "Victoria");
	private final static Address ADDRESS_FOURTH = new Address("5", "Hamilton Street", "Bentleigh", "3204", "Victoria");
	
	public final static Customer PROPERTY_FIRST = new Customer(1, "product1", 100.00, "0411234569",CONTACT_PERSON_FIRST, ADDRESS_FIRST);
	public final static Customer PROPERTY_SECOND = new Customer(2, "product2", 101.00,"0411234560", CONTACT_PERSON_FIRST, ADDRESS_SECOND);
	public final static Customer PROPERTY_THIRD = new Customer(3, "product3", 102.00, "0411234561", CONTACT_PERSON_SECOND, ADDRESS_THIRD);
	public final static Customer PROPERTY_FOURTH = new Customer(4, "product4",103.00, "0411234562", CONTACT_PERSON_THIRD, ADDRESS_FOURTH);
	
	public final static CustomerRepository PROPERTY_REPOSITORY = new JPACustomerRepositoryImpl();
}
