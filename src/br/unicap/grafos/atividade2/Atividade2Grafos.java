package br.unicap.grafos.atividade2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Atividade2Grafos {

    static int ordem, tamanho;
    static String linha;
    static LinkedList<LinkedList<Integer>> adj = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        leitorTxt("C:\\Users\\luizn\\Documents\\NetBeansProjects\\Atividade2Grafos\\src\\br\\unicap\\grafos\\atividade2\\grafo.txt");
        
        //Exibindo questões da atividade
        System.out.println("*** CARACTERÍSTICAS DO GRAFO ***");
        System.out.println("ORDEM: " + ordem);
        System.out.println("TAMANHO: " + tamanho);
        System.out.println("Nº VÉRTICES ISOLADOS: " + verticesIsolados());
        System.out.println("Nº VÉRTICES DE EXTREMIDADE: " + verticesExtremidade());
        System.out.println("GRAU DE ENTRADA DE CADA VÉRTICE: ");
        grauEntrada();
        System.out.println("====================");
        System.out.println("REPRESENTAÇÃO DO GRAFO: ");
        exibirListaAdj(adj);
        System.out.println();
    }

    static void leitorTxt(String caminho) throws FileNotFoundException, IOException {
        BufferedReader buffRead
                = new BufferedReader(new FileReader(caminho));

        linha = buffRead.readLine();
        ordem = Integer.parseInt(linha);   //capturar ordem (nº de vértices)

        linha = buffRead.readLine();
        tamanho = Integer.parseInt(linha); //capturar tamanho (nº de arestas)

        for (int i = 0; i < ordem; ++i) {  //criando lista de adjacência
            adj.add(new LinkedList<>());
        }

        //lendo txt e adicionando arestas
        linha = buffRead.readLine();
        while (linha != null) {
            String vu[] = linha.split(" ");
            int v = Integer.parseInt(vu[0]);
            int u = Integer.parseInt(vu[1]);
            adj.get(v).add(u);
            adj.get(u).add(v);
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    static void exibirListaAdj(LinkedList<LinkedList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("\n" + i + " -> ");
            for (int v : adj.get(i)) {
                System.out.print(v + " ");
            }
        }
    }

    private static void grauEntrada() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " = " + adj.get(i).size());
        }
    }

    private static int verticesIsolados() {
        int cont = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).isEmpty()) {
                cont++;
            }
        }
        return cont;
    }

    private static int verticesExtremidade() {
        int cont = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() == 1) {
                cont++;
            }
        }
        return cont;
    }
}
