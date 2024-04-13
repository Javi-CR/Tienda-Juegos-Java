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
