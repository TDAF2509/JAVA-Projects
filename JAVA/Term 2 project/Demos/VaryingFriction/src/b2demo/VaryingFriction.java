/*
 * JBox2D - A Java Port of Erin Catto's Box2D
 *
 * JBox2D homepage: http://jbox2d.sourceforge.net/
 * Box2D homepage: http://www.box2d.org
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

public class VaryingFriction {

    public VaryingFriction() {
        World world = new World();

        {
            Body ground = new StaticBody(world, new BoxShape(100.0f, 20.0f));
            ground.setPosition(new Vec2(0.0f, -20.0f));
        }

        {
            Body ground = new StaticBody(world, new BoxShape(13.0f, 0.25f));
            ground.setPosition(new Vec2(-4.0f, 22.0f));
            ground.setAngle(-0.25f);
        }

        {
            Body ground = new StaticBody(world, new BoxShape(0.25f, 1.0f));
            ground.setPosition(new Vec2(10.5f, 19.0f));
        }

        {
            Body ground = new StaticBody(world, new BoxShape(13.0f, 0.25f));
            ground.setPosition(new Vec2(4.0f, 14.0f));
            ground.setAngle(0.25f);
        }

        {
            Body ground = new StaticBody(world, new BoxShape(0.25f, 1.0f));
            ground.setPosition(new Vec2(-10.5f, 11.0f));
        }

        {
            Body ground = new StaticBody(world, new BoxShape(13.0f, 0.25f));
            ground.setPosition(new Vec2(-4.0f, 6.0f));
            ground.setAngle(-0.25f);
        }

        {
            Shape shape = new BoxShape(0.5f, 0.5f);
            float density = 25.0f;

            float[] friction = {0.75f, 0.5f, 0.35f, 0.1f, 0.0f};

            for (int i = 0; i < 5; ++i) {
                DynamicBody box = new DynamicBody(world);
                box.setPosition(new Vec2(-15.0f + 4.0f * i, 28.0f));
                SolidFixture fixture = new SolidFixture(box, shape, density);
                fixture.setFriction(friction[i]);
            }
        }

        // make a view
        UserView view = new UserView(world, 500, 500);
        view.setCentre(new Vec2(0, 12));
        view.setZoom(10);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Varying Friction");

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
        new VaryingFriction();
    }

}
