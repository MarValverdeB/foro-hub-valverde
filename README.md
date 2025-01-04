# ForoHub REST API ✨

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)](https://www.mysql.com/)
[![Flyway](https://img.shields.io/badge/Flyway-8.0-red)](https://flywaydb.org/)

ForoHub es un proyecto que implementa un API REST construido con Spring Boot. Provee las funcionalidades CRUD para Topicos.

---

## 🌐 Características

- **Operaciones CRUD** for Topics, Responses, Users, and Courses.
- **Optimistic Locking** uso de `@Version` en las entidades para el control de la concurrencia.
- **Integración con Flyway** para migraciones de esquemas de base de datos.
- **Conversión de Entity a DTO**.
- **Exception Handling** Manejo de Excepcociones.
- **Paginación y Sorting** Implementado con Spring Data JPA.

---

## 🔧 Stack Tecnológico

- **Java 17**
- **Spring Boot 3.0**
    - Spring Data JPA
    - Spring Web
    - Spring Validation
- **MySQL 8.0**
- **Flyway**
- **Lombok** 
- **Gradle** 

---

## ⚙️ Prerequisitos

1. **Java 17** .
2. **MySQL 8.0**.
3. Base de datos creada `ForoDB`.
4. **Flyway**.

---

## ⚖️ Endpoints API

### **Topic Endpoints**

- **Crear Topico**
  ```http
  POST /topicos
  ```
  Request Body:
  ```json
  {
    "titulo": "Topico de Ejemplo",
    "mensaje": "Mensaje de ejemplo.",
    "cursoId": 1,
    "autorId": 1
  }
  ```

- **Get Topics (con Paginación)**
  ```http
  GET /topicos?page=0&size=10&sort=fechaCreacion,asc
  ```

- **Actualizar Topico**
  ```http
  PUT /topicos/{id}
  ```

- **Borrar Topico**
  ```http
  DELETE /topicos/{id}
  ```

---

## 📚 Esquema de Base de datos

### Tablas

1. **Usuario**
2. **Curso**
3. **Topico**
4. **Respuesta**
5. **Perfil**
6. **Usuario_Perfil** (Tabla unión para la relación Many-to-Many)

### Relaciones

- **One-to-Many:** `Curso` a `Topico`
- **One-to-Many:** `Usuario` a `Topico`
- **One-to-Many:** `Usuario` a `Respuesta`
- **One-to-Many:** `Topico` a `Respuesta`
- **Many-to-Many:** `Usuario` a `Perfil`

---

## 🚀 Inicio

### 1. Clonar el Repositorio
```bash
$ git clone https://github.com/your-repo/ForoHub.git
$ cd ForoHub
```

### 2. Configuración de Base de datos
Actualizar el archivo `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ForoDB
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=none
```

### 3. Ejecutar la aplicación
```bash
$ ./gradlew spring-boot:run
```

### 4. Access the API
API is available at: `http://localhost:8080/topicos`

---

## 📈 Ejemplo DTOs

### **TopicoDTO**
```java
public class TopicoDTO {
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private String cursoNombre;
    private String autorNombre;
}
```

## 🔧 Herramientas Utilizadas

- **Postman** para probar las APIs
- **IntelliJ IDEA** IDE de desarrollo

---

## 🔒 Licencia

Este proyecto está bajo la licencia MIT. Ver `LICENSE` para más detalles.

