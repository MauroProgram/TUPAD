# Trabajo Práctico II

**Autor:** Mauro Ezequiel Ponce
**Trabajo:** Trabajo Práctico N°2
**Materia:** Introducción a POO en Java

---

## Ejercicios propuestos: Caso Práctico

Desarrollar en Java los siguientes ejercicios aplicando los conceptos de programación orientada a objetos:

### 1. Registro de Estudiantes
- **Clase:** `Estudiante`
  **Atributos:** `nombre`, `apellido`, `curso`, `calificación`
  **Métodos requeridos:**
  - `mostrarInfo()`
  - `subirCalificacion(puntos)`
  - `bajarCalificacion(puntos)`
- **Tarea:** Instanciar a un estudiante, mostrar su información, aumentar y disminuir calificaciones.

### 2. Registro de Mascotas
- **Clase:** `Mascota`
  **Atributos:** `nombre`, `especie`, `edad`
  **Métodos requeridos:**
  - `mostrarInfo()`
  - `cumplirAnios()`
- **Tarea:** Crear una mascota, mostrar su información, simular el paso del tiempo y verificar los cambios.

### 3. Encapsulamiento con la Clase Libro
- **Clase:** `Libro`
  **Atributos privados:** `titulo`, `autor`, `añoPublicacion`
  **Métodos requeridos:**
  - Getters para todos los atributos
  - Setter con validación para `añoPublicacion`
- **Tarea:** Crear un libro, intentar modificar el año con un valor inválido y luego con uno válido. Mostrar la información final.

### 4. Gestión de Gallinas en Granja Digital
- **Clase:** `Gallina`
  **Atributos:** `idGallina`, `edad`, `huevosPuestos`
  **Métodos requeridos:**
  - `ponerHuevo()`
  - `envejecer()`
  - `mostrarEstado()`
- **Tarea:** Crear dos gallinas, simular sus acciones (envejecer y poner huevos) y mostrar su estado.

### 5. Simulación de Nave Espacial
- **Clase:** `NaveEspacial`
  **Atributos:** `nombre`, `combustible`
  **Métodos requeridos:**
  - `despegar()`
  - `avanzar(distancia)`
  - `recargarCombustible(cantidad)`
  - `mostrarEstado()`
- **Reglas:**
  - Validar que haya suficiente combustible antes de avanzar.
  - Evitar que se supere el límite al recargar.
- **Tarea:** Crear una nave con 50 unidades de combustible, intentar avanzar sin recargar, luego recargar y avanzar correctamente. Mostrar el estado al final.
