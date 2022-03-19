package com.github.hugodorne.enumeration;

/**
 * The enum Disponibilite.
 */
public enum Disponibilite {
	DISPONIBLE("Disponible"),
	INDISPONIBLE("Indisponible");

	private final String label;

	Disponibilite(String label) {
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
