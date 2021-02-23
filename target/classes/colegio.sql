-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 22-10-2018 a las 04:19:29
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.1.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `colegio`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarAlumnoXApellido` (IN `in_ape` VARCHAR(40))  NO SQL
select nombres, apellidos, edad, nombre as localidad, zona, provincia from alumnos, localidades where alumnos.localidad = localidades.id and alumnos.apellidos like concat (in_ape, "%")$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarAlumnoXId` (IN `in_id` INT)  NO SQL
select nombres, apellidos, edad, nombre as localidad, zona, provincia from alumnos, localidades where alumnos.localidad = localidades.id and alumnos.id = in_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarLocalidad` (IN `in_id` INT)  NO SQL
select nombre from localidades where id = in_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEnAlumnos` (IN `in_nombre` VARCHAR(30), IN `in_apellido` VARCHAR(30), IN `in_edad` INT(2), IN `in_direccion` VARCHAR(50), IN `in_localidad` VARCHAR(50))  NO SQL
INSERT INTO `alumnos`(`id`, `nombres`, `apellidos`, `edad`, `direccion`, `localidad`) VALUES (null,in_nombre,in_apellido,in_edad,in_direccion,(SELECT `id` from `localidades` WHERE `localidades`.`nombre` = in_localidad))$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listadoAlumnos` ()  NO SQL
select  nombres, apellidos, edad, direccion, nombre as localidad, zona, provincia from alumnos, localidades where alumnos.localidad = localidades.id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listadoAlumnosXEdadMayor` (IN `in_edad` INT)  NO SQL
select nombres, apellidos, edad, nombre as localidad, zona, provincia from alumnos, localidades where alumnos.localidad = localidades.id and alumnos.edad >= in_edad order by apellidos$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listadoAlumnoXLocalidad` (IN `in_loc` VARCHAR(40))  NO SQL
select nombres, apellidos, edad, nombre as localidad, zona, provincia from alumnos, localidades where alumnos.localidad = localidades.id and localidades.nombre like concat (in_loc, "%")$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listadoLocalidades` ()  NO SQL
select id, nombre from localidades order by nombre$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listadoLocalidadesXZona` (IN `in_zona` VARCHAR(30))  NO SQL
select id, nombre from localidades where zona = in_zona$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listadoZonas` ()  NO SQL
select distinct zona from localidades$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id` int(3) NOT NULL,
  `nombres` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `edad` int(2) NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `localidad` int(3) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `nombres`, `apellidos`, `edad`, `direccion`, `localidad`) VALUES
(1, 'Angie', 'Lione', 15, 'Por alla 33', 33),
(2, 'Matias', 'Garcia', 16, 'Aca a la vuelta 150', 1),
(3, 'Ramiro', 'Lopez', 13, 'Av Sarasa 2123', 2),
(4, 'Maria Lorena', 'Shulls', 14, 'En la Esquina 25', 1),
(5, 'Rodrigo', 'Muscari', 14, 'Otro Lado 973', 6),
(6, 'Daniela', 'Rivas', 15, 'Cerca 3421', 12),
(7, 'Jorge', 'Serrat', 17, 'Bella Vista 3421', 1),
(8, 'Mariana', 'Bonaditta', 15, 'En frente 3452', 35),
(9, 'Juliana', 'Echeverria', 14, 'Por la esquina 3453', 7),
(10, 'Luis', 'Olazabal', 12, 'Lejos 3423', 38),
(11, 'Patricia', 'Lorenzetti', 17, 'De tras de 3423', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidades`
--

CREATE TABLE `localidades` (
  `id` int(3) NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `zona` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `provincia` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `localidades`
--

INSERT INTO `localidades` (`id`, `nombre`, `zona`, `provincia`) VALUES
(1, 'CABA', 'CABA', 'Buenos Aires'),
(2, 'Vicente Lopez', 'GBA Norte', 'Buenos Aires'),
(3, 'San Isidro', 'GBA Norte', 'Buenos Aires'),
(4, 'San Martín', 'GBA Norte', 'Buenos Aires'),
(5, 'San Fernando', 'GBA Norte', 'Buenos Aires'),
(6, 'Tigre', 'GBA Norte', 'Buenos Aires'),
(7, 'Avellaneda', 'GBA Sur', 'Buenos Aires'),
(8, 'Dock Sud', 'GBA Sur', 'Buenos Aires'),
(9, 'Gerli', 'GBA Sur', 'Buenos Aires'),
(10, 'Pineyro', 'GBA Sur', 'Buenos Aires'),
(11, 'Gerli', 'GBA Sur', 'Buenos Aires'),
(12, 'Sarandi', 'GBA Sur', 'Buenos Aires'),
(13, 'Villa Dominico', 'GBA Sur', 'Buenos Aires'),
(14, 'Wilde', 'GBA Sur', 'Buenos Aires'),
(15, 'San Justo', 'GBA Oeste', 'Buenos Aires'),
(16, 'Aldo Bonzi', 'GBA Oeste', 'Buenos Aires'),
(17, 'Ciudad Evita', 'GBA Oeste', 'Buenos Aires'),
(18, 'González Catán', 'GBA Oeste', 'Buenos Aires'),
(19, 'Gregorio de Laferrere', 'GBA Oeste', 'Buenos Aires'),
(20, 'Isidro Casanova', 'GBA Oeste', 'Buenos Aires'),
(21, 'La Tablada', 'GBA Oeste', 'Buenos Aires'),
(22, 'Lomas del Mirador', 'GBA Oeste', 'Buenos Aires'),
(23, 'Rafael Castillo', 'GBA Oeste', 'Buenos Aires'),
(24, 'Ramos Mejía', 'GBA Oeste', 'Buenos Aires'),
(25, 'Tapiales', 'GBA Oeste', 'Buenos Aires'),
(26, 'Villa Luzuriaga', 'GBA Oeste', 'Buenos Aires'),
(27, 'Villa Madero', 'GBA Oeste', 'Buenos Aires'),
(28, 'Virrey del Pino', 'GBA Oeste', 'Buenos Aires'),
(29, 'Lanús', 'GBA Sur', 'Buenos Aires'),
(30, 'Monte Chingolo', 'GBA Sur', 'Buenos Aires'),
(31, 'El Talar', 'GBA Norte', 'Buenos Aires'),
(32, 'Don Torcuato', 'GBA Norte', 'Buenos Aires'),
(33, 'Martínez', 'GBA Norte', 'Buenos Aires'),
(34, 'Boulogne', 'GBA Norte', 'Buenos Aires'),
(35, 'Munro', 'GBA Norte', 'Buenos Aires'),
(36, 'Villa Ballester', 'GBA Norte', 'Buenos Aires'),
(37, 'Ombú', 'GBA Norte', 'Buenos Aires'),
(38, 'Churruca', 'GBA Norte', 'Buenos Aires'),
(39, 'El Palomar', 'GBA Norte', 'Buenos Aires'),
(40, 'Caseros', 'GBA Norte', 'Buenos Aires'),
(41, 'Santos Lugares', 'GBA Norte', 'Buenos Aires'),
(42, 'Lomas de Zamora', 'GBA Sur', 'Buenos Aires'),
(43, 'Banfield', 'GBA Sur', 'Buenos Aires'),
(44, 'Temperley', 'GBA Sur', 'Buenos Aires'),
(45, 'Llavallol', 'GBA Sur', 'Buenos Aires'),
(46, 'Turdera', 'GBA Sur', 'Buenos Aires'),
(47, 'Villa Centenario', 'GBA Sur', 'Buenos Aires'),
(48, 'Villa Fiorito', 'GBA Sur', 'Buenos Aires'),
(49, 'Ingeniero Budge', 'GBA Sur', 'Buenos Aires'),
(50, 'Villa Albertina', 'GBA Sur', 'Buenos Aires'),
(51, 'Olivos', 'GBA Norte', 'Buenos Aires');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `localidad` (`localidad`);

--
-- Indices de la tabla `localidades`
--
ALTER TABLE `localidades`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`localidad`) REFERENCES `localidades` (`id`),
  ADD CONSTRAINT `fk_loc` FOREIGN KEY (`Localidad`) REFERENCES `localidades` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
