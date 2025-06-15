package Generico.sistema_de_estoque.Service;

import Generico.sistema_de_estoque.Controller.FuncionarioController;
import Generico.sistema_de_estoque.DTO.FuncionarioDTO;
import Generico.sistema_de_estoque.Model.Users.Funcionario;
import Generico.sistema_de_estoque.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public ResponseEntity<Funcionario> add(FuncionarioDTO dto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/Funcionario")).body(funcionarioRepository.save(new Funcionario(dto)));
    }

    public ResponseEntity<Stream<Funcionario>> get(int page, int size){
        Pageable p = PageRequest.of(page, size);
        return ResponseEntity.ok().body(this.funcionarioRepository.findAll(p).stream().map(a -> {
            try {
                a.add(linkTo(methodOn(FuncionarioController.class).add(new FuncionarioDTO(a))).withRel("Adicionar Funcionario"));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            return a;
        }));
    }
}
