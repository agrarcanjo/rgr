package com.example.rgr.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 *
 * acentos
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Accent {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    private Integer accent;

    @Column()
    private Boolean occupied;

    @ManyToOne
    @JoinColumn(name = "schedule_movie_id")
    private ScheduleMovie scheduleMovie;

}
