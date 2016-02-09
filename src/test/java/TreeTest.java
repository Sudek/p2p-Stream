import org.junit.Test;

public class TreeTest {

  @Test
  public void shouldInit() {
    Tree tree = new Tree();
    tree.treeInitialization(10);
    tree.treeTrain(10);
  }

  @Test
  public void shouldTrain() {
    Tree tree = new Tree();
    tree.treeTrain(10);
  }

  @Test
  public void shouldStar() {
    Tree tree = new Tree();
    tree.starTree(10);
  }
}
