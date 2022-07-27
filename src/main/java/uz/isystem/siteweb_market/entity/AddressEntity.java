package uz.isystem.siteweb_market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = ("address"))
public class AddressEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = ("district"))
    private String district;
    @Column(name = ("street"))
    private String street;
    @Column(name = ("home"))
    private String home;
}
