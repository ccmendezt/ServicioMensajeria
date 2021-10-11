INSERT INTO cliente (k_tipodoc, k_nrodoc, n_nombres, n_apellidos, o_email, q_telefonocelular) VALUES ('CC', 20191020069, 'Miguel Angel', 'Babativa Niño', 'mababativa@gmail.com', 3172656475);
INSERT INTO cliente (k_tipodoc, k_nrodoc, n_nombres, n_apellidos, o_email, q_telefonocelular) VALUES ('CC', 20182020001, 'Diego Fernando', 'Roman', 'dfroman@gmail.com', 3209564171);
INSERT INTO cliente (k_tipodoc, k_nrodoc, n_nombres, n_apellidos, o_email, q_telefonocelular) VALUES ('CE', 20191020139, 'Cristian Camilo', 'Mendez Trujillo', 'ccmendez@gmail.com', 3112151819);

INSERT INTO mensajero (k_tipodoc, k_nrodoc, n_nombre, n_apellido, o_seguridadsocial, i_sexo, i_tipotransporte, i_tipomedio, o_email, q_telefonocelular, n_nacionalidad, f_fechanacimiento) VALUES ('CE', 20191020133, 'Ibzan Jared', 'Peralta Rosero', false, 'M', 'PQ', 'B', 'ijperalta@gmail.com', 3219786417, 'Venezolano', '1999-04-30');
INSERT INTO mensajero (k_tipodoc, k_nrodoc, n_nombre, n_apellido, o_seguridadsocial, i_sexo, i_tipotransporte, i_tipomedio, o_email, q_telefonocelular, n_nacionalidad, f_fechanacimiento) VALUES ('CC', 20191020153, 'Juan Andres', 'Gonzalez Gonzalez', true, 'M', 'PG', 'M', 'jagonzalez@gmail.com', 3123456789, 'Colombiano', '2002-03-19');

INSERT INTO ciudad (k_idciudad, n_nombreciudad, q_preciotrayecto, t_porcentajecomision) VALUES (11001, 'Bogotá', 10000, 0.12);
INSERT INTO ciudad (k_idciudad, n_nombreciudad, q_preciotrayecto, t_porcentajecomision) VALUES (15001, 'Tunja', 8000, 0.1);

INSERT INTO tipo_paquete (k_idtipop, n_nombretipop, q_tarifapaquete) VALUES ('DC', 'Documentos', 1000);
INSERT INTO tipo_paquete (k_idtipop, n_nombretipop, q_tarifapaquete) VALUES ('PQ', 'Paquete Pequeño', 2500);
INSERT INTO tipo_paquete (k_idtipop, n_nombretipop, q_tarifapaquete) VALUES ('PM', 'Paquete mediano', 3500);
INSERT INTO tipo_paquete (k_idtipop, n_nombretipop, q_tarifapaquete) VALUES ('PG', 'Paquete grande', 5000);



INSERT INTO horariolaboral VALUES ('1','Lunes','08:00','18:00',20191020153,'CC');
INSERT INTO horariolaboral VALUES ('2','Martes','09:00','17:00',20191020153,'CC');
INSERT INTO horariolaboral VALUES ('3','Miercoles','10:00','20:00',20191020153,'CC');
INSERT INTO horariolaboral VALUES ('4','Jueves','06:00','13:00',20191020153,'CC');
INSERT INTO horariolaboral VALUES ('5','Viernes','11:30','17:00',20191020153,'CC');
INSERT INTO horariolaboral VALUES ('6','Sabado','07:00','12:00',20191020153,'CC');
INSERT INTO horariolaboral VALUES ('7','Domingo','09:00','12:00',20191020153,'CC');
INSERT INTO horariolaboral VALUES ('8','Lunes','07:00','17:00',20191020133,'CE');
INSERT INTO horariolaboral VALUES ('9','Martes','07:00','17:00',20191020133,'CE');
INSERT INTO horariolaboral VALUES ('10','Miercoles','07:00','17:00',20191020133,'CE');
INSERT INTO horariolaboral VALUES ('11','Jueves','07:00','17:00',20191020133,'CE');
INSERT INTO horariolaboral VALUES ('12','Viernes','07:00','17:00',20191020133,'CE');

COMMIT;

--INSERT INTO public.servicio (k_idservicio, f_inicial, f_horainicial, i_idayvuelta, v_costo, f_cambioestado, n_cmtcambioestado, i_mediopago, k_idciudad, k_tipodoccli, k_nrodoccli, q_calificacion, k_idtipopaquete, k_nrodocmen, k_tipodocmen) VALUES (4, '2021-10-11', '15:30:21', 'I', 1000, '2021-10-11 16:05:54.096717', 'Se inicio', 'P', 11001, 'CE', 20191020139, NULL, 'DC', NULL, NULL);
