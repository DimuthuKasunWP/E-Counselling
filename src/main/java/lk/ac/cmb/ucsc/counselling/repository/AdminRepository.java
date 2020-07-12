package lk.ac.cmb.ucsc.counselling.repository;

import lk.ac.cmb.ucsc.counselling.model.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//CrudRepository <EntityName, PrimaryKeyType>
public interface AdminRepository extends CrudRepository<Admin, Long> {

    public List<Admin> findByActiveStatus(String status);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="UPDATE Admin SET active_Status='Inactive' WHERE adminID=?1", nativeQuery = true)
    public void deleteAdmin(long id);
}
