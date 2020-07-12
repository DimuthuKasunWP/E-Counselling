package lk.ac.cmb.ucsc.counselling.repository;

import lk.ac.cmb.ucsc.counselling.model.PatientRecords;
import lk.ac.cmb.ucsc.counselling.model.User;
import lk.ac.cmb.ucsc.counselling.model.Counselor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRecordsRepository extends CrudRepository<PatientRecords, Long> {
    public List<PatientRecords> findByUserAndCounselor(User user, Counselor counselor);
}
