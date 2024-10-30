package practica;

public class ArticuloAComprar
{
	String descripcion;
	int cantidad;
	String unidad;
	
	public ArticuloAComprar()
	{
		descripcion = "";
		cantidad = 0;
		unidad = "";
	}

	public ArticuloAComprar(String descripcion, int cantidad, String unidad)
	{
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public int getCantidad()
	{
		return cantidad;
	}

	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}

	public String getUnidad()
	{
		return unidad;
	}

	public void setUnidad(String unidad)
	{
		this.unidad = unidad;
	}
}
