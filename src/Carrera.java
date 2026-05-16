import java.util.ArrayList;

public class Carrera {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
    
    public Carrera(String nombre, ArrayList<Estudiante> estudiantes){
        this.nombre=nombre;
        this.estudiantes=estudiantes;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }
    
    public void setNombre(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            this.nombre=nombre;
        }
        else{
            System.out.println("Nombre Invalido.");
        }
    }
    
    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
    
    public void listarEstudiantes(){
        System.out.println("Estudiantes de la carrera " + nombre + ":");
        if(estudiantes.isEmpty()){
            System.out.println("No hay estudiantes registrados en esta carrera.");
        }
        else{
            for (Estudiante estudiante : estudiantes) {
                System.out.println("---------------------------");
                System.out.println("- " + estudiante.getNombre() + " " + estudiante.getApellido());
                System.out.println("Edad: " + estudiante.getEdad());
                System.out.println("Promedio: " + String.format("%.2f", estudiante.getPromedio()));
                
                //Mostrar materias
                ArrayList<Materia> materias = estudiante.getMaterias();
                if(materias.isEmpty()){
                    System.out.println("Materias: Sin materias registradas");
                }
                else{
                    System.out.println("Materias:");
                    for(Materia materia : materias){
                        System.out.println("  > " + materia.getNombre() + " (" + materia.getCodigo() + ") - Calificación: " + materia.getCalificacion());
                    }
                }
                System.out.println("---------------------------");
            }
        }
    }
    
    public void buscarEstudiante(String nombre){
        boolean encontrado=false;
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("---------------------------");
                System.out.println("- " + estudiante.getNombre() + " " + estudiante.getApellido());
                System.out.println("Documento: " + estudiante.getDocumento());
                System.out.println("Edad: " + estudiante.getEdad());
                System.out.println("Promedio: " + String.format("%.2f", estudiante.getPromedio()));
                
                //Mostrar materias
                ArrayList<Materia> materias = estudiante.getMaterias();
                if(materias.isEmpty()){
                    System.out.println("Materias: Sin materias registradas");
                }
                else{
                    System.out.println("Materias:");
                    for(Materia materia : materias){
                        System.out.println("  > " + materia.getNombre() + " (" + materia.getCodigo() + ") - Calificación: " + materia.getCalificacion());
                    }
                }
                System.out.println("---------------------------");
                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println("Estudiante no encontrado.");
        }
    }
    
    //Método toString
    @Override
    public String toString(){
        return "Carrera: " +
                "Nombre='" + nombre + '\'' +
                ", Estudiantes=" + estudiantes.size() ;
    }
    
    //Método equals - utiliza nombre como identificador único
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return nombre != null && nombre.equals(carrera.nombre);
    }
    
    //Método hashCode - basado en nombre
    @Override
    public int hashCode(){
        return nombre != null ? nombre.hashCode() : 0;
    }
}
