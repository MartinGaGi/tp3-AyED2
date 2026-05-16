# 📚 TP3 - AyED2
## Implementación de un Índice de Estudiantes usando Tablas Hash

Trabajo práctico realizado para la materia **Algoritmos y Estructuras de Datos II**.

Este proyecto implementa una estructura de indexación basada en **tablas hash**, permitiendo almacenar y buscar estudiantes mediante un legajo alfanumérico utilizando:

- Función hash para strings
- Conversión ASCII
- Resolución de colisiones
- Exploración cuadrática
- Control de factor de carga

---

# 🚀 Objetivo

Desarrollar una clase `IndiceEstudiantes` capaz de:

✅ Insertar estudiantes  
✅ Buscar estudiantes por legajo  
✅ Resolver colisiones mediante exploración cuadrática  
✅ Controlar el factor de carga máximo  

---

# 🛠️ Tecnologías utilizadas

- Java
- Programación Orientada a Objetos (POO)
- Tablas Hash
- Exploración cuadrática

---

# 📁 Estructura del proyecto

```txt
src/
│
├── Estudiante.java
├── Universidad.java
├── IndiceEstudiantes.java
└── Main.java
```

---

# 🧠 Implementación de la función Hash

La función hash utilizada trabaja de la siguiente manera:

1. Convierte cada carácter del legajo a ASCII
2. Suma todos los valores obtenidos
3. Aplica módulo 17

## Fórmula

:contentReference[oaicite:0]{index=0}

---

## 📌 Ejemplo

```txt
Legajo: AB12

A → 65
B → 66
1 → 49
2 → 50

Total = 230

230 mod 17 = 9
```

---

# ⚡ Resolución de colisiones

Cuando una posición ya está ocupada, se utiliza **exploración cuadrática**.

## Fórmula utilizada

:contentReference[oaicite:1]{index=1}

## Ejemplo de intentos

| Intento | Operación |
|---|---|
| i = 1 | +1 |
| i = 2 | +4 |
| i = 3 | +9 |
| i = 4 | +16 |

---

# 📊 Parámetros de la tabla hash

| Parámetro | Valor |
|---|---|
| Tamaño de tabla | 17 |
| Factor de carga máximo | 0.7 |
| Máximo de estudiantes | 11 |
| Método de colisiones | Exploración cuadrática |

---

# 📋 Tabla de trabajo

| Legajo | ASCII total | h(k) | ¿Colisión? | Intentos (i²) | Posición final |
|---|---|---|---|---|---|
| AB12 | 230 | 9 | No | 0 | 9 |
| ZX90 | 283 | 11 | No | 0 | 11 |
| LQ33 | 259 | 4 | No | 0 | 4 |
| AA11 | 228 | 7 | No | 0 | 7 |
| BB22 | 232 | 11 | Sí | 1² = 1 | 12 |
| CC33 | 236 | 15 | No | 0 | 15 |

---

# ✅ Funcionalidades implementadas

- Inserción de estudiantes
- Búsqueda por legajo
- Conversión ASCII
- Función hash
- Manejo de colisiones
- Exploración cuadrática
- Control del factor de carga

---

# 🧪 Pruebas realizadas

En `Main.java` se realizaron pruebas para verificar:

- Inserciones normales
- Colisiones
- Reubicación mediante exploración cuadrática
- Búsquedas exitosas
- Búsquedas inexistentes
- Control del límite de carga

---

# 💭 Reflexión

La exploración cuadrática permitió resolver colisiones de manera eficiente evitando agrupamientos excesivos dentro de la tabla hash.

Las colisiones ocurrieron principalmente cuando distintos legajos producían el mismo valor hash.

El uso de un tamaño primo para la tabla mejora considerablemente la distribución de claves y reduce problemas durante la exploración cuadrática.

---

# 👨‍💻 Alumno

- Martin Gabriel Gimenez

---

# 📌 Estado del proyecto

✅ Trabajo práctico finalizado
