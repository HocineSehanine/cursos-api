package com.hocinesehanine.cursosapi.modules.courses.usescases;

import com.hocinesehanine.cursosapi.modules.courses.entiteis.CourseEntity;
import com.hocinesehanine.cursosapi.modules.courses.exceptions.CourseIsNotActiveException;
import com.hocinesehanine.cursosapi.modules.courses.exceptions.CourseNotFountException;
import com.hocinesehanine.cursosapi.modules.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseUseCase {

    private final CourseRepository courseRepository;

    public UpdateCourseUseCase(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void execute(final Long id, CourseEntity newCourseEntity) {
        final var course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            throw new CourseNotFountException();
        }
        if (!course.isActive()) {
            throw new CourseIsNotActiveException();
        }
        courseRepository.updateCourse(id, newCourseEntity);
    }
}
