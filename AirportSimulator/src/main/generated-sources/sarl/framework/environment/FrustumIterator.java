package framework.environment;

import framework.environment.ShapedObject;
import framework.environment.Tree;
import framework.environment.TreeNode;
import framework.math.Shape2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class FrustumIterator<T extends ShapedObject> implements Iterator<T> {
  private final Shape2f<?> frustum;
  
  private T nextObject;
  
  private final Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
  
  private final LinkedList<T> buffer = new LinkedList<T>();
  
  public FrustumIterator(final Tree<T> tree, final Shape2f<?> fr) {
    this.frustum = fr;
    TreeNode<T> _root = tree.getRoot();
    this.stack.add(_root);
    this.searchNext();
  }
  
  @Override
  @Pure
  public boolean hasNext() {
    return (this.nextObject != null);
  }
  
  @Override
  public T next() {
    T n = this.nextObject;
    this.searchNext();
    return n;
  }
  
  private T searchNext() {
    T _xblockexpression = null;
    {
      this.nextObject = null;
      while ((this.buffer.isEmpty() && (!this.stack.empty()))) {
        {
          TreeNode<T> node = this.stack.pop();
          boolean _intersects = this.frustum.intersects(node.getBox());
          if (_intersects) {
            List<TreeNode<T>> _children = node.getChildren();
            for (final TreeNode<T> c : _children) {
              this.stack.add(c);
            }
            LinkedList<T> _objects = node.getObjects();
            for (final T o : _objects) {
              boolean _intersects_1 = this.frustum.intersects(o.getShape());
              if (_intersects_1) {
                this.buffer.add(o);
              }
            }
          }
        }
      }
      T _xifexpression = null;
      boolean _isEmpty = this.buffer.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _xifexpression = this.nextObject = this.buffer.removeFirst();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
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
