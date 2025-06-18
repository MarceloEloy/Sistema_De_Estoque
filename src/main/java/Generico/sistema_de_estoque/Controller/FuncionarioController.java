package Generico.sistema_de_estoque.Controller;

import Generico.sistema_de_estoque.DTO.FuncionarioDTO;
import Generico.sistema_de_estoque.Model.Users.Funcionario;
import Generico.sistema_de_estoque.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> add(@RequestBody FuncionarioDTO dto) throws URISyntaxException {
        return this.funcionarioService.add(dto);
    }
    @GetMapping
    public ResponseEntity<Page<Funcionario>> get(@RequestParam int page, @RequestParam int size){
        return this.funcionarioService.get(page, size);
    }
}
