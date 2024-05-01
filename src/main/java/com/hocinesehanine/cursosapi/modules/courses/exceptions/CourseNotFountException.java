package com.hocinesehanine.cursosapi.modules.courses.exceptions;

public class CourseNotFountException extends RuntimeException {

    public CourseNotFountException() {
        super("Course Not Found");
    }
}
