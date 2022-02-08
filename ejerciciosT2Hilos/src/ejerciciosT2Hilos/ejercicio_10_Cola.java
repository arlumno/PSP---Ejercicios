package ejerciciosT2Hilos;

public class ejercicio_10_Cola {
	private char letra;
    private boolean disponible = false;
    private boolean end = false;
    
    public synchronized char get() {
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        disponible = false;
        notify();
        return letra;
    }

    public synchronized void put(char  valor) {
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        letra = valor;
        disponible = true;
        notify();
    }
    public synchronized void setEnd() {
    	end = true;
    }
    public synchronized boolean getEnd() {
    	return end;
    }
}
