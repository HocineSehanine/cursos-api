package com.hocinesehanine.cursosapi.modules.courses.exceptions;

public class CourseIsNotActiveException extends RuntimeException {

    public CourseIsNotActiveException() {
        super("Course is not active");
    }
}
