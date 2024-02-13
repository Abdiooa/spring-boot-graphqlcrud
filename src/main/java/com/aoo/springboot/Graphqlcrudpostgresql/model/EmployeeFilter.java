package com.aoo.springboot.Graphqlcrudpostgresql.model;

import lombok.Data;

@Data
public class EmployeeFilter {
    private FilterField salary;
    private FilterField age;
    private FilterField position;
}
