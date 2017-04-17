
public class TreeNode<T> {
    public TreeNode(T data) {
        this.data = data;
    }
    public T data;
    public int freq;
    public int height;
    public TreeNode<T> lson;
    public TreeNode<T> rson;
}
