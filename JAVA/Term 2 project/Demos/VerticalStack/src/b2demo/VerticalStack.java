/*******************************************************************************
 * Copyright (c) 2013, Daniel Murphy
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 	* Redistributions of source code must retain the above copyright notice,
 * 	  this list of conditions and the following disclaimer.
 * 	* Redistributions in binary form must reproduce the above copyright notice,
 * 	  this list of conditions and the following disclaimer in the documentation
 * 	  and/or other materials provided with the distribution.
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
 * Created at 4:56:29 AM Jan 14, 2011
 */
package b2demo;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

/**
 * @author Daniel Murphy
 */
public class VerticalStack {
    public static final int e_columnCount = 5;
    public static final int e_rowCount = 15;

    Body bullet;

    public VerticalStack() {
        World world = new World();

        {
            Body ground = new StaticBody(world, new BoxShape(100.0f, 20.0f));
            ground.setPosition(new Vec2(0.0f, -20.0f));

            new SolidFixture(ground, new BoxShape(1.0f, 10.0f, new Vec2(21.0f, 10.0f)));
        }

        float xs[] = new float[] { 0.0f, -10.0f, -5.0f, 5.0f, 10.0f };

        Shape shape = new BoxShape(0.5f, 0.5f);
        for (int j = 0; j < e_columnCount; ++j) {

            float density = 1.0f;
            float friction = 0.3f;

            for (int i = 0; i < e_rowCount; ++i) {
                int n = j * e_rowCount + i;
                assert (n < e_rowCount * e_columnCount);

                Body body = new DynamicBody(world);
                body.setPosition(new Vec2(xs[j], 0.752f + 1.54f * i));
                SolidFixture fixture = new SolidFixture(body, shape, density);
                fixture.setFriction(0.3f);
            }
        }

        bullet = null;

        // make a view
        UserView view = new UserView(world, 500, 500);
        view.setCentre(new Vec2(0, 10));
        view.setZoom(10);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Vertical Stack");

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

/*
    @Override
    public void keyPressed(char argKeyChar, int argKeyCode) {
        switch (argKeyChar) {
        case ',':
            if (bullet != null) {
                getWorld().destroyBody(bullet);
                bullet = null;
            }

            {
                CircleShape shape = new CircleShape();
                shape.m_radius = 0.25f;

                FixtureDef fd = new FixtureDef();
                fd.shape = shape;
                fd.density = 20.0f;
                fd.restitution = 0.05f;

                BodyDef bd = new BodyDef();
                bd.type = BodyType.DYNAMIC;
                bd.bullet = true;
                bd.position.set(-31.0f, 5.0f);

                bullet = getWorld().createBody(bd);
                bullet.createFixture(fd);

                bullet.setLinearVelocity(new Vec2(400.0f, 0.0f));
            }
            break;
        }
    }
*/

    /** Run the demo. */
    public static void main(String[] args) {
        new VerticalStack();
    }

}
