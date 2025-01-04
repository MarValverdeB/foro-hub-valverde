-- V1__Create_tables.sql

-- Create Table: Topico
CREATE TABLE topico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    usuario VARCHAR(50),
    curso VARCHAR(200)
);

