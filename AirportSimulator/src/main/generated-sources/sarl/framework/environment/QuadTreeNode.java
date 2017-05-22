package framework.environment;

import framework.environment.ShapedObject;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import io.sarl.lang.annotation.DefaultValue;
import io.sarl.lang.annotation.DefaultValueSource;
import io.sarl.lang.annotation.DefaultValueUse;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSourceCode;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class QuadTreeNode<T extends ShapedObject> {
  private final Rectangle2f box;
  
  private LinkedList<T> objects;
  
  private final WeakReference<QuadTreeNode<T>> parent;
  
  private List<QuadTreeNode<T>> children;
  
  @DefaultValueSource
  public QuadTreeNode(@DefaultValue("framework.environment.QuadTreeNode#NEW_0") final QuadTreeNode parent, final Rectangle2f box) {
    if ((parent != null)) {
      WeakReference<QuadTreeNode<T>> _weakReference = new WeakReference<QuadTreeNode<T>>(parent);
      this.parent = _weakReference;
    } else {
      this.parent = null;
    }
    this.box = box;
  }
  
  /**
   * Default value for the parameter parent
   */
  @SyntheticMember
  @SarlSourceCode("null")
  private final static QuadTreeNode $DEFAULT_VALUE$NEW_0 = null;
  
  @Pure
  public QuadTreeNode<T> getParent() {
    WeakReference<QuadTreeNode<T>> _parent = this.parent;
    QuadTreeNode<T> _get = null;
    if (_parent!=null) {
      _get=_parent.get();
    }
    return _get;
  }
  
  @Pure
  public Rectangle2f getBox() {
    return this.box;
  }
  
  @Pure
  public LinkedList<T> getObjects() {
    return this.objects;
  }
  
  @Pure
  public List<QuadTreeNode<T>> getChildren() {
    return this.children;
  }
  
  public QuadTreeNode<T> add(final T o) {
    if ((this.children == null)) {
      QuadTreeNode<T> n = null;
      int _size = this.objects.size();
      int _plus = (_size + 1);
      boolean _lessEqualsThan = (_plus <= 10);
      if (_lessEqualsThan) {
        this.objects.add(o);
        n = this;
      } else {
        this.createChildren();
        LinkedList<T> old = this.objects;
        LinkedList<T> _linkedList = new LinkedList<T>();
        this.objects = _linkedList;
        for (final T obj : old) {
          {
            QuadTreeNode<T> x = this.pushInBranch(obj);
            if ((x == null)) {
              this.objects.add(obj);
            }
          }
        }
        n = this.pushInBranch(o);
        if ((n == null)) {
          n = this;
          this.objects.add(o);
        }
      }
      return n;
    } else {
      QuadTreeNode<T> n_1 = this.pushInBranch(o);
      if ((n_1 == null)) {
        this.objects.add(o);
        n_1 = this;
      }
      return n_1;
    }
  }
  
  private QuadTreeNode<T> pushInBranch(final T o) {
    ArrayList<QuadTreeNode<T>> ns = new ArrayList<QuadTreeNode<T>>();
    for (final QuadTreeNode<T> c : this.children) {
      boolean _intersects = o.getShape().intersects(c.box);
      if (_intersects) {
        ns.add(c);
      }
    }
    int _size = ns.size();
    boolean _tripleEquals = (_size == 1);
    if (_tripleEquals) {
      return ns.get(0).add(o);
    }
    return null;
  }
  
  private void createChildren() {
    ArrayList<QuadTreeNode<T>> _arrayList = new ArrayList<QuadTreeNode<T>>(4);
    this.children = _arrayList;
    IntegerRange _upTo = new IntegerRange(0, 3);
    for (final Integer i : _upTo) {
      Rectangle2f _computeChildBox = this.computeChildBox((i).intValue());
      QuadTreeNode<T> _quadTreeNode = new QuadTreeNode<T>(this, _computeChildBox);
      this.children.add(_quadTreeNode);
    }
  }
  
  private Rectangle2f computeChildBox(final int i) {
    Point2f center = this.box.getCenter();
    switch (i) {
      case 0:
        Point2f _lower = this.box.getLower();
        return new Rectangle2f(_lower, center);
      case 1:
        float _x = center.getX();
        float _y = this.box.getLower().getY();
        float _x_1 = this.box.getUpper().getX();
        float _y_1 = center.getY();
        return new Rectangle2f(_x, _y, _x_1, _y_1);
      case 2:
        float _x_2 = this.box.getLower().getX();
        float _y_2 = center.getY();
        float _x_3 = center.getX();
        float _y_3 = this.box.getUpper().getY();
        return new Rectangle2f(_x_2, _y_2, _x_3, _y_3);
      case 3:
        Point2f _upper = this.box.getUpper();
        return new Rectangle2f(center, _upper);
    }
    return null;
  }
  
  @DefaultValueUse("framework.environment.QuadTreeNode,framework.math.Rectangle2f")
  @SyntheticMember
  public QuadTreeNode(final Rectangle2f box) {
    this($DEFAULT_VALUE$NEW_0, box);
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
