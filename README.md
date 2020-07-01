# Metrobus
## Instalación
El proyecto se levanta con docker compose de la siguiente manera:   

`docker-compose build`  
`docker-compose up`  

Esto lo que hace primero es construir las imágenes, luego levantar el postgres,
y al final levanta el aplicativo como tal.

El puerto que expone el aplicativo es el `6969` y no tiene un `contextPath`.

Si se desea correr el proyecto sin docker, se tendría que hacer lo siguiente:
- Cambiar la propiedades del datasource por sus credenciales y host de postgres
en el archivo `application.yml`  
- Correr el comando `mvn spring-boot:run` en la raíz del repositorio

  
Para consumir los servicios, se incluyó un proyecto de postman,
el cual en la raíz del proyecto contiene todos los request que utilicé para obtener
la información necesaria de la página de datos abiertos, es decir no apunta al proyecto,
los request que apuntan al proyecto están sobre la carpeta `restProject` y se encuentran
en el orden que se solicitaron.

El diagrama del proyecto se encuentra en la carpeta `config/project.png` así como
el código con el que se generó el diagrama que se encuentra en el archivo `diagram.txt`,
este diagrama se generó en la página https://sequencediagram.org/

## Stack
El proyecto se desarrollo con las siguientes tecnologías:
- Java `(adoptOpenjdk build 1.8.0_252-b09)`
- Spring framework
- Maven
- Postgres


