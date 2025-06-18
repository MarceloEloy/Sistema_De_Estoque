create table Produtos_Funcionarios(
    produto_id Bigint,
    funcionario_id Bigint,
    foreign key(produto_id) references Produto(id),
    foreign key(funcionario_id) references Funcionario(id)
)