package TrabalhoEmGrupo;

import java.util.concurrent.BlockingQueue;

public class Camareira extends Thread {

	 private int id;
	    private BlockingQueue<Quarto> quartoSujo;
	    private BlockingQueue<Quarto> quartoLimpo;

	    public Camareira(int id, BlockingQueue<Quarto> quartoSujo, BlockingQueue<Quarto> quartoLimpo) {
	        this.id = id;
	        this.quartoSujo = quartoSujo;
	        this.quartoLimpo = quartoLimpo;
	    }

	    public void run() {
	      
	    	while (true) {
	             try {
	                  // Espera por um quarto sujo
	                 Quarto quarto = quartoSujo.take();
	                 System.out.println("Camareira " + id + " limpando o quarto " + quarto.getNumero());
	                 Thread.sleep(4000); 
	                 quartoLimpo.add(quarto);
	              } catch (InterruptedException e) {
	                  e.printStackTrace();
	              }
	          }
	      }
	  
	    
		public void start() {
			
		}
	}
	

