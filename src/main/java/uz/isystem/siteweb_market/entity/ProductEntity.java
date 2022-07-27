package uz.isystem.siteweb_market.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.isystem.siteweb_market.enums.ProductStatus;
import uz.isystem.siteweb_market.enums.ProductType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = ("product"))
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = ("name"))
    private String name;
    @Column(name = ("description_uz"))
    private String descriptionUz;
    @Column(name = ("description_ru"))
    private String descriptionRu;
    @Column(name = ("price"))
    private Double price;
    @Column(name = ("rate"))
    private Integer rate;
    @Column(name = ("created_date"))
    private LocalDateTime createdDate;
    @Column(name = ("visible"), columnDefinition = "boolean")
    private Boolean visible;
    @Column(name = ("type"))
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Column(name = ("status"))
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
}
