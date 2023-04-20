# NttData
### La siguiente aplicacion consta de las siguientes funcionalideas
* CRUD de Clientes
* CRUD de Cuentas
* Consulta de Movimientos
* Creacion de Movimiento
* Consulta de Estado de cuentas

### tecnologias/patrones usados
* jdk 17
* junit5
* Repository
* Clean Architecture
* Hexagonal architecture
* SOLID

## Para levantar el proyecto
clonar proyecto
`git clone https://github.com/ismaelviss/NttData.git`

Abrir proyecto con el IDE de preferencia y configurar las credenciales de bases de datos en el archivo applicatioon-local.properties

Los ENDPOINT disponibles son:
http://localhost:8080/nttdata/v1/clientes
http://localhost:8080/nttdata/v1/cuentas
http://localhost:8080/nttdata/v1/movimientos

## Archivo de base de datos
Las tablas que se utilizan para el proyecto se encuentran en `resources/db.migration/V1.1__create_table.sql`
Se esta utilizando flyway

## Para levantar el proyecto con Docker Compose
El proyecto ya esta cargado en mi cuenta de Docker.hub
solo se debe clonar el proyecto y ejecutar el siguiente comando:
`docker-compose up -d`

Si se desea ejeuctar de manera local se debe modificar el archivo `docker-compose.yml` de la siguiente manera:
1. comentar la linea 5
2. descomentar la linea 4

## Postman
Se deje cargada la coleccion de Postman en stuff con el nombre `NttData.postman_collection.json`