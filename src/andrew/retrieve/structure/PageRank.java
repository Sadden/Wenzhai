package andrew.retrieve.structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PageRank {
	static float D=(float) 0.85;
	static float e=(float) 0.02;
	static float Cha=(float)0.0;
	static float INITIAL_SCORE = (float) 100;
	// Nodes. Easy look up by name of node and its corresponding PageNode object.
	private Map<String, PageNode> name_to_node = new HashMap<String, PageNode>();
	// Edges. The association between a node and the nodes it sends a directed edge.
	private Map<PageNode, List<PageNode>> page_edges = new HashMap<PageNode, List<PageNode>>();
	
	// Parse file and initialize graph represented by member variables.
	public void initialize(Set<String> node2,Set<String> edge2) throws IOException, IllegalArgumentException, NumberFormatException {
		List<String> node=new LinkedList<String>(node2);
		List<String> edge=new LinkedList<String>(edge2);
		int number_of_nodes = node.size();
		// Create name_to_node.
		for (int i = 0; i < number_of_nodes; i++) {
			String name = node.get(i);
			PageNode page_node = new PageNode(name);
			page_node.setCurrentScore(INITIAL_SCORE/node.size());
			//System.out.println(page_node.name+" bef "+page_node.getCurrentScore());
			name_to_node.put(name, page_node);
		}
		int number_of_edges = edge.size();
		// Create page_edges.
		for (int i = 0; i < number_of_edges; i++) {
			String[] nodes_in_edge = edge.get(i).split(" ");
			List<PageNode> nodes;
			if (!name_to_node.keySet().contains(nodes_in_edge[0])
				|| !name_to_node.keySet().contains(nodes_in_edge[1])
				||nodes_in_edge[0].equals(nodes_in_edge[1])) {
				//System.out.println("Throw!");
				//continue;
				throw new IllegalArgumentException();		
			}
			if (page_edges.get(name_to_node.get(nodes_in_edge[0])) != null) {
				nodes = new ArrayList<PageNode>(page_edges.get(name_to_node.get(nodes_in_edge[0])));
			} else {
				nodes = new ArrayList<PageNode>();
			}
			nodes.add(name_to_node.get(nodes_in_edge[1]));
			page_edges.put(name_to_node.get(nodes_in_edge[0]), nodes);
		}
		
	}
	// One iteration of updating the score.
	public boolean updateScore() {
		float ee=e;
		for (PageNode origin: page_edges.keySet()) {
			//System.out.println("origin="+origin.name);
			for (PageNode dest: page_edges.get(origin)) {
				//System.out.println("dest="+dest.name);
				//System.out.println("new="+dest.getNewScore()+" cur="+dest.getCurrentScore()+" oricur="+origin.getCurrentScore());
						float score=dest.getNewScore() + origin.getCurrentScore() / page_edges.get(origin).size();
						dest.setNewScore(score*D+((1-D)/name_to_node.size()));
						//System.out.println("dest score"+score);
			}
		} 
		for (String s: name_to_node.keySet()) {
			PageNode page_node=name_to_node.get(s);

			if(!page_edges.containsKey(page_node)){
				page_node.setNewScore(-page_node.getCurrentScore()/name_to_node.size());
				Cha+=page_node.getCurrentScore()*(1+1/name_to_node.size());
			}
		}
		for (String s: name_to_node.keySet()) {
			PageNode page_node=name_to_node.get(s);
			
			if(Math.abs(page_node.getNewScore()-page_node.getCurrentScore())>ee)ee=page_node.getNewScore()-page_node.getCurrentScore();
			page_node.setCurrentScore(page_node.getNewScore()+Cha/name_to_node.size());
			//System.out.println(page_node.name+" aft "+page_node.getCurrentScore());
			page_node.setNewScore(0);
		}
		Cha=(float) 0.0;
		if(ee>e)return true;
		else return false;
	}
	public List<String> sort(int n){
		List<String> sort=new LinkedList<String>();
		int time=n>name_to_node.size()?name_to_node.size():n;
		for(int i=0;i<time;i++){
			String pos=null;
			float max=(float)0;
			for(String p:name_to_node.keySet()){
				PageNode pp=name_to_node.get(p);
				if(pp.getCurrentScore()>=max){
					max=pp.getCurrentScore();
					pos=p;
				}
			}
			//System.out.println("max="+max+"pos="+pos);
			sort.add(pos);
			try{
				name_to_node.get(pos).setCurrentScore((float)-1);
			}catch(java.lang.NullPointerException e){
				//System.out.println(pos);
				e.printStackTrace();
			}
		}
		
		return sort;
	}
}
