package matrizadyacencia;

import com.sun.javafx.sg.prism.NGArc;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Jeff
 */
public class GraphViewer extends JFrame{
    
    ArrayList<Node> nodes;
    int[][] graph;
    
    private static final int SCREEN_WIDTH = 848, SCREEN_HEIGHT = 600, radius = 50;
    
    private int count;
    private boolean IsGraphReady = false;

    public GraphViewer(ArrayList<Node> nodes, int[][] graph) {
        this.nodes = nodes;
        this.graph = graph;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        requestFocusInWindow();
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        OnMouseEvent();
        count = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        nodes.stream().filter((n) -> (n.isValid())).forEachOrdered((n) -> {
            g.setColor(Color.yellow);
            g.fillOval(n.getX()-radius/2, n.getY()-radius/2, radius, radius);
            g.setColor(Color.blue);
            g.drawString(n.getData(), n.getX(), n.getY());
        });
        if (IsGraphReady) {
            g.setColor(Color.PINK);
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][j] == 1) {
                        Node ni = nodes.get(i), nf = nodes.get(j);
                        g.drawLine(ni.getX(), ni.getY(), nf.getX(), nf.getY());
                    }
                }
            }
        }
    }
    
    private void OnMouseEvent(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (count < nodes.size()) {
                    nodes.get(count).setCoords(e.getX(), e.getY());
                    repaint();
                    count++;
                }
                if(count == nodes.size() && !IsGraphReady){
                    IsGraphReady = true;
                    repaint();
                }
            }
         });
    }
    
    
    
}
