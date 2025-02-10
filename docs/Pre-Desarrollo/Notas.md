## MVC

- Modelo: Datos y lógica de negocio. Clases de entidad [Documento, Libro, Ponencia, ArticuloCientífico, Usuario, etc ]
- Vista
- Controlador: Gestiona la interacción entre la vista y el modelo. Procesar las solicitudes del usuario, llamar a la lógica de negocio y devolver respuestas

Ejemplo Implementación:

- DocumentoController → manejara las peticiones relacionadas con documentos
- UsuarioController → manejara la autenticación y gestión de usuarios
- ReservaController → gestionara las reservas y devoluciones

## Patrones de Creación

### Factory Method

Se usa en la creación de diferentes tipos de documentos [Libro, Ponencia, ArticuloCientífico]

### Singleton

En la gestión de la conexión de la base de datos y las clases DAO

## Patrones Estructurales

### DAO

En la capa de acceso a datos, para separar la lógica de acceso a la BD del resto de la app

### DTO

Para transferir datos entre capas sin exponer directamente las entidades

### Facade

Para reservas:
#### Verifica Estado

**SI**
   1. llena los datos
   2. realiza la reserva
   3. actualizar HistorialCambios
   
**Si no**
  1. cancelar transacción
  2. desplegar mensaje

## Patrones de Comportamiento

### Visitor

Permite utilizar una consulta diferente dependiendo del objeto (libro, ponencia, articulo) para añadir los datos a las respectivas tablas en la base de datos 

### State

Permite que un objeto cambie su comportamiento cuando cambia su estado interno. En la gestión del estado de los documentos [Disponible, Reservado, Dado de baja]

