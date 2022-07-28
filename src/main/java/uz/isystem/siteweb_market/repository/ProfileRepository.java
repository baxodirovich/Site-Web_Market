package uz.isystem.siteweb_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.isystem.siteweb_market.entity.ProfileEntity;
import uz.isystem.siteweb_market.enums.ProfileStatus;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer>, JpaSpecificationExecutor<ProfileEntity> {
   @Transactional
   @Modifying
   @Query("update ProfileEntity set status=:status where id=:id")
   int changeStatus(@Param("status")ProfileStatus status, @Param("id") Integer id);

   Optional<ProfileEntity> findByEmailAndPassword(String email, String password);

   Optional<ProfileEntity> findByEmail(String s);
}
