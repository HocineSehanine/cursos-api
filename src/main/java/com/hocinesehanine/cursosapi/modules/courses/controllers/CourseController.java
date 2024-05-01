package com.hocinesehanine.cursosapi.modules.courses.controllers;

import com.hocinesehanine.cursosapi.modules.courses.entiteis.CourseEntity;
import com.hocinesehanine.cursosapi.modules.courses.usescases.CreateCourseUseCase;
import com.hocinesehanine.cursosapi.modules.courses.usescases.DeleteCourseByIdUseCase;
import com.hocinesehanine.cursosapi.modules.courses.usescases.GetAllCoursesUseCase;
import com.hocinesehanine.cursosapi.modules.courses.usescases.PatchCourseUseCase;
import com.hocinesehanine.cursosapi.modules.courses.usescases.UpdateCourseUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;
    private final GetAllCoursesUseCase getAllCoursesUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final DeleteCourseByIdUseCase deleteCourseByIdUseCase;
    private final PatchCourseUseCase patchCourseUseCase;


    @Operation(summary = "Criação de curso", description = "Esta função responsavel pela criação de novos cursos")
    @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CourseEntity.class)
            )
    })
    @PostMapping("/criar")
    public ResponseEntity<Object> createCourse(@RequestBody CourseEntity courseEntity) {
        final var createdCourse = createCourseUseCase.execute(courseEntity);
        return ResponseEntity.ok(createdCourse);
    }

    @Operation(summary = "Listando todos os cursos filtrados pelo status do cusrso", description = "Esta função responsavel pela listagem dos cursos pelo status")
    @ApiResponse(responseCode = "200", content = {
            @Content(
                    array = @ArraySchema(schema = @Schema(implementation = CourseEntity.class))
            )
    })
    @GetMapping("/cursos")
    public List<CourseEntity> getAllCourses(@RequestParam boolean active) {
        return getAllCoursesUseCase.execute(active);
    }

    @Operation(summary = "Edição de curso", description = "Esta função responsavel pela edição do curso pelo id")
    @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CourseEntity.class)
            )
    })
    @PutMapping("/editar/{id}")
    public ResponseEntity<Object> updateCourseById(@PathVariable Long id, @RequestBody CourseEntity courseEntity) {
        try {
            updateCourseUseCase.execute(id, courseEntity);
            return ResponseEntity.ok().body(id);
        } catch (final Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Exclusão do curso", description = "Esta função responsavel pela exclusão do curso pelo id")
    @ApiResponse(responseCode = "200")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteCourseById(@PathVariable Long id) {
        try {
            deleteCourseByIdUseCase.execute(id);
            return ResponseEntity.ok().body(id);
        } catch (final Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Edição de curso", description = "Esta função responsavel pela edição do curso pelo id")
    @PatchMapping("/ativarDesativar/{id}")
    public ResponseEntity<Object> patchCourseById(@PathVariable Long id) {
        try {
            patchCourseUseCase.execute(id);
            return ResponseEntity.ok().body(id);
        } catch (final Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}