package com.halloween.dao;

import com.halloween.model.Customer;

import java.util.List;

public interface ICustomerDAO extends GenericDAO<Customer> {
    Integer getCustomerID(String username);

    Customer getCustomer(Integer customerID);

    Integer checkLogin(String userName, String password);

    Boolean isAdmin(Integer customerID);

    Integer insertCustomer(Customer customer);

    List<String> getListProvince(String type);

    List<String> getListDistrict(String province, String type);

    List<String> getListWard(String district, String type);
}
