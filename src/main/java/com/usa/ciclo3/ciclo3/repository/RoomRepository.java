package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Room;
import com.usa.ciclo3.ciclo3.repository.crud.RoomCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Nicolás Gámez
 */
@Repository
public class RoomRepository {
    
    @Autowired
    private RoomCrudRepository roomCrudRepository;
    
    public List<Room> getAll(){
        return (List<Room>)roomCrudRepository.findAll();
    }
    
    public Optional<Room> getRoom(int id){
        return roomCrudRepository.findById(id);
    }
    
    public Room save(Room r){
        return roomCrudRepository.save(r);
    }
    
    public void delete(Room id){
        roomCrudRepository.delete(id);
    }
    
}
