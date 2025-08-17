package com.desdeaquisenombraelresto.especificacionesDelProjecto;
/**
 * DOCUMENTACIÓN DE LA ESTRUCTURA DEL PROYECTO
 *
 * Esta clase NO es funcional y NO debe ser ejecutada.
 * Solo sirve para documentar la arquitectura del proyecto.
 */
public class EstructuraProyecto {

    // ======================================================
    // PAQUETE PRINCIPAL: com.desdeaquisenombraelresto.Curriculum
    // ======================================================

    /**
     * DemoApplication.java - Punto de entrada de la aplicación Spring Boot
     * Contiene el método main() y la anotación @SpringBootApplication
     */

    // ======================================================
    // SUPAQUETES DEL PROYECTO
    // ======================================================

    // 1. PAQUETE: Controller
    //    Responsabilidad: Manejar peticiones HTTP y devolver respuestas
    //    Ejemplos:
    //      - UserController.java
    //      - EducationController.java
    //      - ContactMessageController.java
    //    Anotaciones típicas: @RestController, @GetMapping, @PostMapping

    // 2. PAQUETE: DTO (Data Transfer Objects)
    //    Responsabilidad: Transferir datos entre capas sin exponer el modelo interno
    //    Ejemplos:
    //      - UserDTO.java
    //      - EducationDTO.java
    //      - ContactMessageDTO.java
    //    Características:
    //      - Solo contienen campos y getters/setters
    //      - Sin lógica de negocio

    // 3. PAQUETE: Model (Entidades)
    //    Responsabilidad: Representar las tablas de la base de datos
    //    Subpaquetes:
    //      - ContactMessage.java (mensajes de contacto)
    //      - Education.java (formación académica)
    //      - Experience.java (experiencia laboral)
    //      - Project.java (proyectos personales)
    //      - Skill.java (habilidades técnicas)
    //      - User.java (información de usuario)
    //    Anotaciones típicas: @Entity, @Id, @GeneratedValue

    // 4. PAQUETE: Repository
    //    Responsabilidad: Acceso a datos y operaciones con la base de datos
    //    Ejemplos:
    //      - UserRepository.java (interface que extiende JpaRepository)
    //      - EducationRepository.java
    //      - ContactMessageRepository.java
    //    Características:
    //      - Interfaces con métodos como findByEmail(), findAll(), etc.

    // 5. PAQUETE: Service
    //    Responsabilidad: Contener la lógica de negocio
    //    Estructura típica:
    //      - UserService.java (interfaz con definiciones de métodos)
    //      - UserServiceImpl.java (implementación concreta)
    //    Anotaciones típicas: @Service, @Transactional

    // ======================================================
    // FLUJO TÍPICO DE UNA PETICIÓN
    // ======================================================

    /**
     * Ejemplo: Obtener información de usuario
     *
     * 1. Cliente -> HTTP GET /api/users/{id}
     * 2. UserController (@GetMapping) recibe la petición
     * 3. UserController llama a UserService.getUserById(id)
     * 4. UserServiceImpl implementa la lógica:
     *    - Valida parámetros
     *    - Llama a UserRepository.findById(id)
     *    - Convierte entidad User a UserDTO
     * 5. UserService devuelve UserDTO al Controller
     * 6. Controller devuelve respuesta HTTP con UserDTO
     */

    // ======================================================
    // RECURSOS EXTERNOS
    // ======================================================

    /**
     * Directorio: src/main/resources/static
     *    - Contiene archivos estáticos (HTML, CSS, JS, imágenes)
     *    - Accesibles directamente desde la raíz del servidor
     *      Ej: http://localhost:8080/imagenes/avatar.png
     */

    // ======================================================
    // DEPENDENCIAS PRINCIPALES
    // ======================================================

    /*
     * - Spring Boot Starter Web (REST APIs)
     * - Spring Boot Starter Data JPA (base de datos)
     * - MySQL Connector (conexión a MySQL)
     * - Lombok (simplificar código boilerplate)
     * - H2 Database (base de datos en memoria para pruebas)
     */

    // ======================================================
    // BUENAS PRÁCTICAS IMPLEMENTADAS
    // ======================================================

    /**
     * - Separación en capas (Controller-Service-Repository-Model)
     * - Uso de DTOs para transferencia de datos
     * - Inyección de dependencias (@Autowired)
     * - Gestión transaccional (@Transactional)
     * - Validación de datos (@Valid)
     */

    // Clase no instanciable
    private EstructuraProyecto() {
        throw new AssertionError("Esta clase no debe ser instanciada");
    }
}