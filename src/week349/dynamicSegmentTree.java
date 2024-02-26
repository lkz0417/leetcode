package week349;

public class dynamicSegmentTree {
  Node root;
  int size;

  public dynamicSegmentTree(int n){
    root = null;
    size = n;
  }

  public void update(int l, int r, int delta){
    root = update(root, 0, size - 1, l, r, delta);
  }

  public int query(int l, int r){
    return query(root, 0, size - 1, l, r);
  }

  public Node update(Node node,int start, int end, int l, int r, int delta){
    if(node == null){
      node = new Node();
    }

    int mid = (end - start) / 2 + start;
    if(node.lazy > 0){
      node.val += (end - start + 1) * delta;
      if(start != end){
        if(node.left == null) node.left = new Node();
        if(node.right == null) node.right = new Node();
        node.left.lazy += node.lazy;
        node.right.lazy += node.lazy;
      }
      node.lazy = 0;
    }
    if(l > end || r < start){
      return node;
    }
    if(l <= start && r >= end){
      node.val += (end - start + 1) * delta;
      if(start != end){
        if(node.left == null) node.left = new Node();
        if(node.right == null) node.right = new Node();
        node.left.lazy += delta;
        node.right.lazy += delta;
      }

      return node;
    }
    node.left = update(node.left ,start, mid, l, r ,delta);
    node.right = update(node.right, mid+1, end, l, r, delta);
    node.val = node.left.val + node.right.val;
    return node;
  }

  public int query(Node node, int start, int end, int l, int r){
    if(node == null || l> end || r < start){
      return 0;
    }
    if(node.lazy > 0){
      node.val += (end - start +1) * node.lazy;
      if(start != end){
        if(node.left == null) node.left = new Node();
        if(node.right == null) node.right = new Node();
        node.left.lazy += node.lazy;
        node.right.lazy +=node.lazy;
      }
      node.lazy = 0;
    }
    if(start >= l && end <= r){
      return node.val;
    }
    int mid = (end - start) / 2 + start;
    int res = 0;
    if(l <= mid) res += query(node.left, start, mid, l, r);
    if(r > mid) res += query(node.right, mid+1, end, l, r);
    return res;
  }

}
class Node{
  int val;
  int lazy;
  Node left;
  Node right;
  public Node(){
    val = 0;
    lazy = 0;
    left = null;
    right = null;
  }
}
