package TrabalhoEmGrupo;

import java.util.concurrent.BlockingQueue;

public class Recepcionista extends Thread {

	private int id;
    private BlockingQueue<Quarto> quartoDisponivel;
    private BlockingQueue<Hospede> hospedeEsperando;

    public Recepcionista(int id, BlockingQueue<Quarto> quartoDisponivel, BlockingQueue<Hospede> hospedeEsperando) {
        this.id = id;
        this.quartoDisponivel = quartoDisponivel;
        this.hospedeEsperando = hospedeEsperando;
    }

    public void run() {

    	 while (true) {
             try {
                 // Espera por um hóspede
                 Hospede hospede = hospedeEsperando.take();
                 
                 // Procura por um quarto disponível
                 Quarto quarto = quartoDisponivel.poll();
                 if (quarto != null) {
                     quarto.quartoOcupado();
                     quarto.adicionarHospede(hospede);
                     System.out.println("Recepcionista " + id + " fez check-in do hospede " + hospede.getId() + " no quarto " + quarto.getNumero());
                 } else {
                     System.out.println("O Hospede " + hospede.getId() + " esta na fila de espera por um quarto");
                     Thread.sleep(2000);
                     hospedeEsperando.add(hospede);
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }

	public void start() {
		
	}


	
}
