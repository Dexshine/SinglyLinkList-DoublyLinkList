public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    //constructor
    public DoublyLinkedList(String name){
            this.listName = name;
    }
    //remove last Node
    public void popBack() {
        if (isEmpty()){
            System.out.println("ERROR");
        }else{//LinkedList is not empty
            //check if only have 1 Node in LinkedList
            if(this.head == this.tail && this.head.student_id != 0){//LinkedList only have 1 Node
                //head and tail pointed to null
                this.head = null; 
                this.tail = null;
            }else{//LinkedList have more than 1 Node
                this.tail = this.tail.previous;//tail pointed to new last Node of LinkedList
                this.tail.next = null;//next thing of new last Node is null
            }  
        }
    }
    //delete first Node from LinkedList
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
        }else{//LinkedList is not empty
            if(this.head.next == null){//LinkedList only have 1 Node
                //head and tail pointed to null
                this.head = null;
                this.tail = null;
            }else{//LinkedList have more than 1 Node
                this.head = this.head.next;//head pointed to new first Node
                this.head.previous = null; //nothing pointed to old first Node
            }
        }
    }
    //return first Node of LinkedList
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {//LinkedList is not empty
            return this.head;//this function return Node object
        }
    }
    //return last Node of LinkedList
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {//LinkedList is not empty
            return this.tail;//this function return Node Object
        }
    }
    //add new Node in front of LinkedList
    public void pushFront(Node node){
        if (isEmpty()){//LinkedList is empty
            //head and tail pointed to new Node
            this.head = node;
            this.tail = node;
            //make sure that new Node don't point to other Node
            this.head.next = null;
            this.head.previous = null;
        }else{//Linkedlist is not empty
            node.next = this.head;
            this.head.previous = node;//old head point to new Node at the front of LinkedList
            node.previous = null;//make sure that new Node don't point to other Node
            this.head = node;//head pointed to new first Node
        }
    }
    //add new Node behind last Node of LinkedList
    public void pushBack(Node node) {
        if (isEmpty()) {//LinkedList is empty
            //head and tail pointed to new Node
            this.head = node;
            this.tail = node;
            //make sure that new Node don't point to other Node
            this.head.next = null;
            this.head.previous = null;
        } else {//LinkedList is not empty
            this.tail.next = node;//old tail point to new Node at the back of LinkedList
            node.previous = this.tail;//new Node pointed to tail Node
            this.tail = node;//tail pointed to new last Node
        }
    }
    //find Node that have the same student_id
    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {//LinkedList is not empty
            Node current = this.head;//create marker
            while(current != null){//run till marking point to null
                if(current.student_id == id){//can find Node that have the same id
                    return current;//return that Node
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    //erase Node that have the same student_id
    public Node eraseNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {//LinkedList is not empty
            Node current = this.head;//create marker
            //check if it's first Node.
            if(current.student_id == id){//The Node that we want to delete is first Node.
                //check if LinkedList have only one Node or not.
                if(this.head.next == null){//LinkedList only have one Node.
                    this.head = null;
                    this.tail = null;
                    return current;//return Node that have same id
                }
                else{//LinkedList have more than one Node.
                    this.head = this.head.next;//head point to new first Node
                    this.head.previous = null;//previous of new head point to null
                    return current;//return Node that have same id
                }
            }else{//The Node that we want to delete isn't first Node.
                while(current != null){//run till marking point to null
                    if(current.student_id == id){//find Node that have same id
                        Node foundNode = current;//create temporary Node
                        if(current.next == null){//last Node have same id
                            this.tail = current.previous;//tail point to new last Node
                            this.tail.next = null;//last Node.next point to null
                        }else{//the Node that we want(current) is in the middle of the LinkedList
                            current.previous.next = current.next;
                            current.next.previous = current.previous;
                        }
                        return foundNode;//return Node that have the same id
                    }
                    current = current.next;
                }
                //all Node dont have id that we want 
                if(current == null) current =  new Node("Student Not Found!");
            }
            return current;
        }
    }
    //add node2 after node1
    public void addNodeAfter(Node node1, Node node2){
        //check if we only have 1 Node in LinkedList
        if(node1 == tail) this.pushBack(node2); //LinkedList only have 1 Node. so push node2 at the back
        else {//LinkedList have more than 1 Node
            //set new next,previous of node1 and node2
            node2.next = node1.next;//
            node2.previous = node1;
            node1.next = node2;
            node2.next.previous = node2;
        }
    }
    //add node2 before node1
    public void addNodeBefore(Node node1, Node node2){
        Node current = this.head;//creat marker
        //check if Node1 is first Node or not.
        if(node1 == this.head){//Node1 is first Node.
            current = null;
            this.pushFront(node2);//push node2 in front of node1
        }else{//Node1 isn't first Node.
            //run till we can find node1
            while(current.next != node1) current = current.next;
            //set new next,previous of node1 and node2
            node2.next = current.next;
            node2.previous = current;
            node2.next.previous = node2;
            current.next = node2;
        }
    }
    //is this LinkedList empty or not?
    public boolean isEmpty(){
        return this.head == null;
    }
    //merge two LinkedList together, by add LinkedList from argument behind primary LinkedList
    public void merge(DoublyLinkedList list){
        this.tail.next = list.head; //tail from first LinkedList pointed to head of second LinkedList
        list.head.previous = this.tail;//head of second LinkedList .previous pointed to tail of first LinkedList
        this.tail = null;//variable tail from first LinkedList is useless now because we need to use tail of new LinkedList
    }
    
    public void printStructure(){
        if(isEmpty()){//LinkedList is empty.
            System.out.println(this.listName + ": head <-> tail");
        }else{//LinkedList is not empty
            Node current = this.head;//create marker
            System.out.print(this.listName + ": head ");//beginning of output
            while(current != null){//run till last Node
                System.out.print("<-> {" + current.student_id + "} ");//<-> {id} 
                current = current.next;
            }
            System.out.println("<-> tail");//end of output
        }
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    //find which Node have highest GPA
    public Node whoGotHighestGPA(){
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {//LinkedList is not empty
            Node current = this.head; //create marker
            Node topGPA = this.head; //create variable for return
            while(current != null){//run till last Node
                //use >= because in case topGPA have more than 1 Node,instruction require to choose the farthest right Node
                if(current.gpa >= topGPA.gpa) topGPA = current;
                current = current.next;
            }
            return topGPA;
        }
    }
}