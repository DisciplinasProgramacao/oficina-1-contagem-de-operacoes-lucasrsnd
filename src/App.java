import java.util.Random;

public class App {
    static int[] tamanhosTesteGrande =  { 500_000, 1_000_000, 2_000_000, 3_000_000, 5_000_000, 10_000_000 };
    static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        48 };
    static Random aleatorio = new Random(42);

    static int codigo1(int[] vetor) {
        int resposta = 0;
        int operacoes = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i] % 2;
            operacoes++;
        }
        return operacoes;
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

    static long codigo3(int[] vetor) {
        long operacoes = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
                operacoes++;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
            operacoes++;
        }
        return operacoes;
    }

    static int codigo4(int n, int[] operacoes) {
        operacoes[0]++;
        if (n <= 2)
            return 1;
        else
            return codigo4(n - 1, operacoes) + codigo4(n - 2, operacoes);
    }

    static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho / 2);
        }
        return vetor;
    }

    public static void main(String[] args) {
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            long inicio = System.nanoTime();
            int operacoes1 = codigo1(vetor);
            long fim = System.nanoTime();
            System.out.println("Código 1 - Tamanho: " + tamanho + ", Tempo: " + (fim - inicio) + " ns, Operações: " + operacoes1);

            inicio = System.nanoTime();
            int operacoes2 = codigo2(vetor);
            fim = System.nanoTime();
            System.out.println("Código 2 - Tamanho: " + tamanho + ", Tempo: " + (fim - inicio) + " ns, Operações: " + operacoes2);
        }

        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);
            long inicio = System.nanoTime();
            long operacoes3 = codigo3(vetor);
            long fim = System.nanoTime();
            System.out.println("Código 3 - Tamanho: " + tamanho + ", Tempo: " + (fim - inicio) + " ns, Operações: " + operacoes3);
        }

        for (int n : tamanhosTestePequeno) {
            int[] operacoes4 = {0};
            long inicio = System.nanoTime();
            codigo4(n, operacoes4);
            long fim = System.nanoTime();
            System.out.println("Código 4 - Valor de n: " + n + ", Tempo: " + (fim - inicio) + " ns, Operações: " + operacoes4[0]);
        }
    }
}