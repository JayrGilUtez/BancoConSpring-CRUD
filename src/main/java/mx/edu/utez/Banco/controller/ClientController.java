package mx.edu.utez.Banco.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.Banco.model.dto.ClientDto;
import mx.edu.utez.Banco.model.entity.ClientBean;
import mx.edu.utez.Banco.service.impl.ImplClient;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    private final ImplClient clientService;

    @GetMapping("/")
    public List<ClientBean> getClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientBean showById(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody ClientDto clientDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            ClientBean clientSave = clientService.save(clientDto);
            response.put("mensaje", "Cliente creado correctamente");
            response.put("Client", clientSave);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Error al crear el cliente");
            response.put("Cliente", null);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ClientDto update(@RequestBody ClientDto clientDto) {
        ClientBean employeeUpdate = clientService.save(clientDto);
        return clientDto.builder()
                .person_idperson(clientDto.getPerson_idperson())
                .account(clientDto.getAccount())
                .type(clientDto.getType())
                .person_idperson(clientDto.getPerson_idperson())
                .branch_idbranch(clientDto.getBranch_idbranch())
                .cards(clientDto.getCards())
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            ClientBean client = clientService.findById(id);
            clientService.delete(client);
            response.put("mensaje", "Empleado eliminado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el empleado");
            response.put("Empleado", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}