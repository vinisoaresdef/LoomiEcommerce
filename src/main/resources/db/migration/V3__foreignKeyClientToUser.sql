ALTER TABLE clientes
ADD CONSTRAINT fk_usuario_id
FOREIGN KEY (usuario_id)
REFERENCES usuarios(usuario_id);
