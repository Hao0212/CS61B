/**
 * @author Hao
 * @date 2021/11/3 - 12:47 PM
 */
public class LinkedListDeque<T> {

    public class Denode{
        T item;
        Denode next;
        Denode prev;

        public Denode (T items, Denode n){
            item = items;
            prev = next;
            next = n;
        }
    }

    private int size;
    private Denode sentinal;


    public LinkedListDeque(){
        Denode sentinal;
    }


    public int size(){
        return size;
    }
}
