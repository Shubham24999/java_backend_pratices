package com.example.api;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class ApiModelService {
    @Id
    private Integer Id;

    private String serviceName;

    private Integer portNumber;
    
}
