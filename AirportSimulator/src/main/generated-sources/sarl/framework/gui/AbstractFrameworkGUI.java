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
package framework.gui;

import framework.gui.FrameworkGUI;
import framework.math.Circle2f;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import framework.math.Shape2f;
import framework.math.Vector2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 * Abstract implementation of a GUI for the agent framework.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public abstract class AbstractFrameworkGUI extends JFrame implements FrameworkGUI {
  /**
   * Convert the coordinates in the MAS into the equivalent coordinates on the screen.
   * 
   * @param p the coordinates
   * @return the coordinates on the screen.
   */
  @Override
  public Point2f mas2screen(final Point2f p) {
    boolean _equals = p.operator_equals(null);
    if (_equals) {
      return null;
    }
    float _x = p.getX();
    float _worldHeight = this.getWorldHeight();
    float _y = p.getY();
    float _minus = (_worldHeight - _y);
    return new Point2f(_x, _minus);
  }
  
  /**
   * Convert the vector in the MAS into the equivalent vector on the screen.
   * 
   * @param v the vector
   * @return the vector on the screen.
   */
  @Override
  public Vector2f mas2screen(final Vector2f p) {
    if ((p == null)) {
      return null;
    }
    float _x = p.getX();
    float _y = p.getY();
    float _minus = (-_y);
    return new Vector2f(_x, _minus, true);
  }
  
  /**
   * Convert the size in the MAS into the equivalent size on the screen.
   * 
   * @param size the size
   * @return the size on the screen.
   */
  @Override
  public float mas2screen(final float size) {
    return size;
  }
  
  /**
   * Convert the point from the screen coordinate to the MAS coordinate.
   * 
   * @param point the point on the screen.
   * @return the point in the MAS
   */
  @Override
  public Point2f screen2mas(final Point2f point) {
    if ((point == null)) {
      return null;
    }
    float _x = point.getX();
    float _worldHeight = this.getWorldHeight();
    float _y = point.getY();
    float _minus = (_worldHeight - _y);
    return new Point2f(_x, _minus);
  }
  
  /**
   * Convert the given MAS shape to the equivalent AWT shape.
   * 
   * @param shape the MAS shape
   * @return the AWT shape.
   */
  @Override
  public Shape mas2screen(final Shape2f<?> shape) {
    if ((shape == null)) {
      return null;
    }
    if ((shape instanceof Circle2f)) {
      Point2f p = this.mas2screen(((Circle2f)shape).getCenter());
      float radius = this.mas2screen(((Circle2f)shape).getRadius());
      float _x = p.getX();
      float _minus = (_x - radius);
      float _y = p.getY();
      float _minus_1 = (_y - radius);
      return new Ellipse2D.Float(_minus, _minus_1, 
        (2f * radius), 
        (2f * radius));
    }
    if ((shape instanceof Rectangle2f)) {
      Point2f l = this.mas2screen(((Rectangle2f)shape).getLower());
      Point2f u = this.mas2screen(((Rectangle2f)shape).getUpper());
      float _min = Math.min(l.getX(), u.getX());
      float _min_1 = Math.min(l.getY(), u.getY());
      float _mas2screen = this.mas2screen(((Rectangle2f)shape).getWidth());
      float _mas2screen_1 = this.mas2screen(((Rectangle2f)shape).getHeight());
      return new Rectangle2D.Float(
        ((float) _min), 
        ((float) _min_1), _mas2screen, _mas2screen_1);
    }
    throw new IllegalArgumentException();
  }
  
  @Override
  public void paintWorld(final Graphics2D g2d) {
  }
  
  @SyntheticMember
  public AbstractFrameworkGUI() {
    super();
  }
  
  @SyntheticMember
  public AbstractFrameworkGUI(final GraphicsConfiguration gc) {
    super(gc);
  }
  
  @SyntheticMember
  public AbstractFrameworkGUI(final String title) {
    super(title);
  }
  
  @SyntheticMember
  public AbstractFrameworkGUI(final String title, final GraphicsConfiguration gc) {
    super(title, gc);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = -2053347506L;
}
