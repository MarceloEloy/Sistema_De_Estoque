package Generico.sistema_de_estoque.Controller;

import Generico.sistema_de_estoque.DTO.ProdutoDTO;
import Generico.sistema_de_estoque.Model.Produto;
import Generico.sistema_de_estoque.Service.ProdutoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;


@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private Logger logger = LoggerFactory.getLogger(ProdutoController.class.getName());

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
    @GetMapping
    public void get(){
        this.logger.info("Logger Info");
        this.logger.warn("Logger Warn");
        this.logger.debug("Logger Debug");
        this.logger.trace("Logger Trace");
    }
}
