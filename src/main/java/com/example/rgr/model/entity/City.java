package com.example.rgr.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * cidades
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class City {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    private String city;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Cinema> cinemas = new ArrayList<>();

}
