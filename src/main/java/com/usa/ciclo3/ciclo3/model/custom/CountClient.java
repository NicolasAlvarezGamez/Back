package com.usa.ciclo3.ciclo3.model.custom;

import com.usa.ciclo3.ciclo3.model.Client;

/**
 *
 * @author Nicolás Gámez
 */
public class CountClient {
    
    public Long total;
    public Client client;

    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
