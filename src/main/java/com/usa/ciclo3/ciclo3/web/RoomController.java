package com.usa.ciclo3.ciclo3.web;

import com.usa.ciclo3.ciclo3.model.Room;
import com.usa.ciclo3.ciclo3.service.RoomService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nicolás Gámez
 */

@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class RoomController {
    
    @Autowired
    private RoomService roomService;
    
    @RequestMapping("/all")
    public List<Room> getRooms(){
        return roomService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int id){
        return roomService.getRoom(id);
    }
    
    
    @RequestMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room r){
        return roomService.save(r);
    } 
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room r){
        return roomService.update(r);
    } 
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteRoom(@PathVariable("id") int id){
        return roomService.deleteRoom(id);
    }
    
}
