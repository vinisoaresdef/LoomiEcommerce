ALTER TABLE pedidos
ADD CONSTRAINT fk_cliente_id
FOREIGN KEY (cliente_id)
REFERENCES clientes(cliente_id);