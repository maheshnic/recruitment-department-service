package com.recruitment.Department_Service.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean status;
    private String message;
    private T data;
    private String errorCode;
    private long timestamp;

    public ApiResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public ApiResponse(boolean status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public ApiResponse(boolean status, String message, T data) {
        this();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(boolean status, String message, String errorCode) {
        this();
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }

    public ApiResponse(boolean status, String message, String errorCode, T data) {
        this();
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }

    // Static factory methods that return ResponseEntity directly
    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        return ResponseEntity.ok(new ApiResponse<>(true, message, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Created", data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(String message) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, message));
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(String message, T data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, message, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(false, message, "BAD_REQUEST"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message, T data) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(false, message, "BAD_REQUEST", data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> unprocess(String message) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ApiResponse<>(false, message, "UNPROCESSABLE_ENTITY"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message, String errorCode) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(false, message, errorCode));
    }

    public static <T> ResponseEntity<ApiResponse<T>> unauthorized(String message) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse<>(false, message, "UNAUTHORIZED"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> unauthorized(String message, String errorCode) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse<>(false, message, errorCode));
    }

    public static <T> ResponseEntity<ApiResponse<T>> forbidden(String message) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ApiResponse<>(false, message, "FORBIDDEN"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> forbidden(String message, String errorCode) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ApiResponse<>(false, message, errorCode));
    }

    public static <T> ResponseEntity<ApiResponse<T>> internalServerError(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse<>(false, message, "INTERNAL_SERVER_ERROR"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> internalServerError(String message, String errorCode) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse<>(false, message, errorCode));
    }

    public static <T> ResponseEntity<ApiResponse<T>> noContent() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ApiResponse<>(true, "No Content"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> notFound(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, message, "NOT_FOUND"));
    }
}
