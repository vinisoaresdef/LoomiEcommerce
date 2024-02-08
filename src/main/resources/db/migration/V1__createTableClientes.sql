CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    usuario_id BIGINT,
    nome_completo VARCHAR(255),
    contato VARCHAR(255),
    endereco VARCHAR(255),
    status SMALLINT,         --ISSO AQUI ESTÁ ERRADO, PRECISA SER ALTERADO.
    data_criacao VARCHAR(255),  --ISSO AQUI ESTÁ ERRADO, PRECISA SER ALTERADO.
    data_atualizacao VARCHAR(255)   --ISSO AQUI ESTÁ ERRADO, PRECISA SER ALTERADO.
);

