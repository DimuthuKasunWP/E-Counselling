package lk.ac.cmb.ucsc.counselling.repository;

import lk.ac.cmb.ucsc.counselling.model.Payment;
import lk.ac.cmb.ucsc.counselling.model.RateIdentity;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, RateIdentity> {
}
