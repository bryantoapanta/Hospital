public class Paciente implements Comparable<Paciente>
{
    private static int numpaciente =0;
    private int id;
    private String nombre;

    public Paciente(String nombre)
    {
        this.nombre = nombre;
        numpaciente++;
        this.id = numpaciente;
    }
    
    public String toString(){
        return id +":"+nombre;
    }    
    public int getid() {
    	return this.id;
    }
    public int compareTo(Paciente o) {
    	return this.getNombre().toUpperCase().compareTo(o.getNombre().toUpperCase());
    }
    
    public String getNombre() {
    	return this.nombre;
    }
}