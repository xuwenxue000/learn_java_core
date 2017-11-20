package cn.xu.base;

//评测题目: 无
public class LinkedList{

    private Node root;
    private Node end;

    public synchronized void add(Node node){
        if(root==null){
            root = node;
            end = node;
        }else{
            end.next = node;
            end = node;
        }

    }
    public void revert(){
        if(root!=null) {
            if (root != null) {
                Node next = root.next;
                root.next = null;
                if (next != null) {
                    changeLink(root, next);
                }
                root = end;
            }
        }
    }

    public void changeLink(Node node,Node nextNode){
        Node nextNodeNode = nextNode.next;
        nextNode.next = node;
        if(nextNodeNode!=null){
            changeLink(nextNode,nextNodeNode);
        }

    }



    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));
        Node node =list.root;
        while(node!=null){
            System.out.println(node.value);
            node = node.next;
        }
        list.revert();

        node = list.root;
        while(node!=null){
            System.out.println(node.value);
            node = node.next;
        }

    }

}
class Node{
    Node next = null;
    Integer value = null;

    Node(Integer value){
        this.value = value;
    }

}
