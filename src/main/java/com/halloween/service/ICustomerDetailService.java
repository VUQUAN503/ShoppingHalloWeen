package com.halloween.service;

import com.halloween.model.CustomerDetail;

public interface ICustomerDetailService {
	CustomerDetail fyByCusID(Integer customerID);
	Integer insertCustomerDetail(CustomerDetail customer);
	Boolean updateProfile(CustomerDetail customer);
	Boolean updateAddress(CustomerDetail customer);
	CustomerDetail getInfoCustomer(Integer customerID);
	Boolean updateAddress(Integer customerID, String address);
}
