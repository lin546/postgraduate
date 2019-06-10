package model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public abstract String toString();
}
