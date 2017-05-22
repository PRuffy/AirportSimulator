package framework.environment;

import framework.environment.Frustum;
import framework.environment.FrustumIterator;
import framework.environment.QuadTreeNode;
import framework.environment.ShapedObject;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import framework.math.Shape2f;
import framework.math.Vector2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.Iterator;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class QuadTree<T extends ShapedObject> {
  private QuadTreeNode<T> root;
  
  public QuadTree(final Rectangle2f box) {
    QuadTreeNode<T> _quadTreeNode = new QuadTreeNode<T>(box);
    this.root = _quadTreeNode;
  }
  
  @Pure
  public QuadTreeNode<T> getRoot() {
    return this.root;
  }
  
  public Iterator<T> frustumIterator(final Frustum frustum, final Point2f position, final Vector2f orientation) {
    Shape2f<?> geometricFrustum = frustum.toShape(position, orientation);
    return new FrustumIterator<T>(this, geometricFrustum);
  }
  
  public QuadTreeNode<T> add(final T o) {
    return this.root.add(o);
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
