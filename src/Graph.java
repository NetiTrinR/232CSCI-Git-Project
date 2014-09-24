import java.util.ArrayList;

/**
 * Created by Michael Manning on 8/28/2014.
 */
public class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    public void addVertex(Vertex inputVertex){
        vertices.add(inputVertex);
    }

    public void addEdge(Edge inputEdge){
        edges.add(inputEdge);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void removeVertex(Vertex inputVertex) {
        vertices.remove(inputVertex);
    }

    public void removeEdge(Edge inputEdge) {
        edges.remove(inputEdge);
    }

    public void clearEdges(){
        edges.clear();
    }

}
