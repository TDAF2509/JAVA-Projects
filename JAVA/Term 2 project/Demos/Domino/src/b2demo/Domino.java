/*
 * JBox2D - A Java Port of Erin Catto's Box2D
 *
 * JBox2D homepage: http://jbox2d.sourceforge.net/
 * Box2D homepage: http://www.gphysics.com
 *
 * This software is provided 'as-is', without any express or implied
 * warranty.  In no event will the authors be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you must not
 * claim that you wrote the original software. If you use this software
 * in a product, an acknowledgment in the product documentation would be
 * appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be
 * misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */
package b2demo;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

public class Domino {

    public Domino() {
        World world = new World();

        { // Floor
            Body floor = new StaticBody(world, new BoxShape(50.0f, 10.0f));
            floor.setPosition(new Vec2(0.0f, -10.0f));
        }

        { // Platforms
            Shape shape = new BoxShape(15.0f, 0.125f);
            for (int i = 0; i < 4; i++) {
                Body platform = new StaticBody(world, shape);
                platform.setPosition(new Vec2(0.0f, 5f + 5f * i));
            }
        }

        { // Dominoes
            Shape shape = new BoxShape(0.125f, 2f);

            float density = 25.0f;
            float friction = .5f;
            int numPerRow = 25;

            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < numPerRow; j++) {
                    DynamicBody domino = new DynamicBody(world);
                    SolidFixture fixture = new SolidFixture(domino, shape, density);
                    fixture.setFriction(friction);
                    float x = -14.75f + j * (29.5f / (numPerRow - 1));
                    float y = 7.3f + 5f * i;
                    float angle = 0;
                    if (i == 2 && j == 0) {
                        angle = -0.1f;
                        x += .1f;
                    } else if (i == 3 && j == numPerRow - 1) {
                        angle = .1f;
                        x -= .1f;
                    }
                    domino.setPosition(new Vec2(x, y));
                    domino.setAngle(angle);
                }
            }
        }

        // make a view
        UserView view = new UserView(world, 500, 500);
        view.setCentre(new Vec2(0, 12));
        view.setZoom(10);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Domino Test");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    /** Run the demo. */
    public static void main(String[] args) {
        new Domino();
    }
}
