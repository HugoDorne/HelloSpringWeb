package com.github.hugodorne.enumeration;

/**
 * The enum Sexe.
 */
public enum Sexe {
	HOMME("H"),
	FEMME("F");

	private final String label;

	Sexe(String label) {
		this.label = label;
	}

	/**
	 * Gets label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
}
