import java.io.*;
import java.util.*;

public class GeradorDePalavras {

    // Lista base de palavras
    private static final List<String> palavrasBase = Arrays.asList(
        "amor", "feliz", "triste", "sol", "lua", "estrela", "mar", "vento", "chuva", "neve", "fogo", "terra", "ar",
        "montanha", "vale", "rio", "lago", "oceano", "floresta", "deserto", "cidade", "vila", "praia", "ilha", "campo",
        "estrada", "ponte", "túnel", "carro", "ônibus", "bicicleta", "moto", "avião", "barco", "navio", "trem", "metrô",
        "futebol", "basquete", "voleibol", "xadrez", "corrida", "natação", "ginástica", "ciclismo", "boxe", "judô",
        "computador", "internet", "teclado", "mouse", "tela", "impressora", "telefone", "celular", "câmera", "vídeo",
        "música", "dança", "teatro", "cinema", "livro", "poesia", "pintura", "escultura", "fotografia", "arte",
        "matemática", "física", "química", "biologia", "geografia", "história", "filosofia", "sociologia", "psicologia",
        "economia", "política", "direito", "medicina", "engenharia", "arquitetura", "agricultura", "ciência", "tecnologia"
    );

    // Função para gerar as palavras aleatórias
    public static List<String> gerarPalavras(int quantidade) {
        List<String> palavrasGeradas = new ArrayList<>(quantidade);
        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            // Escolhe uma palavra aleatória da lista base
            palavrasGeradas.add(palavrasBase.get(random.nextInt(palavrasBase.size())));
        }
        return palavrasGeradas;
    }

    // Função para criar o arquivo
    public static void criarArquivo(String nomeArquivo, List<String> palavras) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, java.nio.charset.StandardCharsets.UTF_8))) {
            // Escreve as palavras no arquivo
            for (String palavra : palavras) {
                writer.write(palavra);
                writer.newLine(); // Adiciona uma nova linha entre as palavras
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> palavras = gerarPalavras(1150000000); // Gera 10 milhões de palavras
        criarArquivo("words.txt", palavras); // Cria o arquivo words.txt
        System.out.println("Arquivo 'words.txt' criado com sucesso!");
    }
}

