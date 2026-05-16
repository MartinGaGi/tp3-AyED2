public class Personal extends Persona {
    private String departamento;
    private String puesto;
    private String fechaIngreso;
    
    //Constructor VACIO
    public Personal(){
        super("", "", 0, "");
    }
    
    //Constructor CON PARAMETROS
    public Personal(String nombre, String apellido, int edad, String documento, String departamento, String puesto, String fechaIngreso){
        super(nombre, apellido, edad, documento);
        this.departamento = departamento;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
    }
    
    //Getter y Setter DEPARTAMENTO
    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        if(departamento != null && !departamento.trim().isEmpty()){
            this.departamento = departamento;
        }
        else{
            System.out.println("Departamento Invalido.");
        }
    }
    
    //Getter y Setter PUESTO
    public String getPuesto(){
        return puesto;
    }
    public void setPuesto(String puesto){
        if(puesto != null && !puesto.trim().isEmpty()){
            this.puesto = puesto;
        }
        else{
            System.out.println("Puesto Invalido.");
        }
    }
    
    //Getter y Setter FECHA DE INGRESO
    public String getFechaIngreso(){
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso){
        if(fechaIngreso != null && !fechaIngreso.trim().isEmpty()){
            this.fechaIngreso = fechaIngreso;
        }
        else{
            System.out.println("Fecha de Ingreso Invalida.");
        }
    }
    
    //Método toString
    @Override
    public String toString(){
        return "Personal: " +
                "Nombre='" + getNombre() + '\'' +
                ", Apellido='" + getApellido() + '\'' +
                ", Edad=" + getEdad() +
                ", Documento='" + getDocumento() + '\'' +
                ", Departamento='" + departamento + '\'' +
                ", Puesto='" + puesto + '\'' +
                ", Fecha de Ingreso='" + fechaIngreso + '\'';
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
