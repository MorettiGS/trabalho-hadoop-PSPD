import re
from collections import Counter

def contar_ocorrencias(nome_arquivo):
    contador = Counter()
    
    with open(nome_arquivo, 'r', encoding='utf-8') as f:
        for linha in f:
            palavras = re.findall(r'\w+', linha.lower())  # Encontra todas as palavras, ignorando pontuação
            contador.update(palavras)  # Atualiza o contador com as palavras da linha

    return contador

def salvar_contagem(nome_saida, contagem):
    with open(nome_saida, 'w', encoding='utf-8') as f:
        f.writelines(f"{palavra}: {quantidade}\n" for palavra, quantidade in contagem.most_common())

if __name__ == "__main__":
    contagem = contar_ocorrencias("words.txt")
    salvar_contagem("ocurrences.txt", contagem)
    print("Contagem salva em 'ocurrences.txt'")

