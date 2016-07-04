import org.junit.Test;

public class TrainTest {
  Train train = new Train();
  @Test
  public void shouldInit(){
    train.treeTrain(10);
  }
}
