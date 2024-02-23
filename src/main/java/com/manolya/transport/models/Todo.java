package com.manolya.transport.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "todos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Başlık Boş Olamaz")
    @Size(max = 100, message = "Başlık En Fazla 100 Karakter Olmalı")
    @Column(length = 100)
    private String title;

    @Size(max = 255, message = "Açıklama en fazla 255 karakter olmalı")
    @Column(length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;
    private boolean completed = false;

    public enum Priority{
        HIGH, MEDIUM, LOW
    }



}
