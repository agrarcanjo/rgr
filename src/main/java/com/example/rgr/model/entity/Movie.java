package com.example.rgr.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

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
public class Movie {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    @NotBlank(message = "Nome do cinema deve ser preenchido")
    @Size(min = 1, max = 100, message = "Nome do cinema deve ter entre 1 e 100 letras")
    private String name;

}
