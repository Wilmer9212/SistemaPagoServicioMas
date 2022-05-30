
DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes(
idcliente integer not null,
nombre text not null,
appaterno text not null,
apmaterno text,
email text,
telefono integer,
activo boolean,
sexo   varchar(45)
idcolonia integer not null,

primary key(idcliente),
foreign key(idcolonia) references colonias(idcolonia)
);




DROP TABLE IF EXISTS colonias;
CREATE TABLE colonias(
idcolonia integer not null,
nombre text not null,
idmunicipio integer not null,

primary key(idcolonia),
foreign key(idmunicipio) references municipios(idmunicipio)
);


DROP TABLE IF EXISTS municipios;
CREATE TABLE municipios(
idmunicipio integer not null,
nombre text not null,
idestado integer not null,

primary key(idmunicipio),
foreign key(idestado)references estados(idestado)
);


DROP TABLE IF EXISTS estados;
CREATE TABLE estados(
idestado integer not null,
nombre text not null,
primary key(idestado)
);




DROP TABLE IF EXISTS productos;

DROP TABLE IF EXISTS productos;
CREATE TABLE productos(
	idproducto integer not null,
	nombre text not null,
	precio numeric not null,
	preciocliente numeric,
	stock integer,
	activarpreciocliente boolean,
	preciodeproveedor numeric,
	idcategoria integer not null,
	idproveedor integer not null,
	idunidadm integer not null,

	primary key(idproducto),
	foreign key(idproveedor) references proveedores(idproveedor),
	foreign key(idunidadm) references unidadesm(idunidadm),
	foreign key(idcategoria)references categorias(idcategoria)

);


INSERT INTO productos VALUES(1,'Coca-cola',15.80,15.80,200,false,13.60,1,1,1);

DROP TABLE IF EXISTS unidadm;
CREATE TABLE unidadm(
      idunidadm integer,
      descripcion varchar(45),

      primary key(idunidadm)
       
);

INSERT INTO unidadm VALUES(1,'600 ML');

DROP TABLE IF EXISTS proveedores;
CREATE TABLE proveedores(
     idproveedor integer,
     nombre      text,
     telefono    varchar(45),
     mail        text,

     primary key(idproveedor)
       
);

INSERT INTO proveedores values(1,'COCA-COLA S.A De C.V','8134760912','cocacola0045@cocacola.com');


DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria(
      idcategoria integer,
      descripcion varchar(45),

      primary key(idcategoria)
       
);

INSERT INTO categoria VALUES(1,'Bebidas');

DROP TABLE IF EXISTS ventas_realizadas;
CREATE TABLE ventas_realizadas(
   idticket integer,
   fecha timestamp,
   tipoventa varchar(45),
   totalventa numeric,
   idusuario varchar(45),

   primary key(idticket)   
);


DROP TABLE IF EXISTS detalles_venta;
CREATE TABLE detalles_venta(
idticket integer,
producto varchar(45),
totalproducto integer,
fecha timestamp,
total numeric,
iva numeric,
cliente text default 'xxxxxxxxxxxx'
);
