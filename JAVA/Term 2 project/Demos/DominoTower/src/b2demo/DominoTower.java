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
 * Created at 8:41:50 PM Jan 23, 2011
 */
package b2demo;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

/**
 * @author Daniel Murphy
 */
public class DominoTower {
    static final float dwidth = .20f;
    static final float dheight = 1.0f;
    static float ddensity;// = 10f;
    static final float dfriction = 0.1f;
    static int baseCount = 25;
    static final Shape dominoShape = new BoxShape(.5f * dwidth, .5f * dheight);

    public static void makeDomino(float x, float y, boolean horizontal, World world) {
        DynamicBody body = new DynamicBody(world);
        body.setPosition(new Vec2(x, y));
        body.setAngle(horizontal ? (float) (Math.PI / 2.0) : 0f);
        SolidFixture fixture = new SolidFixture(body, dominoShape, ddensity);
        fixture.setFriction(dfriction);
        fixture.setRestitution(0.65f);
    }

    public DominoTower() {
        World world = new World();

        { // Floor
            Shape sd = new BoxShape(50.0f, 10.0f);
            Body bd = new StaticBody(world, sd);
            bd.setPosition(new Vec2(0.0f, -10.0f));
        }

        {
            ddensity = 10f;
            // Make bullet
            Shape sd = new BoxShape(.7f, .7f);

            {
                DynamicBody b = new DynamicBody(world);
                b.setPosition(new Vec2(30f, 50f));
                b.setLinearVelocity(new Vec2(-25f, -25f));
                b.setAngularVelocity(6.7f);
                b.setBullet(true);
                SolidFixture fixture = new SolidFixture(b, sd, 35f);
                fixture.setFriction(0);
                fixture.setRestitution(0.85f);
            }

            {
                DynamicBody b = new DynamicBody(world);
                b.setPosition(new Vec2(-30, 25));
                b.setLinearVelocity(new Vec2(35, -10));
                b.setAngularVelocity(-8.3f);
                b.setBullet(true);
                SolidFixture fixture = new SolidFixture(b, sd, 25f);
                fixture.setFriction(0);
                fixture.setRestitution(0.85f);
            }
        }

        {
            float currX;
            // Make base
            for (int i = 0; i < baseCount; ++i) {
                currX = i * 1.5f * dheight - (1.5f * dheight * baseCount / 2f);
                makeDomino(currX, dheight / 2.0f, false, world);
                makeDomino(currX, dheight + dwidth / 2.0f, true, world);
            }
            currX = baseCount * 1.5f * dheight - (1.5f * dheight * baseCount / 2f);
            // Make 'I's
            for (int j = 1; j < baseCount; ++j) {
                if (j > 3)
                    ddensity *= .8f;
                float currY = dheight * .5f + (dheight + 2f * dwidth) * .99f * j; // y at center of 'I'
                                                                                                                                                    // structure

                for (int i = 0; i < baseCount - j; ++i) {
                    currX = i * 1.5f * dheight - (1.5f * dheight * (baseCount - j) / 2f);// +
                                                                                                                                                             // parent.random(-.05f,
                                                                                                                                                             // .05f);
                    ddensity *= 2.5f;
                    if (i == 0) {
                        makeDomino(currX - (1.25f * dheight) + .5f * dwidth, currY - dwidth, false, world);
                    }
                    if (i == baseCount - j - 1) {
                        // if (j != 1) //djm: why is this here? it makes it off balance
                        makeDomino(currX + (1.25f * dheight) - .5f * dwidth, currY - dwidth, false, world);
                    }
                    ddensity /= 2.5f;
                    makeDomino(currX, currY, false, world);
                    makeDomino(currX, currY + .5f * (dwidth + dheight), true, world);
                    makeDomino(currX, currY - .5f * (dwidth + dheight), true, world);
                }
            }
        }

        // make a view
        UserView view = new UserView(world, 500, 500);
        view.setCentre(new Vec2(0, 12));
        view.setZoom(8);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Domino Tower");

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
        new DominoTower();
    }

}
