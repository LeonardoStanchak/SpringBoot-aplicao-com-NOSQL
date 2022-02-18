package br.com.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Course.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
