package practica;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal
{
	public static void main(String[] args)
	{
		int seleccion;
		String descripcion;
		System.out.println("Escriba como quiere que se llame su lista: ");
		Scanner teclado = new Scanner(System.in);
		String nombre = teclado.nextLine();
		ListaDeLaCompra lista = new ListaDeLaCompra(nombre);
		File archivo = new File(lista.getNombreLista() + ".txt");
		try
		{
			archivo.createNewFile();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			do 
			{
				System.out.println("¿Que quieres hacer ahora?");
				System.out.println("1. Agregar");
				System.out.println("2. Eliminar");
				System.out.println("3. Lista");
				System.out.println("4. Salir");
				seleccion = teclado.nextInt();
				teclado.nextLine();

				switch(seleccion)
				{
				case 1:
					System.out.println("¿Qué artículo quiere agregar?: ");
					descripcion = teclado.nextLine();
					System.out.println("Cantidad (Usa números): ");
					int cantidad = teclado.nextInt();
					teclado.nextLine();
					System.out.println("Unidad: ");
					String unidad = teclado.nextLine();
					ArticuloAComprar articulo = new ArticuloAComprar(descripcion, cantidad, unidad);
					lista.agregarArticulo(articulo);
					System.out.println("Artículo creado");
					break;

				case 2:
					System.out.println("¿Qué artículo quiere eliminar?");
					descripcion = teclado.nextLine();
					lista.eliminarArticulo(descripcion.toLowerCase());
					System.out.println("Artículo eliminado");
					break;

				case 3:
					System.out.println("Artículos en la lista:");
					List<ArticuloAComprar> comprobacion = lista.getArticulos();
					if(comprobacion.isEmpty())
					{
						System.out.println("No hay artículos en la lista");
					}
					else
					{
						for (ArticuloAComprar articuloLista : lista.getArticulos()) 
						{
								System.out.println(articuloLista.getCantidad() + " " + articuloLista.getUnidad() + " | " + articuloLista.getDescripcion());
						}
					}
					break;

				case 4:
					System.out.println("Saliendo del programa.");
					break;

				default:
					System.out.println("El número " + seleccion + " no corresponde a ninguna opción");
				}
			} while (seleccion != 4);
		}
		catch (InputMismatchException ime)
		{
			System.out.println("Error: solo se aceptan números");
		}
		teclado.close();
	}
}