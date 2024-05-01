package com.hocinesehanine.cursosapi.modules.courses.repository;

import com.hocinesehanine.cursosapi.modules.courses.entiteis.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    List<CourseEntity> findAllByActive(final Boolean active);

    @Modifying
    @Transactional
    @Query("""
    UPDATE course c
    SET c.name = :#{#course.name},
        c.category = :#{#course.category},
        c.period = :#{#course.period},
        c.active = :#{#course.active},
        c.updatedAt = CURRENT_TIMESTAMP()
    WHERE c.id = :id
    """)
    void updateCourse(@Param("id") final Long id, @Param("course") final CourseEntity course);

    @Modifying
    @Transactional
    @Query("""
        UPDATE course c
        SET c.active = :active,
            c.updatedAt = CURRENT_TIMESTAMP()
        WHERE c.id = :id
    """)
    void patchCourse(@Param("id") final Long id, @Param("active") final boolean active);
}
