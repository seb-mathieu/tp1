package myapp.collections;

public class ListElement<T> {
    private T data;
private ListElement<T> nextElement = null;

public ListElement(T data) {
    this.data = data;
}

public T getData() {
    return data;
}

public ListElement <T> getNextElement() {
    return nextElement;
}

public void setNextElement(ListElement<T> nextElement) {
    this.nextElement = nextElement;
}
}
