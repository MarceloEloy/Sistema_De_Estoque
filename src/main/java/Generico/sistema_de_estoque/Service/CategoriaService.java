package Generico.sistema_de_estoque.Service;

import Generico.sistema_de_estoque.DTO.CategoriaDTO;
import Generico.sistema_de_estoque.Model.Categoria;
import Generico.sistema_de_estoque.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ResponseEntity<Categoria> addCategoria(CategoriaDTO dto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/Categoria")).body(categoriaRepository.save(new Categoria(dto)));
    }

    public Categoria findById(Long id){
        return categoriaRepository.getReferenceById(id);
    }

}
