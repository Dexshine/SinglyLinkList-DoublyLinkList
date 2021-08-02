public class SinglyLinkedList {
    Node head;
    String listName;

    //constructor
    public SinglyLinkedList(String name){
        this.listName = name;
        this.head = null;
    }

    public void popBack(){
    if(isEmpty()){
        System.out.println("ERROR");
    }else{
        Node current = this.head;
        while(current.next.next != null) current = current.next;
        current.next = null;
    }
    }

    public void popFront(){
    if(isEmpty()){
        System.out.println("ERROR");
    }else{
        this.head = this.head.next;
    }
    }

    public Node topFront(){
    if(isEmpty()){
        System.out.println("ERROR");
        return new Node("Empty List!");
    }else{
        return this.head;
    }
    }

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

    public void pushFront(Node node){
    if(isEmpty()){
        this.head = node;
        head.next = null;
    }else{
        node.next = head;
        this.head = node;
    }
    }

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
    
    public void addNodeAfter(Node node1, Node node2){
        node2.next = node1.next;
        node1.next = node2;
    }
    
    public void addNodeBefore(Node node1, Node node2){
        Node current = this.head;
        while(current.next != node1) current = current.next;
        node2.next = current.next;
        current.next = node2;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    public void merge(SinglyLinkedList list){
        Node current = this.head;
        while(current.next != null) current = current.next;
        current.next = list.head;
    }
    
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
