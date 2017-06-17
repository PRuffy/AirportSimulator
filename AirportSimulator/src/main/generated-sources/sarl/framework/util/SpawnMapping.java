/**
 * $Id$
 * 
 * Copyright (c) 2014-17 Stephane GALLAND <stephane.galland@utbm.fr>.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * This program is free software; you can redistribute it and/or modify
 */
package framework.util;

import framework.environment.AgentBody;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import org.eclipse.xtext.xbase.lib.Inline;

/**
 * Define the spawning mapping
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public abstract class SpawnMapping {
  /**
   * Replies the agent type for a body.
   * 
   * @return the type of a agent for the given body.
   */
  public abstract Class<? extends Agent> getAgentTypeForBody(final AgentBody body);
  
  /**
   * Replies the agent type for a body.
   * 
   * @return the type of a agent for the given body.
   * @see #getAgentTypeForBody(AgentBody)
   */
  @Inline("getAgentTypeForBody($1)")
  public final Class<? extends Agent> operator_doubleArrow(final AgentBody body) {
    return this.getAgentTypeForBody(body);
  }
  
  @SyntheticMember
  public SpawnMapping() {
    super();
  }
}
