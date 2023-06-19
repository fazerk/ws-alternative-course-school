package com.ratings.wsalternativecourseschool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_materias")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_materias")
    private long id;

    @Column(name = "nombre", length = 80)
    private String name;

    @Column(name = "activo", length = 1)
    private Integer active;

    @OneToMany(mappedBy = "course")
    Set<Score> scores;
}
