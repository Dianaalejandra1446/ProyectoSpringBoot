-- Active: 1712777518478@@127.0.0.1@3306@organizacionbd
drop DATABASE;
drop table if exists cuota;
drop table if exists datos_personales;
drop table if exists envio;
drop table if exists envio_alimentos;
drop table if exists envio_ayuda_humanitaria;
drop table if exists envio_ayuda_humanitaria_id_envio_alimentos;
drop table if exists envio_ayuda_humanitaria_id_envio_medicamentos;
drop table if exists envio_ayuda_humanitaria_id_voluntariados;
drop table if exists envio_medicamentos;
drop table if exists envios_sedes;
drop table if exists roles;
drop table if exists sedes;
drop table if exists socios;
drop table if exists usuario;
drop table if exists usuario_roles;
drop table if exists voluntarios;

create table cuota (
    valor int not null,
    id_cuota bigint auto_increment,
    tipo varchar(255),
    primary key (id_cuota)
);

create table datos_personales (
    documento double,
    telefono int,
    id_datos bigint auto_increment,
    apellido varchar(255),
    email varchar(255) not null unique,
    nombre varchar(255),
    primary key (id_datos)
);

create table envio (
    codigo_envio double,
    fecha_salida timestamp,
    id_envio bigint auto_increment,
    destino varchar(255),
    nombre_refugio varchar(255),
    primary key (id_envio)
);

create table envio_alimentos (
    num_toneladas double,
    id_envio_alimentos bigint auto_increment,
    nombre_producto varchar(255),
    primary key (id_envio_alimentos)
);

create table envio_ayuda_humanitaria (
    num_voluntarios int,
    id_ayuda_humanitaria bigint not null,
    id_ayuda_material bigint auto_increment,
    id_envio_sede bigint,
    primary key (id_ayuda_material)
);

create table envio_ayuda_humanitaria_id_envio_alimentos (
    envio_ayuda_material_entity_id_ayuda_material bigint not null,
    id_envio_alimentos_id_envio_alimentos bigint not null,
    unique(id_envio_alimentos_id_envio_alimentos)
);

create table envio_ayuda_humanitaria_id_envio_medicamentos (
    envio_ayuda_material_entity_id_ayuda_material bigint not null,
    id_envio_medicamentos_id_envio_medicamentos bigint not null,
    unique(id_envio_medicamentos_id_envio_medicamentos)
);

create table envio_ayuda_humanitaria_id_voluntariados (
    envio_ayuda_humanitaria_entity_id_ayuda_humanitaria bigint not null,
    id_voluntariados_id_voluntariado bigint not null,
    unique(id_voluntariados_id_voluntariado)
);

create table envio_medicamentos (
    num_unidades int,
    id_envio_medicamentos bigint auto_increment,
    nombre_medicamento varchar(255),
    primary key (id_envio_medicamentos)
);

create table envios_sedes (
    id_envio bigint,
    id_envio_sedes bigint auto_increment,
    id_sede bigint,
    primary key (id_envio_sedes)
);

create table roles (
    id bigint auto_increment,
    description varchar(255),
    role_name varchar(255),
    primary key (id)
);

create table sedes (
    id bigint auto_increment,
    id_socios_id bigint,
    ciudad varchar(255),
    domicilio varchar(255),
    nombre_director varchar(255),
    nombre_sede varchar(255),
    primary key (id)
);

create table socios (
    cuenta_bancaria double,
    fecha_pago timestamp,
    id bigint auto_increment,
    id_cuota_id_cuota bigint,
    id_datos_personales bigint,
    primary key (id)
);

create table usuario (
    cedula bigint not null unique,
    fecha timestamp,
    id bigint auto_increment,
    email varchar(255),
    pwd varchar(255),
    primary key (id)
);

create table usuario_roles (
    roles_id bigint not null,
    usuario_id bigint not null,
    unique(roles_id, usuario_id)
);

create table voluntarios (
    numero_trabajos_participados int,
    id_datos_personales bigint,
    id_sede_id bigint,
    id_voluntariado bigint auto_increment,
    disponibilidad varchar(255) not null,
    profesion varchar(255),
    tipo varchar(255),
    primary key (id_voluntariado)
);

alter table envio_ayuda_humanitaria 
   add constraint FK9gm70th3t7sxdamosi9hh5doe 
   foreign key (id_envio_sede) 
   references envios_sedes(id_envio_sedes);

alter table envio_ayuda_humanitaria_id_envio_alimentos 
   add constraint FK3guk2cvgr0aos7vd5afw9bln3 
   foreign key (id_envio_alimentos_id_envio_alimentos) 
   references envio_alimentos(id_envio_alimentos);

alter table envio_ayuda_humanitaria_id_envio_alimentos 
   add constraint FKahrr2rjrth9qvyixrdn1l78o6 
   foreign key (envio_ayuda_material_entity_id_ayuda_material) 
   references envio_ayuda_humanitaria(id_ayuda_material);

alter table envio_ayuda_humanitaria_id_envio_medicamentos 
   add constraint FK3fkwv9ixc53umblkp7c78u7jv 
   foreign key (id_envio_medicamentos_id_envio_medicamentos) 
   references envio_medicamentos(id_envio_medicamentos);

alter table envio_ayuda_humanitaria_id_envio_medicamentos 
   add constraint FK18ine9y3ki4wx8od3cpoqbf5e 
   foreign key (envio_ayuda_material_entity_id_ayuda_material) 
   references envio_ayuda_humanitaria(id_ayuda_material);

alter table envio_ayuda_humanitaria_id_voluntariados 
   add constraint FKl1u4ob15rmls4rvftjjuc7wt4 
   foreign key (id_voluntariados_id_voluntariado) 
   references voluntarios(id_voluntariado);

alter table envio_ayuda_humanitaria_id_voluntariados 
   add constraint FKed0w22pivffjdo5yhnd7gdp7a 
   foreign key (envio_ayuda_humanitaria_entity_id_ayuda_humanitaria) 
   references envio_ayuda_humanitaria(id_ayuda_material);

alter table envios_sedes 
   add constraint FKda8dpplt199wn2e5j7i9tios8 
   foreign key (id_envio) 
   references envio(id_envio);

alter table envios_sedes 
   add constraint FKddclnbydgg0jctx


-- INSERTAR USUARIOS
INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (1095299292, 'dianaleja@hotmail.com', 'to_be_encoded', '2015-12-01');
INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (1005372684, 'kevin@example.com', 'to_be_encoded_auxiliar', '2015-12-01');
INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (100537265, 'rut@example.com', 'to_be_encoded_director', '2015-12-01');

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
