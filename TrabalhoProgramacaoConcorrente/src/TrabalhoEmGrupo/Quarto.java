package TrabalhoEmGrupo;

import java.util.ArrayList;
import java.util.List;

public class Quarto {

	private int numero;
    private boolean ocupado;
    private List<Hospede> hospede;

    public Quarto(int numero) {
        this.numero = numero;
        this.ocupado = false;
        this.hospede = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public List<Hospede> gethospede() {
        return hospede;
    }

    public void quartoOcupado() {
        ocupado = true;
    }

    public void quartoLiberado() {
        ocupado = false;
        hospede.clear();
    }

    public void adicionarHospede(Hospede hospede) {
        Hospede.add(hospede);
    }

	public static void add(Quarto quarto) {
		// TODO Auto-generated method stub
		
	}
}

