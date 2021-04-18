package com.example.rgr.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * cinemas
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Cinema {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    private String cinema;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
