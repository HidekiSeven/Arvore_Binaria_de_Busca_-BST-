import java.util.Scanner;


class No {
    int valor;
    No esquerda;
    No direita;

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}


class ArvoreBinariaDeBusca {
    No raiz;

    public ArvoreBinariaDeBusca() {
        this.raiz = null;
    }


    public void inserir(int valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }


    private No inserirRecursivo(No noAtual, int valor) {
        if (noAtual == null) {
            return new No(valor);
        }
        if (valor < noAtual.valor) {
            noAtual.esquerda = inserirRecursivo(noAtual.esquerda, valor);
        } else if (valor > noAtual.valor) {
            noAtual.direita = inserirRecursivo(noAtual.direita, valor);
        }
        return noAtual;
    }


    public void percursoEmOrdem() {
        System.out.println("--- Percurso Em Ordem (Crescente) ---");
        percursoEmOrdemRecursivo(this.raiz);
        System.out.println(); // Pula uma linha no final
    }

 
    private void percursoEmOrdemRecursivo(No no) {
        if (no != null) {
            percursoEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            percursoEmOrdemRecursivo(no.direita);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        

        ArvoreBinariaDeBusca bst = new ArvoreBinariaDeBusca();


        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Construtor de Árvore Binária de Busca ---");
        System.out.println("Digite o seu RA (ou uma sequência de 7 dígitos) sem espaços.");
        System.out.print("Sua sequência (ex: 2401718): ");


        String sequenciaStr = scanner.nextLine();

        if (sequenciaStr.length() != 7) {
            System.out.println("\n[ERRO] A sequência deve ter exatamente 7 dígitos.");
            System.out.println("Por favor, execute o programa novamente.");
        } else {
            
            System.out.println("\nInserindo os dígitos na árvore, um por um...");

            for (int i = 0; i < sequenciaStr.length(); i++) {
                

                char digitoChar = sequenciaStr.charAt(i); 

                int numero = Character.getNumericValue(digitoChar);


                if (numero < 0 || numero > 9) {
                     System.out.println("Caractere '" + digitoChar + "' não é um dígito, será ignorado.");
                     continue;
                }

                System.out.println("Inserindo: " + numero);
                bst.inserir(numero);
            }


            System.out.println("\n--- Árvore construída com sucesso! ---");
            bst.percursoEmOrdem();
        }


        scanner.close();
    }
}
