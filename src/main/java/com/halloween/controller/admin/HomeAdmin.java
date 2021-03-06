package com.halloween.controller.admin;

import com.halloween.service.IOrderService;
import com.halloween.service.impl.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/HomeAdmin")
public class HomeAdmin extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final IOrderService orderService = new OrderService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		orderService.updateOrderSuccess();
		Integer orderOfDay = orderService.getOrderOfDay();
		if(orderOfDay != null) request.setAttribute("orderOfDay", orderOfDay);
		request.setAttribute("recentOrders", orderService.getRecentOrder());
		request.setAttribute("revenueOfDay", orderService.getRevenueOfDay());
		request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
