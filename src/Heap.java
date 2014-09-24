import java.util.ArrayList;

/**
 * Created by Michael Manning on 9/11/2014.
 * Pseudo code found at http://www.algorithmist.com/index.php/Heap_sort
 */
public class Heap extends BinaryTree {
    private ArrayList<Integer> indices = new ArrayList<Integer>();
    private int heapSize;

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        for (int i : new int[]{ 6, 5, 3, 1, 8, 7, 2, 4 }){
            test.add(i);
        }
        Heap h = new Heap(test);
    }

    public Heap(ArrayList<Integer> indices) {
        this.indices = indices;
        ArrayList<HeapVertex> vertices = new ArrayList<HeapVertex>();

        //Create the right size for vertices
        vertices.trimToSize();
        for(int i = 0; i < indices.size(); i++){
            vertices.add(null);//So stupid. much wow
        }

        //Create the tree and relations, set the vertices
        HeapVertex root = new HeapVertex(indices, vertices, 0, null);//This creates all of the required nodes

        //Set heapsize
        heapSize = vertices.size()-1;

        //Sort it
        heapSort(vertices);
        System.out.println(indices);
    }

    public ArrayList<Integer> getIndices() {
        return indices;
    }

    public void setIndices(ArrayList<Integer> indices) {
        this.indices = indices;
    }

    public void heapSort(ArrayList<HeapVertex> vertices){

        for(int i = heapSize/2; i >= 0; i--){
            maxHeapify(vertices, vertices.get(i));
        }
//        System.out.println("Finished with heap\n");

        for(int i = heapSize; i >= 0; i--){
//            System.out.println("\nNext sort");
            swap(vertices.get(0), vertices.get(i));
            heapSize--;
            maxHeapify(vertices, vertices.get(0));
        }
    }

    public void maxHeapify(ArrayList<HeapVertex> array, HeapVertex working) {
        HeapVertex left = (HeapVertex)working.getLeftChild();
        HeapVertex right = (HeapVertex)working.getRightChild();
        HeapVertex max;

        if (left != null && left.getIndex() <= heapSize && left.getValue() > working.getValue()) {
            max = left;
        } else{
            max = working;
        }

        if(right != null && right.getIndex() <= heapSize && right.getValue() > max.getValue()){
            max = right;
        }

        if(max != working){
            swap(working, max);
            maxHeapify(array, max);
        }
    }

    public void swap(HeapVertex first, HeapVertex second){
        //Store first value in temporary variable
        int temp = first.getValue();

//        System.out.println("Swapped "+first.getValue()+" with "+second.getValue());
        //Set first variable with second value
        first.setValue(second.getValue());
        indices.set(first.getIndex(), second.getValue());

        //Set second variable with first original value
        second.setValue(temp);
        indices.set(second.getIndex(),temp);
//        System.out.println(indices);
    }
}
