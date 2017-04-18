
public class TreeHandler {

	public static void main(String[] args) {
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
        int a[] = {13,12,5,71,2,54,9,6};
        for(int i=0; i<a.length; i++)
        {
        	TreeNode<Integer> node = new TreeNode<Integer>(a[i]);
        	avlTree.rootNode = avlTree.insertTreeNode(node);
        }
        
        avlTree.middleTraverseTree(avlTree.rootNode);
        
	}

}
