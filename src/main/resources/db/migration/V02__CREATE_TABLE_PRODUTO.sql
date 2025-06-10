create table Produto(
    id Bigint primary key auto_increment,
    nome varchar(30),
    estoque int,
    preco double,
    categoria Bigint,
    foreign key(categoria) references Categoria(id)

)