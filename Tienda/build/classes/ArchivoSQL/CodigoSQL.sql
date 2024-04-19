create table EMPRESADESARROLLADORA
(
    IDEMPRESA     NUMBER not null
        primary key,
    NOMBREEMPRESA VARCHAR2(100)
)
/

create table JUEGO
(
    IDJUEGO          NUMBER not null
        primary key,
    NOMBREJUEGO      VARCHAR2(100),
    FECHALANZAMIENTO DATE,
    PRECIO           NUMBER,
    LIMITEEDAD       NUMBER,
    ENDESCUENTO      CHAR
        check (enDescuento IN ('0', '1')),
    IDEMPRESA        NUMBER
        references EMPRESADESARROLLADORA
)
/

create table ADMINISTRADOR
(
    IDADMIN           NUMBER not null
        primary key,
    NOMBRE            VARCHAR2(100),
    APELLIDO          VARCHAR2(100),
    CORREOELECTRONICO VARCHAR2(100)
        unique,
    CONTRASENA        VARCHAR2(100)
)
/

create table PERMISOS
(
    IDPERMISO     NUMBER not null
        primary key,
    NOMBREPERMISO VARCHAR2(100)
)
/

create table ADMINISTRADOR_PERMISO
(
    IDADMIN   NUMBER not null
        references ADMINISTRADOR,
    IDPERMISO NUMBER not null
        references PERMISOS,
    primary key (IDADMIN, IDPERMISO)
)
/

create table GENERO
(
    IDGENERO NUMBER not null
        primary key,
    NOMBRE   VARCHAR2(50)
)
/

create table USUARIO
(
    IDUSUARIO      NUMBER not null
        primary key,
    NOMBRECOMPLETO VARCHAR2(100),
    NOMBREUSUARIO  VARCHAR2(50),
    EDAD           NUMBER,
    JUGANDO        CHAR
        check (jugando IN ('0', '1')),
    IDGENERO       NUMBER
        references GENERO
)
/

create table USUARIO_JUEGO
(
    IDUSUARIO NUMBER not null
        references USUARIO,
    IDJUEGO   NUMBER not null
        references JUEGO,
    primary key (IDUSUARIO, IDJUEGO)
)
/

create table PLATAFORMA
(
    IDPLATAFORMA NUMBER not null
        primary key,
    NOMBRE       VARCHAR2(100)
        unique
)
/

create table JUEGO_PLATAFORMA
(
    IDJUEGO      NUMBER not null
        references JUEGO,
    IDPLATAFORMA NUMBER not null
        references PLATAFORMA,
    primary key (IDJUEGO, IDPLATAFORMA)
)
/

INSERT INTO JUEGO(NOMBREJUEGO,FECHALANZAMIENTO,PRECIO,LIMITEEDAD,ENDESCUENTO,IDEMPRESA,IMAGEN);
VALUES (	ARK,	2020,	10000,	18,	1,	A,	https://i.ytimg.com/vi/0gLODoXanog/maxresdefault.jpg

);

INSERT INTO JUEGO (IDJUEGO, NOMBREJUEGO, FECHALANZAMIENTO, PRECIO, LIMITEEDAD, ENDESCUENTO, IDEMPRESA, IMAGEN)
VALUES (1, 'ARK', TO_DATE('2024-04-04', 'YYYY-MM-DD'), 49.99, 18, '0', 10, 'https://i.ytimg.com/vi/0gLODoXanog/maxresdefault.jpg');


SELECT IMAGEN FROM JUEGO WHERE IDJUEGO = 1
SELECT IMAGEN FROM JUEGO WHERE ENDESCUENTO = '1'



INSERT INTO JUEGO (IDJUEGO, NOMBREJUEGO, FECHALANZAMIENTO, PRECIO, LIMITEEDAD, ENDESCUENTO, IDEMPRESA, IMAGEN)
VALUES (3, 'The Legend of Zelda: Breath of the Wild', TO_DATE('2017-03-03', 'YYYY-MM-DD'), 59.99, 13, '1', 10,'https://assets.nintendo.com/image/upload/f_auto,q_auto/v1702579818/Microsites/zelda-portal/videos/posters/zelda-featured-trailer');

INSERT INTO JUEGO (IDJUEGO, NOMBREJUEGO, FECHALANZAMIENTO, PRECIO, LIMITEEDAD, ENDESCUENTO, IDEMPRESA, IMAGEN)
VALUES (4, 'Super Mario Odyssey', TO_DATE('2017-10-27', 'YYYY-MM-DD'), 59.99, 6, '1', 10,'https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_1240/b_white/f_auto/q_auto/ncom/software/switch/70010000001130/c42553b4fd0312c31e70ec7468c6c9bccd739f340152925b9600631f2d29f8b5');

INSERT INTO JUEGO (IDJUEGO, NOMBREJUEGO, FECHALANZAMIENTO, PRECIO, LIMITEEDAD, ENDESCUENTO, IDEMPRESA, IMAGEN)
VALUES (5, 'Read Dead Redemption 2', TO_DATE('2017-04-04', 'YYYY-MM-DD'), 49.99, 17, '1', 10,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQyXi1Jjdtp7_Pqp7_lK7OjGc5x2pwcD70FadC9sCmbzx4wRisjwYW944IXXHTwqSL16Ru');

INSERT INTO JUEGO (IDJUEGO, NOMBREJUEGO, FECHALANZAMIENTO, PRECIO, LIMITEEDAD, ENDESCUENTO, IDEMPRESA, IMAGEN)
VALUES (6, 'The Witcher 3: Wild Hunt', TO_DATE('2015-05-19', 'YYYY-MM-DD'), 39.99, 18, '1', 10,'https://cdn.akamai.steamstatic.com/steam/apps/292030/header.jpg?t=1710411171');


/


--Modificaciones a la base de datos

ALTER TABLE juego
ADD IMAGEN VARCHAR2(255);

ALTER TABLE usuario
ADD correo VARCHAR2(35);

ALTER TABLE usuario
ADD contraseña VARCHAR2(50);

ALTER TABLE usuario
ADD IMAGEN VARCHAR2(255);


ALTER TABLE usuario
ADD Nombre VARCHAR2(50);

ALTER TABLE usuario
ADD Apellido VARCHAR2(50);


-- Eliminar la columna NOMBRECOMPLETO
ALTER TABLE usuario
DROP COLUMN NOMBRECOMPLETO;


-- Crear la secuencia (Incrementa el ID del Usuario)
CREATE SEQUENCE seq_usuario
START WITH 1
INCREMENT BY 1;

-- Crear el trigger
CREATE OR REPLACE TRIGGER trg_usuario
BEFORE INSERT ON usuario
FOR EACH ROW
BEGIN
  SELECT seq_usuario.nextval
  INTO :new.IDUSUARIO
  FROM dual;
END;
/

SELECT * FROM USUARIO;


--NUEVO

CREATE TABLE BIBLIOTECA_USUARIO (
    ID_USUARIO NUMBER NOT NULL,
    IDJUEGO NUMBER NOT NULL,
    NOMBREJUEGO VARCHAR2(100 BYTE),
    LIMITEEDAD NUMBER,
    FECHALANZAMIENTO DATE,
    FECHA_COMPRA DATE,
    IMAGEN VARCHAR2(255 BYTE)
);


CREATE OR REPLACE TRIGGER verificar_compra
BEFORE INSERT ON BIBLIOTECA_USUARIO
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM BIBLIOTECA_USUARIO
    WHERE ID_USUARIO = :NEW.ID_USUARIO AND IDJUEGO = :NEW.IDJUEGO;

    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Error: Ya has comprado este juego.');
    END IF;
END;
/

--NUEVO





--Stored procedures
--procedimiento almacenado que muestre información sobre un juego específico.
CREATE OR REPLACE PROCEDURE mostrar_info_juego(p_idjuego IN NUMBER) AS
  v_nombre_juego JUEGO.NOMBREJUEGO%TYPE;
  v_precio JUEGO.PRECIO%TYPE;
BEGIN
  SELECT NOMBREJUEGO, PRECIO INTO v_nombre_juego, v_precio
  FROM JUEGO
  WHERE IDJUEGO = p_idjuego;
  
  DBMS_OUTPUT.PUT_LINE('Nombre del Juego: ' || v_nombre_juego);
  DBMS_OUTPUT.PUT_LINE('Precio: $' || v_precio);
END mostrar_info_juego;
/

--Funciones
--función que calcule el precio de un juego después de aplicar un descuento.
CREATE OR REPLACE FUNCTION calcular_precio_descuento(p_precio IN NUMBER, 
p_descuento IN NUMBER) RETURN NUMBER AS
  v_precio_final NUMBER;
BEGIN
  v_precio_final := p_precio - (p_precio * (p_descuento / 100));
  RETURN v_precio_final;
END calcular_precio_descuento;
/

--Paquetes
--paquete para agrupar nuestras funciones y procedimientos.
CREATE OR REPLACE PACKAGE juegos_util AS
  PROCEDURE mostrar_info_juego(p_idjuego IN NUMBER);
  FUNCTION calcular_precio_descuento(p_precio IN NUMBER, p_descuento IN NUMBER) RETURN NUMBER;
END juegos_util;
/

CREATE OR REPLACE PACKAGE BODY juegos_util AS
  PROCEDURE mostrar_info_juego(p_idjuego IN NUMBER) AS
    v_nombre_juego JUEGO.NOMBREJUEGO%TYPE;
    v_precio JUEGO.PRECIO%TYPE;
  BEGIN
    SELECT NOMBREJUEGO, PRECIO INTO v_nombre_juego, v_precio
    FROM JUEGO
    WHERE IDJUEGO = p_idjuego;
    
    DBMS_OUTPUT.PUT_LINE('Nombre del Juego: ' || v_nombre_juego);
    DBMS_OUTPUT.PUT_LINE('Precio: $' || v_precio);
  END mostrar_info_juego;
  
  FUNCTION calcular_precio_descuento(p_precio IN NUMBER, p_descuento
 IN NUMBER) RETURN NUMBER AS
    v_precio_final NUMBER;
  BEGIN
    v_precio_final := p_precio - (p_precio * (p_descuento / 100));
    RETURN v_precio_final;
  END calcular_precio_descuento;
END juegos_util;
/


--Expresiones regulares
--expresión regular para validar direcciones de correo electrónico.
CREATE OR REPLACE FUNCTION validar_correo(p_correo IN VARCHAR2) RETURN BOOLEAN AS
BEGIN
  IF REGEXP_LIKE(p_correo, '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$') THEN
    RETURN TRUE;
  ELSE
    RETURN FALSE;
  END IF;
END validar_correo;
/

--Triggers
--crear un trigger que se active antes de insertar en la tabla USUARIO 
--para validar el correo electrónico.
CREATE OR REPLACE TRIGGER trg_validar_correo
BEFORE INSERT ON USUARIO
FOR EACH ROW
DECLARE
  v_valido BOOLEAN;
BEGIN
  v_valido := validar_correo(:new.correo);
  IF NOT v_valido THEN
    RAISE_APPLICATION_ERROR(-20001, 'Correo electrónico no válido');
  END IF;
END;
/

--SQL Dinamico
--realizar una consulta personalizada.
CREATE OR REPLACE PROCEDURE consulta_personalizada(p_tabla IN VARCHAR2, 
p_columna IN VARCHAR2) AS
  v_sql VARCHAR2(200);
  v_resultado NUMBER;
BEGIN
  v_sql := 'SELECT COUNT(' || p_columna || ') FROM ' || p_tabla;
  EXECUTE IMMEDIATE v_sql INTO v_resultado;
  DBMS_OUTPUT.PUT_LINE('El número de registros en la tabla ' || p_tabla || ' es: ' || v_resultado);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END consulta_personalizada;
/

--Cursores
--procedimiento almacenado que utilice un cursor para mostrar información 
--sobre todos los juegos.
CREATE OR REPLACE PROCEDURE mostrar_info_juegos AS
  CURSOR c_juegos IS
    SELECT IDJUEGO, NOMBREJUEGO, FECHALANZAMIENTO, PRECIO
    FROM JUEGO;
BEGIN
  FOR juego IN c_juegos LOOP
    DBMS_OUTPUT.PUT_LINE('ID: ' || juego.IDJUEGO || ', Nombre: ' || 
juego.NOMBREJUEGO || ', Fecha de Lanzamiento: ' || juego.FECHALANZAMIENTO || 
', Precio: $' || juego.PRECIO);
  END LOOP;
END mostrar_info_juegos;
/
