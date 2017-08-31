package dlist;

public class Test_DLLNode {

	public static void main(String[] args) {
		DLLNode headNode = new DLLNode(1);
		DLLNode h1 = new DLLNode(5);
		DLLNode h2= new DLLNode(7);
		DLLNode h3 = new DLLNode(11);
		DLLNode h4 = new DLLNode(15);
		Main_DLLNode main = new Main_DLLNode();
		headNode.setNext(h1);
		h1.setPrevious(headNode);
		
		h1.setNext(h2);
		h2.setPrevious(h1);
		
		h2.setNext(h3);
		h3.setPrevious(h2);
		
		h3.setNext(h4);
		h4.setPrevious(h3);
		
		h4.setNext(null);
		
		main.printDllNode(headNode);
		System.out.println("------------");
		main.DLLInsert(headNode, new DLLNode(25),3);
		main.printDllNode(headNode);
		System.out.println("--------");
		main.DllDelete(headNode, 5);
		main.printDllNode(headNode);
		
	}

}
