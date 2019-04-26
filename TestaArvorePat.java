package TP01;

import java.util.Scanner;

public class TestaArvorePat {

    public static void main(String[] args) {
        try {
          
            Scanner input = new Scanner(System.in);
            ArvorePatricia dicionario = new ArvorePatricia(8);
            int i=1, op = 0;
            String palavra = null;
            char[] s_palavra=null;
            
            String palavras1[] = {"trabalho", "computacao", "governo", "educacao", "tecnologia",
                "formacao", "desenvolvimento", "que", "informatica", "em", "crise"};
            String palavras2[] = {"sociedade", "software", "ideia", "pessoa", "Informatica",
                "etica", "muito", "ciencia", "computacao", "que", "area", "moral"};

            ExtraiPalavra palavras = new ExtraiPalavra("/home/aluno/NetBeansProjects/AEDs2/src/TP01/delim.txt", "/home/aluno/NetBeansProjects/AEDs2/src/TP01/teste.txt");
            System.out.println("Digite o número do exemplo que vc quer executar:");
            System.out.println("1: Exemplo 01");
            System.out.println("2: Exemplo 02");
            //op = input.nextInt();
            op = 1;
            if (op == 1) {
                palavras = new ExtraiPalavra("/home/aluno/NetBeansProjects/AEDs2/src/TP01/delim.txt", "/home/aluno/NetBeansProjects/AEDs2/src/TP01/exemplo1.txt");
            }
            if (op == 2) {
                palavras = new ExtraiPalavra("delim.txt", "exemplo2.txt");
            }
            while ((palavra = palavras.proximaPalavra()) != null) {//insere palavras do arquivo escolhido
                if (!palavra.equals("")) {
                    System.out.println("Chave" + (i++) + ": " + palavra);
                    byte[] bytes = palavra.getBytes();
                    StringBuilder bs_palavra = new StringBuilder();
                    int j = 0;
                    for(byte b : bytes){
                        j++;
                        if (j > 8)
                            break;
                        int val = b;
                        for (int k = 0; k < 8; k++) {
                            bs_palavra.append((val & 128) == 0 ? 0 : 1);
                            val <<= 1;
                        }
                    }
                    while (bs_palavra.length()<128)
                        bs_palavra.insert(bs_palavra.length(), '0');
                    System.out.println("Chave" + ": " + bs_palavra.toString());
                    dicionario.insere(bs_palavra.toString().toCharArray());
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
