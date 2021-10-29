package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Nicolás Gámez
 */

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAllClient(){
        return clientRepository.getAllClient();
    }
    
    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    
    public Client saveClient(Client c){
        if(c.getIdClient()==null){
            return clientRepository.saveClient(c);
        }else{
            Optional<Client> paux=clientRepository.getClient(c.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.saveClient(c);
            }else{
                return c;
            }
        }
    }  
    
    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client>g =clientRepository.getClient(c.getIdClient());
            if(!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if(c.getEmail()!=null){
                    g.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    g.get().setPassword(c.getPassword());
                }
                if(c.getAge()!=null){
                    g.get().setAge(c.getAge());
                }
                return clientRepository.saveClient(g.get());
            }
        }
        return c;
    }
    
    public boolean deleteClient(int idClient){
        Optional<Client> c=getClient(idClient);
        if(!c.isEmpty()){
            clientRepository.delete(c.get());
            return true;
        }
        return false;
    }
    

}
