CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    cliente_id BIGINT,
    nome VARCHAR(255),
    data_criacao VARCHAR(255),  --ISSO AQUI ESTÁ ERRADO, PRECISA SER ALTERADO.
    data_atualizacao VARCHAR(255)  --ISSO AQUI ESTÁ ERRADO, PRECISA SER ALTERADO.
);
