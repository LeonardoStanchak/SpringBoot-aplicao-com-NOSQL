package br.com.Course.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Course.Entities.Product;
import br.com.Course.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepos;

	public List<Product> findall() {
		return productRepos.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> product = productRepos.findById(id);
		return product.get();
	}
}
