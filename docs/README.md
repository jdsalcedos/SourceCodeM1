# Proyecto Final Modelos 1

## Instrucciones para el funcionamiento de la aplicación

### Instalación de Xampp

1. Ir a la pagina de [Xampp](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiDoujBvrKLAxUrTDABHWl2OqwQmuEJegQIDRAB&url=https%3A%2F%2Fwww.apachefriends.org%2Fes%2Fdownload.html&usg=AOvVaw2MTR-3Oi4uQnt6xgaEM9p2&opi=89978449) e instalar la versión **8.0.30**.
2. Ejecutar el archivo descargado y seguir todos los pasos de la instalación.
3. Ejecutar **Xampp Control Panel** como administrador.
4. Al iniciar la Xampp se deben prender el modulo de **Apache** y el modulo de **MySQL**.
5. Oprimir en el botón **Admin** del modulo **MySQL**. En esta pagina usted podrá ver, crear, modificar y eliminar sus bases de datos las cuales están alojadas localmente.
6. Para importar la base de datos del proyecto, se debe crear una nueva base de datos que se llame *"biblioteca"* (para esto diríjase al panel izquierdo y oprima el botón **Nueva**). Posteriormente, en la parte superior oprima el botón **Importar**, en el apartado de *selección archivo* utilice el archivo llamado biblioteca.sql (el cual se encuentra en la carpeta **docs** del proyecto) y presione el botón **importar**.

### Configuración para el funcionamiento de la Base de Datos

Aquí podrá encontrar la configuración que debe tener en su computador y en el proyecto para que el aplicativo funcione correctamente.

---

## Carpetas
### *docs* 
> Se alojan la abstracción de los datos pre-desarrollo, links de desarrollo, el diagrama entidad-relación, el diagrama uml, documentos complementarios y el enunciado de los requerimientos.

### *src*
> Se aloja el código fuente del aplicativo, con sus clases correspondientes y lógica.