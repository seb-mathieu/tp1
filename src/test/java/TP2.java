import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import myapp.collections.EndOfListException;
import myapp.collections.Iterator;
import myapp.collections.IteratorOfStockable;
import myapp.collections.List;
import myapp.collections.ListOfStockable;
import myapp.collections.Stockable;
import myapp.tools.FileReader;
import myapp.tools.TextFileTools;

public class TP2 {
    public static class StringData implements Stockable {
        final String message;
        StringData(String message) {
            this.message = message;
        }
        @Override
        public String toString() {
            return message;
        }
        @Override
        public boolean equals(Object obj) {
            if (message == null) return false;
            return message.equals(((StringData)obj).message);
        }
    }
    @Test
    public void addFirst() {
        ListOfStockable list = new ListOfStockable();
        Assertions.assertArrayEquals(new StringData[] { }, 
            list.toArray());
        list.addFirst(new StringData("Hello"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("Hello")}, 
            list.toArray());
        list.addFirst(new StringData("World"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("World"),
            new StringData("Hello")}, 
            list.toArray());
        list.addFirst(new StringData("!"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("!"),
            new StringData("World"),
            new StringData("Hello")}, 
            list.toArray());
    }

    @Test
    public void add() {
        ListOfStockable list = new ListOfStockable();
        Assertions.assertArrayEquals(new StringData[] { }, 
            list.toArray());
        list.add(new StringData("Hello"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("Hello")}, 
            list.toArray());
        list.add(new StringData("World"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("Hello"),
            new StringData("World")}, 
            list.toArray());
        list.add(new StringData("!"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("Hello"),
            new StringData("World"),
            new StringData("!")}, 
            list.toArray());
    }

    @Test
    public void contains() {
        ListOfStockable list = new ListOfStockable();
        Assertions.assertEquals(false, list.contains(new StringData("Hello")));
        list.add(new StringData("Hello"));
        Assertions.assertEquals(true, list.contains(new StringData("Hello")));
        Assertions.assertEquals(false, list.contains(new StringData("World")));
        Assertions.assertEquals(false, list.contains(new StringData("!")));
        list.add(new StringData("World"));
        Assertions.assertEquals(true, list.contains(new StringData("Hello")));
        Assertions.assertEquals(true, list.contains(new StringData("World")));
        Assertions.assertEquals(false, list.contains(new StringData("!")));
        list.add(new StringData("!"));
        Assertions.assertEquals(true, list.contains(new StringData("Hello")));
        Assertions.assertEquals(true, list.contains(new StringData("World")));
        Assertions.assertEquals(true, list.contains(new StringData("!")));
    }

@Test
public void findFirst() {
    ListOfStockable list = new ListOfStockable();
    Assertions.assertEquals(null, list.findFirst(new StringData("Hello")));
    list.add(new StringData("Hello"));
    Assertions.assertEquals(new StringData("Hello"), list.findFirst(new StringData("Hello")));
    Assertions.assertEquals(null, list.findFirst(new StringData("World")));
    list.add(new StringData("World"));
    Assertions.assertEquals(new StringData("Hello"), list.findFirst(new StringData("Hello")));
    Assertions.assertEquals(new StringData("World"), list.findFirst(new StringData("World")));
    list.add(new StringData("Hello"));
    Assertions.assertEquals(new StringData("Hello"), list.findFirst(new StringData("Hello")));
}

    @Test
    public void delete() {
        ListOfStockable list = new ListOfStockable();
        list.add(new StringData("Hello"));
        list.add(new StringData("World"));
        list.add(new StringData("!"));
        list.delete(new StringData("World"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("Hello"),
            new StringData("!")}, 
            list.toArray());
        list.delete(new StringData("World"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("Hello"),
            new StringData("!")}, 
            list.toArray());
        list.delete(new StringData("!"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("Hello")}, 
            list.toArray());
        list.add(new StringData("World"));
        list.delete(new StringData("Hello"));
        Assertions.assertArrayEquals(new StringData[] {
            new StringData("World")}, 
            list.toArray());
            list.delete(new StringData("World"));
        Assertions.assertArrayEquals(new StringData[] {}, list.toArray());
    }

    @Test
    public void iterator() throws EndOfListException {
        ListOfStockable list = new ListOfStockable();
        IteratorOfStockable iterator = new IteratorOfStockable(list);
        Assertions.assertEquals(false, iterator.hasNext());
        list.add(new StringData("Hello"));
        iterator.restart();
        Assertions.assertEquals(true, iterator.hasNext());
        Assertions.assertEquals(new StringData("Hello"), iterator.next());
        Assertions.assertEquals(false, iterator.hasNext());
        list.add(new StringData("World"));
        iterator.restart();
        Assertions.assertEquals(true, iterator.hasNext());
        Assertions.assertEquals(new StringData("Hello"), iterator.next());
        Assertions.assertEquals(true, iterator.hasNext());
        Assertions.assertEquals(new StringData("World"), iterator.next());
        Assertions.assertEquals(false, iterator.hasNext());
        try {
            iterator.next();
            Assertions.fail("Expected EndOfListException");
        } catch (EndOfListException e) {
        
        }
    }
    @Test
    public void exo2() throws EndOfListException {
        List<String> list = new List<String>();
        Iterator<String> it = new Iterator<String>(list);
        Assertions.assertEquals(false, it.hasNext());
        it.restart();
        Assertions.assertEquals(false, it.hasNext());
        list.add("Hello");
        it.restart();
        Assertions.assertEquals(true, it.hasNext());
        String data = it.next();
        Assertions.assertEquals(false, it.hasNext());
        Assertions.assertEquals("Hello", data);
        list.add("World");
        list.add("!");
        it.restart();
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("Hello", it.next());
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("World", it.next());
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("!", it.next());
        Assertions.assertEquals(false, it.hasNext());
    }
 
    @Test
    public void exo3() throws EndOfListException {
        List<String> list = TextFileTools.readFile(FileReader.fromString("Hello,\n\r World !"));
        Iterator<String> it = new Iterator<String>(list);
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("Hello", it.next());
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("World", it.next());
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("!", it.next());
        Assertions.assertEquals(false, it.hasNext());
    }

}
