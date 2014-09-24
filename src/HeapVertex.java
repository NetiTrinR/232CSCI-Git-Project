import java.util.ArrayList;

/**
 * Created by Michael Manning on 9/11/2014.
 */
public class HeapVertex extends BinaryTreeVertex {
    private int index;

    public HeapVertex(ArrayList<Integer> indices, ArrayList<HeapVertex> vertices, int index, HeapVertex parent) {
        super(indices.get(index), parent);

        //Construct backwards based on index (Recursive depth first)
        this.index = index;
        vertices.set(index, this);
        int left = 2*index+1;
        int right = 2*index+2;
        if(left < indices.size()){
            this.setLeftChild(new HeapVertex(indices, vertices, left, this));
        }
        if(right < indices.size()){
            this.setRightChild(new HeapVertex(indices, vertices, right, this));
        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "i: "+this.getIndex()+", v:"+this.getValue();
    }
}
