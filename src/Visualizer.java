import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Michael Manning on 8/29/2014.
 */
public class Visualizer {
    private Graph graph;

    public static void main(String[] args) {
        System.out.println("Running...");

        System.out.println("Instantiating Graph");
        BinaryTree b = new BinaryTree();

        System.out.println("Instantiating Vertices");
        BinaryTreeVertex[] vs = {
                new BinaryTreeVertex(5, null, null, null),
                new BinaryTreeVertex(3, null, null, null),
                new BinaryTreeVertex(6, null, null, null),
                new BinaryTreeVertex(1, null, null, null),
                new BinaryTreeVertex(4, null, null, null)
        };

        for(BinaryTreeVertex v : vs){
            b.insert(b, v);
        }

        System.out.println("Instantiating Visualizer");
        Visualizer v = new Visualizer(b);

        System.out.println("Generating GUI...");
        v.generateGui();

        System.out.println("Done");
    }

    public Visualizer(Graph graph) {
        this.graph = graph;
    }

    public DelegateForest<Vertex, Edge> convertToForest(){
        DelegateForest<Vertex, Edge> forest =  new DelegateForest<Vertex, Edge>();
        ArrayList<Edge> edges = graph.getEdges();

        //Derek added this after class
//        for (Vertex v : graph.getVertices())
//        {
//            forest.addVertex(v);
//        }

        for(Edge edge : edges){
            //This line makes no sense, you can't just add all the vertices then link them, they have to be added one at a time and the linking vertex cannot be in the graph yet
            forest.addVertex(edge.getFirstVertex());//Derek commented this out after class
            forest.addEdge(edge, edge.getFirstVertex(), edge.getSecondVertex(), EdgeType.DIRECTED);//Derek removed EdgeType.DIRECTED after class
        }

        return forest;
    }

    public void generateGui(){
        BasicVisualizationServer<Vertex, Edge> jungBVS = new BasicVisualizationServer<Vertex, Edge>(new TreeLayout<Vertex, Edge>(convertToForest()));
        JFrame frame = new JFrame("Outlab 1 Graph");


        //Good resource at http://stackoverflow.com/questions/3288886/vertex-label-in-jung-graph-visualization
        //Add Labels
        jungBVS.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Vertex>());
        jungBVS.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Edge>());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(jungBVS);
        frame.pack();
        frame.setVisible(true);
    }
}
