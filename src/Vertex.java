/**
 * Created by Michael Manning on 8/28/2014.
 */
public class Vertex {
    private int value;

    public Vertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return ""+this.getValue();
    }
}
