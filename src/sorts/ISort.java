package sorts;

public class ISort {
    public static long sort(int[] vetor) {
        long operacoes = 0;
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            operacoes++; // Acesso ao vetor
            while (j >= 0 && vetor[j] > chave) {
                operacoes++; // Comparação
                vetor[j + 1] = vetor[j];
                j--;
                operacoes++; // Movimentação
            }
            vetor[j + 1] = chave;
            operacoes++; // Inserção
        }
        return operacoes;
    }
}
