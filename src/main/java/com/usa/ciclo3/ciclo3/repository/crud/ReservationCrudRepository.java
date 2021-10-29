package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Nicolás Gámez
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    //JPQL = Java Persistence Query Language
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc") 
    public List<Object[]>countTotalReservationByClient();  
        
    //Query Methods
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
           
    public List<Reservation> findAllByStatus(String status);
 
}
