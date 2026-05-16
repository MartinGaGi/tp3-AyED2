public class Persona{
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    //Constructor que inicializa los atributos
    public Persona(String nombre, String apellido, int edad, String documento){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.documento=documento;
    }
    //Getters
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int getEdad(){
        return edad;
    }
    public String getDocumento(){
        return documento;
    }

    //Setters
    public void setNombre(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
           this.nombre=nombre;
        }
        else{
            System.out.println("Nombre Invalido.");
        }
    }
    public void setApellido(String apellido){
        if(apellido != null && !apellido.trim().isEmpty()){
            this.apellido=apellido;
        }
        else{
            System.out.println("Apellido Invalido.");
        }
    }
    public void setEdad(int edad){
        if(edad > 0){
            this.edad=edad;
        }
        else{
            System.out.println("Edad Invalida.");
        }
    }
    public void setDocumento(String documento){
        if(documento != null && !documento.trim().isEmpty()){
            this.documento=documento;
        }
        else{
            System.out.println("Documento Invalido.");
        }
    }
    
    //Método toString
    @Override
    public String toString(){
        return "Persona:" +
                "Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Edad=" + edad +
                ", Documento='" + documento + '\'';
    }
    
    //Método equals - utiliza documento como identificador único
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return documento != null && documento.equals(persona.documento);
    }
    
    //Método hashCode - basado en documento
    @Override
    public int hashCode(){
        return documento != null ? documento.hashCode() : 0;
    }
}