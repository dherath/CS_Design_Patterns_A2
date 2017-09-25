package studentCoursesBackup.util;

import studentCoursesBackup.binarySearchTree.BSTNodeInterface;
import studentCoursesBackup.binarySearchTree.TreeInterface;
import studentCoursesBackup.myTree.Node;

public class TreeBuilder implements TreeInterface
{
    private BSTNodeInterface masterRoot;//root node for main tree
    private BSTNodeInterface backupRoot1;//root node for backup 1 tree
    private BSTNodeInterface backupRoot2;//root node for backup 2 tree

    /**
     *Constructor
     **/
    public TreeBuilder(){
	masterRoot = null;
	backupRoot1 = null;
	backupRoot2 = null;
    }

    
    //----------------TreeInterface--------------------

    /**
     *gets the BSTNodeinterface for a specific BNumber in a specific tree
     *@param root, the root node for a specific tree
     *@param index, the unique index(BNumber) to search for
     *@return the BSTnodeinterface that complies with the index in a specific tree
     **/
    public BSTNodeInterface find(BSTNodeInterface root,int index){
	BSTNodeInterface current = root;
	while(current.getNodeIndex()!=index){
	    if(index<current.getNodeIndex()){
		current = current.getLeftChild();
	    }else{
		current = current.getRightChild();
	    }
	    if(current==null){
		return null;
	    }
	}
	return current;
    }

    /**
     *inserts a new node with a specific into a given tree
     *@param root, the root node for the required tree
     *@param index, the unique BNumber of student
     **/
    public void insertNode(BSTNodeInterface root,int index){
	if(find(root,index)==null){
	    BSTNodeInterface newNode = new Node(index);
	    if(root == null){
		root = newNode;
	    }else{
		BSTNodeInterface current = root;
		BSTNodeInterface parent;
		while(true){
		    parent = current;
		    if(index<current.getNodeIndex()){
			current = current.getLeftChild();
			if(current == null){
			    parent.setLeftChild(newNode);
			    break;
			}
		    }else{
			current = current.getRightChild();
			if(current == null){
			    parent.setRightChild(newNode);
			    break;
			}
		    }
		}
	    }
	}
    }

    public String printNodes(BSTNodeInterface root){
	return "d";
    }
    
    //-------------------------------------------------
}
