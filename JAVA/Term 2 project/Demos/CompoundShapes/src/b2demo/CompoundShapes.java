/*******************************************************************************
 * Copyright (c) 2013, Daniel Murphy
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
/**
 * Created at 1:13:43 AM Sep 3, 2010
 */
package b2demo;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

/**
 * @author Daniel Murphy
 */
public class CompoundShapes {
    public static final float PI = (float)Math.PI;

    private float randomFloat(float low, float high) {
        return low + (high - low)*(float)Math.random();
    }

    public CompoundShapes() {
        World world = new World();

        {
            Body ground = new StaticBody(world, new BoxShape(100.0f, 20.0f));
            ground.setPosition(new Vec2(0.0f, -20.0f));
        }

        {
            Shape circle1 = new CircleShape(0.5f, new Vec2(-0.5f, 0.5f));
            Shape circle2 = new CircleShape(0.5f, new Vec2(0.5f, 0.5f));

            for (int i = 0; i < 10; ++i) {
                float x = randomFloat(-0.1f, 0.1f);
                Body body = new DynamicBody(world);
                body.setPosition(new Vec2(x + 5.0f, 1.05f + 2.5f * i));
                body.setAngle(randomFloat(-PI, PI));
                new SolidFixture(body, circle1, 2.0f);
                new SolidFixture(body, circle2, 0.0f);
            }
        }

        {
            Shape box1 = new BoxShape(0.25f, 0.5f);
            Shape box2 = new BoxShape(0.25f, 0.5f, new Vec2(0.0f, -0.5f), 0.5f * PI);

            for (int i = 0; i < 10; ++i) {
                float x = randomFloat(-0.1f, 0.1f);
                Body body = new DynamicBody(world);
                body.setPosition(new Vec2(x - 5.0f, 1.05f + 2.5f * i));
                body.setAngle(randomFloat(-PI, PI));
                new SolidFixture(body, box1, 2.0f);
                new SolidFixture(body, box2, 2.0f);
            }
        }

        {
            float d = 1/((float)Math.sqrt(5)*2);
            Shape triangle1 = new PolygonShape(0,0, 0,-1, 4*d,3*d);
            Shape triangle2 = new PolygonShape(0,0, 0,-1, -4*d,3*d);

            for (int i = 0; i < 10; ++i) {
                float x = randomFloat(-0.1f, 0.1f);
                Body body = new DynamicBody(world);
                body.setPosition(new Vec2(x, 3.1f + 2.5f * i));
                new SolidFixture(body, triangle1, 2.0f);
                new SolidFixture(body, triangle2, 2.0f);
            }
        }

        {
            Shape bottom = new BoxShape(1.5f, 0.15f);
            Shape left = new BoxShape(0.15f, 2.7f, new Vec2(-1.45f, 2.35f), 0.2f);
            Shape right = new BoxShape(0.15f, 2.7f, new Vec2(1.45f, 2.35f), -0.2f);

            Body body = new DynamicBody(world);
            body.setPosition(new Vec2(0.0f, 2.0f));
            new SolidFixture(body, bottom, 4.0f);
            new SolidFixture(body, left, 4.0f);
            new SolidFixture(body, right, 4.0f);
        }

        // make a view
        UserView view = new UserView(world, 500, 500);
        view.setCentre(new Vec2(0, 12));
        view.setZoom(10);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Compound Shapes");

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
        new CompoundShapes();
    }

}
