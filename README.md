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
![tablas](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/12.png)

## Para levantar el proyecto con Docker Compose
El proyecto ya esta cargado en mi cuenta de Docker.hub
solo se debe clonar el proyecto y ejecutar el siguiente comando:
`docker-compose up -d`

![docker](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/13.png)

Si se desea ejeuctar de manera local se debe modificar el archivo `docker-compose.yml` de la siguiente manera:
1. comentar la linea 5
2. descomentar la linea 4

![compose](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/14.png)

## Postman
Se deje cargada la coleccion de Postman en stuff con el nombre `NttData.postman_collection.json`
![postman](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/15.png)

#Imagenes del proyecto
### creacion de client
![1](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/1.png)

### consulta de todos los clientes
![2](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/2.png)

### eliminacion de cliente
![4](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/4.png)

### actualizacion de cliente
![5](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/5.png)

### creacion de cuenta
![6](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/6.png)

### actualizacion de cuenta
![7](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/7.png)

### eliminacion de cuenta
![8](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/8.png)

### creacion de movimiento credito
![9](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/9.png)

### creacion de movimiento debito
![10](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/10.png)

### consulta de estado de cuenta
![11](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/11.png)

### Dashboard Docker
![3](https://raw.githubusercontent.com/ismaelviss/NttData/master/stuff/3.png)
