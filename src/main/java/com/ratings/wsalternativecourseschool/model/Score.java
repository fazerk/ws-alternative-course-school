package com.ratings.wsalternativecourseschool.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_calificaciones")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_t_materias")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_t_usuarios")
    private Student student;

    @Column(name = "calificacion")
    private Float score;

    @Column(name = "fecha_registro")
    private LocalDateTime registeredAt;
}
