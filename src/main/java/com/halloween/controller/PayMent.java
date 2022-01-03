package com.halloween.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halloween.model.CartItem;
import com.halloween.model.CustomerDetail;
import com.halloween.service.ICartItemService;
import com.halloween.service.ICustomerDetailService;
import com.halloween.service.ICustomerService;
import com.halloween.service.IOrderService;
import com.halloween.service.impl.CartItemService;
import com.halloween.service.impl.CustomerDetailService;
import com.halloween.service.impl.CustomerService;
import com.halloween.service.impl.OrderService;

@WebServlet("/PayMent")
public class PayMent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static IOrderService orderService = new OrderService();
	private static ICustomerService customerService = new CustomerService();
	private static ICartItemService cartItemService = new CartItemService();
	private static ICustomerDetailService customerDetailService = new CustomerDetailService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String listID = request.getParameter("id");
		int free = 0;
		if(request.getParameter("free") != null) {
			free = Integer.parseInt(request.getParameter("free"));
		}
		String[] intergers = listID.split(",");
		Integer customerID = customerService.getCustomerID(request.getSession().getAttribute("name").toString());
		Integer orderID = orderService.getOrderID(customerID);
		CustomerDetail customerDetail = customerDetailService.getInfoCustomer(customerID);
		orderService.updateOrderDate(orderID);
		if(customerDetail != null)
		{
			request.setAttribute("customerInfo", customerDetail);
		}
		List<CartItem> cartItems = cartItemService.getAllOrderItemByID(intergers, orderID);
		request.setAttribute("cartItems", cartItems);
		request.setAttribute("free", free);
		request.setAttribute("date", CartItem.date);
		request.getRequestDispatcher("payment.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
