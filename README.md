# 🍳 API-MasterChef

**Taller Semana de Receso**  
**Presentado por:** *Julian Lopez*  


---

## 📖 Descripción del Proyecto

Un importante programa de telerrealidad de cocina va a sacar su sitio Web para que todos los televidentes puedan consultar y aprender sobre las recetas que han aparecido a lo largo de las temporadas, sin embargo, también quiere que sea interactivo, donde los televidentes pueden publicar sus recetas.
Por tal motivo nuestra empresa DOSW Company ha sido seleccionada para desarrollar esta iniciativa en su Fase inicial, por lo tanto, usted va a construir una API de gestión de recetas de cocina.
Cada Receta tendrá un título, una lista de ingredientes y los pasos de preparación de la receta, adicional tendrá el nombre del chef que podrá ser un concursante del programa, un chef de los jurados o un televidente del común.
En caso de que sea un participante tiene que establecer en que temporada salió esa receta.


## 🖼️ Imagen Swagger
![alt text](docs/img/swagger.png)
---
## 🚀 Instalación y Ejecución Local


1. _Clonar el repositorio_
    ```bash
    git clone https://github.com/JulianLopez11/API-MasterChef.git
    ```
2. _Entrar al directorio del proyecto_

    ```bash
    cd API-MasterChef
    ```

3. _Compilar el proyecto_
    ```bash
    mvn clean compile
    ```
4. _Ejecutar la aplicación_
    ```bash
    mvn clean verify
    mvn spring-boot:run
    ```