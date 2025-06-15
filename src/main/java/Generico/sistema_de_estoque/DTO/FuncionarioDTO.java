package Generico.sistema_de_estoque.DTO;

import Generico.sistema_de_estoque.Model.Users.Cargos;
import Generico.sistema_de_estoque.Model.Users.Funcionario;

public record FuncionarioDTO(
        Cargos cargo,
        String nome,
        String cpf
) {
    public FuncionarioDTO(Funcionario funcionario){
        this(funcionario.getCargo(), funcionario.getNome(), funcionario.getCpf());
    }
}
