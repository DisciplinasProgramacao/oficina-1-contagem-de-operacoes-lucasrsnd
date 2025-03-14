import matplotlib.pyplot as plt
import numpy as np

# Dados obtidos na execução
codigo1_tamanhos = [500000, 1000000, 2000000, 3000000, 5000000, 10000000]
codigo1_tempos = [2830900, 851900, 712900, 1335300, 1600000, 3271900]
codigo1_operacoes = [250000, 500000, 1000000, 1500000, 2500000, 5000000]

codigo2_tamanhos = [500000, 1000000, 2000000, 3000000, 5000000, 10000000]
codigo2_tempos = [3727000, 1562200, 4300, 1300, 800, 700]
codigo2_operacoes = [1000006, 2000006, 4000006, 6000005, 10000008, 20000008]

codigo3_tamanhos = [12500, 25000, 50000, 100000, 200000]
codigo3_tempos = [41128800, 120509200, 650120000, 1803791200, 7285631400]
codigo3_operacoes = [78131249, 312512499, 1250024999, 5000049999, 20000099999]

codigo4_tamanhos = [3, 6, 12, 24, 48]
codigo4_tempos = [22400, 3000, 22900, 700500, 22013195300]
codigo4_operacoes = [3, 15, 287, 92735, 1025119359]

# Função para gerar gráficos
def gerar_grafico(tamanhos, tempos, operacoes, titulo):
    fig, ax1 = plt.subplots()
    ax1.set_xlabel("Tamanho da Entrada (N)")
    ax1.set_ylabel("Tempo de Execução (ns)", color='tab:red')
    ax1.plot(tamanhos, tempos, 'o-', color='tab:red', label="Tempo de Execução")
    ax1.tick_params(axis='y', labelcolor='tab:red')
    
    ax2 = ax1.twinx()
    ax2.set_ylabel("Número de Operações", color='tab:blue')
    ax2.plot(tamanhos, operacoes, 's-', color='tab:blue', label="Número de Operações")
    ax2.tick_params(axis='y', labelcolor='tab:blue')
    
    plt.title(titulo)
    fig.tight_layout()
    plt.show()

# Gerar gráficos para cada código
gerar_grafico(codigo1_tamanhos, codigo1_tempos, codigo1_operacoes, "Código 1 - Tempo e Operações")
gerar_grafico(codigo2_tamanhos, codigo2_tempos, codigo2_operacoes, "Código 2 - Tempo e Operações")
gerar_grafico(codigo3_tamanhos, codigo3_tempos, codigo3_operacoes, "Código 3 - Tempo e Operações")
gerar_grafico(codigo4_tamanhos, codigo4_tempos, codigo4_operacoes, "Código 4 - Tempo e Operações")
