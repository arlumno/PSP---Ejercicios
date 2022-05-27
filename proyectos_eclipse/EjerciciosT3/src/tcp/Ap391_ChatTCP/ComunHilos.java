package tcp.Ap391_ChatTCP;
import java.net.Socket;

public class ComunHilos {	
	 int CONEXIONES; //Nº DE CONEXIONES TOTALES, OCUPADAS EN EL ARRAY
	 int ACTUALES;   //NÚMERO DE CONEXIONES ACTUALES
	 int MAXIMO;     //MÁXIMO DE CONEXIONES PERMITIDAS	
	 Socket tabla[] = new Socket[MAXIMO];// SOCKETS CONECTADOS
	 String mensajes; //MENSAJES DEL CHAT
	
	public ComunHilos(int maximo, int actuales, int conexiones, 
                                         Socket[] tabla) {
		MAXIMO = maximo;	 
		ACTUALES = actuales; 
		CONEXIONES = conexiones;	
		this.tabla = tabla;  
		mensajes="";        
	}

	public ComunHilos() { super(); }

     public int getMAXIMO() { return MAXIMO;	}
	public void setMAXIMO(int maximo) { MAXIMO = maximo;}


	public int getCONEXIONES() {
		int activas = 0;
		for(int i = 0 ; i< tabla.length;i++) {
			if(tabla[i] != null && !tabla[i].isClosed()) {
				activas++;
			}
		}
		return activas;	
	}
	public synchronized void  setCONEXIONES(int conexiones) {
		CONEXIONES = conexiones;
	}

	public String getMensajes() { return mensajes; }
	public synchronized void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	
	public int getACTUALES() { return getCONEXIONES(); }
	
//	public synchronized void setACTUALES(int actuales) {
//		ACTUALES = actuales;
//	}

	public synchronized void addTabla(Socket s) {
		int i = 0;
		boolean asignado = false;
		
		while(i< tabla.length && !asignado) {
			if(tabla[i] == null || tabla[i].isClosed()) {
				tabla[i] = s;
				asignado = true;
			}
			
			i++;
		}
		if(!asignado) {
			System.out.println("Error: no hay slots disponibles para la conexión.");			
		}
		
	}
	
	//public synchronized void addTabla(Socket s, int i) {		
	//	tabla[i] = s;
	//}	
	
	public Socket getElementoTabla(int i) { return tabla[i]; }
		
}//ComunHilos
