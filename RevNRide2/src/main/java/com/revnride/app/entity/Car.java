package com.revnride.app.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.revnride.app.entity.enums.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Builder
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private int idcar;
    
    @NotNull
    @Column(name = "mark")
    private String mark;
    
    @NotNull
    @Column(name = "model")
    private String model;
    
    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeCar type;
   
    @NotNull
    @Column(name = "year_production")
    
    private int yearProduction;
   
    @NotNull
    @Column(name = "color")
    private String color;
    
    @NotNull
    @Column(name = "engine_capacity")
    
    private int engineCapacity;
    
    @NotNull
    @Column(name = "money")
    private float money;
   
    @NotNull
    @Column(name = "image")
    private String image;
    
    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<Reservation> reservation;
   
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_localization")
    private Localization localization;
 
    public Car(String mark, String model, TypeCar type, int yearProduction, String color, int engineCapacity, float money, Localization localization, String image) {
        this.mark = mark;
        this.model = model;
        this.type = type;
        this.yearProduction = yearProduction;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.money = money;
        this.localization = localization;
        this.image = image;
    }

}
