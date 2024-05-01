package com.hocinesehanine.cursosapi.modules.courses.usescases;

import com.hocinesehanine.cursosapi.modules.courses.entiteis.CourseEntity;
import com.hocinesehanine.cursosapi.modules.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCoursesUseCase {

    private final CourseRepository courseRepository;

    public GetAllCoursesUseCase(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseEntity> execute(final boolean active) {
        return courseRepository.findAllByActive(active);
    }
}
