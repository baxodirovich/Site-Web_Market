package uz.isystem.siteweb_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.siteweb_market.entity.ProductImageEntity;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImageEntity, Integer> {
    List<ProductImageEntity> findAllByProductId(Integer productId);
}
