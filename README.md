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