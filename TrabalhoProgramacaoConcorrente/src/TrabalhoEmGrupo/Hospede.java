package TrabalhoEmGrupo;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Hospede extends Thread {

	 private int id;
	    private List<Quarto> quartos;
	    private BlockingQueue<Hospede> hospedeEsperando;
	    private BlockingQueue<Quarto> quartoDisponivel;

	    public Hospede(int id, List<Quarto> quartos, BlockingQueue<Hospede> hospedeEsperando, BlockingQueue<Quarto> quartoDisponivel) {
	        this.id = id;
	        this.setQuartos(quartos);
	        this.setHospedeEsperando(hospedeEsperando);
	        this.quartoDisponivel = quartoDisponivel;
	    }

	    public void run() {
	    	
	    	 while (true) {
	             try {
	                 // Espera por um quarto disponível
	                 Quarto quarto = quartoDisponivel.take();
	                 quarto.adicionarHospede(this);
	                 System.out.println("Hospede " + id + " Entrou no quarto " + quarto.getNumero());
	                 
	                 Thread.sleep(5000); // Simulando estadia no quarto
	                 
	                 // Hóspedes saem do hotel
	                 quarto.gethospede().clear();
	                 quarto.quartoLiberado();
	                 quartoDisponivel.add(quarto);
	                 System.out.println("Hospede " + id + " Saiu do quarto " + quarto.getNumero());
	                 
	                 // Simula passeio pela cidade
	                 Thread.sleep(3000); // Simulando passeio
	             } catch (InterruptedException e) {
	                 e.printStackTrace();        
	             }
	             
	    	 }
	    	 
	    }

	    
		public static void add(Hospede hospede) {
			
		}

		public List<Quarto> getQuartos() {
			return quartos;
		}

		public void setQuartos(List<Quarto> quartos) {
			this.quartos = quartos;
		}

		public BlockingQueue<Hospede> getHospedeEsperando() {
			return hospedeEsperando;
		}

		public void setHospedeEsperando(BlockingQueue<Hospede> hospedeEsperando) {
			this.hospedeEsperando = hospedeEsperando;
		}
	 
	}
	

