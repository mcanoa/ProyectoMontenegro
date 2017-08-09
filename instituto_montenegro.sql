﻿# Host: localhost  (Version 5.1.73-community)
# Date: 2017-07-04 21:31:52
# Generator: MySQL-Front 6.0  (Build 1.204)


#
# Structure for table "administrador"
#

CREATE TABLE `administrador` (
  `codigoAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(15) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoAdmin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Structure for table "estudiante"
#

CREATE TABLE `estudiante` (
  `documento` int(11) NOT NULL DEFAULT '0',
  `nombres` varchar(60) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `grado` varchar(5) DEFAULT NULL,
  `sexo` varchar(2) DEFAULT NULL,
  `tipoPoblacion` varchar(50) DEFAULT NULL,
  `modeloPedagogico` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for table "estudiante_ocasional"
#

CREATE TABLE `estudiante_ocasional` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` int(11) NOT NULL DEFAULT '0',
  `nombres` varchar(65) DEFAULT NULL,
  `apellidos` varchar(70) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

#
# Structure for table "huella"
#

CREATE TABLE `huella` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` int(11) NOT NULL DEFAULT '0',
  `nombres` varchar(250) DEFAULT '',
  `huella` blob,
  PRIMARY KEY (`id`),
  KEY `huella_ibfk_1` (`documento`),
  CONSTRAINT `huella_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `estudiante` (`documento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Structure for table "instituto_montenegro"
#

CREATE TABLE `instituto_montenegro` (
  `Nit` int(11) NOT NULL AUTO_INCREMENT,
  `documentoEstudiante` int(11) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  `ultimoIngreso` date DEFAULT NULL,
  PRIMARY KEY (`Nit`),
  KEY `documento_Estudiante` (`documentoEstudiante`),
  CONSTRAINT `documento_Estudiante` FOREIGN KEY (`documentoEstudiante`) REFERENCES `estudiante` (`documento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
