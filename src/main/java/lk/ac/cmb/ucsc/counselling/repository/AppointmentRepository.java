package lk.ac.cmb.ucsc.counselling.repository;

import lk.ac.cmb.ucsc.counselling.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
