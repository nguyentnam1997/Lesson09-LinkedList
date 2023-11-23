import java.util.ArrayList;
import java.util.List;

public class Practice {
    /*
    //Cách 1: triển khai theo dạng ArrayList
    List<Integer> list;
    public Practice() {
        list = new ArrayList<>();
    }
    public int get(int index) {
        if (index < 0 || index >= list.size()) {
            return -1;
        }
        return list.get(index);
    }
    public void addAtHead(int val) {
        list.add(0, val);
    }
    public void addAtTail(int val) {
        list.add(val);
    }
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > list.size()) return;
        if (index == list.size()) {
            list.add(val);
            return;
        }
        list.add(index, val);
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= list.size()) return;
        list.remove(index);
    }*/
    //Cách 2: triển khai theo dạng LinkedList
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int length;

    public Practice() {
        head = null;
        length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length) return -1;
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val); //khởi tạo node mới
        newNode.next = head;    //trỏ đến node head
        head = newNode; //head là node mới đc thêm vào
        length++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        //Duyệt tìm node cuối cùng
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == length) {
            addAtTail(val);
            return;
        }
        Node temp = head;
        //tìm node prev (node đằng trước đó)
        while (index > 1) {
            temp = temp.next;
            index--;
        }
        Node newNode = new Node(val);
        newNode.next = temp.next;   //node mới và node temp cùng trỏ và
        temp.next = newNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return;
        length--;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        //tìm node prev (node đằng trước đó)
        while (index > 1) {
            temp = temp.next;
            index--;
        }
        temp.next = temp.next.next;
    }

    //237. Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
