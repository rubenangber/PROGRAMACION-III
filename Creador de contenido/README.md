Un creador de contenido quiere realizar un programa de consola en JAVA para analizar los
posibles ingresos de su canal de Youtube. El programa deberá solicitar al inicio del
programa la siguiente información:
- Nombre del canal
- Número de total vídeos

Por cada video, se le solicitará por consola:
- Título del vídeo
- Duración del video en segundos
- Visualizaciones hasta la fecha
- Id video URL: https://www.youtube.com/watch?v=Sagg08DrO5U

En el programa se establecerá un CPM actual de Youtube de forma fija e inalterable. Supón
un CPM de 1.7 € (1.7 € por 1000 visualizaciones).
Tras esto se le presentará al usuario una tabla similar a la siguiente:

| Título | Visualizaciones | Duración | URL | Ingresos |
|----------|----------|----------|----------|----------|
| Video 1 | 1234 | 20921 | 673&vdyqw | 2,1 |
| Video 2 | 1000 | 2231 | y3f2g8dd12 | 1,7 |
|Suponemos más videos ... |<!-- -->  | <!-- -->  | <!-- --> | <!-- --> |
| Video N | 1000 | 22321 | y421u8d12 | 1,7 |
| Ingresos totales del canal | <!-- -->  | <!-- -->  | <!-- -->  | 5,5 |
| Media de ingresos por video | <!-- -->  | <!-- -->  | <!-- -->  | 1,83 |


Recomendaciones:
- Haz que la E/S por consola sea robusta a fallos, emplea la biblioteca si lo consideras
necesario.
- Utiliza POO y sus principios. Crea clases y objetos que representen el modelo del
dominio del problema (las entidades de información que se manejan y que
implementen lógica relacionada con dichas entidades).
- Recuerda que los atributos de una clase a su vez pueden ser objetos (o Arrays) de
otra clase.
- Utiliza notación camelCase y los estándares de estilo propios de Java.
- Utiliza el depurador del IDE para inspeccionar errores.
- Refactoriza el código para hacerlo más legible