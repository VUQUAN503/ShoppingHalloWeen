package com.halloween.service.impl;

import com.halloween.dao.ICustomerDetailDAO;
import com.halloween.dao.impl.CustomerDetailDAO;
import com.halloween.model.CustomerDetail;
import com.halloween.service.ICustomerDetailService;

public class CustomerDetailService implements ICustomerDetailService{

	private ICustomerDetailDAO newDAO = new CustomerDetailDAO();
	
	@Override
	public CustomerDetail fyByCusID(Integer customerID) {
		return newDAO.fyByCusID(customerID);
	}

	@Override
	public Integer insertCustomerDetail(CustomerDetail customer) {
		return newDAO.insertCustomerDetail(customer);
	}

	@Override
	public Boolean updateAddress(CustomerDetail customer) {
		return newDAO.updateAddress(customer);
	}

	@Override
	public CustomerDetail getInfoCustomer(Integer customerID) {
		return newDAO.getInfoCustomer(customerID);
	}
}
