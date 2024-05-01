package com.hocinesehanine.cursosapi.modules.courses.usescases;

import com.hocinesehanine.cursosapi.modules.courses.entiteis.CourseEntity;
import com.hocinesehanine.cursosapi.modules.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    private final CourseRepository courseRepository;

    public CreateCourseUseCase(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseEntity execute(final CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }
}
