
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends MouseAdapter {

    private WorldView view;
    private Shape ballShape;
    private BodyImage ballImage;

    public MouseHandler(WorldView view) {
        this.view = view;
        float radius = 0.5f;
        ballShape = new CircleShape(radius);
        ballImage = new BodyImage("data/bowl.png", 2*radius);
    }

    /**
     * Create a bowling ball at the current mouse position.
     * @param e event object containing the mouse position
     */
    public void mousePressed(MouseEvent e) {
        DynamicBody ball = new DynamicBody(view.getWorld(), ballShape);
        ball.setPosition(view.viewToWorld(e.getPoint()));
        ball.addImage(ballImage);
    }
}
