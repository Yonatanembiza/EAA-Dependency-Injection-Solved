package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	// The original code for filed injection method / Manual Injection
//	CustomerRepository customerRepository = new CustomerRepositoryImpl();
//	EmailSender emailSender = new EmailSenderImpl();

	// for Setter Injection
	CustomerRepository customerRepository;
	EmailSender emailSender;
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	@Autowired
	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, EmailSender emailSender) {
		this.customerRepository = customerRepository;
		this.emailSender = emailSender;
	}

	public void addCustomer(String name, String email, String street,
							String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerRepository.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}
}
