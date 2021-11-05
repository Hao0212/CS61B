import org.junit.Test;

/**
 * @author Hao
 * @date 2021/11/3 - 12:47 PM
 */
public class LinkedListDeque<T> {

    public class Denode{
        public T item;
        public Denode next;
        public Denode prev;

        public Denode (T items, Denode p, Denode n){
            item = items;
            prev = p;
            next = n;
        }
    }

    private int size;
    private Denode sentinalF;
    private Denode sentinalB;


    public LinkedListDeque(){
        sentinalF = new Denode(null,null,null);
        sentinalB = new Denode(null,null,null);
        sentinalB.prev = sentinalF;
        sentinalF.next = sentinalB;
        size = 0;
    }

    public LinkedListDeque(T item){
        sentinalF = new Denode(null,null,null);
        sentinalB = new Denode(null,null,null);
        sentinalF.next = new Denode(item,sentinalF,sentinalB);
        sentinalB.prev = sentinalF.next;
        size = 1;
    }

    public void addFirst(T item){
        sentinalF.next = new Denode(item , sentinalF, sentinalF.next);
        sentinalF.next.next.prev = sentinalF.next;
        size += 1;
    }

    public void addLast(T item){
        sentinalB.prev = new Denode(item , sentinalB.prev, sentinalB);
        sentinalB.prev.prev.next = sentinalB.prev;
        size += 1;
    }

    public boolean isEmpty(){
        if (sentinalF.next == sentinalB){
            return true;}
        return false;
        }

    public int size(){
        return size;
    }

    public void printDeque(){
        while(sentinalF.next != sentinalB){
            System.out.print(sentinalF.next.item + " ");
            sentinalF.next = sentinalF.next.next;
        }
    }

    public T removeFirst(){
        if (sentinalF.next == sentinalB){
            return null;
        }
        sentinalF.next = sentinalF.next.next;
        size -= 1;
        return sentinalF.next.item;
    }

    public T removeLast(){
        if (sentinalF.next == sentinalB){
            return null;
        }
        sentinalB.prev = sentinalB.prev.prev;
        sentinalB.prev.next = sentinalB;
        size -= 1;
        return sentinalB.prev.item;
    }

    public T get(int index){
        if(index + 1 > size){
            return null;
        }
        for (int i = 0; i < index; i++){
            sentinalF.next = sentinalF.next.next;
        }
        return sentinalF.next.item;
    }

    public static void main(String[] args) {
       LinkedListDeque<Integer> L = new LinkedListDeque<>();
       System.out.println(L.isEmpty());
       L.addFirst(10);
       L.removeFirst();
       System.out.println(L.isEmpty());
    }
}
