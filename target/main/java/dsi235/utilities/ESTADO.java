package dsi235.utilities;

public enum ESTADO {

creado(0),asignado(1),pausado(2),reabierto(3),completado(4);

	public final int value;
	
private ESTADO(int value) {
	this.value=value;
}	
	
}
