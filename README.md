# 🛒 Market Developer API REST

API REST construida con **Spring Boot 3**, desarrollada para la plataforma _Market Developer_.  
Proporciona endpoints seguros, documentados y listos para integraciones con frontend u otros sistemas.

---

## ⚙️ Tecnologías principales

- **Spring Boot 3** → Framework para crear aplicaciones Java modernas y robustas.
- **Spring Security + JWT** → Autenticación y autorización seguras con JSON Web Tokens.
- **Swagger (OpenAPI)** → Documentación interactiva para probar los endpoints.
- **MapStruct** → Mapeo automático entre DTOs y entidades.
- **PostgreSQL** → Base de datos relacional.

📖 Documentación en vivo:  
👉 [Swagger UI - Market API](https://market.fabiocordoba.me/fabio/api/swagger-ui/index.html)

---

## 🚀 Características principales

- 🔑 Login y autenticación con JWT.
- 🔒 Endpoints protegidos mediante roles y permisos.
- 🗂️ Mapeo eficiente de entidades con MapStruct.
- 📑 Documentación Swagger disponible en producción.
- 🐘 Integración con PostgreSQL para persistencia de datos.

---

## 🛠️ Cómo ejecutar el proyecto localmente

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/fabioCordoba/market.git
cd market
```

### 2️⃣ Configurar variables en application.properties

Ubicado en src/main/resources/application.properties:

```bash
server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/tu_db
spring.datasource.username=usuario
spring.datasource.password=clave

jwt.secret=claveSuperSecreta
jwt.expiration-in-ms=3600000
```

### 3️⃣ Compilar y ejecutar

```bash
./gradlew bootRun
```

### 4️⃣ Probar la API

Accede a:

```bash
👉 http://localhost:8080/swagger-ui/index.html
```
