package com.example.rgr.model.entity;

import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;

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
public class ScheduleMovie {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate schedule;

    @Column()
    private Long price;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
