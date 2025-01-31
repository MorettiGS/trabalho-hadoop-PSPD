import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ContadorDePalavras {

    // Atualizando a expressão regular para capturar letras acentuadas e caracteres especiais da língua portuguesa
    public static Map<String, Integer> contarOcorrencias(String nomeArquivo) {
        Map<String, Integer> contador = new HashMap<>();
        // Expressão regular para capturar letras acentuadas e caracteres especiais
        Pattern pattern = Pattern.compile("[a-zA-Záàãâäéèêëíìîïóòõôöúùûüç]+");

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo, java.nio.charset.StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Transforma todas as palavras em minúsculas e encontra as palavras na linha
                Matcher matcher = pattern.matcher(linha.toLowerCase());
                while (matcher.find()) {
                    String palavra = matcher.group();
                    contador.put(palavra, contador.getOrDefault(palavra, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return contador;
    }

    public static void salvarContagem(String nomeSaida, Map<String, Integer> contagem) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeSaida, java.nio.charset.StandardCharsets.UTF_8))) {
            contagem.entrySet().stream()
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))  // Ordena por quantidade
                    .forEach(entry -> {
                        try {
                            bw.write(entry.getKey() + ": " + entry.getValue());
                            bw.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> contagem = contarOcorrencias("words.txt");
        salvarContagem("ocurrences.txt", contagem);
        System.out.println("Contagem salva em 'ocurrences.txt'");
    }
}

