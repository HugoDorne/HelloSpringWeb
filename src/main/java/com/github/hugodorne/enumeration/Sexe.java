package com.github.hugodorne.enumeration;

public enum Sexe {
	HOMME("H"),
	FEMME("F");

	private String label;

	Sexe(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
