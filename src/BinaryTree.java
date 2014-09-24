import java.util.ArrayList;

/**
 * Created by Michael Manning on 9/4/2014.
 */
public class BinaryTree extends Graph {
    private BinaryTreeVertex root = null;

    public BinaryTreeVertex getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeVertex root) {
        this.root = root;
    }

    public BinaryTreeVertex iterativeSearch(BinaryTreeVertex node, int key){
        while(node != null && node.getValue() != key){
            if(key < node.getValue())
                node = node.getLeftChild();
            else
                node = node.getRightChild();
        }
        return node;
    }

    public BinaryTreeVertex search(BinaryTreeVertex node, int key){
        if(node == null || key == node.getValue())
            return node;
        if(key < node.getValue())
            return search(node.getLeftChild(), key);
        else
            return search(node.getRightChild(), key);
    }

    public void insert(BinaryTree tree, BinaryTreeVertex node){
        BinaryTreeVertex working = null;
        BinaryTreeVertex bus = tree.getRoot();
        while(bus != null){
            working = bus;
            if(node.getValue() < bus.getValue())
                bus = bus.getLeftChild();
            else
                bus = bus.getRightChild();
        }
        node.setParent(working);
        if(working == null)
            tree.setRoot(node);
        else if(node.getValue() < working.getValue())
            working.setLeftChild(node);
        else
            working.setRightChild(node);
        tree.addVertex(node);
    }

    public void transplant(BinaryTree tree, BinaryTreeVertex soil, BinaryTreeVertex plant){
        if(soil.getParent() == null)
            tree.setRoot(plant);
        else if(soil == soil.getParent().getLeftChild())
            soil.getParent().setLeftChild(plant);
        else
            soil.getParent().setRightChild(plant);
        if(plant != null)
            plant.setParent(soil.getParent());
    }

    public void removeVertex(BinaryTree tree, BinaryTreeVertex node){
        if(node.getLeftChild() == null)
            transplant(tree, node, node.getRightChild());
        else if(node.getRightChild() == null)
            transplant(tree,node,node.getLeftChild());
        else{
            BinaryTreeVertex bus = getMinimum(node.getRightChild());
            if(bus.getParent() != node){
                transplant(tree, bus, bus.getRightChild());
                bus.setRightChild(node.getRightChild());
                bus.getRightChild().setParent(bus);
            }
            transplant(tree, node, bus);
            bus.setLeftChild(node.getLeftChild());
            bus.getLeftChild().setParent(bus);
        }
        for(Edge edge : tree.getEdges()){
            if(edge.getFirstVertex() == node || edge.getSecondVertex() == node)
                tree.removeEdge(edge);
        }
        tree.removeVertex(node);
    }

    public BinaryTreeVertex getMinimum(BinaryTreeVertex node){
        while(node.getLeftChild() != null)
            node = node.getLeftChild();
        return node;
    }

    public ArrayList<Edge> getEdges(){
        this.clearEdges();
        preEdgeWalk(this.getRoot(),"root");//the root edge won't be added so the direction doesn't matter
        return super.getEdges();
    }

    //Because of the way Jung forest.addEdge works it has to be pre >.>
    public void preEdgeWalk(BinaryTreeVertex current, String direction){
        if(current != null) {
            if(current.getParent() != null) {
                //Add parent before child
                Edge toAdd = new Edge(0, current.getParent(), current);
                toAdd.setEdgeLabel(direction);
                this.addEdge(toAdd);
            }
            preEdgeWalk(current.getLeftChild(), "left");
            preEdgeWalk(current.getRightChild(),"right");
        }
    }
}
