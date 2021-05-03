import java.util.ArrayList;

public class Tarjeta
{
    public static ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
    
    private String pregunta;
    private String respuesta;
    private String tema;
    private int ultVezRespondida;
    private int racha;
    public static int posAñadir;

    public Tarjeta()
    {
    }
    
    public Tarjeta(String preg, String resp)
    {
        this(preg, resp, "General");
    }

    public Tarjeta(String preg, String resp, String tema)
    {
        Tarjeta tarjetaTemporal = new Tarjeta();
        tarjetaTemporal.setPregunta(preg);
        tarjetaTemporal.setRespuesta(resp);
        tarjetaTemporal.setTema(tema);
        
        Tarjeta.tarjetas.add(tarjetaTemporal);

        Tarjeta.posAñadir++;
    }

    public void califPreg(boolean calif)
    {
        if(calif==true)
        {
            this.racha = this.racha + 1;
        }
        else
        {
            this.racha = 0;
        }
    }

    public void setPregunta(String preg)
    {
        this.pregunta = preg;
    }

    public void setRespuesta(String resp)
    {
        this.respuesta = resp;
    }
    
    public void setTema(String tema)
    {
        this.tema = tema;
    }

    public String getPregunta()
    {
        return this.pregunta;
    }

    public String getRespuesta()
    {
        return this.respuesta;
    }
    
    public String getTema()
    {
        return this.tema;
    }
    
    public static int cantidadTarjetas()
    {
        return Tarjeta.posAñadir;
    }
    
    @Override
    public String toString()
    {
        return "Pregunta: " + this.getPregunta() + "\n" + "Respuesta: " + this.getRespuesta() + "\n" + "Tema: " + this.getTema() + "\n";
    }
    
    public static String mostrarTarjetas()
    {
        String informacionTarjetas = "Mostrando todas las tarjetas creadas:  \n ";
        
        for(int i = 0; i<tarjetas.size(); i++)
        {
            String tarEnume = (i + 1) + ". \n" + tarjetas.get(i).toString();
            informacionTarjetas = informacionTarjetas.concat(tarEnume);
        }
        
        return informacionTarjetas;
    }
    
    public static String mostrarTarjetasTema(String tem)
    {
        ArrayList<Tarjeta> tarjetasTema = new ArrayList<Tarjeta>();
        
        for(int i = 0; i<tarjetas.size(); i++)
        {
            if(tem.equals(Tarjeta.tarjetas.get(i).getTema()))
            {
                tarjetasTema.add(tarjetas.get(i));
            }
        }
        
        String informacionTarjetas = "Mostrando la información de las tarjetas de temática " + tem + ": \n";
        
        for(int i = 0; i<tarjetasTema.size(); i++)
        {
            String tarjetaEnumerada = (i + 1) + ". \n" + tarjetasTema.get(i).toString();
            informacionTarjetas = informacionTarjetas.concat(tarjetaEnumerada);
            
        }
        return informacionTarjetas;
    }
    
    public static boolean verificarTema(String tem)
    {
        for(int i = 0; i<Tarjeta.tarjetas.size(); i++)
        {
            if(tem.toUpperCase().equals(Tarjeta.tarjetas.get(i).getTema().toUpperCase()))
            {
                break;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    public static ArrayList<Tarjeta> tematizarTarjetas(String tem)
    {
        ArrayList<Tarjeta> tarjetasTema = new ArrayList<Tarjeta>();
        
        for(int i = 0; i<tarjetas.size(); i++)
        {
            if(tem.equals(Tarjeta.tarjetas.get(i).getTema()))
            {
                tarjetasTema.add(tarjetas.get(i));
            }
        }
        return tarjetasTema;
    }
}
