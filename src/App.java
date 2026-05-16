import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Universidad universidad;
    private static Scanner scanner;
    
    public static void main(String[] args){
        scanner = new Scanner(System.in);
        universidad = new Universidad("UNViMe", "Garcia Lorca 123");
        menuPrincipal();
    }
    
    //MENU PRINCIPAL
    public static void menuPrincipal(){
        boolean salir = false;
        int opcion = 0;
        
        do{
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1. Gestionar Carreras");
            System.out.println("2. Gestionar Estudiantes");
            System.out.println("3. Gestionar Profesores");
            System.out.println("4. Gestionar Personal");
            System.out.println("5. Ver información de la Universidad");
            System.out.println("6. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    menuGestionarCarreras();
                    break;
                case 2:
                    menuGestionarEstudiantes();
                    break;
                case 3:
                    menuGestionarProfesores();
                    break;
                case 4:
                    menuGestionarPersonal();
                    break;
                case 5:
                    verInformacionUniversidad();
                    break;
                case 6:
                    System.out.println("¡Gracias por usar el sistema! ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }while(!salir);
        scanner.close();
    }
    
    //MENU GESTIONAR CARRERAS
    public static void menuGestionarCarreras(){
        boolean volver = false;
        int opcion = 0;
        
        do{
            System.out.println("\n======= GESTIONAR CARRERAS =======");
            System.out.println("1. Agregar carrera");
            System.out.println("2. Listar todas las carreras");
            System.out.println("3. Ver estudiantes de una carrera");
            System.out.println("4. Volver al menú principal");
            System.out.println("===================================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    agregarCarrera();
                    break;
                case 2:
                    listarCarreras();
                    break;
                case 3:
                    verEstudiantesCarrera();
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while(!volver);
    }
    
    //MENU GESTIONAR ESTUDIANTES
    public static void menuGestionarEstudiantes(){
        boolean volver = false;
        int opcion = 0;
        
        do{
            System.out.println("\n====== GESTIONAR ESTUDIANTES ======");
            System.out.println("1. Inscribir estudiante en carrera");
            System.out.println("2. Inscribir estudiante en materia");
            System.out.println("3. Buscar estudiante por documento");
            System.out.println("4. Ver información de estudiante");
            System.out.println("5. Volver al menú principal");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    inscribirEstudianteCarrera();
                    break;
                case 2:
                    inscribirEstudianteMateria();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    verInformacionEstudiante();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while(!volver);
    }
    
    //MENU GESTIONAR PROFESORES
    public static void menuGestionarProfesores(){
        boolean volver = false;
        int opcion = 0;
        
        do{
            System.out.println("\n======= GESTIONAR PROFESORES =======");
            System.out.println("1. Registrar nuevo profesor");
            System.out.println("2. Asignar materia a profesor");
            System.out.println("3. Ver información de profesor");
            System.out.println("4. Volver al menú principal");
            System.out.println("=====================================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    registrarProfesor();
                    break;
                case 2:
                    asignarMateriaProfesor();
                    break;
                case 3:
                    verInformacionProfesor();
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while(!volver);
    }
    
    //MENU GESTIONAR PERSONAL
    public static void menuGestionarPersonal(){
        boolean volver = false;
        int opcion = 0;
        
        do{
            System.out.println("\n======= GESTIONAR PERSONAL =======");
            System.out.println("1. Registrar nuevo personal");
            System.out.println("2. Ver información de personal");
            System.out.println("3. Volver al menú principal");
            System.out.println("===================================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    registrarPersonal();
                    break;
                case 2:
                    verInformacionPersonal();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while(!volver);
    }
    
    //FUNCIONES CARRERAS
    public static void agregarCarrera(){
        System.out.println("\n--- AGREGAR NUEVA CARRERA ---");
        System.out.print("Nombre de la carrera: ");
        String nombreCarrera = scanner.nextLine();
        Carrera carrera = new Carrera(nombreCarrera, new ArrayList<Estudiante>());
        universidad.agregarCarrera(carrera);
    }
    
    public static void listarCarreras(){
        System.out.println();
        universidad.listarCarreras();
    }
    
    public static void verEstudiantesCarrera(){
        System.out.println("\n--- VER ESTUDIANTES DE UNA CARRERA ---");
        System.out.print("Nombre de la carrera: ");
        String nombreCarrera = scanner.nextLine();
        Carrera carrera = universidad.obtenerCarrera(nombreCarrera);
        
        if(carrera != null){
            carrera.listarEstudiantes();
        }
        else{
            System.out.println("ERROR: La carrera '" + nombreCarrera + "' no existe.");
        }
    }
    
    //FUNCIONES ESTUDIANTES
    public static void inscribirEstudianteCarrera(){
        System.out.println("\n--- INSCRIBIR ESTUDIANTE EN CARRERA ---");
        System.out.print("Nombre de la carrera: ");
        String nombreCarrera = scanner.nextLine();
        Carrera carrera = universidad.obtenerCarrera(nombreCarrera);
        
        if(carrera != null){
            System.out.print("Nombre del estudiante: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido del estudiante: ");
            String apellido = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Documento (Cédula/DNI): ");
            String documento = scanner.nextLine();
            
            Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, edad, documento, nombreCarrera, 0);
            carrera.agregarEstudiante(nuevoEstudiante);
            universidad.agregarEstudiante(nuevoEstudiante);
            System.out.println("Estudiante '" + nombre + " " + apellido + "' inscrito exitosamente en " + nombreCarrera);
        }
        else{
            System.out.println("ERROR: La carrera '" + nombreCarrera + "' no existe.");
        }
    }
    
    public static void inscribirEstudianteMateria(){
        System.out.println("\n--- INSCRIBIR ESTUDIANTE EN MATERIA ---");
        System.out.print("Nombre de la carrera: ");
        String nombreCarrera = scanner.nextLine();
        Carrera carrera = universidad.obtenerCarrera(nombreCarrera);
        
        if(carrera != null){
            System.out.print("Nombre del estudiante: ");
            String nombreEst = scanner.nextLine();
            Estudiante estudiante = null;
            
            for(Estudiante est : carrera.getEstudiantes()){
                if(est.getNombre().equalsIgnoreCase(nombreEst)){
                    estudiante = est;
                    break;
                }
            }
            
            if(estudiante != null){
                System.out.print("Nombre de la materia: ");
                String nombreMateria = scanner.nextLine();
                System.out.print("Código de la materia: ");
                String codigoMateria = scanner.nextLine();
                System.out.print("Créditos de la materia: ");
                int creditos = scanner.nextInt();
                System.out.print("Calificación obtenida: ");
                double calificacion = scanner.nextDouble();
                scanner.nextLine();
                
                Materia nuevaMateria = new Materia(nombreMateria, codigoMateria, creditos, calificacion);
                estudiante.agregarMateria(nuevaMateria);
                
                System.out.println("Materia '" + nombreMateria + "' inscrita exitosamente para " + nombreEst);
                System.out.println("Promedio actualizado: " + String.format("%.2f", estudiante.getPromedio()));
            }
            else{
                System.out.println("ERROR: El estudiante '" + nombreEst + "' no existe en la carrera.");
            }
        }
        else{
            System.out.println("ERROR: La carrera '" + nombreCarrera + "' no existe.");
        }
    }
    
    public static void buscarEstudiante(){
        System.out.println("\n--- BUSCAR ESTUDIANTE ---");
        System.out.print("Nombre de la carrera: ");
        String nombreCarrera = scanner.nextLine();
        Carrera carrera = universidad.obtenerCarrera(nombreCarrera);
        
        if(carrera != null){
            System.out.print("Documento del estudiante a buscar: ");
            String documento = scanner.nextLine();
            while(documento.length()<7||documento.length()>8||documento.isBlank()){
                System.out.println("Documento inválido. Debe tener entre 7 y 8 caracteres y no puede estar vacío.");
                System.out.print("Documento del estudiante a buscar: ");
                documento = scanner.nextLine();
            }
            universidad.buscarPorDocumento(documento);
        }
        else{
            System.out.println("ERROR: La carrera '" + nombreCarrera + "' no existe.");
        }
    }
    
    public static void verInformacionEstudiante(){
        System.out.println("\n--- VER INFORMACIÓN DE ESTUDIANTE ---");
        System.out.print("Nombre de la carrera: ");
        String nombreCarrera = scanner.nextLine();
        Carrera carrera = universidad.obtenerCarrera(nombreCarrera);
        
        if(carrera != null){
            System.out.print("Nombre del estudiante: ");
            String nombreEst = scanner.nextLine();
            
            for(Estudiante est : carrera.getEstudiantes()){
                if(est.getNombre().equalsIgnoreCase(nombreEst)){
                    System.out.println("\n" + est);
                    System.out.println("Materias inscritas: " + est.getMaterias().size());
                    for(Materia m : est.getMaterias()){
                        System.out.println("  - " + m);
                    }
                    return;
                }
            }
            System.out.println("ERROR: El estudiante '" + nombreEst + "' no existe.");
        }
        else{
            System.out.println("ERROR: La carrera '" + nombreCarrera + "' no existe.");
        }
    }
    
    //FUNCIONES PROFESORES
    public static void registrarProfesor(){
        System.out.println("\n--- REGISTRAR NUEVO PROFESOR ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Documento (Cédula/DNI): ");
        String documento = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Años de experiencia: ");
        int anos = scanner.nextInt();
        scanner.nextLine();
        
        Profesor profesor = new Profesor(nombre, apellido, edad, documento, especialidad, anos);
        universidad.agregarProfesor(profesor);
        System.out.println("Profesor registrado exitosamente");
        System.out.println(profesor);
    }
    
    public static void asignarMateriaProfesor(){
        System.out.println("\n--- ASIGNAR MATERIA A PROFESOR ---");
        System.out.print("Documento del profesor: ");
        String documento = scanner.nextLine();
        Profesor profesor = universidad.obtenerProfesor(documento);
        if(profesor != null){
            System.out.print("Nombre de la materia: ");
            String nombreMateria = scanner.nextLine();
            System.out.print("Código de la materia: ");
            String codigoMateria = scanner.nextLine();
            System.out.print("Créditos de la materia: ");
            int creditos = scanner.nextInt();
            System.out.print("Calificación asignada: ");
            double calificacion = scanner.nextDouble();
            scanner.nextLine();

            Materia materia = new Materia(nombreMateria, codigoMateria, creditos, calificacion);
            profesor.asignarMateria(materia);
            System.out.println("Materia '" + nombreMateria + "' asignada a " + profesor.getNombre() + " " + profesor.getApellido());
        }
        else{
            System.out.println("ERROR: No se encontró ningún profesor con documento " + documento);
        }
    }
    
    public static void verInformacionProfesor(){
        System.out.println("\n--- VER INFORMACIÓN DE PROFESOR ---");
        System.out.print("Documento del profesor: ");
        String documento = scanner.nextLine();
        Profesor profesor = universidad.obtenerProfesor(documento);
        if(profesor != null){
            System.out.println(profesor);
            if(profesor.getMateriasAsignadas().isEmpty()){
                System.out.println("Materias asignadas: ninguno");
            } else {
                System.out.println("Materias asignadas:");
                for(Materia materia: profesor.getMateriasAsignadas()){
                    System.out.println("  - " + materia);
                }
            }
        }
        else{
            System.out.println("ERROR: No se encontró ningún profesor con documento " + documento);
        }
    }
    
    //FUNCIONES PERSONAL
    public static void registrarPersonal(){
        System.out.println("\n--- REGISTRAR NUEVO PERSONAL ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Documento (Cédula/DNI): ");
        String documento = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Puesto: ");
        String puesto = scanner.nextLine();
        System.out.print("Fecha de ingreso (DD/MM/YYYY): ");
        String fechaIngreso = scanner.nextLine();
        
        Personal personal = new Personal(nombre, apellido, edad, documento, departamento, puesto, fechaIngreso);
        universidad.agregarPersonal(personal);
        System.out.println("Personal registrado exitosamente");
        System.out.println(personal);
    }
    
    public static void verInformacionPersonal(){
        System.out.println("\n--- VER INFORMACIÓN DE PERSONAL ---");
        System.out.print("Documento del personal: ");
        String documento = scanner.nextLine();
        Personal persona = universidad.obtenerPersonal(documento);
        if(persona != null){
            System.out.println(persona);
        }
        else{
            System.out.println("ERROR: No se encontró ningún personal con documento " + documento);
        }
    }
    
    //FUNCIONES UNIVERSIDAD
    public static void verInformacionUniversidad(){
        System.out.println("\n" + universidad);
        System.out.println("\nCarreras registradas: " + universidad.getCarreras().size());
        System.out.println("Estudiantes registrados: " + universidad.getEstudiantes().size());
        System.out.println("Profesores registrados: " + universidad.getProfesores().size());
        System.out.println("Personal registrado: " + universidad.getPersonal().size());
    }
}
