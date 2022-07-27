package uz.isystem.siteweb_market.entity;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.enums.ProfileRole;
import uz.isystem.siteweb_market.enums.ProfileStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("profile"))
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = ("name"))
    private String name;
    @Column(name = ("surname"))
    private String surname;
    @Column(name = ("email"), insertable = false, updatable = false)
    private String email;
    @Column(name = ("password"))
    private String password;
    @Column(name = ("contact"))
    private String contact;
    @Column(name = ("created_date"))
    private LocalDateTime createdDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = ("attach_id"))
    private ImageEntity imageId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ("address_id"))
    private AddressEntity address;

    @Column(name = ("status"))
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

    @Column(name = ("role"))
    @Enumerated(EnumType.STRING)
    private ProfileRole role;
}
