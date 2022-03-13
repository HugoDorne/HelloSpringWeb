package com.github.hugodorne.enumeration;

public enum Disponibilite {
	DISPONIBLE("Disponible"),
	INDISPONIBLE("Indisponible");

	private String label;

	Disponibilite(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
