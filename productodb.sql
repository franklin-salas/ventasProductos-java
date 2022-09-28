-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-10-2019 a las 18:46:45
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.1.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `producto_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `combo`
--

CREATE TABLE `combo` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_producto` int(10) UNSIGNED NOT NULL,
  `id_compuesto` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `combo`
--

INSERT INTO `combo` (`id`, `id_producto`, `id_compuesto`) VALUES
(25, 2, 25),
(26, 22, 25),
(27, 4, 23),
(28, 1, 23),
(29, 22, 23),
(30, 4, 26),
(31, 1, 26),
(32, 22, 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(10) UNSIGNED NOT NULL,
  `codigo` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `precio` double(8,2) NOT NULL,
  `nota` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cantidad` int(10) UNSIGNED NOT NULL,
  `type` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `codigo`, `descripcion`, `precio`, `nota`, `cantidad`, `type`) VALUES
(1, 'P-001', 'RAM-800Hz ', 50.00, 'En 50 $ -> 350 Bs', 20, 'Simple'),
(2, 'P-002', 'RAM-1200Hz ', 55.00, '20$ -> 140Bs', 20, 'Simple'),
(4, 'P-003', 'Targeta Asrock -3100 1200Hz ', 60.00, 'i5- i7 4ta generación', 5, 'Simple'),
(18, 'jhuh', 'javi', 4.00, '', 0, 'Simple'),
(19, '444', 'lara', 5.00, '', 0, 'Simple'),
(21, 'P-004', 'Targeta Asrock -3100 1800Hz ', 60.00, 'i5- i7 4ta generación', 5, 'Simple'),
(22, 'P-005', 'Targeta Asrock -3100 1800Hz  Copia', 60.00, 'i5- i7 4ta generación', 5, 'Simple'),
(23, 'P-009', 'compuesto', 0.00, '', 3, 'Compuesto'),
(24, 'P-0014', 'RAM-800Hz  copia', 50.00, 'En 50 $ -> 350 Bs', 50, 'Simple'),
(25, 'P-010', 'Pc -Basica ', 0.00, '', 0, NULL),
(26, 'EEE-1', 'ram-000', 20.00, '', 15, 'Compuesto');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `combo`
--
ALTER TABLE `combo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `combo_id_producto_foreign` (`id_producto`),
  ADD KEY `combo_id_compuesto_foreign` (`id_compuesto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `combo`
--
ALTER TABLE `combo`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `combo`
--
ALTER TABLE `combo`
  ADD CONSTRAINT `combo_id_compuesto_foreign` FOREIGN KEY (`id_compuesto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `combo_id_producto_foreign` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
