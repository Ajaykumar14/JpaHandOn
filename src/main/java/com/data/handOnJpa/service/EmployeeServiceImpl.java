package com.data.handOnJpa.service;

import com.data.handOnJpa.entity.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Value("EMPLOYEE_DATA.json")
    private Resource resource;

    public List<Employee> getEmployeeData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>() {
        };
        return objectMapper.readValue(resource.getInputStream(), typeReference);

    }
}
