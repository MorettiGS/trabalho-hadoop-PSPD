def contar_palavras(nome_arquivo):
    with open(nome_arquivo, 'r', encoding='utf-8') as f:
        return sum(1 for _ in f.read().split())

if __name__ == "__main__":
    num_palavras = contar_palavras("words.txt")
    print(f"O arquivo contém {num_palavras} palavras.")

