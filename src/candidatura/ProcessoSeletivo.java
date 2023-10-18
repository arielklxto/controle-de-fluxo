package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", "MARCIA", "JOANA"};
        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }
    }
    /**
     * @param candidato
     */
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }

        } while(continuarTentando && tentativasRealizadas<3);

        if(atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa!");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas);
        }

    }

    // método auxiliar
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void ImprimirSelecionados() {
        String [] candidatos = {"FELIPE", "MARCIA", "JOANA"};

        System.out.println("Imprimindo a lista de candidatos informando o indice");

        for(int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato nº " + (indice+1) + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de interação foreach");

        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "JOANA", "FABRICIO", "PEDRO", "JOÃO"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato" + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + "foi selecionado para a vaga");

                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");

        } else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA-PROPOSTA");
        } else {
            System.out.println("AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS");
        }

        
    }
}