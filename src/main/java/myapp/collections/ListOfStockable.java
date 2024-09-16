package myapp.collections;

public class ListOfStockable {
    ListElementOfStockable head = null;

    public void addFirst(Stockable data) {
    ListElementOfStockable newElement = new ListElementOfStockable(data);
        if (head == null){
            head = newElement;
        }
        else {
            ListElementOfStockable nextElement=head;
            head = newElement;
            newElement.setNextElement(nextElement);
        }

    }


    public Stockable[] toArray() {
        // count number of elements
        int count = 0;
        ListElementOfStockable loopElement = head;
        while (loopElement != null) {
            count = count + 1;
            loopElement = loopElement.getNextElement();
        }
        // create array from list content
        Stockable[] array = new Stockable[count];
        int index = 0;
        loopElement = head;
        while (loopElement != null) {
            array[index] = loopElement.getData();
            index = index + 1;
            loopElement = loopElement.getNextElement();
        }
        return array;
        }

    public void add(Stockable data) {
        ListElementOfStockable newElement = new ListElementOfStockable(data);
        if (head == null){
            head = newElement;
        }
        else {
            ListElementOfStockable loopElement = head;
            while (loopElement.getNextElement() != null) {
                loopElement = loopElement.getNextElement();
            }
            loopElement.setNextElement(newElement);
        }
    }

    public boolean contains(Stockable data) {
        ListElementOfStockable loopElement = head;
        while (loopElement != null) {
            if (loopElement.getData().equals(data)) {
                return true;
            }
            loopElement = loopElement.getNextElement();
        }
        return false;
    }

    public Stockable findFirst(Stockable data) {
        ListElementOfStockable loopElement = head;
        while (loopElement != null) {
            if (loopElement.getData().equals(data)) {
                return loopElement.getData();
            }
            loopElement = loopElement.getNextElement();
        }
        return null;
    }
    
    public void delete(Stockable data) {
    if (head == null) {
        return;
    }
    if (head.getData().equals(data)) {
        head = head.getNextElement();
        return;
    }
    ListElementOfStockable loopElement = head;
    while (loopElement.getNextElement() != null) {
        if (loopElement.getNextElement().getData().equals(data)) {
            loopElement.setNextElement(loopElement.getNextElement().getNextElement());
            return;
        }
        loopElement = loopElement.getNextElement();
    }
}
}
