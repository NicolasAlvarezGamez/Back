package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.model.custom.CountClient;
import com.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Nicolás Gámez
 */
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int idReservation) {
        return reservationCrudRepository.findById(idReservation);
    }

    public Reservation saveReservation(Reservation r) {
        return reservationCrudRepository.save(r);
    }

    public void delete(Reservation id) {
        reservationCrudRepository.delete(id);
    }

    public List<Reservation> getReservationByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountClient> getTopClients() {
        List<CountClient> res = new ArrayList<>();

            List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
            for (int i = 0; i < report.size(); i++) {
            res.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
            return res;
    }

}
