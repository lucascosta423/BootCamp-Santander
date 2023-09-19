package candidaturas;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class processoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        for (String candidato: candidatos) {
            ligandoCanditosSelecionados(candidato);
        }
    }
    static void ligandoCanditosSelecionados(String candidato) {

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do {
            atendeu= atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        }while(continuarTentando && tentativasRealizadas<3);

        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM "
                    + candidato +" NA "
                    + tentativasRealizadas
                    + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM "
                    + candidato +", NÚMERO MAXIMO TENTATIVAS "
                    + tentativasRealizadas + " REALIZADA");
    }
    //método auxiliar
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void imprimindoCandidatosSelecionados(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};

        System.out.println("Imprimindo candidatos com os indices");

        for (int i = 0; i < candidatos.length;i++){
            System.out.println("Candidato de n° " + (i + 1) + " é o "+ candidatos[i]);
        }

        System.out.println("Forma Abreviada");
        for (String candidato: candidatos) {
            System.out.println("O candidato selecionado foi "+ candidato);
        }
    }
    static void selecionarCandidatos(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("-----------------------------------");
            System.out.println("O candidato " + candidato + " solicitou o salario R$"+salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;

            }
            System.out.println("-----------------------------------");
            candidatoAtual++;
        }
    }
    static void analisarCandidatos(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
        }else{
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

}
