package framework.environment;

import framework.CreationOfEnv;
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
import framework.math.Rectangle2f;
import framework.time.StepTimeManager;
import framework.time.TimeManager;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class WorldModel extends AbstractEnvironment implements WorldModelStateProvider {
  private QuadTree<SituatedObject> objTree;
  
  private Graph graph;
  
  private ArrayList<AgentBody> agentBodies;
  
  public WorldModel(final float width, final float height, final String filename) {
    super(width, height, new StepTimeManager(500));
    Rectangle2f _rectangle2f = new Rectangle2f(0, 0, width, height);
    QuadTree<SituatedObject> _quadTree = new QuadTree<SituatedObject>(_rectangle2f);
    this.objTree = _quadTree;
    Graph _graph = new Graph();
    this.graph = _graph;
    CreationOfEnv envInit = null;
    CreationOfEnv _creationOfEnv = new CreationOfEnv();
    envInit = _creationOfEnv;
    envInit.createGraph(filename, this.graph, this.objTree);
  }
  
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
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
}
