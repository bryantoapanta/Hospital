

import java.util.Arrays;

public class Hospital 
{ 
    private Paciente tpacientes[];
    private int contadorpacientes;

    public Hospital(int numpacientes)
    {
        tpacientes = new Paciente[numpacientes];//definir longitud de la tabla pacientes
        contadorpacientes = 0;
    }

   
    
    // Ingreso de un paciente al hospital
       /**
     * Ingresa pacientes en la tabla
     * @return boolean
     * */
    public boolean ingreso(Paciente p)
    {	
    	for(int x=0; x<tpacientes.length;x++) {
    		if (tpacientes[x]==null) {
    			tpacientes[x]=p;//alamcena el paciente en la celda vacia.
    			contadorpacientes++;
    			//this.mostrartabla();
    			return true;
    		}
    		
    	}
        return false;
    }
  
    
    // Alta del paciente - se borra de la tabla
    /**Elimina el paciente que corresponde con el id
     * @return boolean
     * */
    public boolean alta ( int id_paciente){
    	for(int x=0; x<tpacientes.length;x++) {
    		if (tpacientes[x].getid()==id_paciente) {//SI COINCIDE CON EL ID DEL PACIENTE
    			tpacientes[x]=null;//BORRA EL PACIENTE
    			contadorpacientes--;// CONTADOR DISMINUYE
    			return true;
    		}
    	}
      return false;   
    }    
    
    // Devuelve el paciente con el identidador indicado o null si no existe
    /**
     * Busca el paciente que corresponde con el id
     * @return el paciente
     * */
    public Paciente buscar(int id){
    	this.ordenar();//LLAMA A ORDENAR PARA QUE NO QUEDE ESPACIO VACIO ENTRE CELDAS QUE CONTENGAN OBJETOS
    	//Arrays.sort(tpacientes,0,contadorpacientes);//ordena desde la posicion 0 hasta el contadorpacientes
    	for(int x=0; x<tpacientes.length;x++) {
    		//System.out.println("numero"+x+" ="+tpacientes[x]);
    		if(tpacientes[x]!=null) {// pregunto si la casilla esta vacia. si no esta vacia iguala para verificar si coincide id
    			 if(tpacientes[x].getid()==id) {
    	       		// System.out.println("Encontrado ="+tpacientes[x].getNombre());
    	       		 return tpacientes[x];// si se encuentra devuelvo el paciente
    	       		}
    		}
       	
       	
    	}
    	return null;
    	
    }
    
    // Imprime por consola la lista ORDENADO por NOMBRE de pacientes ***
    /**
     * Imprime los pacientes de forma ordenada por nombres
     * @see ordenar()
     * */
    public void listapacientes (){
    	this.ordenar();//LLAMA A ORDENAR PARA QUE NO QUEDE ESPACIO VACIO ENTRE CELDAS QUE CONTENGAN OBJETOS
    	//Arrays.sort(tpacientes,0,contadorpacientes);//ordena desde la posicion 0 hasta el contadorpacientes
     for(int x=0; x<tpacientes.length;x++) {
    	 
 		if (tpacientes[x] instanceof Paciente){// si es una instancia de pciente ejecuta la accion
 		System.out.println(tpacientes[x].toString());//to string imprime id mas nombre
     }}
    
    }    
       
    // Devuelve el mas grave o el caso de paciente con la misma gravedad el
    // que su identificador sea mas bajo.
    /**
     * Devuelve el paciente mas grave
     * @return aux , que seria el paciente mas grave
     * */
    public Paciente pacienteMasUrgente(){
    	boolean normales=true;
    	PacienteGrave aux=new PacienteGrave(null, null);
    	this.ordenar();
    	//Arrays.sort(tpacientes,0,contadorpacientes);//ordena desde la posicion 0 hasta el contadorpacientes
    	//Paciente [] tnormales= new Paciente[contadorpacientes-contadorpacienteGrave()];
    	PacienteGrave [] tgrave= new PacienteGrave[contadorpacienteGrave()];//CREO UNA TABLA PARA ALMACENAR LOS PACIENTES GRAVES
       
    	//Creamos un for para almacenar en tablas diferentes los tipod de paciente
    	for (int x=0;x<contadorpacientes;x++) {
        	if(tpacientes[x] instanceof PacienteGrave) {// si el objeto es una instancia de paciente grave 
        		tgrave[x]=(PacienteGrave) tpacientes[x];// guardo en tgrave el paciente. hace falta casting ya que no todos son de tipo grave
        	}
        }
    	
    	for(int i=0; i<tgrave.length;i++) {//RECORRE LA TABLA GRAVE
    		if(i==0) {// SI ES 0, AUX = AL OBJETO DE LA POSICION 0
    			aux=tgrave[i];
    		}
    		else {//SI NO ES 0 LA POSICION.
    			if(aux.grave().ordinal()<tgrave[i].grave().ordinal()) {//SI LA POSICION AUX DEL PACIENTE DE TIPO GRAVE ES MENOR QUE LA POSICION ACTUAL.
    				aux=tgrave[i];    			}// AUX = EL PACIENTE GRAVE
    		}
    		
    		if(aux==tgrave[i]) {// SI SON IGUALES
    			if(aux.getid()>tgrave[i].getid()) {//COMPARO PARA VER CUAL TIENE MENOR INDICADOR
    				aux=tgrave[1];
    			}
    			else aux=aux;
    		}
    	}
    return aux;  
        
    }    
    
    
  /*  public void mostrartabla()
    {
    	for(int x=0; x<tpacientes.length;x++) {
    		tpacientes[x]= (Paciente)tpacientes[x];
    		if (tpacientes[x] instanceof Paciente){// si es una instancia de pciente ejecuta la accion
    		System.out.println(x+"="+tpacientes[x].getNombre());
    		}}
    }
    */
    /**
     * ordena el array para que no queden huecos libres entre objetos
     * */
    public void ordenar() {// ordena la tabla para que no hay espacios vacios entre celdas de objetos.
    	for(int x=0; x<tpacientes.length;x++) {
    		if(x!=tpacientes.length-1) {//mientras no sea la ultima posicion
    			if(tpacientes[x]==null && tpacientes[x+1]!=null) {
        			tpacientes[x]=tpacientes[x+1];
        			tpacientes[x+1]=null;
        		}
    		}
    		
    	}
    }
   
    /**
     * Metodo usado para ver cuantos pacientes graves hay.
     * @return contadorpaciente
     * */
    public int contadorpacienteGrave()
    {	int contadorpaciente=0;
    	this.ordenar();
    	Arrays.sort(tpacientes,0,contadorpacientes);//ordena desde la posicion 0 hasta el contadorpacientes
    	for(int x=0; x<contadorpacientes;x++) {// hasta los pacientes existentes
    	
    		if (tpacientes[x] instanceof PacienteGrave){// si es una instancia de paciente ejecuta la accion
    		//System.out.println(x+"="+tpacientes[x].getNombre());
    		contadorpaciente++;
    		}
    		}
    return contadorpaciente;
    }    
}
    
/*public Paciente[] tabla(){
	return this.tpacientes;
}}*/