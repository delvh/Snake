package dev.lh;

import java.util.ArrayList;
import java.util.List;

public class Handler {
	
	List<Updateable> targets;
	
	public Handler() {
		targets = new ArrayList<>();
		targets.add(new Snake(3));
	}

}
