package uz.isystem.siteweb_market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import uz.isystem.siteweb_market.convertlar.ProductConverter;
import uz.isystem.siteweb_market.dto.product.ProductCreateDto;
import uz.isystem.siteweb_market.dto.product.ProductDetailDto;
import uz.isystem.siteweb_market.dto.product.ProductFilterDto;
import uz.isystem.siteweb_market.entity.ProductEntity;
import uz.isystem.siteweb_market.enums.ProductStatus;
import uz.isystem.siteweb_market.exception.ProfileNotFoundException;
import uz.isystem.siteweb_market.exception.ServerBadRequestException;
import uz.isystem.siteweb_market.repository.ProductRepository;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductImageService productImageService;

    public void create(ProductCreateDto dto) {
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setType(dto.getType());

        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(ProductStatus.CREATED);
        repository.save(entity);
    }

    public ProductDetailDto getById(Integer id, Boolean isAdmin) {
        ProductEntity entity = findEntityById(id);
        if (!isAdmin) {
            if (!entity.getStatus().equals(ProductStatus.PUBLISHED)) {
                throw new ServerBadRequestException("Product not Published");
            }

        }
        ProductDetailDto dto = ProductConverter.toDetail(entity);
        dto.setImageList(productImageService.getProductImageDtoList(entity.getId()));
        return dto;
    }

    public void update(Integer id, ProductCreateDto dto) {
        ProductEntity entity = repository.getById(id);
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setType(dto.getType());
        repository.save(entity);
    }

    public void changeStatus(Integer id, ProductStatus status) {
        repository.changeStatus(id, status);
    }

    public List<ProductDetailDto> getLit() {
        return null;
    }

    public void block(Integer id) {
        ProductEntity entity = findEntityById(id);
        entity.setStatus(ProductStatus.BLOCKED);
        repository.save(entity);
    }

    public void publish(Integer id) {
        ProductEntity entity = findEntityById(id);
        entity.setStatus(ProductStatus.PUBLISHED);
        repository.save(entity);
    }

    public Page<ProductDetailDto> getPaginationList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> products = repository.findAll(pageable);
        return products.map(ProductConverter::toDetail);
    }

    public Page<ProductDetailDto> filter(ProductFilterDto dto) {
        String sortBy = dto.getSortBy();
        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "createdDate";
        }
        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), dto.getDirection(), sortBy);

        List<Predicate> predicateList = new ArrayList<>();
        Specification<ProductEntity> specification = ((root, criteriaQuery, criteriaBuilder) -> {
            if (dto.getName() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("name"), dto.getName()));
            }
            if (dto.getMinPrice() != null && dto.getMaxPrice() != null) {
                predicateList.add(criteriaBuilder.between(root.get("price"), dto.getMinPrice(), dto.getMaxPrice()));
            }
            if (dto.getType() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("type"), dto.getType()));
            }
            if (dto.getRate() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("rate"), dto.getRate()));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });
        Page<ProductEntity> page = repository.findAll(specification, pageable);

        Page<ProductDetailDto> resultPaging = page.map(entity -> {
            ProductDetailDto detailDto = toShortDTO(entity);
            detailDto.setImageList(productImageService.getProductImageDtoList(entity.getId()));
            return detailDto;
        });
        return resultPaging;
    }

    private ProductDetailDto toShortDTO(ProductEntity entity) {
        ProductDetailDto dto = new ProductDetailDto();
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public ProductEntity findEntityById(Integer id) {
        Optional<ProductEntity> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new ProfileNotFoundException("Invalid id");
        }
        return optional.get();
    }
}
