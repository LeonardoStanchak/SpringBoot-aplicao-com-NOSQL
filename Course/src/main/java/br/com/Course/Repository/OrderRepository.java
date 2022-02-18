package br.com.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Course.Entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
