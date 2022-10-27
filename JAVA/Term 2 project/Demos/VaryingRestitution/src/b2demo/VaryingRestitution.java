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

public class VaryingRestitution {

    public VaryingRestitution() {
        World world = new World();

        {
            Body ground = new StaticBody(world, new BoxShape(50.0f, 10.0f));
            ground.setPosition(new Vec2(0.0f, -10.0f));
        }

        {
            Shape shape = new CircleShape(0.6f);
            float density = 5.0f;

            float restitution[] = new float[] { 0.0f, 0.1f, 0.3f, 0.5f, 0.75f,
                    0.9f, 1.0f };

            for (int i = 0; i < restitution.length; ++i) {
                DynamicBody body = new DynamicBody(world);
                body.setPosition(new Vec2(-10.0f + 3.0f * i, 10.0f));
                SolidFixture fixture = new SolidFixture(body, shape, density);
                fixture.setRestitution(restitution[i]);
            }
        }

        // make a view
        UserView view = new UserView(world, 500, 500);
        view.setCentre(new Vec2(0, 5));

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Varying Restitution");

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
        new VaryingRestitution();
    }
}
