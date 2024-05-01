package com.hocinesehanine.cursosapi.modules.courses.entiteis;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity(name = "course")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank()
    @Schema(example = "Java", requiredMode = Schema.RequiredMode.REQUIRED, description = "nome do curso")
    private String name;

    @NotBlank()
    @Schema(example = "BackEnd", requiredMode = Schema.RequiredMode.REQUIRED, description = "Categoria do cuso")
    private String category;

    @NotBlank()
    @Schema(example = "MANHA", requiredMode = Schema.RequiredMode.REQUIRED, description = "Tipo do periodo do curso")
    private String period;

    @Schema(example = "true", requiredMode = Schema.RequiredMode.REQUIRED, description = "Curso ativo ou não")
    private boolean active;

    @CreationTimestamp
    @Schema(example = "2022-04-29T14:30", description = "Data da criação do curso")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
