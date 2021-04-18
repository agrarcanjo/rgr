package com.example.rgr.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * filmes
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class MovieCity {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @JsonIgnore
    @NotNull(message = "O Cinema deve ser preenchido")
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @NotNull(message = "O Filme deve ser preenchido")
    private Movie movie;


}
