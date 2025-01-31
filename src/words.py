import random

palavras_base = [
    "amor", "feliz", "triste", "sol", "lua", "estrela", "mar", "vento", "chuva", "neve", "fogo", "terra", "ar",
    "montanha", "vale", "rio", "lago", "oceano", "floresta", "deserto", "cidade", "vila", "praia", "ilha", "campo",
    "estrada", "ponte", "túnel", "carro", "ônibus", "bicicleta", "moto", "avião", "barco", "navio", "trem", "metrô",
    "futebol", "basquete", "voleibol", "xadrez", "corrida", "natação", "ginástica", "ciclismo", "boxe", "judô",
    "computador", "internet", "teclado", "mouse", "tela", "impressora", "telefone", "celular", "câmera", "vídeo",
    "música", "dança", "teatro", "cinema", "livro", "poesia", "pintura", "escultura", "fotografia", "arte",
    "matemática", "física", "química", "biologia", "geografia", "história", "filosofia", "sociologia", "psicologia",
    "economia", "política", "direito", "medicina", "engenharia", "arquitetura", "agricultura", "ciência", "tecnologia"
]

palavras = random.choices(palavras_base, k=150000000)

def criar_arquivo(nome_arquivo, palavras):
    with open(nome_arquivo, "w", encoding="utf-8") as f:
        f.write("\n".join(palavras))

if __name__ == "__main__":
    criar_arquivo("words.txt", palavras)
    print("Arquivo 'words.txt' criado com sucesso!")
