package mx.edu.utez.Banco.service.impl;

import mx.edu.utez.Banco.model.dao.BranchDao;
import mx.edu.utez.Banco.model.dao.EmployeeDao;
import mx.edu.utez.Banco.model.dao.PersonDao;
import mx.edu.utez.Banco.model.dto.EmployeeDto;
import mx.edu.utez.Banco.model.entity.BranchBean;
import mx.edu.utez.Banco.model.entity.EmployeeBean;
import mx.edu.utez.Banco.model.entity.PersonBean;
import mx.edu.utez.Banco.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplEmployee implements IEmployee {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private BranchDao branchDao;
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public EmployeeBean save(EmployeeDto employeeDto) {
        BranchBean branch = branchDao.findById(employeeDto.getBranch_idbranch()).orElse(null);
        PersonBean person = personDao.findById(employeeDto.getPerson_idperson()).orElse(null);

        EmployeeBean employee = EmployeeBean.builder()
                .idEmployee(employeeDto.getId_employee())
                .emplNumber(employeeDto.getEmployee_number())
                .adminDate(employeeDto.getAdmition_date())
                .branchBean(branch)
                .personBean(person)
                .build();
        return employeeDao.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeBean findById(Integer id) {
        return employeeDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeBean> findAll() {
        return (List<EmployeeBean>) employeeDao.findAll();
    }

    @Override
    @Transactional
    public void delete(EmployeeBean employee) {
        employeeDao.delete(employee);
    }
}
