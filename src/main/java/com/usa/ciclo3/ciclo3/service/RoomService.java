package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Room;
import com.usa.ciclo3.ciclo3.repository.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Nicolás Gámez
 */

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getAll(){
        return roomRepository.getAll();
    }
    
    public Optional<Room> getRoom(int id){
        return roomRepository.getRoom(id);
    }
    
    public Room save(Room r){
        if(r.getId()==null){
            return roomRepository.save(r);
        }else{
            Optional<Room> paux=roomRepository.getRoom(r.getId());
            if(paux.isEmpty()){
                return roomRepository.save(r);
            }else{
                return r;
            }
        }
    }  
    
    public Room update(Room r){
        if(r.getId()!=null){
            Optional<Room>g =roomRepository.getRoom(r.getId());
            if(!g.isEmpty()){
                if(r.getName()!=null){
                    g.get().setName(r.getName());
                }
                if(r.getStars()!=null){
                    g.get().setStars(r.getStars());
                }
                if(r.getHotel()!=null){
                    g.get().setHotel(r.getHotel());
                }
                if(r.getDescription()!=null){
                    g.get().setDescription(r.getDescription());
                }
                return roomRepository.save(g.get());
            }
        }
        return r;
    }
    
    public boolean deleteRoom(int id){
        Optional<Room> r=getRoom(id);
        if(!r.isEmpty()){
            roomRepository.delete(r.get());
            return true;
        }
        return false;
    }
    
}
