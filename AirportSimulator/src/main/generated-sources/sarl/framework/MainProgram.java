package framework;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class MainProgram {
  private final static float WORLD_SIZE_X = 200f;
  
  private final static float WORLD_SIZE_Y = 200f;
  
  private final static String filename = "name";
  
  public static void main(final String... argv) {
  }
  
  @SyntheticMember
  public MainProgram() {
    super();
  }
}
