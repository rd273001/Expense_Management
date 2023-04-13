package com.assignment.Expense_Management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  
    @Getter
    private String resourceName;
    @Getter
    private String fieldName;
    @Getter
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long ticketId) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, ticketId));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = ticketId;
    }

}