package dev.lh;

import java.awt.Graphics;

/**
 * This interface contains everything that needs to updated regularly.<br>
 * <br>
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
	 * @param g the {@link Graphics} object that is used to render this object
	 * @since Snake 1.0
	 */
	void render(Graphics g);

}
