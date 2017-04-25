package matrizadyacencia;

public class Node {
    
    private final String data;
    private int x = 0,y = 0;

    public Node(String data) {
        this.data = data;
    }
    
    public void setCoords (int _x,int _y){
        x = _x;
        y = _y;
    }
    
    public boolean isValid(){
        return x != 0 && y != 0;
    }
    
    public String getData(){
        return data;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
}
