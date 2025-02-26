//TC - O(v + E)
//SC - O(V)

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>(); 
        Queue<Node> q = new LinkedList<>();
        if(node == null) return null;
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n : curr.neighbors){
                if(!map.containsKey(n)){
                    Node copyN = new Node(n.val);
                    map.put(n, copyN);
                    q.add(n);
                }
                 map.get(curr).neighbors.add(map.get(n));
            }
           
        }
        return copyNode;
    }
}
