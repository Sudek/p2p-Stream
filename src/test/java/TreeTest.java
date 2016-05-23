import org.junit.Test;

public class TreeTest {

  Tree tree = new Tree();

  @Test
  public void shouldInit() {
    tree.treeInitialization(10);
}

  @Test
  public void shouldTrain() {
    tree.treeTrain(10);
  }

  @Test
  public void shouldStar() {
    tree.starTree(6);
  }
}
