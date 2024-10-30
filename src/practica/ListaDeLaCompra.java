package practica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListaDeLaCompra
{
	String nombreLista;
	
	public ListaDeLaCompra()
	{
		nombreLista = "";
	}

	public ListaDeLaCompra(String nombreLista)
	{
		this.nombreLista = nombreLista;
	}

	public String getNombreLista()
	{
		return nombreLista;
	}

	public void setNombreLista(String nombreLista)
	{
		this.nombreLista = nombreLista;
	}
	
	public void agregarArticulo(ArticuloAComprar articulo)
	{
		try
		{
			FileWriter fw = new FileWriter(nombreLista + ".txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(articulo.getCantidad() + "|" + articulo.getUnidad() + "|" + articulo.getDescripcion());
			pw.close();
			bw.close();
			fw.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void eliminarArticulo(String descripcionArticulo)
	{
		List<String> articulos = new ArrayList<>();
        try 
        {
        	FileReader fr = new FileReader(nombreLista + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) 
            {
                if (!linea.toLowerCase().contains(descripcionArticulo)) 
                {
                    articulos.add(linea);
                } 
            }
            br.close();
            fr.close();
            
            FileWriter fw = new FileWriter(nombreLista + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (String articulo : articulos) 
            {
                pw.println(articulo);
            }
            pw.close();
            bw.close();
            fw.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
	
	public List<ArticuloAComprar> getArticulos()
	{
		List<ArticuloAComprar> listaArticulos = new ArrayList<>();
	    try 
	    {
	        FileReader fr = new FileReader(nombreLista + ".txt");
	        BufferedReader br = new BufferedReader(fr);
	        String linea;
	        
	        while ((linea = br.readLine()) != null) 
	        {
	            String[] partes = linea.split("\\|");
	            if (partes.length == 3) 
	            {
	                int cantidad = Integer.parseInt(partes[0]);
	                String unidad = partes[1];
	                String descripcion = partes[2];
	                ArticuloAComprar articuloLista = new ArticuloAComprar(descripcion, cantidad, unidad);
	                listaArticulos.add(articuloLista);
	            }
	        }
	        br.close();
	        fr.close();
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    } 
	    catch (NumberFormatException e) 
	    {
	        System.out.println("Error de formato en el archivo de texto.");
	    }
	    return listaArticulos;
	}
}