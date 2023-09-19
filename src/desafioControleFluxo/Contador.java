package desafioControleFluxo;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args){
        Scanner terminal = new Scanner(System.in);

        System.out.println("Digite o primeiro parametro: ");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parametro: ");
        int parametroDois = terminal.nextInt();

        contar(parametroUm,parametroDois);
    }

    static void contar(int parametroUm, int parametroDois){
        if (parametroUm > parametroDois){
            try {
                throw new ParametrosInvalidosException();
            } catch (ParametrosInvalidosException e) {
                e.printStackTrace();
            }
        }
        int contador = parametroDois - parametroUm;
        listaNumeros(contador);

    }
    static void listaNumeros(int contador){
        for (int i = 1; i <= contador;i++){
            System.out.print(i+" ");
        }
    }
}
