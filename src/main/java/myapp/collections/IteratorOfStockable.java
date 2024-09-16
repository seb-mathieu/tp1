package myapp.collections;

public class IteratorOfStockable {
    private ListOfStockable list;
    private ListElementOfStockable current = null;


    
    public IteratorOfStockable(ListOfStockable list) {
        this.list = list;
        restart();
    }

    public void restart() {
        current = list.head;
    }

    public Stockable next() throws EndOfListException{
        if (current == null) {
            throw new EndOfListException();
        } else {
            Stockable data = current.getData();
            current = current.getNextElement();
            return data;
        }
    }    

    public boolean hasNext(){
        if (current != null){
            return true;
        }
        return false;
    }
}
