# Todo App 

## Clase 01
1. Inicio de proyecto
2. Estructura de carpetas, dependencias para APIs y RestapisApplication
3. Desarrollar los POJOS(Plain Old Java Object)
4. REST APIs

## Clase 02
1. Configuración H2
2. De Clase a Entidades
3. Implementando CRUD con Spring Data 
   - Implementación de las interfaces
   - Implementación de los servicios
5. Finders - JPA
6. Paginación y Ordenamiento

## Clase 03
1. Implementación de los finders
   - Finders
   - Query Methods
   - Named Queries
2. Validaciones
   - Bean Validation usando Hibernate Validator
   - Validaciones personalizadas
3. Eventos del dominio
   - Concepto: Cuando genere un nuevo Todo que hay un evento que diga "Se ha creado un Todo"
   - Escuchador de eventos: 
     - Vamos a implementar en la capa service un escuchador de eventos para que sea notificado cuando un objeto Todo es guardado a través del TodoRepository
4. Spring Data REST
   - Agregamos las dependencias de Spring Data REST
   - Agregar repositorio REST para la entidad Todo y TodoType
5. Etags: 
   - Concepto: Un etags es un header que viene en el response y que determina una version específica de un recurso
   - Para que lo usan: 
     - Para que el servidor web No envie una respuesta completa si el contenido no ha cambiado
     - Cache web
     - Ahorro de ancho de banda
    - Implementación:
      - Hay que usar filtros, porque ese filtro va a generar un etag basado en el contenido de la respuesta y agrega al header de cada request