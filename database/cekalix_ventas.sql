CREATE DATABASE IF NOT EXISTS cekalix_ventas
    CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE cekalix_ventas;

CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    clave VARCHAR(100) NOT NULL,
    rol VARCHAR(30) NOT NULL DEFAULT 'VENDEDOR',
    activo TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(40) NOT NULL UNIQUE,
    nombre VARCHAR(120) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL DEFAULT 0,
    stock INT NOT NULL DEFAULT 0,
    activo TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS venta (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(150) NOT NULL,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(12,2) NOT NULL DEFAULT 0,
    estado VARCHAR(30) NOT NULL DEFAULT 'REGISTRADA'
);

-- Clave en texto plano solo para probar localmente este prototipo académico.
INSERT INTO usuario (nombre, usuario, clave, rol)
VALUES ('Administrador', 'admin', 'admin123', 'ADMIN')
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);

INSERT INTO producto (sku, nombre, descripcion, precio, stock)
VALUES
('SKU-0001', 'Producto de ejemplo A', 'Registro de demostración', 25.00, 100),
('SKU-0002', 'Producto de ejemplo B', 'Registro de demostración', 48.50, 50)
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);
