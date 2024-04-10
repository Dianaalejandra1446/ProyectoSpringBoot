-- INSERTAR USUARIOS
INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (1095299291, 'dianaleja@hotmail.com', 'to_be_encoded', '2015-12-01');
INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (1005372614, 'lauragomez@example.com', 'to_be_encoded_auxiliar', '2015-12-01');
INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (1005372615, 'carlosrodriguez@example.com', 'to_be_encoded_director', '2015-12-01');

-- INSERTAR ROLES
INSERT INTO roles (role_name, description) VALUES ('ROLE_ADMIN', 'puede ver el punto de cuenta'); 
INSERT INTO roles (role_name, description) VALUES ('ROLE_AUXILIAR', 'puede ver el punto de cuenta'); 
INSERT INTO roles (role_name, description) VALUES ('ROLE_DIRECTOR', 'puede ver el punto de cuenta'); 

-- Insertar usuarioRoles

INSERT INTO usuario_roles (roles_id, usuario_id) VALUES (1, 1); 
INSERT INTO usuario_roles (roles_id, usuario_id) VALUES (2, 2); 
INSERT INTO usuario_roles (roles_id, usuario_id) VALUES (3, 3); 

-- Inserts para la tabla 'cuota'
INSERT INTO cuota (valor, tipo) VALUES (10, 'Mínima');
INSERT INTO cuota (valor, tipo) VALUES (20, 'Media');
INSERT INTO cuota (valor, tipo) VALUES (30, 'Máxima');

-- Inserts para la tabla 'datos_personales'
INSERT INTO datos_personales (documento, telefono, apellido, email, nombre) VALUES (123456789, 123456789, 'García', 'garcia@example.com', 'Juan');
INSERT INTO datos_personales (documento, telefono, apellido, email, nombre) VALUES (987654321, 987654321, 'Martínez', 'martinez@example.com', 'María');

-- Inserts para la tabla 'envio'
INSERT INTO envio (codigo_envio, fecha_salida, destino, nombre_refugio) VALUES (12345, '2024-04-01', 'Ciudad X', 'Refugio X');
INSERT INTO envio (codigo_envio, fecha_salida, destino, nombre_refugio) VALUES (67890, '2024-04-02', 'Ciudad Y', 'Refugio Y');

-- Inserts para la tabla 'envio_alimentos'
INSERT INTO envio_alimentos (num_toneladas, nombre_producto) VALUES (10.5, 'Arroz');
INSERT INTO envio_alimentos (num_toneladas, nombre_producto) VALUES (8.7, 'Frijoles');

-- Inserts para la tabla 'envio_medicamentos'
INSERT INTO envio_medicamentos (num_unidades, nombre_medicamento) VALUES (500, 'Aspirina');
INSERT INTO envio_medicamentos (num_unidades, nombre_medicamento) VALUES (300, 'Paracetamol');

-- Inserts para la tabla 'socios'
INSERT INTO socios (cuenta_bancaria, fecha_pago, id_cuota_id_cuota, id_datos_personales) VALUES (1234567890, '2024-04-01', 1, 1);
INSERT INTO socios (cuenta_bancaria, fecha_pago, id_cuota_id_cuota, id_datos_personales) VALUES (9876543210, '2024-04-01', 2, 2);
-- Inserts para la tabla 'sedes'
INSERT INTO sedes (id_socios_id, ciudad, domicilio, nombre_director, nombre_sede) VALUES (1, 'Ciudad A', 'Calle Principal 123', 'Dr. Pérez', 'Sede A');
INSERT INTO sedes (id_socios_id, ciudad, domicilio, nombre_director, nombre_sede) VALUES (2, 'Ciudad B', 'Avenida Central 456', 'Dr. López', 'Sede B');

-- Inserts para la tabla 'envios_sedes'
INSERT INTO envios_sedes (id_envio, id_sede) VALUES (1, 1);
INSERT INTO envios_sedes (id_envio, id_sede) VALUES (2, 2);
INSERT INTO envio_ayuda_humanitaria (num_voluntarios, id_ayuda_humanitaria, id_envio_sede) VALUES (10, 1, 1);
INSERT INTO envio_ayuda_humanitaria (num_voluntarios, id_ayuda_humanitaria, id_envio_sede) VALUES (20, 2, 2);

-- Inserts para la tabla 'voluntarios'
INSERT INTO voluntarios (numero_trabajos_participados, id_datos_personales, id_sede_id, disponibilidad, profesion, tipo) VALUES (5, 1, 1, 'Sí', 'Médico', 'Sanitario');
INSERT INTO voluntarios (numero_trabajos_participados, id_datos_personales, id_sede_id, disponibilidad, profesion, tipo) VALUES (3, 2, 2, 'Sí', 'ATS', 'Sanitario');
/*-- SQLBook: Code
CREATE TABLE `Datos_personales`(
    `id_datos` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR(255) NOT NULL,
    `apellido` VARCHAR(255) NOT NULL,
    `documento` DOUBLE NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `telefono` INT
);
CREATE TABLE `Envio_ayuda_humanitaria`(
    `id_ayuda_humanitaria` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `num_voluntarios` INT,
    `id_voluntario` INT NOT NULL,
    `id_envio_sede` INT NOT NULL
);
CREATE TABLE `Cuota`(
    `id_cuota` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `tipo` VARCHAR(255),
    `valor` INT
);
CREATE TABLE `Socios`(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_datos_personales` INT NOT NULL,
    `cuenta_bancaria` DOUBLE,
    `fecha_pago` DATE,
    `id_cuota` INT NOT NULL
);
CREATE TABLE `Envio_medicamentos`(
    `id_envio_medicamentos` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre_medicamento` VARCHAR(255) NOT NULL,
    `num_unidades` INT NOT NULL
);
CREATE TABLE `Sedes`(
    `id_sede` INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre_sede` VARCHAR(255) NOT NULL,
    `ciudad` VARCHAR(255) NOT NULL,
    `domicilio` VARCHAR(255) NOT NULL,
    `nombre_director` VARCHAR(255) NOT NULL,
    `id_socio` INT NOT NULL
);
CREATE TABLE `Envio`(
    `id_envio` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `codigo_envio` INT NOT NULL,
    `nombre_refugio` VARCHAR(255) NOT NULL,
    `destino` VARCHAR(255),
    `fecha_salida` DATE NOT NULL
);
CREATE TABLE `Envio_ayuda_material`(
    `id_ayuda_material` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_envio_sede` INT NOT NULL,
    `id_envio_alimentos` INT NOT NULL,
    `id_envio_medicamento` INT NOT NULL
);
CREATE TABLE `Voluntariados`(
    `id_voluntario` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `tipo` VARCHAR(255),
    `profesion` VARCHAR(255),
    `disponibilidad` VARCHAR(255),
    `num_trabajos_participados` INT,
    `id_datos_personales` INT NOT NULL,
    `id_sede` INT NOT NULL
);
CREATE TABLE `Envios_Sedes`(
    `id_envios_sede` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_envio` INT NOT NULL,
    `id_sede` INT NOT NULL
);
CREATE TABLE `Envio_alimentos`(
    `id_envio_alimentos` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre_producto` VARCHAR(255),
    `num_toneladas` DOUBLE NOT NULL
);
ALTER TABLE
    `Envio_ayuda_humanitaria` ADD CONSTRAINT `envio_ayuda_humanitaria_id_envio_sede_foreign` FOREIGN KEY(`id_envio_sede`) REFERENCES `Envios_Sedes`(`id_envios_sede`);
ALTER TABLE
    `Envio_ayuda_humanitaria` ADD CONSTRAINT `envio_ayuda_humanitaria_id_voluntario_foreign` FOREIGN KEY(`id_voluntario`) REFERENCES `Voluntariados`(`id_voluntario`);
ALTER TABLE
    `Voluntariados` ADD CONSTRAINT `voluntariados_id_sede_foreign` FOREIGN KEY(`id_sede`) REFERENCES `Sedes`(`id_sede`);
ALTER TABLE
    `Envios_Sedes` ADD CONSTRAINT `envios_sedes_id_sede_foreign` FOREIGN KEY(`id_sede`) REFERENCES `Sedes`(`id_sede`);
ALTER TABLE
    `Envio_ayuda_material` ADD CONSTRAINT `envio_ayuda_material_id_envio_alimentos_foreign` FOREIGN KEY(`id_envio_alimentos`) REFERENCES `Envio_alimentos`(`id_envio_alimentos`);
ALTER TABLE
    `Envios_Sedes` ADD CONSTRAINT `envios_sedes_id_envio_foreign` FOREIGN KEY(`id_envio`) REFERENCES `Envio`(`id_envio`);
ALTER TABLE
    `Voluntariados` ADD CONSTRAINT `voluntariados_id_datos_personales_foreign` FOREIGN KEY(`id_datos_personales`) REFERENCES `Datos_personales`(`id_datos`);
ALTER TABLE
    `Socios` ADD CONSTRAINT `socios_id_datos_personales_foreign` FOREIGN KEY(`id_datos_personales`) REFERENCES `Datos_personales`(`id_datos`);
ALTER TABLE
    `Envio_ayuda_material` ADD CONSTRAINT `envio_ayuda_material_id_envio_sede_foreign` FOREIGN KEY(`id_envio_sede`) REFERENCES `Envios_Sedes`(`id_envios_sede`);
ALTER TABLE
    `Envio_ayuda_material` ADD CONSTRAINT `envio_ayuda_material_id_envio_medicamento_foreign` FOREIGN KEY(`id_envio_medicamento`) REFERENCES `Envio_medicamentos`(`id_envio_medicamentos`);
ALTER TABLE
    `Socios` ADD CONSTRAINT `socios_id_cuota_foreign` FOREIGN KEY(`id_cuota`) REFERENCES `Cuota`(`id_cuota`);
ALTER TABLE
    `Sedes` ADD CONSTRAINT `sedes_id_socio_foreign` FOREIGN KEY(`id_socio`) REFERENCES `Socios`(`id`);*/