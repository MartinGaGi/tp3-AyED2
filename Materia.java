public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;
    private Profesor profesor;
    
    public Materia(String nombre, String codigo, int creditos, double calificacion){
        this.nombre=nombre;
        this.codigo=codigo;
        this.creditos=creditos;
        this.calificacion=calificacion;
        this.profesor=null;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            this.nombre=nombre;
        }
        else{
            System.out.println("Nombre Invalido.");
        }
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo(String codigo){
        if(codigo != null && !codigo.trim().isEmpty()){
            this.codigo=codigo;
        }
        else{
            System.out.println("Codigo Invalido.");
        }
    }
    
    public int getCreditos(){
        return creditos;
    }
    
    public void setCreditos(int creditos){
        if(creditos > 0){
            this.creditos=creditos;
        }
        else{
            System.out.println("Debe ingresar un numero mayor a 0.");
        }
    }
    
    public double getCalificacion(){
        return calificacion;
    }
    
    public void setCalificacion(double calificacion){
        if(calificacion > 0){
            this.calificacion=calificacion;
        }
        else{
            System.out.println("Debe ingresar un numero mayor a 0.");
        }
    }
    
    //Getter y Setter PROFESOR
    public Profesor getProfesor(){
        return profesor;
    }
    
    public void setProfesor(Profesor profesor){
        if(profesor != null){
            this.profesor = profesor;
        }
        else{
            System.out.println("Profesor Invalido.");
        }
    }
    
    //Método toString
    @Override //override es para indicar que estamos sobrescribiendo el método toString de la clase Object.
    public String toString(){
        return "Materia:" +
                "Nombre='" + nombre + '\'' +
                ", Codigo='" + codigo + '\'' +
                ", Creditos=" + creditos +
                ", Calificacion=" + calificacion +
                ", Profesor=" + (profesor != null ? profesor.getNombre() + " " + profesor.getApellido() : "Sin asignar");// esto esta medio al pedo pq igual muestra Sin Asignar
    }
    
    //Método equals - utiliza código como identificador único
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return codigo != null && codigo.equals(materia.codigo);
    }
    
    //Método hashCode - basado en código
    @Override
    public int hashCode(){
        return codigo != null ? codigo.hashCode() : 0;
    }
}
