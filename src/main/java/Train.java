import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.*;
import org.slf4j.*;
import java.util.*;

public class Train {

  Logger logger = LoggerFactory.getLogger(Tree.class);

  public void treeTrain(int numUsers) {
    SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> trainGraph =
        new SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge>
            (DefaultWeightedEdge.class);
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int counter = 0; counter < numUsers; counter++) {
      Random rdn = new Random();
      list.add(counter, rdn.nextInt(85));
      trainGraph.addVertex(counter);
      logger.info("Vertex - " + counter + " added! Ping - " + list.get(counter));
    }

    for (int counter = 1; counter < numUsers; counter++) {
      if (counter % 2 != 0) {
        DefaultWeightedEdge e1 = trainGraph.addEdge(0, counter);
        trainGraph.setEdgeWeight(e1, list.get(counter));
      } if (counter % 2 == 0) {
        DefaultWeightedEdge e2 = trainGraph.addEdge(counter - 1, counter);
        trainGraph.setEdgeWeight(e2, list.get(counter));
      }
    }
    logger.info("Shortest path from 0 to 4 and check what graph build right");
    List shortest_path = DijkstraShortestPath.findPathBetween(trainGraph, 0, 4);
    System.out.println(shortest_path);
  }
}
