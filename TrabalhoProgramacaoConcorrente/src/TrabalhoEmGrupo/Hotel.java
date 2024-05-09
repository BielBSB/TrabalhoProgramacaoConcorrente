package TrabalhoEmGrupo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Hotel {
    public static void main(String[] args) {
        int numQuarto = 10;
        int numHospede = 50;
        int numCamareira = 10;
        int numRecepcionista = 5;

        BlockingQueue<Quarto> quartoDisponivel = new ArrayBlockingQueue<>(numQuarto);
        BlockingQueue<Quarto> quartoSujo = new ArrayBlockingQueue<>(numQuarto);
        BlockingQueue<Quarto> quartoLimpo = new ArrayBlockingQueue<>(numQuarto);
        BlockingQueue<Hospede> hospedeEsperando = new ArrayBlockingQueue<>(numHospede);

        // Criar quartos
        List<Quarto> quarto = new ArrayList<>();
        for (int i = 1; i <= numQuarto; i++) {
            quarto.add(new Quarto(i));
            quartoDisponivel.add(quarto.get(i - 1));
        }

        // Iniciar camareiras
        for (int i = 0; i < numCamareira; i++) {
            new Camareira(i, quartoSujo, quartoLimpo).start();
        }

        // Iniciar recepcionistas
        for (int i = 0; i < numRecepcionista; i++) {
            new Recepcionista(i, quartoDisponivel, hospedeEsperando).start();
        }

        // Iniciar hóspedes
        for (int i = 0; i < numHospede; i++) {
            new Hospede(i, quarto, hospedeEsperando, quartoDisponivel).start();
        }
    }
}
