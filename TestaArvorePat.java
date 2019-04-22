package tp01;

import java.util.Scanner;

public class TestaArvorePat {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            ArvorePatricia dicionario = new ArvorePatricia(16);
            int i=1, op = 0;
            String palavra = null;
            char[] s_palavra=null;
            
            String palavras1[] = {"trabalho", "computacao", "governo", "educacao", "tecnologia",
                "formacao", "desenvolvimento", "que", "informatica", "em", "crise"};
            String palavras2[] = {"sociedade", "software", "ideia", "pessoa", "Informatica",
                "etica", "muito", "ciencia", "computacao", "que", "area", "moral"};

            ExtraiPalavra palavras = new ExtraiPalavra("delim.txt", "teste.txt");
            System.out.println("Digite o número do exemplo que vc quer executar:");
            System.out.println("1: Exemplo 01");
            System.out.println("2: Exemplo 02");
            op = input.nextInt();
            if (op == 1) palavras = new ExtraiPalavra("delim.txt", "exemplo1.txt");
            if (op == 2) palavras = new ExtraiPalavra("delim.txt", "exemplo2.txt");
            while ((palavra = palavras.proximaPalavra()) != null) {//insere palavras do arquivo escolhido
                if(!palavra.equals(""))
                {
                    System.out.println("Chave" + (i++) + ": " + palavra);
                    s_palavra=palavra.toCharArray();
                    //s_palavra=dicionario.stringTiago(s_palavra);
                    dicionario.insere(s_palavra);
                }
            }
            palavras.fecharArquivos();

            // @{\it Pesquisa cada chave na \'arvore}@
            if (op==1){
                for (i = 0; i < palavras1.length; i++) {
                    System.out.println("Pesquisando chave: " + (i+1) + ": " + palavras1[i]);
                    s_palavra=palavras1[i].toCharArray();
                    //s_palavra=ArvorePatricia.stringTiago(s_palavra);
                    dicionario.pesquisa(s_palavra);
                }
            }
            else if (op==2){
                for (i = 0; i < palavras2.length; i++) {
                    System.out.println("Pesquisando chave: " + (i+1) + ": " + palavras2[i]);
                    s_palavra=palavras2[i].toCharArray();
                    //s_palavra=ArvorePatricia.stringTiago(s_palavra);
                    dicionario.pesquisa(s_palavra);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
