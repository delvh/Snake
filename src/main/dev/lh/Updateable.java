package dev.lh;

import java.awt.Graphics2D;

/**
 * This interface contains everything that needs to be updated regularly.
 * <p>
 * Project: <strong>Snake</strong><br>
 * File: <strong>Updateable.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake 1.0
 */
public interface Updateable {

	/**
	 * Here should the actions be implemented that are supposed to happen when a new
	 * frame gets created.
	 *
	 * @since Snake 1.0
	 */
	void nextFrame();

	/**
	 * Renders the object.
	 *
	 * @param g the graphics object that is used to render this object
	 * @since Snake 1.0
	 */
	void render(Graphics2D g);
}
