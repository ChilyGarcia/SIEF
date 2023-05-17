INSERT IGNORE INTO roles(id, nombre) VALUES (1, "ROLE_USER"),(2, "ROLE_ADMIN")

INSERT IGNORE INTO usuarios(id, nombre, username, email, password) VALUES (1, "admin", "admin", "admin", "$2a$12$N//BFWal3piYWI4aS3L1ceNBpqAhEMKnkKFF9tMpOxO5QNT9qh0WC")

INSERT IGNORE INTO usuarios_roles(usuario_id, rol_id) VALUES (1, 2)