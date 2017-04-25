package matrizadyacencia;

import java.util.ArrayList;

public class Matrizadyacencia {
    
    public static void main(String[] args) {
        
        // Definir la lista de nodos.
        ArrayList<Node> nodes = new ArrayList<>();
        
        //Agregar nodos a la lista.
        Node n = new Node("A");
        nodes.add(n);
        n = new Node("B");
        nodes.add(n);
        n = new Node("C");
        nodes.add(n);
        n = new Node("D");
        nodes.add(n);
        n = new Node("E");
        nodes.add(n);
        n = new Node("F");
        nodes.add(n);
        
        //Definir matriz de adyacencia e ingresar nodos.
        int[][] graph = {{0,1,1,1,1,1},{1,0,0,0,1,0},{1,0,0,0,1,1},{1,0,0,0,0,1},
            {1,1,1,0,0,0},{1,0,1,1,0,0}};
        
        new GraphViewer(nodes, graph);
        
    }
    
}
