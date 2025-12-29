# Servicio de Productos

Este proyecto es una API RESTful desarrollada con Spring Boot para la gestión de productos. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos MySQL.

## Tecnologías Utilizadas

*   **Java 21**
*   **Spring Boot 3** (Web, Data JPA, Validation)
*   **MySQL** (Base de datos)
*   **Lombok**
*   **Docker** y **Docker Compose**

## Requisitos Previos

*   Docker y Docker Compose instalados.
*   Java 21.
*   Maven.

## Configuración

## Configuración de Variables de Entorno

El proyecto utiliza variables de entorno para configurar la conexión a la base de datos y otros parámetros. Se incluye un archivo de ejemplo `.example.env`.

1.  Copia el archivo de ejemplo:
    ```bash
    cp .example.env .env
    ```
2.  Edita el archivo `.env` con tus credenciales y configuración deseada:
    ```properties
    DB_URL=jdbc:mysql://mysql:3306/bd_service
    DB_USER=tu_usuario
    DB_PASSWORD=tu_contraseña
    MYSQL_ROOT_PASSWORD=tu_contraseña_root
    ```

## Ejecución con Docker

El proyecto está totalmente contenerizado. `docker-compose` se encarga de construir la imagen de la aplicación (usando el `Dockerfile` presente) y levantar la base de datos MySQL.

1.  **Generar el JAR (Opcional si el Dockerfile no tiene multi-stage build):**
    Si tu Dockerfile copia el JAR desde `target/`, asegúrate de empaquetar la aplicación primero:
    ```bash
    ./mvnw clean package
    ```

2.  **Levantar los servicios:**
    Ejecuta el siguiente comando en la raíz del proyecto:
    ```bash
    docker-compose up --build
    ```

    Esto realizará lo siguiente:
    *   Construirá la imagen de la aplicación `servicio-productos` usando el `Dockerfile`.
    *   Iniciará el contenedor de MySQL (`mysql_container_java`).
    *   Iniciará el contenedor de la aplicación (`servicio_productos`) en el puerto `3000`.

## Endpoints Principales

La API estará disponible en `http://localhost:3000/api/productos`.

*   `GET /api/productos`: Obtener todos los productos.
*   `POST /api/productos`: Crear un nuevo producto.
    *   Body:
        ```json
        {
            "nombre": "Producto Ejemplo",
            "precio": 100.0,
            "cantidad": 10
        }
        ```
*   `PATCH /api/productos/{id}`: Actualizar un producto existente.
*   `DELETE /api/productos/{id}`: Eliminar un producto.

## Estructura del Proyecto

El proyecto sigue una arquitectura en capas:
*   `controller`: Controladores REST.
*   `service`: Lógica de negocio.
*   `repository`: Acceso a datos (JPA).
*   `model`: Entidades JPA.
*   `dto`: Objetos de transferencia de datos.
*   `mapper`: Conversión entre Entidades y DTOs.
*   `exception`: Manejo global de excepciones.
