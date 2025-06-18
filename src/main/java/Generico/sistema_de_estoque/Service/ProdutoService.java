package Generico.sistema_de_estoque.Service;

import Generico.sistema_de_estoque.Controller.CategoriaController;
import Generico.sistema_de_estoque.Controller.ProdutoController;
import Generico.sistema_de_estoque.DTO.ProdutoDTO;
import Generico.sistema_de_estoque.Model.Produto;
import Generico.sistema_de_estoque.Repository.CategoriaRepository;
import Generico.sistema_de_estoque.Repository.ProdutoRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProdutoService {

    @Autowired
    Logger logger;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<Produto> addProduto(ProdutoDTO dto) throws URISyntaxException {
        Produto produto = new  Produto(dto);
        produto.setCategoria(categoriaRepository.findById(dto.categoriaID()).get());
        produto.add(linkTo(methodOn(CategoriaController.class).findById(dto.categoriaID())).withRel("Categoria"));
        logger.info("Post Method Occurred");
        return ResponseEntity.created(new URI("/Produto")).body(produtoRepository.save(produto));
    }

    public ResponseEntity<Page<Produto>> listProduto(int page, int size){
        Pageable pagina = PageRequest.of(page, size);
        return ResponseEntity.ok(produtoRepository.findAll(pagina));
    }

    public ResponseEntity<Produto> alterProduto(Long id, ProdutoDTO dto) throws URISyntaxException {
        Produto produto = produtoRepository.getReferenceById(id);
        produto.add(linkTo(methodOn(ProdutoController.class).add(dto)).withRel("Adicionar"));

        if (!produto.getNome().equals(dto.nome()) || !dto.nome().equals("")){
            produto.setNome(dto.nome());
        }

        if (produto.getEstoque() != dto.estoque()){
            produto.setEstoque(dto.estoque());
        }

        if (produto.getCategoria() != categoriaRepository.getReferenceById(dto.categoriaID())){
            produto.setCategoria(categoriaRepository.getReferenceById(dto.categoriaID()));
        }

        return ResponseEntity.ok(produtoRepository.save(produto));
    }
}
