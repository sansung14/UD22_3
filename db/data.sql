USE UD22;
CREATE TABLE `cientificos` (
	`DNI` varchar(8),
	`NomApels` varchar(255),
	PRIMARY KEY (`DNI`)
);
CREATE TABLE `proyecto` (
	`id` char(4),
	`Nombre` varchar(255),
	`Horas` int,
	PRIMARY KEY (`id`)
);
CREATE TABLE `asignado` (
	`cientifico` varchar(8) NOT NULL,
	`proyecto` char(4) NOT NULL,
	PRIMARY KEY (`cientifico`),
    CONSTRAINT `cientificos_fk` FOREIGN KEY (`cientifico`) REFERENCES `cientificos` (`DNI`) on update cascade,
	CONSTRAINT `proyecto_fk` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`id`) on update cascade
);