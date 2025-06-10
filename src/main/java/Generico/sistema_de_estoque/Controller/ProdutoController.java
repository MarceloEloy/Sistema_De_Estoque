package Generico.sistema_de_estoque.Controller;

import Generico.sistema_de_estoque.DTO.ProdutoDTO;
import Generico.sistema_de_estoque.Model.Produto;
import Generico.sistema_de_estoque.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> add(@RequestBody ProdutoDTO dto) throws URISyntaxException {
        return produtoService.addProduto(dto);
    }

    @PutMapping
    public ResponseEntity<Produto> alter(@RequestParam Long id, @RequestBody ProdutoDTO dto) throws URISyntaxException {
        return produtoService.alterProduto(id, dto);
    }
}
