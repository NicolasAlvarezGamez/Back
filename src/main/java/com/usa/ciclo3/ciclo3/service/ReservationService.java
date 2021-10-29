package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.model.custom.CountClient;
import com.usa.ciclo3.ciclo3.model.custom.StatusAmount;
import com.usa.ciclo3.ciclo3.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolás Gámez
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Método para obtener en una lista todas las reservas
     *
     * @return List
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * Método para obtener en una reserva por medio del ID
     *
     * @param idReservation
     * @return Reservation
     */
    public Optional<Reservation> getReservation(int idReservation) {
        return reservationRepository.getReservation(idReservation);
    }

    /**
     * Método para guardar una reservación
     *
     * @param r
     * @return r
     */
    public Reservation saveReservation(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.saveReservation(r);
        } else {
            Optional<Reservation> paux = reservationRepository.getReservation(r.getIdReservation());
            if (paux.isEmpty()) {
                return reservationRepository.saveReservation(r);
            } else {
                return r;
            }
        }
    }

    /**
     * Método para actualizar una reservación
     *
     * @param r
     * @return r
     */
    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> g = reservationRepository.getReservation(r.getIdReservation());
            if (!g.isEmpty()) {
                if (r.getStartDate() != null) {
                    g.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    g.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus() != null) {
                    g.get().setStatus(r.getStatus());
                }
                if (r.getScore() != null) {
                    g.get().setScore(r.getScore());
                }
                return reservationRepository.saveReservation(g.get());
            }
        }
        return r;
    }

    /**
     * Método para borrar una reservación
     *
     * @param id
     * @return boolean
     */
    public boolean deleteReservation(int id) {
        Optional<Reservation> r = getReservation(id);
        if (!r.isEmpty()) {
            reservationRepository.delete(r.get());
            return true;
        }
        return false;
    }

    /**
     * Método para obtener los clientes con más reservaciones
     *
     * @return
     */
    public List<CountClient> getTopClients() {
        return reservationRepository.getTopClients();
    }

    /**
     * Método para obtener la cantidad de reservas completadas y canceladas
     *
     * @return statAmnt
     */
    public StatusAmount getStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

        StatusAmount statAmnt = new StatusAmount(completed.size(), cancelled.size());
        return statAmnt;
    }

    /**
     * Método para obtener las reservaciones comprendidas en un periodo de
     * tiempo
     *
     * @param d1
     * @param d2
     * @return List
     */
    public List<Reservation> getReservationPeriod(String d1, String d2) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat parser = new SimpleDateFormat(pattern);
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        } catch (ParseException e) {
        }
        if (dateOne.before(dateTwo)) {
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        } else {
            return new ArrayList<>();
        }
    }

}
