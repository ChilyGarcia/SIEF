INSERT IGNORE INTO roles(id, nombre) VALUES (1, "ROLE_USER"),(2, "ROLE_ADMIN")

INSERT IGNORE INTO usuarios(id, nombre, username, email, password) VALUES (1, "admin", "admin", "admin", "123")

INSERT IGNORE INTO usuarios_roles(usuario_id, rol_id) VALUES (1, 2)