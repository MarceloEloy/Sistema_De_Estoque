package Generico.sistema_de_estoque.DTO;

import Generico.sistema_de_estoque.Model.Produto;
import Generico.sistema_de_estoque.Model.Users.Cargos;
import Generico.sistema_de_estoque.Model.Users.Funcionario;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record FuncionarioDTO(
        Cargos cargo,
        String nome,
        String cpf,
        Set<Long> produtosID
) {
    public FuncionarioDTO(Funcionario funcionario){
        this(funcionario.getCargo(), funcionario.getNome(), funcionario.getCpf(), funcionario.getProdutos().stream().map(Produto::getId).collect(Collectors.toSet()));
    }
}
