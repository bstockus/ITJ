package experiments.drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements MouseListener, ComponentListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1048562645093867730L;
	private static final Integer POINT_WIDTH = 4;
	private static final Integer POINT_HEIGHT = 4;
	
	private LinkedBlockingQueue<Point> pointsToDrawQueue = new LinkedBlockingQueue<Point>();
	private LinkedBlockingQueue<Point> linesToDrawStartPointQueue = new LinkedBlockingQueue<Point>();
	private LinkedBlockingQueue<Point> linesToDrawEndPointQueue = new LinkedBlockingQueue<Point>();
	private ArrayList<Point> pointsAllreadyDrawn = new ArrayList<Point>();
	private ArrayList<Point> linesAllreadyDrawnStartPoint = new ArrayList<Point>();
	private ArrayList<Point> linesAllreadyDrawnEndPoint = new ArrayList<Point>();
	private Boolean doFullRedraw = false;
	private Boolean doClearScreen = false;
	private Boolean currentlyTrackingMouseMovement = false;
	private Boolean currentlyDrawingLine = false;
	private Point currentInitialMousePoint = null;
	
	public DrawingPanel() {
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.addMouseListener(this);
		this.addComponentListener(this);
		this.addMouseMotionListener(this);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 200);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		Point currentPoint = this.pointsToDrawQueue.poll();
		while (currentPoint != null) {
			g.drawOval(currentPoint.x, currentPoint.y, DrawingPanel.POINT_WIDTH, DrawingPanel.POINT_HEIGHT);
			this.pointsAllreadyDrawn.add(currentPoint);
			currentPoint = this.pointsToDrawQueue.poll();
		}
		
		Point currentLineStartPoint = this.linesToDrawStartPointQueue.poll();
		while (currentLineStartPoint != null) {
			Point currentLineEndPoint = this.linesToDrawEndPointQueue.poll();
			g.drawLine(currentLineStartPoint.x, currentLineStartPoint.y, currentLineEndPoint.x, currentLineEndPoint.y);
			this.linesAllreadyDrawnStartPoint.add(currentLineStartPoint);
			this.linesAllreadyDrawnEndPoint.add(currentLineEndPoint);
			currentLineStartPoint = this.linesToDrawStartPointQueue.poll();
		}
		
		if (this.doFullRedraw) {
			for (Point point: this.pointsAllreadyDrawn) {
				g.drawOval(point.x, point.y, DrawingPanel.POINT_WIDTH, DrawingPanel.POINT_HEIGHT);
			}
			for (Integer index = 0; index < this.linesAllreadyDrawnStartPoint.size(); index ++) {
				Point startPoint = this.linesAllreadyDrawnStartPoint.get(index);
				Point endPoint = this.linesAllreadyDrawnEndPoint.get(index);
				g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
			}
			this.doFullRedraw = false;
		}
		
		if (this.doClearScreen) {
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			this.pointsAllreadyDrawn.clear();
			this.linesAllreadyDrawnEndPoint.clear();
			this.linesAllreadyDrawnStartPoint.clear();
			this.doClearScreen = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		if (me.getButton() == MouseEvent.BUTTON3) {
			System.out.print("Clear Screen");
			this.doClearScreen = true;
			this.repaint();
		} else {
			this.currentlyTrackingMouseMovement = true;
			this.currentInitialMousePoint = me.getPoint();
			this.currentlyDrawingLine = false;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		if (!(this.currentlyTrackingMouseMovement)) {
			if (this.currentlyDrawingLine) {
				try {
					this.pointsToDrawQueue.put(me.getPoint());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				this.linesToDrawStartPointQueue.put(this.currentInitialMousePoint);
				this.linesToDrawEndPointQueue.put(me.getPoint());
				this.repaint();
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.currentlyTrackingMouseMovement = false;
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent me) {
		try {
			this.linesToDrawStartPointQueue.put(this.currentInitialMousePoint);
			this.linesToDrawEndPointQueue.put(me.getPoint());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.currentInitialMousePoint = me.getPoint();
		this.currentlyDrawingLine = true;
		this.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent ce) {
		
	}

	@Override
	public void componentMoved(ComponentEvent ce) {
		this.doFullRedraw = true;
		this.repaint();
	}

	@Override
	public void componentResized(ComponentEvent ce) {
		this.doFullRedraw = true;
		this.repaint();
	}

	@Override
	public void componentShown(ComponentEvent ce) {
		this.doFullRedraw = true;
		this.repaint();
	}
	
}
