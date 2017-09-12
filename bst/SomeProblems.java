package bst;

import javax.print.attribute.standard.NumberOfInterveningJobs;

public class SomeProblems {
	
	/**
	 * 查找元素
	 * @param root
	 * @param data
	 * @return
	 */
	public static BSTNode FindNode(BSTNode root,int data) {
		if (root == null) {
			return null;
		}
		if (data < root.getData()) {
			return FindNode(root.getLeft(), data);
		} else if(data > root.getData()){
			return FindNode(root.getRight(), data);
		}
		return root;
	}
	
	/**
	 * 查找最小元素
	 * @param root
	 * @return
	 */
	public static BSTNode findMin(BSTNode root) {
		if (root == null) {
			return null;
		} else {
			if (root.getLeft() == null) {
				return root;
			}else {
				return findMin(root.getLeft());
			}
		}
	}
	
	/**
	 *查找最大元素 
	 * @param root
	 * @return
	 */
	public static BSTNode findMax(BSTNode root) {
		if (root == null) {
			return null;
		} else {
			if (root.getRight() == null) {
				return root;
			}else {
				return findMax(root.getRight());
			}
		}
	}
	
	/*
	 * 插入元素
	 */
	public static BSTNode insertNode(BSTNode root,int data) {
		if (root == null) {
			root = new BSTNode();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
		} else {
			if (data < root.getData()) {
				root.setLeft(insertNode(root.getLeft(), data));
			} else if (data > root.getData()) {
				root.setRight(insertNode(root.getRight(), data));
			}
		}
		return root;
		
	}
	
	/**
	 * 删除结点
	 * @param root
	 * @param data
	 */
	public static void deleteNode(BSTNode root,int data) {
				BSTNode parent = null;
				while (root != null) {
					if (root.getData() > data) {
						parent = root;
						root = root.getLeft();
					}
					if (root.getData() < data) {
						parent = root;
						root = root.getRight();
					}
					if (root.getData() == data) {
						break;
					}
				}
				if (root.getLeft() == null) { //左孩子为空
					if (parent.getLeft() == root) {
						parent.setLeft(root.getRight());
					}
					if (parent.getRight() == root) {
						parent.setRight(root.getRight());
					}
					
				}
				if (root.getRight() == null) { //右孩子为空
					if (parent.getRight() == root) {
						parent.setRight(root.getLeft());
					}
					if (parent.getLeft() == root) {
						parent.setLeft(root.getLeft());
					}
				}
				
				if (root.getLeft() != null && root.getRight() != null) {  //有两个孩子结点
					BSTNode temp = root.getLeft();
					if (temp.getRight() == null) {
						root.setData(temp.getData());
						root.setLeft(temp.getLeft());
					}else {
						BSTNode qnode = temp;
						BSTNode temp1 = qnode.getRight();
						while (temp1.getRight()!=null) {
							qnode = temp1;
							temp1 = temp1.getRight();
						}
						root.setData(qnode.getData());
						if (qnode.getLeft() == temp1) {
							qnode.setLeft(qnode.getRight());
						}else if (qnode.getRight() == temp1) {
							qnode.setRight(temp1.getLeft());
						}
					}
					
				}
				
				
				
				
	}
	
	/**
	 * 中序遍历
	 * @param root
	 */
	public static void printf(BSTNode root){
		if (root != null) {
			printf(root.getLeft());
			System.out.print(root.getData()+" ");
			printf(root.getRight());
		}
		
	}
	
	
	
	/**
	 * 查找最近公共祖先
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	public static BSTNode FindLCA(BSTNode root,int x,int y) {
		while (root != null) {
			if (x > root.getData() && y > root.getData()) {
				root = root.getRight();
			} else if(x < root.getData() && y < root.getData()){
				root = root.getLeft();
			} else {
				break;
			}
		}
		return root;
	}
	
	/**
	 * 判断是否为BST树
	 * @param root
	 * @param pre //前驱结点
	 * @return
	 */
	public static boolean isBST(BSTNode root,BSTNode pre) {
		if (root != null) {
			if (!isBST(root.getLeft(), pre)) {
				return false;
			}
			if (pre != null && pre.getData() > root.getData()) {
				return false;
			}
			pre = root;
			return isBST(root.getRight(), pre);
		}
		return true;
	}
	
	/**
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public static BSTNode getK(BSTNode root,int k) {
		int count = numNode(root.getLeft());
		if (count+1 == k) {
			return root;
		} else if(k <= count){
			return getK(root.getLeft(), k);
		} else {
			return getK(root.getRight(), k-1-count);
		}
	}
	
	/**
	 * 获取树的结点数量
	 * @param root
	 * @return
	 */
	public static int numNode(BSTNode root) {
		if (root == null) {
			return 0; 
		}
		
		return (numNode(root.getRight())+numNode(root.getLeft())+1);
		
	}

	
	/**
	 * 输出 k1-k2之间的数
	 * @param root
	 * @param k1
	 * @param k2
	 */
	public static void Range(BSTNode root,int k1,int k2) {
		if (root == null) {
			return;
		}
		if (k1 <= root.getData()) {
			Range(root.getLeft(), k1, k2);
		}
		if (k1 <= root.getData() && k2 >=root.getData()) {
			System.out.println(root.getData());
		}
		if (root.getData() <= k2) {
			Range(root.getRight(), k1, k2);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		int[] datas = {1,2,3,4,5,6,7};
		BSTNode node = CreateTree.Create(datas, 0, 6);
//		System.out.println(SomeProblems.FindNode(node, 6).getData());
//		System.out.println(SomeProblems.findMin(node).getData());
//		System.out.println(SomeProblems.findMax(node).getData());
//		BSTNode node2 = SomeProblems.insertNode(node, 11);
//		System.out.println(SomeProblems.findMax(node2).getData());
//		SomeProblems.deleteNode(node, 5);
//		System.out.println(SomeProblems.findMin(node).getData());
//		SomeProblems.printf(node);
//		System.out.println(SomeProblems.FindLCA(node, 3,5).getData());
//		int pre = Integer.MIN_VALUE;
//		BSTNode pre = new BSTNode();
//		System.out.println(SomeProblems.isBST(node,pre));
//		System.out.println(SomeProblems.getK(node, 3, 0).getData());
//		System.out.println(SomeProblems.numNode(node));
//		System.out.println(SomeProblems.getK(node, 3).getData());
		Range(node, 1, 7);
	}

}
