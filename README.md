# Proyecto Acceso a Datos - NBA
La aplicación del proyecto permite a los usuarios a hacer consultas sobre los jugadores de la NBA registrados en la base de datos,mostrando datos sobre ellos como posición
en la que juegan, equipo al que pertenecen,altura , peso, etc. Además permite añadir imagenes de cada uno de los jugadores a la basae de datos. La app también nos deja acceder a información sobre los equipos de la NBA, mostrando datos como la ciudad en la que se
encuentran, el nombre del equipo, la conferencia a la que pertenecen, etc. También permite a los usuarios hacer consultas sobre los partidos de la NBA, mostrando contra quien jugaron,
los puntos de cada equipo y la fecha.

Para ejecutar el proyecto en principio con bajarte el codigo y ejecutarlo debería funcionar. En caso de que no funcione, se deberá modificar la ruta de la base de datos en el archivo
"src/main/resources/META-INF/persistence.xml" en la etiqueta "property" con el nombre "jakarta.persistence.jdbc.url" y cambiar la ruta por la ruta de la base absoluta.

Una vez ejecutado el proyecto contará con una interfaz con dos pestañas, una para consultar jugadores y otra para consultar equipos. En la pestaña de jugadores se podrá buscar jugadores segun su nombre y en la pestaña de equipos se 
mostrará una tabla con todos los equipos de la base de datos. Pulsando en el boton de mas info se mostrará una nueva ventana con los datos del equipo y un historial de los ultimos partidos y de los partidos que tendrá en el futuro.

Actualmente se está trabajando en la implemetación de SpringBoot en el proyecto para crear una web desde la que consultar los datos de la base de datos.
