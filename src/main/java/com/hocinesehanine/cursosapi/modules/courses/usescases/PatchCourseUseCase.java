package com.hocinesehanine.cursosapi.modules.courses.usescases;

import com.hocinesehanine.cursosapi.modules.courses.exceptions.CourseNotFountException;
import com.hocinesehanine.cursosapi.modules.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class PatchCourseUseCase {

    private final CourseRepository courseRepository;

    public PatchCourseUseCase(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void execute(final Long id) {
        var courseEntity = courseRepository.findById(id)
                .orElseThrow(CourseNotFountException::new);

        boolean newActiveStatus = !courseEntity.isActive();
        courseRepository.patchCourse(id, newActiveStatus);
    }
}
