package se.yrgo.services.customers;

import java.util.List;

import se.yrgo.dataaccess.CustomerDao;
import se.yrgo.dataaccess.RecordNotFoundException;
import se.yrgo.domain.Call;
import se.yrgo.domain.Customer;

public class CustomerManagementServiceProductionImpl implements CustomerManagementService {
    CustomerDao customerDao;

    public CustomerManagementServiceProductionImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;    
    }

    @Override
    public void newCustomer(Customer newCustomer) {
        customerDao.create(newCustomer);
    }

    @Override
    public void updateCustomer(Customer changedCustomer) throws CustomerNotFoundException {
        try {
            customerDao.update(changedCustomer);
        } catch (RecordNotFoundException ex) {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public void deleteCustomer(Customer oldCustomer) throws CustomerNotFoundException {
        try {
            customerDao.delete(oldCustomer);
        } catch(RecordNotFoundException ex) {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
        try {
            return customerDao.getById(customerId);
        } catch (RecordNotFoundException ex) {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public List<Customer> findCustomersByName(String name) throws CustomerNotFoundException {
        try {
            return customerDao.getByName(name);
        } catch (RecordNotFoundException ex) {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerNotFoundException {
        try {
            return customerDao.getAllCustomers();
        } catch (RecordNotFoundException ex) {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
        try {
            return customerDao.getFullCustomerDetail(customerId);
        } catch (RecordNotFoundException | NullPointerException ex) {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
        try {
            customerDao.addCall(callDetails, customerId);
        } catch (RecordNotFoundException ex) {
            throw new CustomerNotFoundException();
        }
    }    
}
