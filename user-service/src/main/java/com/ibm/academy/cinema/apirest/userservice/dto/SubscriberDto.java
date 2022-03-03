package com.ibm.academy.cinema.apirest.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberDto extends UserDto {

    @Null
    private Integer points;
}
