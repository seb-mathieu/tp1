package myapp.collections;

public class List<T> {
    ListElement<T> head = null;

    public void addFirst(T data) {
    ListElement<T> newElement = new ListElement<T>(data);
        if (head == null){
            head = newElement;
        }
        else {
            ListElement<T> nextElement=head;
            head = newElement;
            newElement.setNextElement(nextElement);
        }

    }

    public void add(T data) {
        ListElement <T> newElement = new ListElement<T>(data);
        if (head == null){
            head = newElement;
        }
        else {
            ListElement <T> loopElement = head;
            while (loopElement.getNextElement() != null) {
                loopElement = loopElement.getNextElement();
            }
            loopElement.setNextElement(newElement);
        }
    }

    public boolean contains(T data) {
        ListElement <T> loopElement = head;
        while (loopElement != null) {
            if (loopElement.getData().equals(data)) {
                return true;
            }
            loopElement = loopElement.getNextElement();
        }
        return false;
    }

    public T findFirst(T data) {
        ListElement <T>loopElement = head;
        while (loopElement != null) {
            if (loopElement.getData().equals(data)) {
                return loopElement.getData();
            }
            loopElement = loopElement.getNextElement();
        }
        return null;
    }
    
    public void delete(T data) {
    if (head == null) {
        return;
    }
    if (head.getData().equals(data)) {
        head = head.getNextElement();
        return;
    }
    ListElement <T> loopElement = head;
    while (loopElement.getNextElement() != null) {
        if (loopElement.getNextElement().getData().equals(data)) {
            loopElement.setNextElement(loopElement.getNextElement().getNextElement());
            return;
        }
        loopElement = loopElement.getNextElement();
    }
}
}
