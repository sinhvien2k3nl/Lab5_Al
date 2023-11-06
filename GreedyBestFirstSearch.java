package puzzle_8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			Node com = frontier.poll();
			if(com.getH()==0)
				return com;
			else {
				List<Node> children = model.getSuccessors(com);
				for(Node child : children) {
					if(!frontier.contains(child) && !explored.contains(child)) {
						child.setG(com.getG()+1);
						frontier.add(child);
					}
				}
			}
		}
		return null;
	}

}
