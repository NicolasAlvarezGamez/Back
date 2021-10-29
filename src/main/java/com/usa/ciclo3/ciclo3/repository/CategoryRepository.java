package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Nicolás Gámez
 */
@Repository
public class CategoryRepository {
    
     @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category saveCategory(Category c){
        return categoryCrudRepository.save(c);
    }
    
    public void delete(Category id){
        categoryCrudRepository.delete(id);
    }
    
    
}
