package br.com.Course.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Course.Entities.Category;
import br.com.Course.Entities.User;
import br.com.Course.Repository.CategoryRepository;
import br.com.Course.Repository.UserRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepos;

	public List<Category> findall() {
		return categoryRepos.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> category = categoryRepos.findById(id);
		return category.get();
	}
}
