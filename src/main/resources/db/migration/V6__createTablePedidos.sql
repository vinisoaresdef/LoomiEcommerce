CREATE TABLE pedidos (
    pedido_id SERIAL PRIMARY KEY,
    cliente_id BIGINT,
    status SMALLINT,
    data_pedido VARCHAR(255), --ISSO AQUI ESTÁ ERRADO, PRECISA SER ALTERADO.
    total_pedido INT
);
