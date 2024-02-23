package com.manolya.transport.dto;

import com.manolya.transport.models.Todo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDTO {
    @NotBlank(message = "Başlık Boş Olamaz")
    @Size(max = 100, message = "Başlık En Fazla 100 Karakter Olmalı")
    private String title;

    @Size(max = 255, message = "Açıklama en fazla 255 karakter olmalı")
    private String description;

    private Todo.Priority priority = Todo.Priority.LOW;
    private boolean completed = false;

    public Todo toEntity(){
        return new Todo(null,title,description,priority,completed);
    }
}
