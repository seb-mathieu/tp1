package myapp.collections;

class ListElementOfStockable {
private Stockable data;
private ListElementOfStockable nextElement = null;

public ListElementOfStockable(Stockable data) {
    this.data = data;
}

public Stockable getData() {
    return data;
}

public ListElementOfStockable getNextElement() {
    return nextElement;
}

public void setNextElement(ListElementOfStockable nextElement) {
    this.nextElement = nextElement;
}

}
