package Generico.sistema_de_estoque.Controller;

import Generico.sistema_de_estoque.DTO.CategoriaDTO;
import Generico.sistema_de_estoque.Model.Categoria;
import Generico.sistema_de_estoque.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> addCategoria(@RequestBody CategoriaDTO dto) throws URISyntaxException {
        System.out.println("ok");
        return this.categoriaService.addCategoria(dto);
    }

    @GetMapping
    public ResponseEntity<Categoria> findById(@RequestParam Long id){
        return ResponseEntity.ok().body(categoriaService.findById(id));
    }

}
