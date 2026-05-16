import java.util.ArrayList;


public class Estudiante extends Persona {
    private String carrera;
    private double promedio;
    private ArrayList<Materia> materias;//Array list pq pide una LISTA de materias.
    
    //Constructor VACIO
    public Estudiante(){
        super("", "", 0, "");
        materias = new ArrayList<>();
    }
    
    //Constructor CON PARAMETROS
    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera, double promedio){
        super(nombre, apellido, edad, documento);
        this.carrera=carrera;
        this.promedio=promedio;
        materias = new ArrayList<>();
    }
    //Getter y Setter CARRERA
    public String getCarrera(){
        return carrera;
    }
    public void setCarrera(String carrera){
        if(carrera != null && !carrera.trim().isEmpty()){
           this.carrera=carrera;
        }
        else{
            System.out.println("Carrera Invalida.");
        }
    }
    //Getter PROMEDIO - Se calcula automaticamente basado en las materias
    public double getPromedio(){
        return calcularPromedio();
    }
    //Getter MATERIAS
    public ArrayList<Materia> getMaterias(){
        return materias;
    }
    //Metodo agregar materia del punto 4.
    public void agregarMateria(Materia materia){
        materias.add(materia);
    }
    //Metodo para calcular el promedio.
    public double calcularPromedio() {
        if (materias.isEmpty()) {
            System.out.println("El estudiante no tiene materias registradas.");
            return 0;
        }

        double suma = 0;//suma las notas

        for (Materia m : materias) {//para cada materia "m" dentro de la lista "materias"...
            suma += m.getCalificacion();//suma = suma + m.getCalificacion
        }

        return suma / materias.size();//suma de las notas dividido la cantidad de materias
    }
    
    //Método toString
    @Override
    public String toString(){
        return "Estudiante: " +
                "Nombre='" + getNombre() + '\'' +
                ", Apellido='" + getApellido() + '\'' +
                ", Edad=" + getEdad() +
                ", Documento='" + getDocumento() + '\'' +
                ", Carrera='" + carrera + '\'' +
                ", Promedio=" + String.format("%.2f", calcularPromedio()) +
                ", Materias=" + materias.size();
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