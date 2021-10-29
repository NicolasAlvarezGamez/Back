package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Nicolás Gámez
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<Client> getAllClient(){
        return (List<Client>)clientCrudRepository.findAll();
    }
    
    public Optional<Client> getClient(int idClient){
        return clientCrudRepository.findById(idClient);
    }
    
    public Client saveClient(Client c){
        return clientCrudRepository.save(c);
    }
    
    public void delete(Client idClient){
        clientCrudRepository.delete(idClient);
    }    
    
}
