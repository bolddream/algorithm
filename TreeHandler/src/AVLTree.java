
public class AVLTree<T extends Comparable<T>>
{
    
    public TreeNode<T> rootNode;
    public int height;
    
    public int getMaxHeight(TreeNode<T> root)
    {
        if(root == null)
        {
            return 0;
        }
        
        int height = 1;
        int leftSonHeight = getMaxHeight(root.lson);
        int rightSonHeight = getMaxHeight(root.rson);
        if(leftSonHeight > rightSonHeight)
        {
            height += leftSonHeight;
        }
        else
        {
            height += rightSonHeight;
        }
        
        return height;
    }
    
    public TreeNode<T> singleRotateLeft(TreeNode<T> k2)
    {
        TreeNode<T> k1 = k2.lson;
        if(k1 == null)
        {
            return null;
        }
        
        TreeNode<T> temp = k1.rson;
        k1.rson = k2;
        k2.lson = temp;
        
        k2.height = getMaxHeight(k2);
        k1.height = getMaxHeight(k1);
        return k1;
    }
    
    public TreeNode<T> singleRotateRight(TreeNode<T> k2)
    {
        TreeNode<T> k1 = k2.rson;
        if(k1 == null)
        {
            return null;
        }
        
        TreeNode<T> temp = k1.lson;
        k1.lson = k2;
        k2.rson = temp;
        
        k2.height = getMaxHeight(k2);
        k1.height = getMaxHeight(k1);
        return k1;
    }
    
    public TreeNode<T> doubleRotateLeftRight(TreeNode<T> k3)
    {
        k3.lson = singleRotateRight(k3.lson);
        return singleRotateLeft(k3);
    }
    
    public TreeNode<T> doubleRotateRightLeft(TreeNode<T> k3)
    {
        k3.rson = singleRotateLeft(k3.rson);
        return singleRotateRight(k3);
    }
    
    public TreeNode<T> insertTreeNode(TreeNode<T> insertNode)
    {
        return insertTreeNode(insertNode, this.rootNode);
    }
    
    public TreeNode<T> insertTreeNode(TreeNode<T> insertNode, TreeNode<T> currentNode)
    {
        if(insertNode == null)
        {
            return currentNode;
        }
        
        TreeNode<T> rootNode = currentNode;
        if(currentNode == null)
        {
            currentNode = insertNode;
            currentNode.height = 1;
            currentNode.freq = 1;
            rootNode = currentNode;
            return rootNode;
        }
    
        if(insertNode.data.compareTo(currentNode.data) > 0)
        {
            currentNode.rson = insertTreeNode(insertNode, currentNode.rson);
            currentNode.height = getMaxHeight(currentNode);
            rootNode = ajustAVLTree(currentNode);
        }
        else if(insertNode.data.compareTo(currentNode.data) < 0)
        {
            currentNode.lson = insertTreeNode(insertNode, currentNode.lson);
            currentNode.height = getMaxHeight(currentNode);
            rootNode = ajustAVLTree(currentNode);
        }
        else
        {
            currentNode.freq ++;
            rootNode = currentNode;
        }
        
        return rootNode;
        
    }
    
    public TreeNode<T> ajustAVLTree(TreeNode<T> currentNode)
    {
        TreeNode<T> rootNode = currentNode;
        
        int leftSonHeight = (currentNode.lson != null) ? currentNode.lson.height : 0;
        int rightSonHeight = (currentNode.rson != null) ? currentNode.rson.height : 0;
        if(2 == rightSonHeight - leftSonHeight)
        {
        	int rightLeftSonHeight = (currentNode.rson.lson != null) ? currentNode.rson.lson.height : 0;
            int rightRightSonHeight = (currentNode.rson.rson != null) ? currentNode.rson.rson.height : 0;
            
            if(rightLeftSonHeight > rightRightSonHeight)
            {
                //RL
                rootNode = doubleRotateRightLeft(currentNode);
            }
            else
            {
                //RR
                rootNode = singleRotateRight(currentNode);
            }
        }
        else if(2 == leftSonHeight - rightSonHeight)
        {
        	int leftLeftSonHeight = (currentNode.lson.lson != null) ? currentNode.lson.lson.height : 0;
            int leftRightSonHeight = (currentNode.lson.rson != null) ? currentNode.lson.rson.height : 0;
            
            if(leftLeftSonHeight > leftRightSonHeight)
            {
                //LL
                rootNode = singleRotateLeft(currentNode);
            }
            else
            {
                //LR
                rootNode = doubleRotateLeftRight(currentNode);
            }
        }
        
        return rootNode;
    }
    
    public TreeNode<T> deleteTreeNode(TreeNode<T> deleteNode, TreeNode<T> currentNode)
    {
        if(deleteNode == null || currentNode == null)
        {
            return currentNode;
        }
        
        TreeNode<T> rootNode;

        if(deleteNode.data.compareTo(currentNode.data) > 0)
        {
            currentNode = deleteTreeNode(deleteNode, currentNode.rson);
            currentNode.height = getMaxHeight(currentNode);
            
            rootNode = ajustAVLTree(currentNode);
        }
        else if(deleteNode.data.compareTo(currentNode.data) < 0)
        {
            currentNode = deleteTreeNode(deleteNode, currentNode.lson);
            currentNode.height = getMaxHeight(currentNode);
            
            rootNode = ajustAVLTree(currentNode);
        }
        else
        {
            if(currentNode.freq >=2)
            {
                currentNode.freq--;
            }
            else
            {
                currentNode = null;
            }
            rootNode = currentNode;
        }
        
        
        return rootNode;
    }
    
    public TreeNode<T> middleSearchTreeNode(T searchData, TreeNode<T> currentNode)
    {
        if(currentNode == null)
        {
            return null;
        }
        
        TreeNode<T> result = null;
        if(searchData.equals(currentNode.data))
        {
            return currentNode;
        }
        else
        {
            result = middleSearchTreeNode(searchData, currentNode.lson);
            if(result == null)
            {
                result = middleSearchTreeNode(searchData, currentNode.rson);
            }
        }
        
        return result;
    }
    
    public void middleTraverseTree(TreeNode<T> rootNode)
    {
        if(rootNode == null)
        {
            return ;
        }
        
        if(rootNode.data != null)
        {
        	System.out.print(rootNode.data.toString() + "  ");
        }
              
        middleTraverseTree(rootNode.lson);
        middleTraverseTree(rootNode.rson);
     }
}
