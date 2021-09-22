package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    private int id;

    @Size(min = 6, max = 50, message = "The name must be at least 6 character and max 50 character")
    private String name;

    @Min(value = 0, message = "The total member must be greater than 0")
    private int totalMember;
}
