package com.jfranbob.coursesmanagement.application.shared;

public sealed interface Result<T> permits Result.Success, Result.Failure {
    record Success<T>(T data) implements Result<T> {
    }

    record Failure<T>(String reason) implements Result<T> {
    }
}
