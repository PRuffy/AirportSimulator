/**
 * $Id$
 * 
 * Copyright (c) 2011-17 Stephane GALLAND <stephane.galland@utbm.fr>.
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
package framework;

import framework.environment.EnvironmentEvent;
import framework.environment.WorldModelState;
import framework.gui.AbstractFrameworkGUI;
import framework.math.Point2f;
import framework.math.Vector2f;
import framework.time.TimeManager;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.Serializable;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * UI for the rabbits.
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class GUI extends AbstractFrameworkGUI {
  public GUI(final float worldWidth, final float worldHeight, final TimeManager timeManager) {
  }
  
  @Override
  public void paintAgentBody(final Graphics2D g2d, final Point2f positionOnScreen, final Vector2f orientationOnScreen, final Shape shape, final Serializable type, final String name, final Point2f positionInMas, final Shape frustum) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void paintSituatedObject(final Graphics2D g2d, final Point2f positionOnScreen, final Vector2f orientationOnScreen, final Shape shape, final Serializable type, final String name, final Point2f positionInMas) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void setMessage(final String message) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  @Pure
  public String getMessage() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  @Pure
  public float getWorldWidth() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  @Pure
  public float getWorldHeight() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  @Pure
  public WorldModelState getLastWorldState() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void paintAxes(final Graphics2D g) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void setMouseTargetOnScreen(final Point2f screenPosition) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void environmentChanged(final EnvironmentEvent event) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void setTerminationHandler(final Procedure0 handler) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  @Pure
  public Procedure0 getTerminationHandler() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @SyntheticMember
  private final static long serialVersionUID = -1236636640L;
}
