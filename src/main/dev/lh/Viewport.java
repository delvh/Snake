package dev.lh;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Implements a hardware-accelerated rendering loop.
 * <p>
 * Project: <strong>Snake</strong><br>
 * File: <strong>Viewport.java</strong><br>
 * Created: <strong>01.07.2020</strong><br>
 * 
 * @author Kai S. K. Engelbart
 * @since Snake 1.0
 */
public class Viewport extends Canvas {

	private static final long serialVersionUID = 1L;

	// Enable OpenGL hardware acceleration
	static {
		System.setProperty("sun.java2d.trace", "timestamp,log,count");
		System.setProperty("sun.java2d.transaccel", "True");
		System.setProperty("sun.java2d.opengl", "True");
	}

	private Updateable gameRoot;
	private Timer timer = new Timer();
	private TimerTask renderTask;

	/**
	 * @param gameRoot the game object responsible for updating the rest
	 * @since Snake 1.0
	 */
	public Viewport(Updateable gameRoot) {
		this.gameRoot = gameRoot;
		setIgnoreRepaint(true);
	}

	/**
	 * Starts the render task.
	 * 
	 * @since Snake 1.1
	 */
	public void start() {
		if (renderTask != null)
			renderTask.cancel();
		else
			createBufferStrategy(2);

		renderTask = new TimerTask() {

			private long lastTime = System.currentTimeMillis();

			@Override
			public void run() {
				long time = System.currentTimeMillis();
				double dt = (time - lastTime) * 1E-3;
				lastTime = time;
				// TODO: Delta time adjustment
				gameRoot.tick();
				render();
			}
		};

		timer.schedule(renderTask, 0, 100);
	}

	/**
	 * Stops the render task.
	 * 
	 * @since Snake 1.1
	 */
	public void stop() {
		renderTask.cancel();
	}

	private void render() {
		Graphics2D g = (Graphics2D) getBufferStrategy().getDrawGraphics();

		// Clear the screen
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		// Perform the actual rendering
		gameRoot.render(g);

		// Flip buffers
		g.dispose();
		getBufferStrategy().show();

		// Synchronize with display refresh rate
		getToolkit().sync();
	}
}
