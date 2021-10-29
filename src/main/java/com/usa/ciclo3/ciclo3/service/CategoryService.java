package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nicolás Gámez
 */

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.saveCategory(c);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(c.getId());
            if(paux.isEmpty()){
                return categoryRepository.saveCategory(c);
            }else{
                return c;
            }
        }
    }     
    
    public Category update(Category d){
        if(d.getId()!=null){
            Optional<Category>g =categoryRepository.getCategory(d.getId());
            if(!g.isEmpty()){
                if(d.getName()!=null){
                    g.get().setName(d.getName());
                }
                if(d.getDescription()!=null){
                    g.get().setDescription(d.getDescription());
                }
                return categoryRepository.saveCategory(g.get());
            }
        }
        return d;
    }
    
    public boolean deleteCategory(int id){
        Optional<Category> d=getCategory(id);
        if(!d.isEmpty()){
            categoryRepository.delete(d.get());
            return true;
        }
        return false;
    }
}
