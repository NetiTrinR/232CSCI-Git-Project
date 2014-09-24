/**
 * Created by Michael Manning on 9/4/2014.
 */
public class BinaryTreeVertex extends Vertex {
    private BinaryTreeVertex leftChild = null;
    private BinaryTreeVertex rightChild = null;
    private BinaryTreeVertex parent = null;

    public BinaryTreeVertex(int value, BinaryTreeVertex leftChild, BinaryTreeVertex rightChild, BinaryTreeVertex parent) {
        super(value);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.parent = parent;
    }
    public BinaryTreeVertex(int value, BinaryTreeVertex parent){
        super(value);
        this.parent = parent;
    }

    public BinaryTreeVertex getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeVertex leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeVertex getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeVertex rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeVertex getParent() {
        return parent;
    }

    public void setParent(BinaryTreeVertex parent) {
        this.parent = parent;
    }
}
