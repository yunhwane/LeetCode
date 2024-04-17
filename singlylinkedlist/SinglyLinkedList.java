package singlylinkedlist;

import java.util.Objects;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList(Node<E> head, Node<E> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }


    /**
     *
     * @description
     * add
     * void addFirst : 첫번째 위치에 요소 추가
     * void addLast : 마지막 위치에 요소 추가
     * boolean add() : 마지막 위치에 요소 추가 성공시 true 반환
     * void add(int index, Object element) : 지정된 위치에 요소 추가
     *
     */
    public void addFirst(E value) {
        Node<E> first = head;
        Node<E> newNode = new Node<>(value, first);
        size++;
        head = newNode;

        if(first==null) {
            tail = newNode;
        }
    }

    public void addLast(E value) {
        Node<E> last = tail;
        Node<E> newNode = new Node<>(value, null);
        size++;
        tail = newNode;

        /**
         * 만약 최초의 요소가 추가 되면 head == tail
         * 아닐 시, next에 새로운 노드와 next에 값 바라보도록 추가
         */
        if(last == null) {
            head = newNode;
        }else {
            last.next = newNode;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void add(int index, E value) {

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            addFirst(value);
            return;
        }

        if(index == size - 1) {
            addLast(value);
            return;
        }

        Node<E> prevNode = search(index-1);
        Node<E> nextNode = prevNode.next;
        Node<E> newNode = new Node<>(value, nextNode);
        size++;
        prevNode.next = newNode;
    }

    /**
     *
     * @Description remove
     * Object removeFirst() 맨 앞 요소 제거 및 반환
     * Object remove() 맨 앞 요소 제거
     * Object removeLast() : 맨 뒤 요소 제거
     * Object remove(int index) : 인덱스 위치에 요소 제거
     * boolean remove(Object value) : 요소값이 일치하는 위치의 요소를 제거( 중복값 있을 경우 맨 앞 요소 제거 )
     */

    public E removeFirst() {
        if(head == null) {
            throw new IndexOutOfBoundsException();
        }

        E returnValue = head.item;

        Node<E> first = head.next;

        // 고아가 되버린 노드는 나중에 GC가 수거
        head.next = null;
        head.item = null;
        head = first;

        size--;

        if(head == null) {
            tail = null;
        }

        return returnValue;
    }

    public E remove() {
        return removeFirst();
    }

    public E remove(int index) {
        if(index < 0 || index <= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            return removeFirst();
        }

        Node<E> prevNode = search(index -1);
        Node<E> delNode = prevNode.next;
        Node<E> nextNode = delNode.next;

        E returnValue = delNode.item;

        delNode.item = null;
        delNode.next = null;

        size--;

        prevNode.next = nextNode;
        return returnValue;
    }

    public boolean remove(Object o) {

        if(head == null) {
            throw new RuntimeException();
        }

        Node<E> prevNode = null;
        Node<E> delNode = null;
        Node<E> nextNode = null;

        Node<E> i = head;

        while(i != null) {
            if(Objects.equals(i.item, o)){
                delNode = i;
                break;
            }

            prevNode = i;

            i = i.next;
        }

        if (delNode == null) {
            return false;
        }

        if (delNode == head) {
            removeFirst();
            return true;
        }

        nextNode = delNode.next;

        // 8. 삭제 요소 데이터 모두 제거
        delNode.next = null;
        delNode.item = null;
        size--;
        prevNode.next = nextNode;
        return true;
    }

    // 시간 복잡도 O(N)
    private Node<E> search(int index) {
        Node<E> n = head;

        for(int i = 0; i < index; i++) {
            n = n.next;
        }

        return n;
    }
    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
