public class PacienteGrave extends Paciente
{
  
    private TipoGravedad gravedad; //enumerado

    public PacienteGrave(String nombre, TipoGravedad gravedad)
    {
        super(nombre);
        this.gravedad=gravedad;
    }

    public String toString()
    {
        return super.toString()+" "+this.gravedad;// Devuelve string de clase paciente + tipo de gravedad
    }
    public TipoGravedad grave() {
    	return this.gravedad;
    }
}
