import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.*;
import org.slf4j.*;
import java.util.*;

public class Star {

  Logger logger = LoggerFactory.getLogger(Tree.class);

  public void starTree(int numUsers) {

    int edgeCounter = 3;
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> lowList = new ArrayList<Integer>();
    ArrayList<Integer> mediumList = new ArrayList<Integer>();
    ArrayList<Integer> highList = new ArrayList<Integer>();

    SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> starGraph =
        new SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge>
            (DefaultWeightedEdge.class);
    for (int counter = 0; counter < numUsers; counter++) {
      Random rdn = new Random();
      list.add(counter, rdn.nextInt(99));
      starGraph.addVertex(counter);
      logger.info("Vertex - " + counter + " added! Ping - " + list.get(counter));
    }

    for (int counter = 0; counter < numUsers - 1; counter++) {
      DefaultWeightedEdge e1 = starGraph.addEdge(counter, counter + 1);
      starGraph.setEdgeWeight(e1, list.get(counter));
      if(counter == numUsers - 2) {
        DefaultWeightedEdge lastEdge = starGraph.addEdge(counter + 1, 1);
        starGraph.setEdgeWeight(lastEdge, list.get(counter + 1));
      }
    }

    while (edgeCounter < numUsers) {
      DefaultWeightedEdge e1 = starGraph.addEdge(0, edgeCounter);
      starGraph.setEdgeWeight(e1, list.get(edgeCounter));
      edgeCounter += 2;
    }

    logger.info("Shortest path from 0 to 5 and check what graph build right");
    List shortest_path = DijkstraShortestPath.findPathBetween(starGraph, 0, 5);
    System.out.println(shortest_path);
    for(DefaultWeightedEdge e : starGraph.edgeSet()){
      System.out.println(starGraph.getEdgeSource(e) + " -> " + starGraph.getEdgeTarget(e));
    }
  }
}
