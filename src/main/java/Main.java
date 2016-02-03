import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.*;
import org.slf4j.*;
import java.util.List;

public class Main {

  public static void main(String [] args)
  {
    Logger logger = LoggerFactory.getLogger(Main.class);
    logger.info("Hi, I'm logger! Nice to meet you!");

    SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph =
        new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
            (DefaultWeightedEdge.class);

    graph.addVertex("vertex1");
    graph.addVertex("vertex2");
    graph.addVertex("vertex3");
    graph.addVertex("vertex4");
    graph.addVertex("vertex5");


    DefaultWeightedEdge e1 = graph.addEdge("vertex1", "vertex2");
    graph.setEdgeWeight(e1, 5);

    DefaultWeightedEdge e2 = graph.addEdge("vertex2", "vertex3");
    graph.setEdgeWeight(e2, 3);

    DefaultWeightedEdge e3 = graph.addEdge("vertex4", "vertex5");
    graph.setEdgeWeight(e3, 6);

    DefaultWeightedEdge e4 = graph.addEdge("vertex2", "vertex4");
    graph.setEdgeWeight(e4, 2);

    DefaultWeightedEdge e5 = graph.addEdge("vertex5", "vertex4");
    graph.setEdgeWeight(e5, 4);

    DefaultWeightedEdge e6 = graph.addEdge("vertex2", "vertex5");
    graph.setEdgeWeight(e6, 9);

    DefaultWeightedEdge e7 = graph.addEdge("vertex4", "vertex1");
    graph.setEdgeWeight(e7, 7);

    DefaultWeightedEdge e8 = graph.addEdge("vertex3", "vertex2");
    graph.setEdgeWeight(e8, 2);

    DefaultWeightedEdge e9 = graph.addEdge("vertex1", "vertex3");
    graph.setEdgeWeight(e9, 10);

    DefaultWeightedEdge e10 = graph.addEdge("vertex3", "vertex5");
    graph.setEdgeWeight(e10, 1);

    logger.info("Shortest path from vertex1 to vertex5:");
    List shortest_path = DijkstraShortestPath.findPathBetween(graph, "vertex1", "vertex5");
    System.out.println(shortest_path);
    Tree tree = new Tree();
    tree.treeInitialization();
  }
}