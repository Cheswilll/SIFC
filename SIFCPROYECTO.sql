-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: sifcnuevo
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asistencias`
--

DROP TABLE IF EXISTS `asistencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistencias` (
  `idAsistencia` int(11) unsigned zerofill NOT NULL,
  `fechaAsistencia` date NOT NULL,
  `nombreJugador` varchar(45) NOT NULL,
  `asistencia` char(4) NOT NULL,
  `noIdentificacionJugador` bigint(12) NOT NULL,
  `noIdentificacionProfesor` bigint(12) NOT NULL,
  PRIMARY KEY (`idAsistencia`),
  KEY `fkAsistenciasConPersonasJ_idx` (`noIdentificacionJugador`),
  KEY `fkAsistenciasConPersonasP_idx` (`noIdentificacionProfesor`),
  CONSTRAINT `fkAsistenciasConPersonasJ` FOREIGN KEY (`noIdentificacionJugador`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkAsistenciasConPersonasP` FOREIGN KEY (`noIdentificacionProfesor`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencias`
--

LOCK TABLES `asistencias` WRITE;
/*!40000 ALTER TABLE `asistencias` DISABLE KEYS */;
INSERT INTO `asistencias` (`idAsistencia`, `fechaAsistencia`, `nombreJugador`, `asistencia`, `noIdentificacionJugador`, `noIdentificacionProfesor`) VALUES (00000000001,'2017-12-12','Pedro','A',22222222,33333333);
/*!40000 ALTER TABLE `asistencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` (`idCategoria`, `nombreCategoria`) VALUES (1,'Pre-Juvenil'),(2,'Juvenil');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigosvalidacion`
--

DROP TABLE IF EXISTS `codigosvalidacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigosvalidacion` (
  `idCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `noIdentificacionPersona` bigint(12) NOT NULL,
  PRIMARY KEY (`idCodigo`),
  KEY `fkCodigosConPersonas_idx` (`noIdentificacionPersona`),
  CONSTRAINT `fkCodigosConPersonas` FOREIGN KEY (`noIdentificacionPersona`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigosvalidacion`
--

LOCK TABLES `codigosvalidacion` WRITE;
/*!40000 ALTER TABLE `codigosvalidacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `codigosvalidacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobantes`
--

DROP TABLE IF EXISTS `comprobantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobantes` (
  `idComprobante` int(11) NOT NULL AUTO_INCREMENT,
  `comprobante` blob,
  `noIdentificacionPersona` bigint(12) NOT NULL,
  PRIMARY KEY (`idComprobante`),
  KEY `fkComprobantesConPersonas_idx` (`noIdentificacionPersona`),
  CONSTRAINT `fkComprobantesConPersonas` FOREIGN KEY (`noIdentificacionPersona`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobantes`
--

LOCK TABLES `comprobantes` WRITE;
/*!40000 ALTER TABLE `comprobantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprobantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entidadesdesalud`
--

DROP TABLE IF EXISTS `entidadesdesalud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entidadesdesalud` (
  `idEntidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEntidad` varchar(45) NOT NULL,
  PRIMARY KEY (`idEntidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entidadesdesalud`
--

LOCK TABLES `entidadesdesalud` WRITE;
/*!40000 ALTER TABLE `entidadesdesalud` DISABLE KEYS */;
INSERT INTO `entidadesdesalud` (`idEntidad`, `nombreEntidad`) VALUES (1,'Salud Total');
/*!40000 ALTER TABLE `entidadesdesalud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipos` (
  `idAsignacion` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEquipo` int(11) NOT NULL,
  `noIdentificacionJugador` bigint(12) NOT NULL,
  `categoria` int(11) NOT NULL,
  `noIdentificacionnProfesor` bigint(12) NOT NULL,
  PRIMARY KEY (`idAsignacion`),
  KEY `fkEquiposCategorias_idx` (`categoria`),
  KEY `fkEquiposConPersonasJ_idx` (`noIdentificacionJugador`),
  KEY `fkEquiposConPersonasP_idx` (`noIdentificacionnProfesor`),
  CONSTRAINT `fkEquiposCategorias` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkEquiposConPersonasJ` FOREIGN KEY (`noIdentificacionJugador`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkEquiposConPersonasP` FOREIGN KEY (`noIdentificacionnProfesor`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` (`idAsignacion`, `codigoEquipo`, `noIdentificacionJugador`, `categoria`, `noIdentificacionnProfesor`) VALUES (1,12,22222222,1,44444444),(2,12,33333333,1,44444444);
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formulario`
--

DROP TABLE IF EXISTS `formulario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formulario` (
  `idFormulario` int(11) NOT NULL AUTO_INCREMENT,
  `noIdentificacion` bigint(12) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `jornadaEstudio` varchar(45) DEFAULT NULL,
  `rh` int(11) NOT NULL,
  `alergias` varchar(45) DEFAULT NULL,
  `lesiones` varchar(45) DEFAULT NULL,
  `entidadSalud` int(11) NOT NULL,
  `nombreMama` varchar(45) NOT NULL,
  `empresaMama` varchar(45) DEFAULT NULL,
  `cargoMama` varchar(45) DEFAULT NULL,
  `telefonoMama` varchar(45) NOT NULL,
  `nombrePadre` varchar(45) DEFAULT NULL,
  `empresaPadre` varchar(45) DEFAULT NULL,
  `cargoPadre` varchar(45) DEFAULT NULL,
  `telefonoPadre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFormulario`),
  KEY `fkFormularioConRh_idx` (`rh`),
  KEY `fkFormularioConEntidades_idx` (`entidadSalud`),
  KEY `fkFormularioConPersonas_idx` (`noIdentificacion`),
  CONSTRAINT `fkFormularioConEntidades` FOREIGN KEY (`entidadSalud`) REFERENCES `entidadesdesalud` (`idEntidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkFormularioConPersonas` FOREIGN KEY (`noIdentificacion`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkFormularioConRh` FOREIGN KEY (`rh`) REFERENCES `tiposdesangre` (`idRh`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formulario`
--

LOCK TABLES `formulario` WRITE;
/*!40000 ALTER TABLE `formulario` DISABLE KEYS */;
INSERT INTO `formulario` (`idFormulario`, `noIdentificacion`, `nombres`, `apellidos`, `fechaNacimiento`, `jornadaEstudio`, `rh`, `alergias`, `lesiones`, `entidadSalud`, `nombreMama`, `empresaMama`, `cargoMama`, `telefonoMama`, `nombrePadre`, `empresaPadre`, `cargoPadre`, `telefonoPadre`) VALUES (1,22222222,'Pedro','Mora','1999-04-03','Mañana',5,'Ninguna','Ninguna',1,'Maria Cam','ewdw','hjuhiu','iuhiui','uuihui','u','hiuhuihihiuh','iuhiuh');
/*!40000 ALTER TABLE `formulario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidades` (
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombreLocalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` (`idLocalidad`, `nombreLocalidad`) VALUES (1,'Engativa'),(2,'Suba'),(3,'Usme'),(4,'Tunjuelito'),(5,'Chapinero'),(6,'Fontibon'),(7,'Rafael uribe');
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidos`
--

DROP TABLE IF EXISTS `partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partidos` (
  `idPartido` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoPartido` int(11) NOT NULL,
  `noIdentificacionProfesor` bigint(12) NOT NULL,
  `tiempoJuado` time DEFAULT NULL,
  `amonestaciones` varchar(45) DEFAULT NULL,
  `nombreEquipoRival` varchar(45) DEFAULT NULL,
  `horaDelPartido` time NOT NULL,
  `observaciones` varchar(45) DEFAULT NULL,
  `fechaDelPartido` date NOT NULL,
  `idTipoAlineacion` int(11) NOT NULL,
  `golesAfavor` int(11) DEFAULT NULL,
  `golesEnContra` int(11) DEFAULT NULL,
  `lugarPartido` varchar(45) NOT NULL,
  `idTorneo` int(11) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPartido`),
  KEY `fkPartidosPersonasProfesor_idx` (`noIdentificacionProfesor`),
  KEY `fkPartidosAlineaciones_idx` (`idTipoAlineacion`),
  KEY `fkPartidosConTorneos_idx` (`idTorneo`),
  KEY `fkPartidosConTipos_idx` (`idTipoPartido`),
  CONSTRAINT `fkPartidosAlineaciones` FOREIGN KEY (`idTipoAlineacion`) REFERENCES `tiposalineaciones` (`idTipoAlineacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkPartidosConTipos` FOREIGN KEY (`idTipoPartido`) REFERENCES `tipopartido` (`idTipoPartido`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkPartidosConTorneos` FOREIGN KEY (`idTorneo`) REFERENCES `torneos` (`idTorneo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkPartidosPersonasProfesor` FOREIGN KEY (`noIdentificacionProfesor`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos`
--

LOCK TABLES `partidos` WRITE;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
INSERT INTO `partidos` (`idPartido`, `idTipoPartido`, `noIdentificacionProfesor`, `tiempoJuado`, `amonestaciones`, `nombreEquipoRival`, `horaDelPartido`, `observaciones`, `fechaDelPartido`, `idTipoAlineacion`, `golesAfavor`, `golesEnContra`, `lugarPartido`, `idTorneo`, `direccion`) VALUES (1,1,44444444,'12:12:12','no','Los tesos','12:40:00','Ninguna','2017-12-12',1,12,1,'Escuela',1,'Crr 121 '),(2,2,44444444,'07:12:12','Si ','Los duros ','07:12:12','Ninguna','2017-12-11',3,3,2,'Escuela',1,'Crr 121 ');
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `url` text,
  `permiso_padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkPermisoPadreConPermiso_idx` (`permiso_padre`),
  CONSTRAINT `fkPermisoPadreConPermiso` FOREIGN KEY (`permiso_padre`) REFERENCES `permisos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` (`id`, `nombre`, `url`, `permiso_padre`) VALUES (1,'Inicio ','app/admin/admin.xhtml',1),(2,'Validacion','app/admin/asignarRoles.xhtml',2),(3,'Usuarios','app/admin/usuariosNormales.xhtml',3),(4,'Torneos','app/admin/verTorneos.xhtml',4),(5,'Reportes','app/admin/reporteUsuarios.xhtml',5),(6,'Formularios','app/admin/formulariosSend.xhtml',6),(7,'Informacion personal','app/admin/informacionPersonal.xhtml',7),(8,'Actualizar informacion persona','app/admin/actualizarInfoPersonal.xhtml',8),(9,'Cambiar estado','app/admin/cambiarEstado.xhtml',2),(10,'Registrar torneo','app/admin/crearTorneo.xhtml',4),(11,'Usuarios administradores','app/admin/usuariosAdmins.xhtml',3),(12,'Usuarios jugadores','app/admin/usuariosJugadores.xhtml',3),(13,'Usuarios profesores','app/admin/usuariosProfesores.xhtml',3),(14,'Inicio','app/aspirante/aspirante.xhtml',14),(15,'Informacion personal','app/aspirante/informacionPersonalAspirante.xhtml',15),(16,'Actualizar informacion personal','app/aspirante/actualizarInfoAspirante.xhtml',15),(17,'Adjuntar Boletin de calificaciones ','app/aspirante/adjuntarBoletin.xhtml',17),(18,'Adjuntar Comprobante de pago','app/aspirante/adjuntarComprobante.xhtml',18),(19,'Formulario de inscripcion','app/aspirante/formulario.xhtml',19),(20,'Inicio','app/jugador/jugador.xhtml',20),(21,'Inicio','app/profesor/profesor.xhtml',21),(22,'Informacion personal','app/profesor/informacionPersonalProfesor.xhtml',22),(23,'Actualizar informacion personal','app/profesor/actualizarInfoProfesor.xhtml',22),(24,'Asistencias','app/profesor/registrarAsistencia.xhtml',24),(25,'Ver asistencias ','app/profesor/listarAsistencias.xhtml',24),(26,'Plantilla de partido ','app/profesor/registrarPlantillaPartido.xhtml',26),(27,'Ver partidos','app/profesor/listarPartidos.xhtml',26),(28,'Seguimientos','app/profesor/nuevoSeguimiento.xhtml',28),(29,'Ver seguimientos ','app/profesor/listarSeguimientos.xhtml',28),(30,'Test fisicos ','app/profesor/registrarTest.xhtml',30),(31,'Test fisicos realizados','app/profesor/listarTest.xhtml',30);
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `noIdentificacion` bigint(12) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `nombre1` varchar(45) NOT NULL,
  `nombre2` varchar(45) DEFAULT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date NOT NULL,
  `telefonoCelular` varchar(15) NOT NULL,
  `telefonoFijo` varchar(15) DEFAULT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) NOT NULL,
  `idTipoIdentificacion` int(11) NOT NULL,
  `idLocalidad` int(11) NOT NULL,
  `barrio` varchar(30) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`noIdentificacion`),
  KEY `fkPeronasDocumentos_idx` (`idTipoIdentificacion`),
  KEY `fkPersonasLocalidades_idx` (`idLocalidad`),
  CONSTRAINT `fkPeronasDocumentos` FOREIGN KEY (`idTipoIdentificacion`) REFERENCES `tiposdocumentos` (`idTipoDocumento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkPersonasLocalidades` FOREIGN KEY (`idLocalidad`) REFERENCES `localidades` (`idLocalidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` (`noIdentificacion`, `idEstado`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `fechaNacimiento`, `telefonoCelular`, `telefonoFijo`, `contrasena`, `correoElectronico`, `idTipoIdentificacion`, `idLocalidad`, `barrio`, `direccion`) VALUES (11111111,1,'Wilson','Fabian','Mora','Mora','1999-02-02','123123','123123','1234','wfmora98@misena.edu.co',1,1,'Villas de granada','Crr 121 #76B- 11'),(22222222,1,'Pedro','Camilo','Ruiz','Guzman','1999-12-12','123213','212312','1234','Rguzman@gmail.com',1,1,'La riviera','Crr 34 # 67A-19'),(33333333,1,'Juan','Sebastian','Fernandez','Diaz','1999-12-12','121221','4345566','1234','SDiaz@gmail.com',1,1,'Villas del dorado','Crr 232 #89C Bis -12'),(44444444,1,'Ruben ','Dario','Montero','Casas','1999-12-11','123213','1231234','1234','rdario34@gmail.com',1,1,'Lisboa','Crr 98 # 34 - B 34 '),(1031170068,2,'Miguel ','Angel','Lopez','Montero','1997-05-18','312938847','238572881','ggizi','Mlopez@gmail.com',1,1,'Marruecos','Crr 45 #98-23'),(99041101489,1,'Camila','Alejandra','Mican','Guzman','1999-04-03','2108873039','3128384','alejandragg','Aguzman@gmail.com',3,3,'Alejandria','Crr 45#09 -90');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`idRol`, `nombreRol`) VALUES (1,'Administrador'),(2,'Profesor'),(3,'Jugador'),(4,'Aspirante');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolesconpermisos`
--

DROP TABLE IF EXISTS `rolesconpermisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolesconpermisos` (
  `idRol` int(11) NOT NULL,
  `idPermiso` int(11) NOT NULL,
  PRIMARY KEY (`idRol`,`idPermiso`),
  KEY `fkRolesconPConPermisos_idx` (`idPermiso`),
  CONSTRAINT `fkRolesconPConPermisos` FOREIGN KEY (`idPermiso`) REFERENCES `permisos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkRolesconPConRoles` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolesconpermisos`
--

LOCK TABLES `rolesconpermisos` WRITE;
/*!40000 ALTER TABLE `rolesconpermisos` DISABLE KEYS */;
INSERT INTO `rolesconpermisos` (`idRol`, `idPermiso`) VALUES (1,2),(1,3),(1,4),(1,5),(1,6);
/*!40000 ALTER TABLE `rolesconpermisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolesdepersonas`
--

DROP TABLE IF EXISTS `rolesdepersonas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolesdepersonas` (
  `idRol` int(11) NOT NULL,
  `noIdentificacion` bigint(12) NOT NULL,
  PRIMARY KEY (`idRol`,`noIdentificacion`),
  KEY `fkRolesConPersonas_idx` (`noIdentificacion`),
  CONSTRAINT `fkRolesConPersonas` FOREIGN KEY (`noIdentificacion`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkRolesConRoles` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolesdepersonas`
--

LOCK TABLES `rolesdepersonas` WRITE;
/*!40000 ALTER TABLE `rolesdepersonas` DISABLE KEYS */;
INSERT INTO `rolesdepersonas` (`idRol`, `noIdentificacion`) VALUES (1,11111111),(2,11111111),(2,22222222),(3,33333333),(4,44444444),(4,99041101489);
/*!40000 ALTER TABLE `rolesdepersonas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimientos`
--

DROP TABLE IF EXISTS `seguimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seguimientos` (
  `idSeguimiento` int(11) NOT NULL AUTO_INCREMENT,
  `noIdentificacionJugador` bigint(12) NOT NULL,
  `nombresJugador` varchar(45) NOT NULL,
  `partidosJugados` int(11) NOT NULL,
  `tallaGuayos` int(11) NOT NULL,
  `testRealizados` int(11) NOT NULL,
  `tallaCamisa` int(11) NOT NULL,
  `tallaPantaloneta` int(11) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `noIdentificacionProfesor` bigint(12) NOT NULL,
  PRIMARY KEY (`idSeguimiento`),
  KEY `fkSeguimientosPersonasJ_idx` (`noIdentificacionProfesor`),
  KEY `fkSeguimientosConIdJugador_idx` (`noIdentificacionJugador`),
  CONSTRAINT `fkSeguimientosConIdJugador` FOREIGN KEY (`noIdentificacionJugador`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkSeguimientosPersonasJ` FOREIGN KEY (`noIdentificacionProfesor`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimientos`
--

LOCK TABLES `seguimientos` WRITE;
/*!40000 ALTER TABLE `seguimientos` DISABLE KEYS */;
INSERT INTO `seguimientos` (`idSeguimiento`, `noIdentificacionJugador`, `nombresJugador`, `partidosJugados`, `tallaGuayos`, `testRealizados`, `tallaCamisa`, `tallaPantaloneta`, `fechaIngreso`, `noIdentificacionProfesor`) VALUES (1,33333333,'Pedro fabian',12,12,12,12,12,'2017-11-10',44444444);
/*!40000 ALTER TABLE `seguimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testfisicos`
--

DROP TABLE IF EXISTS `testfisicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testfisicos` (
  `idTest` int(11) NOT NULL AUTO_INCREMENT,
  `noIdentificacionJugador` bigint(12) NOT NULL,
  `noIdentificacionProfesor` bigint(12) NOT NULL,
  `velocidad` double NOT NULL,
  `altura` double NOT NULL,
  `resistencia` double NOT NULL,
  `fuerza` double NOT NULL,
  `agilidad` double NOT NULL,
  `peso` double NOT NULL,
  PRIMARY KEY (`idTest`),
  KEY `fkTestConPersonasJ_idx` (`noIdentificacionJugador`),
  KEY `fkTestConPersonasP_idx` (`noIdentificacionProfesor`),
  CONSTRAINT `fkTestConPersonasJ` FOREIGN KEY (`noIdentificacionJugador`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkTestConPersonasP` FOREIGN KEY (`noIdentificacionProfesor`) REFERENCES `personas` (`noIdentificacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testfisicos`
--

LOCK TABLES `testfisicos` WRITE;
/*!40000 ALTER TABLE `testfisicos` DISABLE KEYS */;
INSERT INTO `testfisicos` (`idTest`, `noIdentificacionJugador`, `noIdentificacionProfesor`, `velocidad`, `altura`, `resistencia`, `fuerza`, `agilidad`, `peso`) VALUES (1,33333333,44444444,123123.1,1231.2,12312.1,1213.1,1213.1,12312.1);
/*!40000 ALTER TABLE `testfisicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopartido`
--

DROP TABLE IF EXISTS `tipopartido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopartido` (
  `idTipoPartido` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTipoPartido` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoPartido`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopartido`
--

LOCK TABLES `tipopartido` WRITE;
/*!40000 ALTER TABLE `tipopartido` DISABLE KEYS */;
INSERT INTO `tipopartido` (`idTipoPartido`, `nombreTipoPartido`) VALUES (1,'Entrenamiento'),(2,'Amistoso'),(3,'Competitivo');
/*!40000 ALTER TABLE `tipopartido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposalineaciones`
--

DROP TABLE IF EXISTS `tiposalineaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposalineaciones` (
  `idTipoAlineacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombreAlineacion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoAlineacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposalineaciones`
--

LOCK TABLES `tiposalineaciones` WRITE;
/*!40000 ALTER TABLE `tiposalineaciones` DISABLE KEYS */;
INSERT INTO `tiposalineaciones` (`idTipoAlineacion`, `nombreAlineacion`) VALUES (1,'4.2.4'),(2,'3.3.2.2'),(3,'4.4.2'),(4,'5.2.2.1'),(5,'3.5.2');
/*!40000 ALTER TABLE `tiposalineaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposdesangre`
--

DROP TABLE IF EXISTS `tiposdesangre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposdesangre` (
  `idRh` int(11) NOT NULL AUTO_INCREMENT,
  `rh` varchar(45) NOT NULL,
  PRIMARY KEY (`idRh`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposdesangre`
--

LOCK TABLES `tiposdesangre` WRITE;
/*!40000 ALTER TABLE `tiposdesangre` DISABLE KEYS */;
INSERT INTO `tiposdesangre` (`idRh`, `rh`) VALUES (1,'B+'),(2,'B-'),(3,'O+'),(4,'O-'),(5,'A+'),(6,'A-'),(7,'AB+'),(8,'AB-');
/*!40000 ALTER TABLE `tiposdesangre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposdocumentos`
--

DROP TABLE IF EXISTS `tiposdocumentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposdocumentos` (
  `idTipoDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(45) DEFAULT NULL,
  `sigla` varchar(5) NOT NULL,
  PRIMARY KEY (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposdocumentos`
--

LOCK TABLES `tiposdocumentos` WRITE;
/*!40000 ALTER TABLE `tiposdocumentos` DISABLE KEYS */;
INSERT INTO `tiposdocumentos` (`idTipoDocumento`, `documento`, `sigla`) VALUES (1,'Cedula','C.C'),(2,'Tarjeta de identidad','T.I'),(3,'Cedula extranjera','C.E'),(4,'Pasaporte','PAS');
/*!40000 ALTER TABLE `tiposdocumentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipostorneos`
--

DROP TABLE IF EXISTS `tipostorneos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipostorneos` (
  `idTipoTorneo` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTipoTorneo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoTorneo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipostorneos`
--

LOCK TABLES `tipostorneos` WRITE;
/*!40000 ALTER TABLE `tipostorneos` DISABLE KEYS */;
INSERT INTO `tipostorneos` (`idTipoTorneo`, `nombreTipoTorneo`) VALUES (1,'Entrenamiento'),(2,'Competitivo'),(3,'Amistosos');
/*!40000 ALTER TABLE `tipostorneos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torneos`
--

DROP TABLE IF EXISTS `torneos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `torneos` (
  `idTorneo` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoTorneo` int(11) NOT NULL,
  `lugarTorneo` varchar(45) DEFAULT NULL,
  `duracion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTorneo`),
  KEY `fkTorneosConTiposTorneos_idx` (`idTipoTorneo`),
  CONSTRAINT `fkTorneosConTiposTorneos` FOREIGN KEY (`idTipoTorneo`) REFERENCES `tipostorneos` (`idTipoTorneo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneos`
--

LOCK TABLES `torneos` WRITE;
/*!40000 ALTER TABLE `torneos` DISABLE KEYS */;
INSERT INTO `torneos` (`idTorneo`, `idTipoTorneo`, `lugarTorneo`, `duracion`) VALUES (1,1,'Escuela','Sin limite');
/*!40000 ALTER TABLE `torneos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sifcnuevo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-14 21:47:38
