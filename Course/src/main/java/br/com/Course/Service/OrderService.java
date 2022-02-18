package br.com.Course.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Course.Entities.Order;
import br.com.Course.Entities.User;
import br.com.Course.Repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepos;

	public List<Order> findall() {
		return orderRepos.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> order = orderRepos.findById(id);
		return order.get();
	}
}
