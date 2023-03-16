package com.revnride.app.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Builder
@Table(name = "localization")
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localization")
    /**id*/
    private Long id;

    @NotNull
    @Column(name = "city")
    /**city*/
    private String city;

    @OneToMany(mappedBy = "localization", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<Car> car;

    /** Constructor Class Localization
     *
     * @param city Car location city
     */
    public Localization(String city) {
        this.city = city;
    }

}
