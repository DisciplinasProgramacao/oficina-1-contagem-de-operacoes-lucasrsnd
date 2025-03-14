import java.util.Random;

public class App {
    static int[] tamanhosTesteGrande = {500_000, 1_000_000, 2_000_000, 3_000_000, 5_000_000, 10_000_000};
    static int[] tamanhosTesteMedio = {12_500, 25_000, 50_000, 100_000, 200_000};
    static int[] tamanhosTestePequeno = {3, 6, 12, 24, 48};
    static Random aleatorio = new Random(42);

    public static void main(String[] args) {
        executarTesteCodigo1();
        executarTesteCodigo2();
        executarTesteCodigo3();
        executarTesteCodigo4();
    }

    static int codigo1(int[] vetor) {
        int resposta = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i] % 2;
        }
        return resposta;
    }

    static int codigo2(int[] vetor) {
        int contador = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
            }
        }
        return contador;
    }

    static void codigo3(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
    }

    static int codigo4(int n) {
        if (n <= 2)
            return 1;
        else
            return codigo4(n - 1) + codigo4(n - 2);
    }

    static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho / 2);
        }
        return vetor;
    }

    static void executarTesteCodigo1() {
        System.out.println("Executando Código 1...");
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            long inicio = System.nanoTime();
            int resultado = codigo1(vetor);
            long fim = System.nanoTime();
            System.out.printf("Tamanho: %d | Resultado: %d | Tempo: %.4f ms\n",
                    tamanho, resultado, (fim - inicio) / 1e6);
        }
    }

    static void executarTesteCodigo2() {
        System.out.println("\nExecutando Código 2...");
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            long inicio = System.nanoTime();
            int operacoes = codigo2(vetor);
            long fim = System.nanoTime();
            System.out.printf("Tamanho: %d | Operações: %d | Tempo: %.4f ms\n",
                    tamanho, operacoes, (fim - inicio) / 1e6);
        }
    }

    static void executarTesteCodigo3() {
        System.out.println("\nExecutando Código 3...");
        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);
            long inicio = System.nanoTime();
            codigo3(vetor);
            long fim = System.nanoTime();
            System.out.printf("Tamanho: %d | Tempo: %.4f ms\n",
                    tamanho, (fim - inicio) / 1e6);
        }
    }

    static void executarTesteCodigo4() {
        System.out.println("\nExecutando Código 4...");
        for (int tamanho : tamanhosTestePequeno) {
            long inicio = System.nanoTime();
            int resultado = codigo4(tamanho);
            long fim = System.nanoTime();
            System.out.printf("N: %d | Resultado: %d | Tempo: %.4f ms\n",
                    tamanho, resultado, (fim - inicio) / 1e6);
        }
    }
}
