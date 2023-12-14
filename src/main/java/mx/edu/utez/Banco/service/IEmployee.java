package mx.edu.utez.Banco.service;


import mx.edu.utez.Banco.model.dto.EmployeeDto;
import mx.edu.utez.Banco.model.entity.EmployeeBean;

import java.util.List;

public interface IEmployee {
    EmployeeBean save(EmployeeDto employeeDto);

    EmployeeBean findById(Integer id);

    List<EmployeeBean> findAll();

    void delete(EmployeeBean employeeBean);
}
