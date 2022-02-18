package br.com.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Course.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
