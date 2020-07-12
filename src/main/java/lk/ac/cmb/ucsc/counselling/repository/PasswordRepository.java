package lk.ac.cmb.ucsc.counselling.repository;

import lk.ac.cmb.ucsc.counselling.model.Password;
import lk.ac.cmb.ucsc.counselling.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PasswordRepository extends CrudRepository<Password,String> {
    public List<Password> findByEmail(String email);
}
