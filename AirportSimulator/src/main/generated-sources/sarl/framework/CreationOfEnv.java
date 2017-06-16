package framework;

import framework.environment.Graph;
import framework.environment.QuadTree;
import framework.environment.SituatedObject;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class CreationOfEnv {
  @SuppressWarnings("java_style_type_cast")
  public DocumentBuilderFactory createGraph(final String filename, final Graph graph, final QuadTree<SituatedObject> objTree) {
    DocumentBuilderFactory _xblockexpression = null;
    {
      DocumentBuilderFactory factory = null;
      _xblockexpression = factory = DocumentBuilderFactory.newInstance();
    }
    return _xblockexpression;
  }
  
  @SyntheticMember
  public CreationOfEnv() {
    super();
  }
}
