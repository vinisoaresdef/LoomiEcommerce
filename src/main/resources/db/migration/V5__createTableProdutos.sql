CREATE TABLE produtos (
    produto_id SERIAL PRIMARY KEY,
    nome_produto VARCHAR(255),
    descricao TEXT,
    preco INT,
    qtd_estoque INT,
    data_criacao VARCHAR(255), --ISSO AQUI ESTÁ ERRADO, PRECISA SER ALTERADO.
    data_atualizacao VARCHAR(255) --ISSO AQUI ESTÁ ERRADO, PRECISA SER ALTERADO.
);
