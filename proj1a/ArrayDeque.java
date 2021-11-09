import javax.swing.*;
import java.lang.reflect.Array;

/**
 * @author Hao
 * @date 2021/11/5 - 1:14 AM
 */
public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int first = 0;
    private int last = 1;
    private int capacity = 8;

    public T[] copyDeque(T[] items){
        int index = (first+1) % capacity;
        int tempsize = size;
        T[] b = (T[])new Object[tempsize];
        for(int bindex = 0; bindex < tempsize; bindex++){
            b[bindex] = items[index];
            index = index + 1 < capacity - 1 ? index + 1 :  0;
        }
        return b;

    }
    
    public void resize(T[] items){
        T[] largerarray = (T[]) new Object[size * 2];
        items = copyDeque(largerarray);
        capacity = size * 2;
        first = capacity - 1;
        last = size;
    }
    
    public void shrink(T items[]){
        T[] smallerarray = (T[]) new Object[size / 2];
        items = copyDeque(smallerarray);
        items = smallerarray;
        capacity = size / 2;
        first = capacity - 1;
        last = size;
    }

    public ArrayDeque(){
        items = (T[]) new Object[capacity];
        size = 0;
    }



    public void addFirst(T item){
        if(size == capacity){
            resize(items);
        }
        items[first] = item;
        first = first - 1 < 0 ? capacity - 1 : first -1;
        size += 1;

    }

    public void addLast(T item){
        if (size == capacity){
            resize(items);
        }
        items[last] = item;
        last = last + 1 < capacity - 1 ? last + 1 : 0;
        size += 1;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int i = 1;
        while (i <= size){
            System.out.println(items[first + 1]);
            first = first + 1 < capacity - 1 ? first + 1 : -1;
            i += 1;
        }
    }

    public T removeFirst(){
        T removedItem = items[first + 1];
        items[first + 1] = null;
        first += 1;
        size -= 1;
        if (size < capacity/4){
            shrink(items);
        }
        return removedItem;

    }

    public T removeLast(){
        T removedItem = items[last - 1];
        items[last - 1] = null;
        last -= 1;
        size -= 1;
        if (size < capacity/4){
            shrink(items);
        }
        return removedItem;
    }

    public T get(int index){
        return items[index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addLast(15);
        l.addLast(20);
        l.addFirst(10);
        l.addFirst(5);
        l.addFirst(1);
        l.addLast(25);
        l.addLast(30);
        l.addLast(35);
        l.addLast(40);
        l.printDeque();

    }
}
