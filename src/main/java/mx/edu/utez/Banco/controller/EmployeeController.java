package mx.edu.utez.Banco.controller;

import mx.edu.utez.Banco.model.dao.BranchDao;
import mx.edu.utez.Banco.model.dao.PersonDao;
import mx.edu.utez.Banco.model.dto.EmployeeDto;
import mx.edu.utez.Banco.model.entity.EmployeeBean;
import mx.edu.utez.Banco.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private IEmployee employeeService;
    @Autowired
    private BranchDao branchDao;
    @Autowired
    private PersonDao personDao;

    @GetMapping("/")
    public List<EmployeeBean> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeBean showById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody EmployeeDto employeeDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            EmployeeBean employeeSave = employeeService.save(employeeDto);
            response.put("mensaje", "Empleado creado correctamente");
            response.put("Empleado", employeeSave);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Error al crear el empleado");
            response.put("Empleado", null);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto) {
        EmployeeBean employeeUpdate = employeeService.save(employeeDto);
        return EmployeeDto.builder()
                .id_employee(employeeDto.getId_employee())
                .employee_number(employeeDto.getEmployee_number())
                .admition_date(employeeDto.getAdmition_date())
                .branch_idbranch(employeeDto.getBranch_idbranch())
                .person_idperson(employeeDto.getPerson_idperson())
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            EmployeeBean employee = employeeService.findById(id);
            employeeService.delete(employee);
            response.put("mensaje", "Empleado eliminado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el empleado");
            response.put("Empleado", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
