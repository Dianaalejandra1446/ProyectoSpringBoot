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
