package dev.lh;

import java.util.ArrayList;
import java.util.List;

/**
 * The handler handles incoming events in Snake.<br>
 * <br>
 * Project: <strong>Snake</strong><br>
 * File: <strong>Handler.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake 1.0
 */
public class Handler {

	List<Updateable> targets;

	/**
	 * Constructs a new {@link Handler}.
	 *
	 * @since Snake 1.0
	 */
	public Handler() {
		targets = new ArrayList<>();
		targets.add(new Snake(3));
	}

}
