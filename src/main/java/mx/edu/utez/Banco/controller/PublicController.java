package mx.edu.utez.Banco.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/public")
@RequiredArgsConstructor
public class PublicController {
    @PostMapping(value = "demo")
    public String welcome(){
        return "Welcome from security endpoint";
    }
}
