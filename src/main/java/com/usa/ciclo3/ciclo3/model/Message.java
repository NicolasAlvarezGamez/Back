package com.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author Nicolás Gámez
 */

@Entity
@Table(name="message")
public class Message implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Variables
    private Integer idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="roomId")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Room room;
    
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setId(Integer id) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
