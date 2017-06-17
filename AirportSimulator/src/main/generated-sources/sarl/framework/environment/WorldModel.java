package framework.environment;

import framework.environment.AbstractEnvironment;
import framework.environment.AgentBody;
import framework.environment.Graph;
import framework.environment.Influence;
import framework.environment.MotionInfluence;
import framework.environment.Percept;
import framework.environment.QuadTree;
import framework.environment.SituatedObject;
import framework.gui.WorldModelStateProvider;
import framework.math.Point2f;
import framework.time.TimeManager;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SuppressWarnings("all")
public class WorldModel extends AbstractEnvironment implements WorldModelStateProvider {
  private QuadTree<SituatedObject> objTree;
  
  private Graph graph;
  
  @Override
  protected void onAgentBodyCreated(final AgentBody body) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected void onAgentBodyDestroyed(final AgentBody body) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected List<Influence> computeEndogenousBehaviorInfluences() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected List<Percept> computePerceptionsFor(final AgentBody agent) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected void applyInfluences(final Collection<MotionInfluence> motionInfluences, final Collection<Influence> otherInfluences, final TimeManager timeManager) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  @Pure
  public Iterable<? extends SituatedObject> getAllObjects() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void setMouseTarget(final Point2f target) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    WorldModel other = (WorldModel) obj;
    if (this.objTree == null) {
      if (other.objTree != null)
        return false;
    } else if (!this.objTree.equals(other.objTree))
      return false;
    if (this.graph == null) {
      if (other.graph != null)
        return false;
    } else if (!this.graph.equals(other.graph))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.objTree== null) ? 0 : this.objTree.hashCode());
    result = prime * result + ((this.graph== null) ? 0 : this.graph.hashCode());
    return result;
  }
  
  /**
   * @param width is the width of the environment.
   * @param height is the height of the environment.
   * @param timeManager is the time manager to use.
   */
  @SyntheticMember
  public WorldModel(final float width, final float height, final TimeManager timeManager) {
    super(width, height, timeManager);
  }
}
