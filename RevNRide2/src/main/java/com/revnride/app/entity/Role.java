package com.revnride.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    /***/
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    /***/
    private Roles name;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();


    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + name.hashCode();
        return result;
    }
}
