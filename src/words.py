import random
import nltk
from nltk.corpus import floresta

nltk.download("floresta")

palavras_portugues = list(set(word.lower() for word in floresta.words() if word.isalpha()))

def gerar_arquivo(quantidade=250000):
    with open("words.txt", 'w', encoding='utf-8') as f:
        palavras_aleatorias = ' '.join(random.choices(palavras_portugues, k=quantidade))
        f.write(palavras_aleatorias)

if __name__ == "__main__":
    gerar_arquivo()
    print("Arquivo 'words.txt' gerado com sucesso!")
