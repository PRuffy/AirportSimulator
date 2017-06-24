package framework;

import framework.FrameworkLauncher;
import framework.GUI;
import framework.agent.TempAgent;
import framework.environment.AgentBody;
import framework.environment.DynamicType;
import framework.environment.WorldModel;
import framework.time.TimeManager;
import framework.util.SpawnMapping;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SarlElementType(16)
@SuppressWarnings("all")
public class AirportBoot extends FrameworkLauncher {
  private final float WORLD_SIZE_X = 200f;
  
  private final float WORLD_SIZE_Y = 200f;
  
  private final String filename = "res/graphInfo.xml";
  
  @Override
  protected boolean initializeSimulation(final List<Object> parameters) {
    WorldModel environment = new WorldModel(this.WORLD_SIZE_X, this.WORLD_SIZE_Y, this.filename);
    TimeManager _timeManager = environment.getTimeManager();
    GUI gui = new GUI(this.WORLD_SIZE_X, this.WORLD_SIZE_Y, _timeManager);
    DynamicType behaviour = DynamicType.STEERING;
    final SpawnMapping _function = new SpawnMapping() {
      @Override
      public Class<? extends Agent> getAgentTypeForBody(final AgentBody it) {
        return TempAgent.class;
      }
    };
    return this.initializeSimulation(environment, behaviour, gui, parameters, _function);
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
    AirportBoot other = (AirportBoot) obj;
    if (Float.floatToIntBits(other.WORLD_SIZE_X) != Float.floatToIntBits(this.WORLD_SIZE_X))
      return false;
    if (Float.floatToIntBits(other.WORLD_SIZE_Y) != Float.floatToIntBits(this.WORLD_SIZE_Y))
      return false;
    if (!Objects.equals(this.filename, other.filename)) {
      return false;
    }
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.WORLD_SIZE_X);
    result = prime * result + Float.floatToIntBits(this.WORLD_SIZE_Y);
    result = prime * result + Objects.hashCode(this.filename);
    return result;
  }
  
  @SyntheticMember
  public AirportBoot(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  public AirportBoot(final BuiltinCapacitiesProvider provider, final UUID parentID, final UUID agentID) {
    super(provider, parentID, agentID);
  }
}
