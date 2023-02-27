package com.revnride.app.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Builder
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rent")
    /**idrent*/
    private Long idrent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_car", nullable = false)
    /**car*/
    private Car car;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "date")
    @Column(name = "data_from")
    /**dataFrom*/
    private Date dataFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "date")
    @Column(name = "data_to")
    /**dataTo*/
    private Date dataTo;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "localization_start", referencedColumnName = "id_localization")
    /**localizationStart*/
    private Localization localizationStart;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "localization_end", referencedColumnName = "id_localization")
    /**localizationEnd*/
    private Localization localizationEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    private DaoUser user;

    @Column(name = "price")
    /**price*/
    private float price;


    /** Constructor Class Reservation
     *
     * @param car Car Class Object
     * @param user User Class Object
     * @param dataFrom Date of the reservation start
     * @param dataTo Date of the reservation end
     * @param localizationStart The city where the reservations started
     * @param localizationEnd The city where the reservations ended
     * @param price  Reservation cost
     */
    public Reservation(Car car, DaoUser user, Date dataFrom, Date dataTo, Localization localizationStart, Localization localizationEnd, float price) {
        this.car = car;
        this.user = user;
        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
        this.localizationStart = localizationStart;
        this.localizationEnd = localizationEnd;
        this.price = price;
    }

}
