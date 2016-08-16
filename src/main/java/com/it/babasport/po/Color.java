package com.it.babasport.po;

public class Color {
	private int colorId;
	private String colorName;
	public int getColorId() {
		return colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (colorId != other.colorId)
			return false;
		return true;
	}
	
	
}
