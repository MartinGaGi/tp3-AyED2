# TP3 - AyED2
## Implementación de un Índice de Estudiantes usando Tablas Hash

Trabajo práctico realizado para la materia Algoritmos y Estructuras de Datos II.

## Objetivo

Implementar una estructura `IndiceEstudiantes` utilizando una tabla hash para almacenar y buscar estudiantes mediante su legajo alfanumérico.

La implementación incluye:

- Función hash para strings
- Conversión ASCII
- Manejo de colisiones
- Exploración cuadrática
- Control de factor de carga

---

## Tecnologías utilizadas

- Java
- Programación Orientada a Objetos
- Tablas Hash

---

## Estructura del proyecto

```txt
src/
│
├── Estudiante.java
├── Universidad.java
├── IndiceEstudiantes.java
└── Main.java
```

---

## Función Hash

La función hash utilizada:

1. Convierte cada carácter del legajo a ASCII
2. Suma todos los valores
3. Aplica módulo 17

Ejemplo:

```txt
AB12

A = 65
B = 66
1 = 49
2 = 50

Total = 230

230 mod 17 = 9
```

---

## Resolución de colisiones

Se implementó exploración cuadrática:

```

h(k,i) = (h(k) + i²) mod 17

```

Ejemplo de intentos:

- i = 1 → +1
- i = 2 → +4
- i = 3 → +9

---

## Factor de carga

- Tamaño de tabla: 17
- Factor de carga máximo: 0.7
- Máximo permitido: 11 estudiantes

---

## Funcionalidades implementadas

- Insertar estudiantes
- Buscar estudiantes por legajo
- Manejo de colisiones
- Verificación de factor de carga

---
---

## Tabla de trabajo

| Legajo | ASCII total | h(k) | ¿Colisión? | Intentos (i²) | Posición final |
|---|---|---|---|---|---|
| AB12 | 230 | 9 | No | 0 | 9 |
| ZX90 | 283 | 11 | No | 0 | 11 |
| LQ33 | 259 | 4 | No | 0 | 4 |
| AA11 | 228 | 7 | No | 0 | 7 |
| BB22 | 232 | 11 | Sí | 1² = 1 | 12 |
| CC33 | 236 | 15 | No | 0 | 15 |

### Explicación

La tabla muestra:

- La suma ASCII de cada legajo
- El resultado de la función hash:
  
```txt
h(k) = suma ASCII mod 17
```

- Si ocurrió colisión
- Los intentos realizados mediante exploración cuadrática
- La posición final dentro de la tabla hash
  
---

## Reflexión

La exploración cuadrática permitió resolver colisiones de manera eficiente evitando agrupamientos excesivos.

Las colisiones ocurrieron principalmente cuando distintos legajos producían el mismo valor hash.

El uso de un tamaño primo para la tabla mejora la distribución y reduce problemas durante la exploración cuadrática.

---

## Autor

- MartinGaGi
