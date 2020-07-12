package lk.ac.cmb.ucsc.counselling.repository;

import lk.ac.cmb.ucsc.counselling.util.AppointmentStatus;
import lk.ac.cmb.ucsc.counselling.model.AppointmentRequest;
import lk.ac.cmb.ucsc.counselling.model.AppointmentRequestPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRequestRepository extends CrudRepository<AppointmentRequest, AppointmentRequestPK> {

    public List<AppointmentRequest> findByStatusAndId_Counselor_id(AppointmentStatus s,Long counselor);

    public List<AppointmentRequest> findById_Counselor_id(Long id);
}
