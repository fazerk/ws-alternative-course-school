package com.ratings.wsalternativecourseschool.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_alumnos")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_usuarios")
    @JsonProperty("id_t_usuarios")
    private long id;

    @Column(name = "nombre", length = 80)
    @JsonProperty("nombre")
    private String name;

    @Column(name = "ap_paterno", length = 80)
    @JsonProperty("ap_paterno")
    private String surname;

    @Column(name = "ap_materno", length = 80)
    @JsonProperty("ap_materno")
    private String secondSurname;

    @Column(name = "activo", length = 1)
    @JsonIgnore
    private Integer active;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    Set<Score> scores;

}
