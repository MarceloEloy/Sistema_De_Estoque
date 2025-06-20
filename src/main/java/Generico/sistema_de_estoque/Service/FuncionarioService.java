package Generico.sistema_de_estoque.Service;

import Generico.sistema_de_estoque.Controller.FuncionarioController;
import Generico.sistema_de_estoque.DTO.FuncionarioDTO;
import Generico.sistema_de_estoque.Model.Users.Funcionario;
import Generico.sistema_de_estoque.Repository.FuncionarioRepository;
import Generico.sistema_de_estoque.Repository.ProdutoRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class FuncionarioService {

    @Autowired
    Logger logger;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public ResponseEntity<Funcionario> add(FuncionarioDTO dto) throws URISyntaxException, RuntimeException {
        List<Character> cpfV1 = new ArrayList<>();
        String cpf = "";
        char[] dtoCpf = dto.cpf().toCharArray();
        for (int i = 0; i < dtoCpf.length; i += 1){
            if (dtoCpf[i] == '-' || dtoCpf[i] == '.'){
                throw new RuntimeException("formatação errada de CPF");
            }
            cpfV1.add(dtoCpf[i]);
            if (i == 2 || i == 5){
                cpfV1.add('.');
            }
            if (i == 8){
                cpfV1.add('-');
            }
            if (i == dtoCpf.length -1){
                for (int j = 0; j < cpfV1.size(); j += 1) {
                   cpf += cpfV1.get(j);
                }
            }
        }
        Funcionario f = new Funcionario(dto);
        if (!f.getProdutos().isEmpty()) {
            f.setProdutos(dto.produtosID().stream().map(a -> {
                return produtoRepository.findById(a).get();
            }).collect(Collectors.toSet()));
        }
        f.setCpf(cpf);
        logger.info("Post Method Occurred");
        return ResponseEntity.created(new URI("/Funcionario")).body(funcionarioRepository.save(f));
    }

    public ResponseEntity<Page<Funcionario>> get(int page, int size){
        Pageable p = PageRequest.of(page , size);
        return ResponseEntity.ok().body(funcionarioRepository.findAll(p));
    }
}
