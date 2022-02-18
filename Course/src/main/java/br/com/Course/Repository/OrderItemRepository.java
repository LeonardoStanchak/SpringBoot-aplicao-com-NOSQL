package br.com.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Course.Entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
