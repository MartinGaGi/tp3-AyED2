import java.util.ArrayList;


public class Profesor extends Persona {
    private String especialidad;
    private int añosExperiencia;
    private ArrayList<Materia> materiasAsignadas;
    
    //Constructor VACIO
    public Profesor(){
        super("", "", 0, "");//super es para llamar al constructor de la clase padre(Persona).
        materiasAsignadas = new ArrayList<>();
    }
    
    //Constructor CON PARAMETROS
    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, int añosExperiencia){
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        materiasAsignadas = new ArrayList<>();
    }
    
    //Getter y Setter ESPECIALIDAD
    public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        if(especialidad != null && !especialidad.trim().isEmpty()){
            this.especialidad = especialidad;
        }
        else{
            System.out.println("Especialidad Invalida.");
        }
    }
    
    //Getter y Setter AÑOS DE EXPERIENCIA
    public int getAñosExperiencia(){
        return añosExperiencia;
    }
    public void setAñosExperiencia(int añosExperiencia){
        if(añosExperiencia >= 0){
            this.añosExperiencia = añosExperiencia;
        }
        else{
            System.out.println("Años de experiencia inválido.");
        }
    }
    
    //Getter MATERIAS ASIGNADAS
    public ArrayList<Materia> getMateriasAsignadas(){
        return materiasAsignadas;
    }
    
    //Método para asignar una materia
    public void asignarMateria(Materia materia){
        if(materia != null){
            materiasAsignadas.add(materia);
        }
        else{
            System.out.println("Materia inválida.");
        }
    }
    
    //Método toString
    @Override
    public String toString(){
        return "Profesor:" +
                "Nombre='" + getNombre() + '\'' +
                ", Apellido='" + getApellido() + '\'' +
                ", Edad=" + getEdad() +
                ", Documento='" + getDocumento() + '\'' +
                ", Especialidad='" + especialidad + '\'' +
                ", Años de Experiencia=" + añosExperiencia +
                ", Materias Asignadas=" + materiasAsignadas.size();
    }
    
    //Método equals - hereda de Persona (utiliza documento)
    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
    
    //Método hashCode - hereda de Persona
    @Override
    public int hashCode(){
        return super.hashCode();
    }
    
}
