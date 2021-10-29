package com.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Nicolás Gámez
 */
@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Variables
    private Integer id;
    private String name;
    private String hotel;
    private Integer stars;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("rooms")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    public List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Reservation> reservations;

    /**
     * Obtiene del Integer Id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Implementa un Valor para Id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el Valor de Name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Implementa un Valor para Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el Valor de Hotel
     *
     * @return hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * Implementa un Valor para Hotel
     *
     * @param hotel
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
     * Obtiene el Valor de Stars
     *
     * @return stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * Implementa un Valor para Stars
     *
     * @param stars
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * Obtiene el Valor de Description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Implementa un Valor para Description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el Valor de la Sección Categoría
     *
     * @return Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Implementa un Valor para la Sección Categoría
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Obtiene el Valor de la Sección Mensajes
     *
     * @return Messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Implementa un Valor para la Sección Mensajes
     *
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Obtiene el Valor de la Sección Reservas
     *
     * @return reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Implementa un Valor para la Sección de Reservas
     *
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
