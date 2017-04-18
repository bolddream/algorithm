
public class TreeHandler {

	public static void main(String[] args) {
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		
		//test insert
        int a[] = {13,12,5,71,2,54,9,6};
		//int a[] = {13,12,5};
        for(int i=0; i<a.length; i++)
        {
        	TreeNode<Integer> node = new TreeNode<Integer>(a[i]);
        	avlTree.rootNode = avlTree.insertTreeNode(node);
        } 
        avlTree.middleTraverseTree(avlTree.rootNode);        

        
        //test middle search
        Integer searchData = new Integer(13);
        TreeNode<Integer> resultNode = avlTree.middleSearchTreeNode(searchData, avlTree.rootNode);
        
        if(resultNode != null)
        {
            if(resultNode.data != null)
            {
                System.out.println();
                System.out.println(resultNode.data.toString());
            }
        }
        avlTree.middleTraverseTree(avlTree.rootNode);
        
        //test delete 
        System.out.println();
        Integer deleteData = new Integer(5);
        TreeNode<Integer> deleteNode = new TreeNode<Integer>(deleteData);
        avlTree.rootNode = avlTree.deleteTreeNode(deleteNode, avlTree.rootNode);
        avlTree.middleTraverseTree(avlTree.rootNode);
        
	}

}
