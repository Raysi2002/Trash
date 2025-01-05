package com.raysi.company.error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResourceNotFoundException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
}
