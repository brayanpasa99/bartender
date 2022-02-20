# Bartender

## Tecnologías usadas:

Backend: Spring Boot (Java)
Cliente API: Insomnia
Base de Datos: MySQL

## Contexto

El respositorio consta de los archivos necesarios para exponer el API requerida para la organización de vasos numerados con base en los números primos.

La base de datos utilizada se encuentra en la carpeta ["databases"](https://github.com/brayanpasa99/bartender/tree/master/database)

El archivo usado en el cliente HTML de Insomnia está en la carpeta principal del proyecto y se denomina [Insomnia_2022-02-20.json](https://github.com/brayanpasa99/bartender/blob/master/Insomnia_2022-02-20.json)

## Iniciar proyecto

Seleccionar alguna de las dos opciones:

Clonar el repositorio por medio de SSH: [git@github.com:brayanpasa99/bartender.git](git@github.com:brayanpasa99/bartender.git)
Clonar el repositorio por medio de HTTPS [https://github.com/brayanpasa99/bartender.git](https://github.com/brayanpasa99/bartender.git)

Luego, acceder a los archivos de base de datos e importarlos por medio de Workbench (interfaz de MySQL) o por la terminal de comandos.

Después, en la carpeta principal abrir el archivo pom.xml con el entorno de desarrollo preferido para cargar así las dependencias y acceder al código fuente del proyecto. Modificar e archivo [application.properties](https://github.com/brayanpasa99/bartender/blob/master/src/main/resources/application.properties) para establecer la conexión con la base de datos de manera correcta e iniciar la aplicación ejecutando [BartenderApplication.java](https://github.com/brayanpasa99/bartender/blob/master/src/main/java/com/bartender/bartender/BartenderApplication.java) 

## Probar 

La aplicación cuenta con dos endpoint principales:

* (Dirección en la que se expuso el API)/glass/getAllGlassArray que va a traer todos los arreglos numerados de vasos de la base de datos.
* (Dirección en la que se expuso el API)/glass/getGlassArrayById/{id}/{Q} donde se debe reemplazar {id} por el identificador de la pila de datos y {Q} por el número de iteraciones que se desean realizar, con esto se hará el procedimiento especificado y verá una respuesta (Desde el inspector web o desde el cliente API preferido) con las diferentes iteraciones y los datos obtenidos en cada una de ellas (de no ejecutarse alguna excepción).
