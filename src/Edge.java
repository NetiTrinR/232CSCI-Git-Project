
/**
 * Created by Michael Manning on 8/28/2014.
 */
public class Edge {
    private int value;
    private Vertex firstVertex;
    private Vertex secondVertex;
    private String edgeLabel;

    public Edge(int value, Vertex firstVertex, Vertex secondVertex) {
        this.value = value;
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vertex getFirstVertex() {
        return firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }

    public String getEdgeLabel() {
        return edgeLabel;
    }

    public void setEdgeLabel(String edgeLabel) {
        this.edgeLabel = edgeLabel;
    }

    public String toString(){
        return edgeLabel+"";
    }
}
