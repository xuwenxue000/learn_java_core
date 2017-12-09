package cn.xu.base;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 先进先出队列
 * @param <E>
 * @author william
 */
public class FifoBlockQueue<E> extends AbstractQueue<E>
        implements BlockingQueue<E>, java.io.Serializable{

    private volatile Node first;
    private volatile Node end;

    int maxSize = Integer.MAX_VALUE;

    private final Object notEmptyLockObj = new Object();
    private final Object notFullLockObj = new Object();

    private final Object lockObject = new Object();

    public FifoBlockQueue(){

    }
    public FifoBlockQueue(int maxSize){
        this.maxSize = maxSize;
    }
    public static void main(String[] args){
        final FifoBlockQueue<String> queue = new FifoBlockQueue(20);
        /*
        new Thread(new Runnable() {
            public void run() {
                for(int i=0 ;i<100000;i++){
                    try {
                        queue.put(i+"");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        for(int i=0 ;i<15;i++){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        while(true){
                            queue.take();
                            //System.out.println();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        for(int i=0 ;i<15;i++) {
            final int num = i;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        int index = 0;
                        while (index<10000) {
                            queue.put(num + "_" + index++);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
         */

    }

    private volatile int size = 0;

    public Iterator<E> iterator() {
        return null;
    }

    public void put(E e) throws InterruptedException {

        synchronized (notFullLockObj){
            while(size>=maxSize) {
                notFullLockObj.wait();
            }
            synchronized (lockObject){
                if(end==null){
                    end = new Node();
                    end.setValue(e);
                    first = end;
                }else{
                    Node node = new Node();
                    node.setValue(e);
                    node.setPre(end);
                    end.setNext(node);
                    end = node;
                }
                size++;
                //System.out.println("put:"+e+":"+size);
            }
        }
        synchronized(notEmptyLockObj){
            notEmptyLockObj.notify();
        }
    }
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }
    public E take() throws InterruptedException {
        E result = null;
        synchronized (notEmptyLockObj){
            while(first==null) {
                notEmptyLockObj.wait();
            }
            synchronized (lockObject){
                result= first.getValue();
                first = first.getNext();
                if(first!=null){
                    first.setPre(null);
                    size--;
                }else{
                    end = null;
                    first =null;
                    size=0;
                }
                //System.out.println("take:"+result+":"+size);
            }
        }
        synchronized (notFullLockObj){
            notFullLockObj.notify();
        }
        return result;
    }
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }
    public int remainingCapacity() {
        return 0;
    }
    public int drainTo(Collection<? super E> c) {
        return 0;
    }
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }
    public boolean offer(E e) {
        return false;
    }
    public E poll() {
        return null;
    }
    public E peek() {
        return null;
    }

    public int size() {
        return size;
    }
    class Node{

        Node pre;
        Node next;
        E value;

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public void setValue(E value) {
            //System.out.println(value);
            this.value = value;
        }
        public E getValue() {
            return value;
        }
    }

}
