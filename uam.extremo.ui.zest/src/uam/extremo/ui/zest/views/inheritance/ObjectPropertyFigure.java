package uam.extremo.ui.zest.views.inheritance;

import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.CoordinateListener;
import org.eclipse.draw2d.EventDispatcher;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IClippingStrategy;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.KeyEvent;
import org.eclipse.draw2d.KeyListener;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;

public class ObjectPropertyFigure implements IFigure {

	@Override
	public void add(IFigure figure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(IFigure figure, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(IFigure figure, Object constraint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(IFigure figure, Object constraint, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAncestorListener(AncestorListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCoordinateListener(CoordinateListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFigureListener(FigureListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFocusListener(FocusListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addKeyListener(KeyListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLayoutListener(LayoutListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMouseListener(MouseListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMouseMotionListener(MouseMotionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNotify() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsPoint(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub

	}

	@Override
	public IFigure findFigureAt(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFigure findFigureAt(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFigure findFigureAtExcluding(int x, int y, Collection collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFigure findMouseEventTargetAt(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getBackgroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Border getBorder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getClientArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getClientArea(Rectangle rect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IClippingStrategy getClippingStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cursor getCursor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Font getFont() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getForegroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insets getInsets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayoutManager getLayoutManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getLocalBackgroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getLocalForegroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getMaximumSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getMinimumSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getMinimumSize(int wHint, int hHint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFigure getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFigure getToolTip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateManager getUpdateManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleFocusGained(FocusEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleFocusLost(FocusEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleKeyPressed(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleKeyReleased(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMouseDoubleClicked(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMouseExited(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMouseHover(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMousePressed(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasFocus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EventDispatcher internalGetEventDispatcher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Rectangle rect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void invalidate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void invalidateTree() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCoordinateSystem() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFocusTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMirrored() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOpaque() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestFocusEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isShowing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void paint(Graphics graphics) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(IFigure figure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAncestorListener(AncestorListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCoordinateListener(CoordinateListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFigureListener(FigureListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFocusListener(FocusListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeKeyListener(KeyListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLayoutListener(LayoutListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMouseListener(MouseListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMouseMotionListener(MouseMotionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNotify() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(String property, PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub

	}

	@Override
	public void repaint(int x, int y, int w, int h) {
		// TODO Auto-generated method stub

	}

	@Override
	public void repaint(Rectangle rect) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void revalidate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBackgroundColor(Color c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBorder(Border b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBounds(Rectangle rect) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClippingStrategy(IClippingStrategy clippingStrategy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConstraint(IFigure child, Object constraint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCursor(Cursor cursor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocusTraversable(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFont(Font f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setForegroundColor(Color c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLayoutManager(LayoutManager lm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocation(Point p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaximumSize(Dimension size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMinimumSize(Dimension size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOpaque(boolean isOpaque) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(IFigure parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPreferredSize(Dimension size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRequestFocusEnabled(boolean requestFocusEnabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSize(Dimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSize(int w, int h) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToolTip(IFigure figure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub

	}

	@Override
	public void translate(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void translateFromParent(Translatable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void translateToAbsolute(Translatable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void translateToParent(Translatable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void translateToRelative(Translatable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

}
