package lk.ac.cmb.ucsc.counselling.repository;

import lk.ac.cmb.ucsc.counselling.model.RateIdentity;
import lk.ac.cmb.ucsc.counselling.model.Rated;
import org.springframework.data.repository.CrudRepository;

public interface RatedRepository extends CrudRepository<Rated, RateIdentity> {
}
