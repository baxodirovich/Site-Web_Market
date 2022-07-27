package uz.isystem.siteweb_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.isystem.siteweb_market.entity.ProductEntity;
import uz.isystem.siteweb_market.enums.ProductStatus;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>, JpaSpecificationExecutor<ProductEntity> {
    @Transactional
    @Modifying
    @Query("update ProductEntity set status =: status where id =: id")
    void changeStatus(Integer id, ProductStatus status);
}
