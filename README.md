# Proyecto Tienda - Backend

Hola, este es mi proyecto para el curso. Es una API REST que hice usando Java y Spring Boot. La verdad soy bastante nuevo con Java asi que fui aprendiendo sobre la marcha, pero el codigo cumple con los requerimientos. 

El sistema sirve para llevar el inventario de una tienda. Basicamente pedes crear categorias y despues agregar productos y decir a que categoria pertenecen. Todo esto se guarda en una base de datos en MySQL.

## Tecnologias que use
* Java 17
* Spring Boot
* Spring Data JPA para la persistencia
* MySQL (lo corro con XAMPP para no complicarme)
* Postman para ir probando que las rutas funcionen
* Hibernate Validator

## Como organice las carpetas
Trate de seguir la arquitectura en capas que nos pidieron para que quede ordenado:
* model: aca estan los moldes como Producto y Categoria. Tienen una relacion de muchos a uno.
* repository: los archivos que se encargan de hablar con la base de datos.
* service: aca meti la logica de negocio y los filtros.
* controller: son los puntos de entrada o urls que llamamos desde el frontend o postman.
* exception: arme esto para que si hay un error (como buscar un id que no existe) tire un mensaje de texto claro y no rompa todo el programa.

## Rutas de la API

### Para las categorias (/api/categorias)
* GET /api/categorias - te trae todas las categorias guardadas

* POST /api/categorias - crea una categoria nueva

### Para los productos (/api/productos)
* GET /api/productos - lista de todos los productos
* POST /api/productos - guarda un producto. le puse unas reglas para que el nombre no quede en blanco y el precio sea positivo
* PUT /api/productos/{id} - para modificar un producto
* DELETE /api/productos/{id} - para borrarlo

### Consultas avanzadas
* GET /api/productos/categoria/{categoriaId} - hice este filtro para listar los productos pero filtrados por su categoria

## Detalles extra
* Le configure el CORS permitiendo cualquier origen para poder conectarlo con un front en React despues.
* Las validaciones de datos atajan errores antes de que lleguen a la base de datos.

Desarrollado por Daniel Sandoval para el proyecto de java TalentoTech