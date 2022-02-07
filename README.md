# Ejercicio-GlobalLogic

Proyecto para la creacion y consulta de usuarios que implementa JPA y JWT

###Requisitos del sistema
- gradle
- jdk 1.8

###Construccion JAR
ubicarse en la carpeta raiz del proyecto y ejecutar "gradle build"

###Ejecucion JAR
ubicarse en la carpeta /build/libs y ejecutar "java -jar Ejercicio-1.0-SNAPSHOT.jar"

A continuacion se muestra aquellas variables de entorno utilizadas en el proyecto en conjunto 
de su valor por defecto para su funcionamiento

| Nombre variable | valor por defecto |
| ------------- | ------------- |
| SERVER_PORT  | 8080  |
| DATASOURCE_URL | jdbc:h2:mem:testdb |
|DATASOURCE_DRIVER_CLASS_NAME|org.h2.Driver|
|DATASOURCE_USER|user|
|DATASOURCE_PASSWORD|password|
|JPA_DATABASE_PLATFORM|org.hibernate.dialect.H2Dialect|
|SQL_INIT_PLATFORM|h2|
