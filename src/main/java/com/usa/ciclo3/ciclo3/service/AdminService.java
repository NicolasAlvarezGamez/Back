package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Admin;
import com.usa.ciclo3.ciclo3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolás Gámez
 */

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int idAdmin){
        return adminRepository.getAdmin(idAdmin);
    }
    
    public Admin save(Admin a){
        if(a.getIdAdmin()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> paux=adminRepository.getAdmin(a.getIdAdmin());
            if(paux.isEmpty()){
                return adminRepository.save(a);
            }else{
                return a;
            }
        }
    }  
    
    public Admin update(Admin a){
        if(a.getIdAdmin()!=null){
            Optional<Admin>g =adminRepository.getAdmin(a.getIdAdmin());
            if(!g.isEmpty()){
                if(a.getName()!=null){
                    g.get().setName(a.getName());
                }
                if(a.getEmail()!=null){
                    g.get().setEmail(a.getEmail());
                }
                if(a.getPassword()!=null){
                    g.get().setPassword(a.getPassword());
                }
                return adminRepository.save(g.get());
            }
        }
        return a;
    }
    
    public boolean deleteAdmin(int idAdmin){
        Optional<Admin> a=getAdmin(idAdmin);
        if(!a.isEmpty()){
            adminRepository.delete(a.get());
            return true;
        }
        return false;
    }
    
    
}
