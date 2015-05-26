package Trees_and_Graphs;

import java.util.LinkedList;

public class IsRoute {

	/**
	 * Problem 4.2
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
		System.out.println(isRoute(g, start, end));
	}

	public static enum State{
		Unvisited, Visited, Visiting;
	}
	
	public static boolean isRoute(Graph g, Node start, Node dest){
		if (g == null || start == null || dest == null) return false;
		if (dest == start) return true;
		for (Node u : g.getNodes()){
			u.state = State.Unvisited;
		}
		
		LinkedList<Node> queue = new LinkedList<Node>();
		
		queue.add(start);
		
		while(!queue.isEmpty()){
			Node n = queue.remove();
			for (Node u : g.getNodes()){
				if (u == n){
					u.state = State.Visited;
					System.out.println("Visiting Node: " + u.getVertex());
					if (dest == u) return true;
					
					for (Node v : u.getAdjacent()){
						if (v.state == State.Unvisited){
							queue.add(v);
						}
					}
				}
			}
		}
		
		return false;
	}
	
	// Book's solution
	public static boolean search(Graph g, Node start, Node end){
		if (start == end) return true;
		
		// Operates as queue
		LinkedList<Node> q = new LinkedList<Node>();
		
		for (Node u : g.getNodes()){
			u.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		
		q.add(start);
		Node u;
		
		while (!q.isEmpty()){
			u = q.removeFirst(); // Dequeue
			
			if (u != null) {
				
				// Check this node's neighbors
				for (Node v : u.getAdjacent()){
					if (v.state == State.Unvisited){
						if (v == end){ // Found destination node
							return true;
						}
						else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				
				u.state = State.Visited;
			}
		}
		
		return false;
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
}
