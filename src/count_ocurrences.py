from collections import Counter

def contar_ocorrencias(nome_arquivo):
    with open(nome_arquivo, 'r', encoding='utf-8') as f:
        palavras = f.read().split()
    
    contagem = Counter(palavras)
    
    return contagem

def salvar_contagem(nome_saida, contagem):
    with open(nome_saida, 'w', encoding='utf-8') as f:
        for palavra, quantidade in contagem.most_common():
            f.write(f"{palavra}: {quantidade}\n")

if __name__ == "__main__":
    from collections import Counter  # Garantir que Counter está definido
    contagem = contar_ocorrencias("words.txt")
    salvar_contagem("ocurrences.txt", contagem)
    print("Contagem salva em 'ocurrences.txt'")
