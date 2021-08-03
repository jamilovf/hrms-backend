package com.jamilovf.hrms.mapper;


import com.jamilovf.hrms.dto.DepartmentDto;
import com.jamilovf.hrms.entity.concretes.Department;

public class DepartmentMapper {
    public static DepartmentDto entityToDto(Department department){
        return new DepartmentDto()
                .setId(department.getId())
                .setName(department.getName());
    }

    public static Department dtoToEntity(DepartmentDto departmentDto){
        return new Department()
                .setId(departmentDto.getId())
                .setName(departmentDto.getName());
    }
}
