package uz.isystem.siteweb_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.isystem.siteweb_market.entity.OrderItemEntity;

import java.util.List;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
    List<OrderItemEntity> findAllByOrderId(Integer orderId);
}
