package framework;

import framework.SimulatorAgent;
import framework.environment.DynamicType;
import framework.environment.Environment;
import framework.environment.StopSimulation;
import framework.gui.FrameworkGUI;
import framework.util.SpawnMapping;
import io.janusproject.Boot;
import io.janusproject.JanusConfig;
import io.janusproject.kernel.Kernel;
import io.janusproject.services.contextspace.ContextSpaceService;
import io.janusproject.util.LoggerCreator;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.EventSpace;
import io.sarl.lang.core.SpaceID;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Launcher of the simulation framework.
 * 
 * This launcher needs the {@link http://www.janusproject.io Janus platform}.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class FrameworkLauncher {
  private static UUID environmentInteractionSpace;
  
  private static Environment environmentSingleton;
  
  private static FrameworkGUI uiSingleton;
  
  private static Kernel kernel;
  
  private final static AtomicBoolean canStop = new AtomicBoolean(false);
  
  /**
   * Launch the simulation and its associated UI.
   * 
   * @param environment is the environment to use.
   * @param spawnMapping the mapping from body to agent type.
   * @param behaviorType the type of the agent behaviors.
   * @param gui is the GUI to launch.
   * @param parameters the parameters to give to every agent.
   * @throws Exception if the Janus platform cannot be started.
   */
  public static void launchSimulation(final Environment environment, final SpawnMapping spawnMapping, final DynamicType behaviorType, final FrameworkGUI gui, final Object... parameters) {
    try {
      Boot.setOffline(true);
      Boot.setVerboseLevel(LoggerCreator.toInt(Level.INFO));
      Boot.showJanusLogo();
      FrameworkLauncher.environmentInteractionSpace = UUID.randomUUID();
      FrameworkLauncher.uiSingleton = gui;
      FrameworkLauncher.environmentSingleton = environment;
      List<?> params = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(FrameworkLauncher.environmentSingleton, FrameworkLauncher.environmentInteractionSpace, spawnMapping, behaviorType));
      System.arraycopy(parameters, 0, params, 4, parameters.length);
      FrameworkLauncher.kernel = Boot.startJanus(SimulatorAgent.class, params);
      if ((FrameworkLauncher.uiSingleton != null)) {
        if ((FrameworkLauncher.environmentSingleton != null)) {
          FrameworkLauncher.environmentSingleton.addEnvironmentListener(FrameworkLauncher.uiSingleton);
        }
        FrameworkLauncher.uiSingleton.setVisible(true);
      }
      FrameworkLauncher.canStop.set(true);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Stop the simulation right now.
   */
  public static Kernel stopSimulation() {
    Kernel _xblockexpression = null;
    {
      boolean _get = FrameworkLauncher.canStop.get();
      boolean _not = (!_get);
      if (_not) {
        throw new IllegalStateException("You must call startSimulation() before stopSimulation().");
      }
      AgentContext context = FrameworkLauncher.kernel.<ContextSpaceService>getService(ContextSpaceService.class).getContext(
        UUID.fromString(JanusConfig.DEFAULT_CONTEXT_ID_VALUE));
      EventSpace space = context.getDefaultSpace();
      SpaceID _spaceID = space.getSpaceID();
      UUID _randomUUID = UUID.randomUUID();
      Address adr = new Address(_spaceID, _randomUUID);
      StopSimulation sSimulation = new StopSimulation(adr);
      context.getDefaultSpace().emit(sSimulation, null);
      if ((FrameworkLauncher.uiSingleton != null)) {
        FrameworkLauncher.uiSingleton.setVisible(false);
        if ((FrameworkLauncher.environmentSingleton != null)) {
          FrameworkLauncher.environmentSingleton.removeEnvironmentListener(FrameworkLauncher.uiSingleton);
        }
        FrameworkLauncher.uiSingleton.dispose();
      }
      FrameworkLauncher.environmentSingleton = null;
      FrameworkLauncher.environmentInteractionSpace = null;
      FrameworkLauncher.uiSingleton = null;
      _xblockexpression = FrameworkLauncher.kernel = null;
    }
    return _xblockexpression;
  }
  
  @SyntheticMember
  public FrameworkLauncher() {
    super();
  }
}
