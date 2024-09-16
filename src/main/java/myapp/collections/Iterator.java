package myapp.collections;

public class Iterator <T> {
    private List<T> list;
    private ListElement<T> current = null;


    
    public Iterator(List<T> list) {
        this.list = list;
        restart();
    }

    public void restart() {
        current = list.head;
    }

    public T next() throws EndOfListException{
        if (current == null) {
            throw new EndOfListException();
        } else {
            T data = current.getData();
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
