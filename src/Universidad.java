import java.util.ArrayList;

public class Universidad {
    
    String nombre;
    String direccion;
    ArrayList<Carrera> carreras;//Relacion con la clase Carrera.
    ArrayList<Estudiante> estudiantes;//Relacion con la clase Estudiante.
    ArrayList<Profesor> profesores;//Relacion con la clase Profesor.
    ArrayList<Personal> personal;//Relacion con la clase Personal.
    private IndiceEstudiante indice;
    
    public Universidad(String nombre, String direccion){
        this.nombre=nombre;
        this.direccion=direccion;
        this.carreras= new ArrayList<>();
        this.estudiantes=new ArrayList<>();
        this.profesores=new ArrayList<>();
        this.personal=new ArrayList<>();
        this.indice = new IndiceEstudiante();
    }
    //GETTERS
    public String getNombre(){
        return nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public ArrayList<Carrera> getCarreras(){
        return carreras;
    }
    public ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }
    public ArrayList<Profesor> getProfesores(){
        return profesores;
    }
    public ArrayList<Personal> getPersonal(){
        return personal;
    }
    //SETTERS
    public void setNombre(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
           this.nombre=nombre;
        }
        else{
            System.out.println("Nombre Invalido.");
        }
    }
    public void setDireccion(String direccion){
         if(direccion != null && !direccion.trim().isEmpty()){
           this.direccion=direccion;
        }
        else{
            System.out.println("Dirección Invalida.");
        }
    }
    public void setEstudiantes(ArrayList<Estudiante> estudiantes){
        this.estudiantes=estudiantes;
    }
    public void setProfesores(ArrayList<Profesor> profesores){
        this.profesores = profesores;
    }
    public void setPersonal(ArrayList<Personal> personal){
        this.personal = personal;
    }
    
    public void agregarEstudiante(Estudiante estudiante){
        for(Estudiante e : estudiantes){
            if(estudiante.getDocumento().equalsIgnoreCase(e.getDocumento())){
                System.out.println("Error: El estudiante con documento " + estudiante.getDocumento() + " ya existe.");
                return;
            }
        }
        for(Carrera carrera : carreras){
            if(carrera.getNombre().equalsIgnoreCase(estudiante.getCarrera())){
                carrera.agregarEstudiante(estudiante);
                break;
            }
        }
            estudiantes.add(estudiante);
            indice.insertar(estudiante.getDocumento(), estudiante);
        }

    public void agregarProfesor(Profesor profesor){
        if(profesor != null){
            profesores.add(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " " + profesor.getApellido() + " agregado exitosamente.");
        } else {
            System.out.println("Profesor invalido.");
        }
    }
    
    public void agregarPersonal(Personal personal){
        if(personal != null){
            this.personal.add(personal);
            System.out.println("Personal " + personal.getNombre() + " " + personal.getApellido() + " agregado exitosamente.");
        } else {
            System.out.println("Personal invalido.");
        }
    }
    
    public Profesor obtenerProfesor(String documento){
        for(Profesor profesor : profesores){
            if(profesor.getDocumento().equalsIgnoreCase(documento)){
                return profesor;
            }
        }
        return null;
    }
    
    public Personal obtenerPersonal(String documento){
        for(Personal empleado : personal){
            if(empleado.getDocumento().equalsIgnoreCase(documento)){
                return empleado;
            }
        }
        return null;
    }
    
    //METODOS PARA GESTIONAR CARRERAS
    public void agregarCarrera(Carrera carrera){
        if(carrera != null){
            carreras.add(carrera);
            System.out.println("Carrera " + carrera.getNombre() + " agregada exitosamente.");
        }
        else{
            System.out.println("Carrera invalida.");
        }
    }
    
    public Carrera obtenerCarrera(String nombre){//esto es para buscar la carrera a la que se le va a inscribir el estudiante.
        for(Carrera carrera : carreras){
            if(carrera.getNombre().equalsIgnoreCase(nombre)){
                return carrera;
            }
        }
        return null;
    }
    
    public void listarCarreras(){
        System.out.println("=== CARRERAS DE " + nombre + " ===");
        if(carreras.isEmpty()){
            System.out.println("No hay carreras registradas.");
        }
        else{
            for(Carrera carrera : carreras){
                System.out.println("- " + carrera.getNombre());
            }
        }
    }
    
    //Método toString
    @Override
    public String toString(){
        return "Universidad:" +
                "Nombre='" + nombre + '\'' +
                ", Direccion='" + direccion + '\'' +
                ", Carreras=" + carreras.size() +
                ", Estudiantes=" + estudiantes.size() +
                ", Profesores=" + profesores.size() +
                ", Personal=" + personal.size();
    }
    
    //Método equals - utiliza nombre como identificador único
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Universidad universidad = (Universidad) o;
        return nombre != null && nombre.equals(universidad.nombre);
    }
    
    //Método hashCode - basado en nombre
    @Override
    public int hashCode(){
        return nombre != null ? nombre.hashCode() : 0;
    }

    //Clase IndiceEstudiante
    public class IndiceEstudiante {
    //***ATRIBUTOS DE LA CLASE
        private Estudiante[] tabla;
        private int tamaño;
        private int cantidadInsertados;

    //***CONSTRUCTOR
    public IndiceEstudiante(){
        this.tamaño=23;
        this.tabla=new Estudiante[tamaño];
        this.cantidadInsertados=0;
    }

    //***METODOS

    //***METODO HASH
    private int hash(String legajo){
        int suma=0;
        for(int i=0;i<legajo.length();i++){
            suma=suma+legajo.charAt(i);
        }
        return suma%tamaño;
    }

    //***METODO PARA INSERTAR
    public void insertar(String legajo,Estudiante estudiante){
        double factorCarga=(double)cantidadInsertados/tamaño;
        if(factorCarga>=0.75){
            System.out.println("Error la tabla hash ya esta llena");
            return;
        }
        int o=hash(legajo);//++++calcula la posicion segun el legajo;
        int r=0;//**Posicion de exploracion */
        int p=0;//**Pasos en la exploracion 
        while(tabla[o]!=null){
            p+=1;
            r=exploracionCuadratica(o,p);
            o=r;
        }
        tabla[o]=estudiante;
        cantidadInsertados+=1;
    }

    //***METODO PARA LA EXPLORACION
    private int exploracionCuadratica(int o,int p){
        int funcion=(o+(p*p))%tamaño;
        return funcion;
    }


    //***METODO PARA BUSCAR
    public Estudiante buscar(String legajo){
       int o=0;//+++pasos para la exploracion
        int r=hash(legajo);//++++calcula la posicion segun el dni;

        while(tabla[r]!=null){
            if(tabla[r].getDocumento().equalsIgnoreCase(legajo)){
                return tabla[r];
            }
            o+=1;
            r=exploracionCuadratica(r,o);
        }
        return null;
    }
    }
       //metodo para buscar estudiante por documento
    public Estudiante buscarPorDocumento(String documento){
    Estudiante encontrado = indice.buscar(documento);
    if(encontrado!=null){
        System.out.println(encontrado.toString());
    }else{
        System.out.println("Estudiante no encontrado.");
    }
    return encontrado;
    }
}
