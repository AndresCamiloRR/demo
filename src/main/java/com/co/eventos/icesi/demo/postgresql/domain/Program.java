package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "programas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer code;

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "codigo_area", referencedColumnName = "codigo")
    private Area area;

}