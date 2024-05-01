package com.hocinesehanine.cursosapi.modules.courses.usescases;

import com.hocinesehanine.cursosapi.modules.courses.exceptions.CourseNotFountException;
import com.hocinesehanine.cursosapi.modules.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseByIdUseCase {

    private final CourseRepository courseRepository;

    public DeleteCourseByIdUseCase(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void execute(Long id){
        final var course = courseRepository.findById(id).orElse(null);
        if (course == null){
            throw new CourseNotFountException();
        }
        courseRepository.deleteById(id);
    }
}
