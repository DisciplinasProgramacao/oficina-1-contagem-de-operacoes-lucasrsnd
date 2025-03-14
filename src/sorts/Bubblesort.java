package sorts;

public class Bubblesort {
    public static long sort(int[] vetor) {
        int n = vetor.length;
        long operacoes = 0;
        boolean trocou;
        do {
            trocou = false;
            for (int i = 0; i < n - 1; i++) {
                operacoes++; // Contando comparação
                if (vetor[i] > vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    trocou = true;
                    operacoes += 3; // Contando as trocas
                }
            }
            n--;
        } while (trocou);
        return operacoes;
    }
}
