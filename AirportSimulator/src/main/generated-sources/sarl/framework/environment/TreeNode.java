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
public class TreeNode<T extends ShapedObject> {
  private final Rectangle2f box;
  
  private LinkedList<T> objects;
  
  private final WeakReference<TreeNode<T>> parent;
  
  private List<TreeNode<T>> children;
  
  @DefaultValueSource
  public TreeNode(@DefaultValue("framework.environment.TreeNode#NEW_0") final TreeNode parent, final Rectangle2f box) {
    if ((parent != null)) {
      WeakReference<TreeNode<T>> _weakReference = new WeakReference<TreeNode<T>>(parent);
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
  private final static TreeNode $DEFAULT_VALUE$NEW_0 = null;
  
  @Pure
  public TreeNode<T> getParent() {
    WeakReference<TreeNode<T>> _parent = this.parent;
    TreeNode<T> _get = null;
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
  public List<TreeNode<T>> getChildren() {
    return this.children;
  }
  
  public TreeNode<T> add(final T o) {
    if ((this.children == null)) {
      TreeNode<T> n = null;
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
            TreeNode<T> x = this.pushInBranch(obj);
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
      TreeNode<T> n_1 = this.pushInBranch(o);
      if ((n_1 == null)) {
        this.objects.add(o);
        n_1 = this;
      }
      return n_1;
    }
  }
  
  private TreeNode<T> pushInBranch(final T o) {
    ArrayList<TreeNode<T>> ns = new ArrayList<TreeNode<T>>();
    for (final TreeNode<T> c : this.children) {
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
    ArrayList<TreeNode<T>> _arrayList = new ArrayList<TreeNode<T>>(4);
    this.children = _arrayList;
    IntegerRange _upTo = new IntegerRange(0, 3);
    for (final Integer i : _upTo) {
      Rectangle2f _computeChildBox = this.computeChildBox((i).intValue());
      TreeNode<T> _treeNode = new TreeNode<T>(this, _computeChildBox);
      this.children.add(_treeNode);
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
  
  @DefaultValueUse("framework.environment.TreeNode,framework.math.Rectangle2f")
  @SyntheticMember
  public TreeNode(final Rectangle2f box) {
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
