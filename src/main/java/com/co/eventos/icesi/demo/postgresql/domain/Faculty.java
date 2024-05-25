package com.co.eventos.icesi.demo.postgresql.domain;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "facultades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer code;

    @Column(name = "nombre")
    private String name;

    @Column(name = "ubicacion")
    private String location;

    @Column(name = "nro_telefono")
    private String phoneNumber;

    @Column(name = "id_decano")
    private String deanId;

}