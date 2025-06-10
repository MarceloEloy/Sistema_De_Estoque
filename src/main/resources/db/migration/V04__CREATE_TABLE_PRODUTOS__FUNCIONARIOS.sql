create table Produtos_Funcionarios(
    id_Produtos Bigint,
    id_Funcionarios Bigint,
    foreign key(id_Produtos) references Produto(id),
    foreign key(id_Funcionarios) references Funcionario(id)
)