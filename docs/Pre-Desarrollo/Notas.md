## MVC

- Modelo: Datos y lógica de negocio. Clases de entidad [Documento, Libro, Ponencia, ArticuloCientifico, Usuario, etc ]
- Vista
- Controlador: Gestiona la interacción entre la vista y el modelo. Procesar las solicitudes del usuario, llamar a la lógica de negocio y devolver respuestas

Ejemplo Implementación:

- DocumentoController → manejara las peticiones relacionadas con documentos
- UsuarioController → manejara la autenticación y gestión de usuarios
- ReservaController → gestionara las reservas y devoluciones

## Patrones de Creación

### Factory Method

Se usa en la creación de diferentes tipos de documentos [Libro, Ponencia, ArticuloCientifico]

### Singleton

En la gestión de la conexión de la base de datos y las clases DAO

## Patrones Estructurales

### DAO

En la capa de acceso a datos, para separar la lógica de acceso a la BD del resto de la app

### DTO

Para transferir datos entre capas sin exponer directamente las entidades

## Patrones de Comportamiento

### Observer

Para notificar a los usuarios cuando se modifica un documento o cambia su estado de reserva

### Command

Para encapsular acciones como “Crear documento”, “Modificar documento” y “Eliminar documento”

### State

Permite que un objeto cambie su comportamiento cuando cambia su estado interno. En la gestión del estado de los documentos [Disponible, Reservado, Dado de baja]

### Chain of Responsibility

En el control de permisos cuando un usuario intenta modificar o eliminar un documento.  Se pueden definir reglas como:

1. Verificar si el usuario es el creador del documento
2. Si no lo es, rechazar la operación
