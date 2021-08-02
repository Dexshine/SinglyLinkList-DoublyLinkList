public class SinglyLinkedList {
    Node head;
    String listName;

    //constructor
    public SinglyLinkedList(String name){
        this.listName = name;
        this.head = null;
    }
    //remove last Node of SinglyLinkedList.
    public void popBack(){
    if(isEmpty()){
        System.out.println("ERROR");
    }else{
        Node current = this.head;
        while(current.next.next != null) current = current.next;
        current.next = null;
    }
    }
    //remove first Node of SinglyLinkedList.
    public void popFront(){
    if(isEmpty()){
        System.out.println("ERROR");
    }else{
        this.head = this.head.next;
    }
    }
    //return first Node of SinglyLinkedList.
    public Node topFront(){
    if(isEmpty()){
        System.out.println("ERROR");
        return new Node("Empty List!");
    }else{
        return this.head;
    }
    }
    //return last Node of SinglyLinkedList.
    public Node topBack(){
    if(isEmpty()){
        System.out.println("ERROR");
        return new Node("Empty List!");
    }else{
        Node current = this.head;
        while(current.next != null) current = current.next;
        return current;
    }
    }
    //push new Node in front of first Node of SinglyLinkedList.
    public void pushFront(Node node){
    if(isEmpty()){
        this.head = node;
        head.next = null;
    }else{
        node.next = head;
        this.head = node;
    }
    }
    //push new Node at the back of last Node of SinglyLinkedList.
    public void pushBack(Node node) {
    if (isEmpty()){
        this.head = node;
        head.next = null;
    }else{
        Node current = this.head;
        while(current.next != null) current = current.next;
        current.next = node;
    }
    }
    //find Node that have same student_id as argument.
    public Node findNode(int id){
    if(isEmpty()){
        return new Node("Empty List!");
    }else{
        Node current = this.head;
        while(current != null){
            if(current.student_id == id) return current;
            current = current.next;
        }
        return new Node("Student Not Found!");
    }
    }
    //erase Node that have same student_id as argument.
    public Node eraseNode(int id){
    if(isEmpty()){
        System.out.println("ERROR");
        return new Node("Empty List!");
    }else{
        Node current = this.head;
        while(current != null){
            if(current.next.student_id == id){
                Node foundNode = current.next;
                current.next = current.next.next;
                return foundNode;
            }
            current = current.next;
        }
        return new Node("Student Not Found!");
    }
    }
    //add node2 behind node1.
    public void addNodeAfter(Node node1, Node node2){
        node2.next = node1.next;
        node1.next = node2;
    }
    //add node2 in front of node1.
    public void addNodeBefore(Node node1, Node node2){
        Node current = this.head;
        while(current.next != node1) current = current.next;
        node2.next = current.next;
        current.next = node2;
    }
    //check if SinglyLinkedList is empty or not.
    public boolean isEmpty(){
        return this.head == null;
    }
    public void merge(SinglyLinkedList list){
        Node current = this.head;
        while(current.next != null) current = current.next;
        current.next = list.head;
    }
    //print student_id of all Node in SinglyLinkedList.
    public void printStructure(){
        if(isEmpty()){
            System.out.println(this.listName + ": head -> null");
        }else{
            Node current = this.head;
            System.out.print(this.listName + ": head ");
            while(current != null){
                System.out.print("-> [" + current.student_id + "]");
                current = current.next;
            }
            System.out.println(" -> null");
        }
    }
    //find who got highestGPA in SinglyLinkedList.
    public Node whoGotHighestGPA(){
        if(isEmpty()){
            return new Node("Empty List!");
        }else{
            Node current = this.head;
            Node topGPA = this.head;
            while(current != null){
                if(current.gpa >= topGPA.gpa) topGPA = current;
                current = current.next;
            }
            return topGPA;
        }
    }
}
