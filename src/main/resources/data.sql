-- ============================================================
-- TINKUY · DATOS DE PRUEBA INICIALES (H2)
-- Ejecutar después de que Hibernate haya creado las tablas.
-- ============================================================


-- ------------------------------------------------------------
-- 1. CATÁLOGOS
-- ------------------------------------------------------------

INSERT INTO pais (id, codigo_pais, nombre) VALUES
                                               (1,'ES','España'),
                                               (2,'PT','Portugal'),
                                               (3,'FR','Francia');

INSERT INTO especie (id, nombre) VALUES
                                     (1,'Perro'),
                                     (2,'Gato');

INSERT INTO raza (id, nombre, especie_id) VALUES
                                              (1,'Golden Retriever',1),
                                              (2,'Mestizo',1),
                                              (3,'Pastor Alemán',1),
                                              (4,'Labrador Retriever',1),
                                              (5,'Podenco',1),
                                              (6,'Europeo común',2),
                                              (7,'Siamés',2),
                                              (8,'Mestizo',2);

INSERT INTO rol (id, nombre, descripcion, activo) VALUES
                                                      (1,'ADMIN','Administración completa de la protectora',1),
                                                      (2,'GESTOR','Gestión de animales y solicitudes',1),
                                                      (3,'USUARIO','Acceso de usuario registrado',1);


-- ------------------------------------------------------------
-- 2. PERSONAS
-- ------------------------------------------------------------

INSERT INTO persona
(id,nombre,apellido1,apellido2,prefijo_pais,telefono,email,
 fecha_registro,fecha_actualizacion,fecha_baja,fecha_consentimiento_rgpd)
VALUES
    (1,'Ana','García','López','+34','600100101','ana.garcia@example.test','2025-01-10 10:00:00',NULL,NULL,'2025-01-10 10:00:00'),
    (2,'Marcos','Pérez','Souto','+34','600100102','marcos.perez@example.test','2025-02-12 11:30:00',NULL,NULL,'2025-02-12 11:30:00'),
    (3,'Lucía','Fernández','Vidal','+34','600100103','lucia.fernandez@example.test','2025-03-05 09:15:00',NULL,NULL,'2025-03-05 09:15:00'),
    (4,'David','Rodríguez','Méndez','+34','600100104','david.rodriguez@example.test','2025-03-20 12:00:00',NULL,NULL,'2025-03-20 12:00:00'),
    (5,'Elena','Martínez','Costa','+34','600100105','elena.martinez@example.test','2025-04-01 08:45:00',NULL,NULL,'2025-04-01 08:45:00'),
    (6,'Alba','Vázquez','Díaz','+34','600100106','paula.vazquez@example.test','2025-04-18 17:20:00',NULL,NULL,'2025-04-18 17:20:00'),
    (7,'Javier','López','Núñez','+34','600100107','javier.lopez@example.test','2025-05-02 13:10:00',NULL,NULL,'2025-05-02 13:10:00'),
    (8,'Sofía','Alonso','Rey','+34','600100108','sofia.alonso@example.test','2025-05-16 10:10:00',NULL,NULL,'2025-05-16 10:10:00'),
    (9,'Carlos','Díaz','Pardo','+34','600100109','carlos.diaz@example.test','2025-06-01 09:00:00',NULL,NULL,'2025-06-01 09:00:00'),
    (10,'Marta','Iglesias','Ramos','+34','600100110','marta.iglesias@example.test','2025-06-10 14:30:00',NULL,NULL,'2025-06-10 14:30:00');


-- ------------------------------------------------------------
-- 3. DATOS LEGALES
-- ------------------------------------------------------------

INSERT INTO datos_legales_persona
(persona_id,tipo_doc_identidad,numero_doc_identidad,fecha_nacimiento,
 direccion_basica,direccion_detalles,cod_postal,ciudad,provincia_estado,
 fecha_supresion_legal,pais_id)
VALUES
    (1,'DNI','11111111A','1988-04-12','Rúa Real 10','2º A','15003','A Coruña','A Coruña',NULL,1),
    (2,'DNI','22222222B','1990-08-22','Avenida Finisterre 25',NULL,'15004','A Coruña','A Coruña',NULL,1),
    (3,'NIE','X1234567C','1995-02-03','Rúa Barcelona 8','Portal 1','15010','A Coruña','A Coruña',NULL,1),
    (4,'DNI','33333333D','1982-11-19','Calle Mayor 14',NULL,'15100','Carballo','A Coruña',NULL,1),
    (5,'DNI','44444444E','1978-07-30','Rúa do Porto 3','Bajo','15160','Sada','A Coruña',NULL,1),
    (6,'DNI','55555555F','1992-01-16','Rúa San Andrés 45',NULL,'15003','A Coruña','A Coruña',NULL,1),
    (7,'DNI','66666666G','1985-09-09','Avenida de Arteixo 80','3º C','15007','A Coruña','A Coruña',NULL,1),
    (8,'PASAPORTE','P12345678','1998-06-25','Rua da Praia 2',NULL,'15001','A Coruña','A Coruña',NULL,1),
    (9,'DNI','77777777H','1975-12-01','Rúa Orzán 20',NULL,'15001','A Coruña','A Coruña',NULL,1);


-- ------------------------------------------------------------
-- 4. USUARIOS Y ROLES
-- ------------------------------------------------------------

INSERT INTO usuario
(id,username,password_hash,activo,fecha_creacion,fecha_actualizacion,
 fecha_ultimo_acceso,fecha_baja,persona_id)
VALUES
    (1,'admin.tinkuy','$2a$10$REEMPLAZAR_POR_HASH_BCRYPT_ADMIN',1,'2025-01-10 10:05:00',NULL,'2025-06-15 09:00:00',NULL,1),
    (2,'gestor.animales','$2a$10$REEMPLAZAR_POR_HASH_BCRYPT_GESTOR',1,'2025-02-12 11:35:00',NULL,'2025-06-14 18:00:00',NULL,2),
    (3,'luciaf','$2a$10$REEMPLAZAR_POR_HASH_BCRYPT_USUARIO',1,'2025-03-05 09:20:00',NULL,'2025-06-13 12:00:00',NULL,3),
    (4,'davidr','$2a$10$REEMPLAZAR_POR_HASH_BCRYPT_USUARIO',1,'2025-03-20 12:05:00',NULL,NULL,NULL,4),
    (5,'elenam','$2a$10$REEMPLAZAR_POR_HASH_BCRYPT_USUARIO',1,'2025-04-01 08:50:00',NULL,NULL,NULL,5);

INSERT INTO usuario_rol (usuario_id,rol_id) VALUES
                                                (1,1),(1,2),(2,2),(3,3),(4,3),(5,3);


-- ------------------------------------------------------------
-- 5. ANIMALES
-- ------------------------------------------------------------

INSERT INTO animal
(id,nombre,sexo,tamano,fecha_nacimiento,es_fecha_nac_estimada,
 esterilizado,ppp,raza_id)
VALUES
    (1,'Nube','HEMBRA','GRANDE','2021-05-10',0,1,0,1),
    (2,'Toby','MACHO','MEDIANO','2019-09-01',1,1,0,2),
    (3,'Kira','HEMBRA','GRANDE','2023-02-15',0,0,0,3),
    (4,'Rocky','MACHO','GRANDE','2017-06-20',0,1,0,4),
    (5,'Lúa','HEMBRA','MEDIANO','2024-01-12',0,0,0,5),
    (6,'Milo','MACHO','PEQUENO','2022-03-08',0,1,0,6),
    (7,'Cleo','HEMBRA','PEQUENO','2020-11-11',1,1,0,7),
    (8,'Bruno','MACHO','MUY_GRANDE','2018-04-03',0,1,1,3),
    (9,'Menta','HEMBRA','PEQUENO','2025-01-20',1,0,0,8),
    (10,'Simba','MACHO','MEDIANO','2020-07-07',0,1,0,6),
    (11,'Ares','MACHO','GRANDE','2021-08-14',0,1,0,3),
    (12,'Lola','HEMBRA','PEQUENO','2023-04-22',0,0,0,2),
    (13,'Duna','HEMBRA','MEDIANO','2020-12-03',1,1,0,5),
    (14,'Bowie','MACHO','PEQUENO','2022-07-19',0,1,0,7),
    (15,'Nala','HEMBRA','MEDIANO','2024-02-11',0,0,0,6),
    (16,'Thor','MACHO','MUY_GRANDE',NULL,NULL,NULL,NULL,3),
    (17,'Pipa','HEMBRA','PEQUENO','2025-03-18',1,0,0,8),
    (18,'Duque','MACHO','GRANDE','2018-01-25',0,1,0,4),
    (19,'Mora','HEMBRA','MEDIANO','2022-10-09',0,0,0,6),
    (20,'Chispa','DESCONOCIDO','PEQUENO',NULL,NULL,NULL,NULL,2);


-- ------------------------------------------------------------
-- 6. FICHAS COMPLETAS
-- ------------------------------------------------------------

INSERT INTO ficha_animal_completa
(animal_id,num_microchip,fecha_alta,urgente,motivo_urgencia,
 detalle_urgencia,fecha_fallec,es_fecha_fallec_estimada,historia,
 desparasitado_externo,desparasitado_interno,vacunas_al_dia,
 compatibilidad_perros,compatibilidad_gatos,compatibilidad_ninos,
 disponible_adopcion,disponible_acogida)
VALUES
    (1,'981020000000001','2025-01-15 10:00:00',0,NULL,NULL,NULL,NULL,'Nube es una perra sociable y tranquila. Sin solicitudes activas.',1,1,1,1,0,1,1,1),
    (2,'981020000000002','2025-02-01 11:00:00',0,NULL,NULL,NULL,NULL,'Toby tiene solicitudes en trámite y canceladas.',1,1,1,1,1,1,1,1),
    (3,'981020000000003','2025-02-18 09:30:00',1,'SALUD','Necesita seguimiento veterinario.',NULL,NULL,'Kira está acogida actualmente.',1,1,0,1,0,1,0,0),
    (4,'981020000000004','2025-03-02 12:00:00',1,'SENIOR','Perro senior en protectora.',NULL,NULL,'Rocky necesita un hogar tranquilo.',1,1,1,1,1,1,1,1),
    (5,'981020000000005','2025-03-10 10:15:00',0,NULL,NULL,NULL,NULL,'Lúa con múltiples solicitudes variadas.',0,1,0,1,0,1,1,1),
    (6,'981020000000006','2025-03-20 08:45:00',0,NULL,NULL,NULL,NULL,'Milo es independiente y cariñoso. Adoptado.',1,1,1,1,1,0,0,0),
    (7,'981020000000007','2025-04-01 13:00:00',0,NULL,NULL,NULL,NULL,'Cleo tiene solicitud rechazada y sigue sin adoptar.',1,1,1,0,1,1,1,1),
    (8,'981020000000008','2025-04-05 09:00:00',1,'VULNERABILIDAD','Acogida estable.',NULL,NULL,'Bruno necesita acogida.',1,1,1,0,1,1,0,0),
    (9,'981020000000009','2025-05-01 10:00:00',0,NULL,NULL,NULL,NULL,'Menta es una cachorra sin solicitud.',0,0,0,1,1,1,1,1),
    (10,'981020000000010','2025-05-12 11:00:00',0,NULL,NULL,NULL,NULL,'Simba con anuncio de pérdida.',1,1,1,1,1,1,1,1),
    (11,'981020000000011','2025-04-20 10:00:00',0,NULL,NULL,NULL,NULL,'Ares tuvo una primera solicitud rechazada y posteriormente fue adoptado.',1,1,1,1,0,1,0,0),
    (12,'981020000000012','2025-06-03 11:30:00',0,NULL,NULL,NULL,NULL,'Lola con solicitud cancelada.',1,1,1,1,1,1,1,1),
    (13,'981020000000013','2025-06-05 09:00:00',1,'OTRO','Adaptación progresiva.',NULL,NULL,'Duna con solicitud rechazada y sin adoptar.',1,1,0,0,1,0,1,1),
    (14,'981020000000014','2025-06-07 12:15:00',0,NULL,NULL,NULL,NULL,'Bowie es un gato curioso.',1,1,1,1,1,1,1,1),
    (15,'981020000000015','2025-06-09 10:45:00',0,NULL,NULL,NULL,NULL,'Nala fue adoptada por Carlos Díaz tras completar el proceso de valoración.',0,1,1,1,1,1,0,0),
    (16,'981020000000016','2025-06-11 08:30:00',0,NULL,NULL,'2025-06-12',0,'Thor fallecido y adoptado históricamente antes de su deceso.',NULL,NULL,NULL,NULL,NULL,NULL,0,0);


-- ------------------------------------------------------------
-- 7. IMÁGENES DE ANIMALES
-- ------------------------------------------------------------

INSERT INTO imagen_animal
(id,archivo_url,texto_alt,orden,animal_id)
VALUES
    (1,'animal-1-inicial-1.jpg','Nube sentada mirando a cámara',1,1),
    (2,'animal-1-inicial-2.jpg','Nube paseando',2,1),
    (3,'animal-2-inicial-1.jpg','Toby en el jardín',1,2),
    (4,'animal-3-inicial-1.jpg','Kira de pie',1,3),
    (5,'animal-4-inicial-1.jpg','Rocky descansando',1,4),
    (6,'animal-5-inicial-1.jpg','Lúa jugando',1,5),
    (7,'animal-6-inicial-1.jpg','Milo mirando a cámara',1,6),
    (8,'default-animal.png','Cleo sobre una manta',1,7),
    (9,'default-animal.png','Bruno en el exterior',1,8),
    (10,'default-animal.png','Menta jugando',1,9),
    (11,'default-animal.png','Simba sentado',1,10),
    (12,'default-animal.png','Ares jugando en el patio',1,11),
    (13,'default-animal.png','Lola sentada sobre una manta',1,12),
    (14,'default-animal.png','Duna paseando con correa',1,13),
    (15,'default-animal.png','Bowie mirando por la ventana',1,14),
    (16,'default-animal.png','Nala descansando',1,15),
    (17,'default-animal.png','Thor tumbado en su cama',1,16),
    (18,'default-animal.png','Pipa en una zona exterior',1,17),
    (19,'default-animal.png','Duque sentado',1,18),
    (20,'default-animal.png','Mora mirando a cámara',1,19),
    (21,'default-animal.png','Chispa en una manta',1,20);


-- ------------------------------------------------------------
-- 8. SOLICITUDES
-- ------------------------------------------------------------

INSERT INTO solicitud
(id,tipo,prioridad,fecha_solicitud,estado,fecha_resolucion,
 motivo_resolucion,fecha_cancelacion,motivo_cancelacion,
 comentarios_solicitud,comentarios_internos,persona_id,
 usuario_resolucion_id,usuario_cancelacion_id)
VALUES
-- ADOPCIONES
(1,'ADOPCION','ALTA','2025-05-01 10:00:00','EN_TRAMITE',NULL,NULL,NULL,NULL,'Interés en Nube.','Pendiente entrevista.',3,NULL,NULL),
(2,'ADOPCION','NORMAL','2025-05-03 12:30:00','ESPERANDO_CUESTIONARIO',NULL,NULL,NULL,NULL,'Interés en Toby.','Cuestionario solicitado.',4,NULL,NULL),
(3,'ADOPCION','URGENTE','2025-05-05 09:15:00','APROBADA','2025-05-20 16:00:00','Valoración favorable.',NULL,NULL,'Adopción de Milo.','Aprobada.',5,2,NULL),
(4,'ADOPCION','BAJA','2025-05-07 15:00:00','RECHAZADA','2025-05-14 11:00:00','No se cumplen condiciones.',NULL,NULL,'Solicitud para Cleo (rechazada, sin adoptar).','Rechazada.',6,2,NULL),

-- ACOGIDAS
(5,'ACOGIDA','ALTA','2025-05-08 10:20:00','EN_TRAMITE',NULL,NULL,NULL,NULL,'Acogida de Kira.','La persona aceptó el animal propuesto.',7,NULL,NULL),
(6,'ACOGIDA','URGENTE','2025-05-10 08:00:00','APROBADA','2025-05-12 13:00:00','Aprobada.',NULL,NULL,'Acogida de Bruno.','Formalizada.',8,2,NULL),
(7,'ACOGIDA','NORMAL','2025-05-11 18:00:00','CANCELADA',NULL,NULL,'2025-05-13 09:00:00','No puede continuar.','Acogida de Toby cancelada.','Cancelada.',9,NULL,2),
(12,'ACOGIDA','ALTA','2025-05-22 14:00:00','ESPERANDO_REVISION',NULL,NULL,NULL,NULL,'Acogida Bruno.','Cuestionario recibido; pendiente de revisión.',5,NULL,NULL),

-- ANUNCIOS
(8,'ANUNCIO','ALTA','2025-05-14 09:00:00','PENDIENTE',NULL,NULL,NULL,NULL,'Anuncio de perro encontrado.','Pendiente.',10,NULL,NULL),
(9,'ANUNCIO','NORMAL','2025-05-16 10:00:00','ESPERANDO_REVISION',NULL,NULL,NULL,NULL,'Gato perdido Simba.','Revisar.',3,NULL,NULL),
(10,'ANUNCIO','BAJA','2025-05-18 12:00:00','APROBADA','2025-05-19 10:00:00','Validado.',NULL,NULL,'Anuncio Lúa.','Publicado.',4,2,NULL),

-- MÁS ADOPCIONES
(11,'ADOPCION','NORMAL','2025-05-21 11:00:00','PENDIENTE',NULL,NULL,NULL,NULL,'Adopción Lúa.','Nueva solicitud.',6,NULL,NULL),
(13,'ADOPCION','ALTA','2025-05-02 09:00:00','RECHAZADA','2025-05-05 10:00:00','Incompatible con estilo de vida.',NULL,NULL,'Solicitud inicial para Ares.','Rechazada.',1,2,NULL),
(14,'ADOPCION','ALTA','2025-05-06 11:00:00','APROBADA','2025-05-15 12:00:00','Aprobada tras nueva revisión.',NULL,NULL,'Segunda solicitud para Ares.','Aprobada.',2,2,NULL),
(15,'ADOPCION','NORMAL','2025-05-04 10:00:00','RECHAZADA','2025-05-10 11:00:00','Vivienda no apta.',NULL,NULL,'Solicitud para Duna (rechazada, sin adoptar).','Rechazada.',3,2,NULL),
(16,'ADOPCION','BAJA','2025-05-08 14:00:00','CANCELADA',NULL,NULL,'2025-05-09 15:00:00','Desistimiento del adoptante.','Solicitud para Lola cancelada.','Cancelada.',4,NULL,2),
(17,'ADOPCION','ALTA','2025-06-11 09:00:00','APROBADA','2025-06-11 14:00:00','Adopción completada con éxito.',NULL,NULL,'Solicitud histórica para Thor.','Aprobada antes del deceso.',1,2,NULL),
(18,'ADOPCION','NORMAL','2025-06-15 10:00:00','APROBADA','2025-06-25 12:00:00','Valoración favorable y documentación firmada.',NULL,NULL,'Solicitud de adopción de Nala.','Adopción formalizada; pendiente acreditar esterilización.',9,2,NULL);


-- ------------------------------------------------------------
-- 9. CANDIDATURAS DE ANIMALES
-- Tabla: candidatura_animal
-- PK: solicitud_id + animal_id + fecha_propuesta
-- ------------------------------------------------------------

INSERT INTO candidatura_animal
(solicitud_id,animal_id,fecha_propuesta,estado,
 fecha_respuesta,motivo_descarte)
VALUES
-- Adopciones: el animal forma parte de la elección de la persona.
(1,1,'2025-05-01 10:00:00','ESCOGIDO',NULL,NULL),
(2,2,'2025-05-03 12:30:00','ESCOGIDO',NULL,NULL),
(3,6,'2025-05-05 09:15:00','ESCOGIDO',NULL,NULL),
(4,7,'2025-05-07 15:00:00','ESCOGIDO',NULL,NULL),
(11,5,'2025-05-21 11:00:00','ESCOGIDO',NULL,NULL),
(13,11,'2025-05-02 09:00:00','ESCOGIDO',NULL,NULL),
(14,11,'2025-05-06 11:00:00','ESCOGIDO',NULL,NULL),
(15,13,'2025-05-04 10:00:00','ESCOGIDO',NULL,NULL),
(16,12,'2025-05-08 14:00:00','ESCOGIDO',NULL,NULL),
(17,16,'2025-06-11 09:00:00','ESCOGIDO',NULL,NULL),
(18,15,'2025-06-15 10:00:00','ESCOGIDO',NULL,NULL),

-- Acogidas: la persona ya aceptó el animal propuesto.
(5,3,'2025-05-08 10:20:00','ESCOGIDO','2025-05-09 10:00:00',NULL),
(6,8,'2025-05-10 08:00:00','ESCOGIDO','2025-05-11 10:00:00',NULL),
(7,2,'2025-05-11 18:00:00','CANCELADO',NULL,NULL);


-- ------------------------------------------------------------
-- 10. CUESTIONARIOS ONLINE INICIALES
-- ------------------------------------------------------------

INSERT INTO cuestionario_hogar
(solicitud_id,num_ninos_menos_6_anios,num_ninos_mas_6_anios,
 num_perros,num_gatos,num_otros,tipo_vivienda,
 dispone_licencia_ppp,duracion_max_meses)
VALUES
    (1,0,1,0,1,0,'PISO',0,NULL),
    (2,0,0,1,0,0,'CASA_JARDIN',0,NULL),
    (3,0,0,0,0,0,'PISO',0,NULL),
    (4,1,0,0,0,0,'PISO',0,NULL),
    (5,0,0,1,0,0,'CASA',0,6),
    (6,0,2,0,1,0,'CASA_JARDIN',1,12),
    (11,0,0,0,0,0,'PISO',0,NULL),
    (12,0,1,1,0,0,'CASA',1,8),
    (13,0,0,0,0,0,'PISO',0,NULL),
    (14,0,0,0,0,0,'CASA',0,NULL),
    (15,1,1,0,0,0,'PISO',0,NULL),
    (16,0,0,0,0,0,'PISO',0,NULL),
    (17,0,0,0,0,0,'CASA_JARDIN',1,NULL),
    (18,0,1,0,0,0,'CASA_JARDIN',0,NULL);


-- ------------------------------------------------------------
-- 11. DOCUMENTOS DE CUESTIONARIO
-- ------------------------------------------------------------

INSERT INTO documento_cuestionario
(solicitud_id,url_pdf,hash_integridad,fecha_registro,tipo)
VALUES
    (1,'/docs/cuestionarios/solicitud-1-general.pdf','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','2025-05-02 10:00:00','GENERAL'),
    (3,'/docs/cuestionarios/solicitud-3-general.pdf','bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb','2025-05-06 12:00:00','GENERAL'),
    (5,'/docs/cuestionarios/solicitud-5-reducido.pdf','cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc','2025-05-09 10:00:00','REDUCIDO'),
    (6,'/docs/cuestionarios/solicitud-6-general.pdf','dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd','2025-05-11 09:00:00','GENERAL'),
    (14,'/docs/cuestionarios/solicitud-14-general.pdf','eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee','2025-05-07 09:00:00','GENERAL'),
    (17,'/docs/cuestionarios/solicitud-17-general.pdf','ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff','2025-06-11 09:30:00','GENERAL'),
    (18,'/docs/cuestionarios/solicitud-18-general.pdf','6666666666666666666666666666666666666666666666666666666666666666','2025-06-16 10:00:00','GENERAL');


-- ------------------------------------------------------------
-- 12. DOCUMENTOS VINCULANTES
-- ------------------------------------------------------------

INSERT INTO documento_vinculante
(id,fecha_registro,fecha_firma,fecha_anulacion,motivo_anulacion,
 fecha_resolucion,motivo_resolucion,url_pdf,hash_integridad)
VALUES
    (1,'2025-05-20 15:30:00','2025-05-20',NULL,NULL,NULL,NULL,'/docs/adopcion/contrato-milo.pdf','1111111111111111111111111111111111111111111111111111111111111111'),
    (2,'2025-05-12 12:30:00','2025-05-12',NULL,NULL,NULL,NULL,'/docs/acogida/contrato-bruno.pdf','2222222222222222222222222222222222222222222222222222222222222222'),
    (3,'2025-05-25 10:00:00','2025-05-25',NULL,NULL,NULL,NULL,'/docs/acogida/contrato-kira.pdf','3333333333333333333333333333333333333333333333333333333333333333'),
    (4,'2025-05-15 13:00:00','2025-05-15',NULL,NULL,NULL,NULL,'/docs/adopcion/contrato-ares.pdf','4444444444444444444444444444444444444444444444444444444444444444'),
    (5,'2025-06-11 14:30:00','2025-06-11',NULL,NULL,NULL,NULL,'/docs/adopcion/contrato-thor.pdf','5555555555555555555555555555555555555555555555555555555555555555'),
    (6,'2025-06-25 11:30:00','2025-06-25',NULL,NULL,NULL,NULL,'/docs/adopcion/contrato-nala.pdf','6666666666666666666666666666666666666666666666666666666666666666');


-- ------------------------------------------------------------
-- 13. CUSTODIAS
-- ------------------------------------------------------------

INSERT INTO custodia_animal
(id,fecha_inicio,fecha_fin,animal_id,persona_id,solicitud_id)
VALUES
    (1,'2025-05-20 16:00:00',NULL,6,5,3),
    (2,'2025-05-15 13:00:00',NULL,11,2,14),
    (3,'2025-06-11 15:00:00','2025-06-12 10:00:00',16,1,17),
    (4,'2025-06-25 12:00:00',NULL,15,9,18);


-- ------------------------------------------------------------
-- 14. ESTANCIAS
-- ------------------------------------------------------------

INSERT INTO estancia_animal
(id,tipo,fecha_inicio,fecha_fin,observaciones,animal_id,persona_id)
VALUES
    (1,'ACOGIDA','2025-05-12 14:00:00',NULL,'Acogida familiar aprobada de Bruno.',8,8),
    (2,'PROTECTORA','2025-03-02 12:00:00',NULL,'Estancia en instalaciones de la protectora (Rocky).',4,NULL),
    (3,'ACOGIDA','2025-05-25 11:00:00',NULL,'Acogida de prueba de Kira.',3,7),
    (4,'PROTECTORA','2025-06-11 08:30:00','2025-06-11 15:00:00','Estancia inicial en instalaciones antes de adopción de Thor.',16,NULL),
    (5,'PROTECTORA','2025-03-20 08:45:00','2025-05-20 16:00:00','Estancia de Milo en las instalaciones de la protectora antes de su adopción.',6,NULL),
    (6,'ADOPTANTE','2025-05-20 16:00:00',NULL,'Milo convive con su familia adoptante, Elena Martínez.',6,5),
    (7,'PROTECTORA','2025-04-20 10:00:00','2025-05-15 13:00:00','Estancia de Ares en la protectora antes de su adopción.',11,NULL),
    (8,'ADOPTANTE','2025-05-15 13:00:00',NULL,'Ares convive con su familia adoptante, Marcos Pérez.',11,2),
    (9,'ADOPTANTE','2025-06-11 15:00:00','2025-06-12 10:00:00','Estancia de Thor con su adoptante hasta su fallecimiento.',16,1),
    (10,'PROTECTORA','2025-06-09 10:45:00','2025-06-25 12:00:00','Estancia de Nala en la protectora antes de su adopción.',15,NULL),
    (11,'ADOPTANTE','2025-06-25 12:00:00',NULL,'Nala convive con su familia adoptante, Carlos Díaz.',15,9);


-- ------------------------------------------------------------
-- 15. DOCUMENTOS DE ADOPCIÓN
-- ------------------------------------------------------------

INSERT INTO documento_adopcion
(id,fecha_limite_esterilizacion,fecha_esterilizacion_acreditada,
 custodia_animal_id)
VALUES
    (1,NULL,NULL,1),
    (4,NULL,NULL,2),
    (5,NULL,NULL,3),
    (6,'2025-12-25',NULL,4);


-- ------------------------------------------------------------
-- 16. DOCUMENTOS DE ACOGIDA
-- ------------------------------------------------------------

INSERT INTO documento_acogida
(id,fecha_fin_prevista,tipo,estancia_animal_id)
VALUES
    (2,'2025-11-12','CONTRATO_ACOGIDA',1),
    (3,'2025-08-25','CONTRATO_ACOGIDA',3);


-- ------------------------------------------------------------
-- 17. DETALLES DE ANUNCIOS
-- ------------------------------------------------------------

INSERT INTO detalles_anuncio
(id,fecha_publicacion,fecha_cierre,estado,es_perdida_interna,
 provincia,localidad,zona,texto,animal_id,solicitud_id)
VALUES
    (1,'2025-05-14 10:00:00',NULL,'PENDIENTE',0,'A Coruña','A Coruña','Os Mallos','Perro encontrado.',4,8),
    (2,'2025-05-16 12:00:00',NULL,'PUBLICADO',0,'A Coruña','A Coruña','Monte Alto','Gato perdido Simba.',10,9),
    (3,'2025-05-19 10:00:00',NULL,'PUBLICADO',0,'A Coruña','A Coruña','Riazor','Familia localizada Lúa.',5,10),
    (4,'2025-05-10 09:00:00',NULL,'PUBLICADO',1,'A Coruña','A Coruña','Instalaciones','Necesita difusión.',8,NULL),
    (6,'2025-05-11 09:00:00','2025-05-30 17:00:00','RESUELTO',1,'A Coruña','Sada','Centro','Aviso resuelto.',2,NULL),
    (7,'2025-05-12 09:00:00','2025-06-01 12:00:00','CERRADO',1,'A Coruña','Carballo','Zona norte','Campaña cerrada.',3,NULL);


-- ------------------------------------------------------------
-- 18. REINICIO DE SECUENCIAS
-- ------------------------------------------------------------

ALTER TABLE pais ALTER COLUMN id RESTART WITH 4;
ALTER TABLE especie ALTER COLUMN id RESTART WITH 3;
ALTER TABLE raza ALTER COLUMN id RESTART WITH 9;
ALTER TABLE rol ALTER COLUMN id RESTART WITH 4;
ALTER TABLE persona ALTER COLUMN id RESTART WITH 11;
ALTER TABLE usuario ALTER COLUMN id RESTART WITH 6;
ALTER TABLE animal ALTER COLUMN id RESTART WITH 21;
ALTER TABLE imagen_animal ALTER COLUMN id RESTART WITH 22;
ALTER TABLE solicitud ALTER COLUMN id RESTART WITH 19;
ALTER TABLE custodia_animal ALTER COLUMN id RESTART WITH 5;
ALTER TABLE estancia_animal ALTER COLUMN id RESTART WITH 12;
ALTER TABLE detalles_anuncio ALTER COLUMN id RESTART WITH 8;