import java.util.Scanner;
import java.util.ArrayList;
public class Tecnicas
{
    public static void examinacion()
    {
        Scanner scan = new Scanner(System.in);
        if(Tarjeta.cantidadTarjetas()>0)
        {
            while(true)
            {
                System.out.println("¿Quieres estudiar un tema en específico? \n Ingrese general para estudiarlo todo o ingrese el tema que quiere estudiar específicamente");
                String tema = scan.next();
                if(tema.toUpperCase().equals("GENERAL"))
                {
                    System.out.println("Empezando sesión de estudio...");
                    int l = 0;
                    for(int i = 0 ; i < Tarjeta.tarjetas.size() ; i++)
                    {
                        System.out.println("1.");
                        String pregTarjeta = Tarjeta.tarjetas.get(i).getPregunta();
                        System.out.println(pregTarjeta);
                        System.out.println("Presiona cualquier valor para mostrar la respuesta, no ingreses nada y presiona enter para salir");
                        String value = scan.nextLine();
                        l++;
                        
                        if(l==1)
                        {
                            value = scan.nextLine();
                        }
                        if(value.isEmpty())
                        {
                            String respPregunta = Tarjeta.tarjetas.get(i).getRespuesta();
                            System.out.println(pregTarjeta);
                            System.out.println("¿Respondiste bien la pregunta? 1 para no, 2 para sí.");
                            int calificacion = scan.nextInt(); 
                            if(calificacion == 1)
                            {
                                Tarjeta.tarjetas.get(i).califPreg(false);
                            }
                            else if(calificacion == 2)
                            {
                                Tarjeta.tarjetas.get(i).califPreg(true);
                            }
                        }
                    }
                    System.out.println("¡Terminaste el mazo!");
                    System.out.println("Presiona 1 para salir, presiona 2 para volver a repasar");
                    int decision = scan.nextInt();
                    if(decision == 1)
                    {
                        break;
                    }

                    if(decision == 2)
                    {
                        continue;
                    }

                }
                else if(Tarjeta.verificarTema(tema))
                {
                    System.out.println("Empezando sesión de estudio...");
                    ArrayList<Tarjeta> tarjetasTematizadas = Tarjeta.tematizarTarjetas(tema);
                    int l = 0; 
                    for(int i = 0 ; i < tarjetasTematizadas.size() ; i++)
                    {
                        System.out.println("1.");
                        String pregTarjeta = tarjetasTematizadas.get(i).getPregunta();
                        System.out.println(pregTarjeta);
                        System.out.println("Ingresa cualquier valor para mostrar la respuesta, no ingrese nada y presione enter para salir");
                        String value = scan.nextLine();
                        l++;
                        
                        if(l==1)
                        {
                            value = scan.nextLine();
                        }
                        
                        if(value.toLowerCase().equals("exit"))
                        {
                            break;
                        }
                        String respPregunta = tarjetasTematizadas.get(i).getRespuesta();
                        System.out.println(pregTarjeta);
                        
                        System.out.println("¿Respondiste bien la pregunta? 1 para no, 2 para sí.");
                        int calificacion = scan.nextInt(); 
                        if(calificacion == 1)
                        {
                            Tarjeta.tarjetas.get(i).califPreg(false);
                        }
                        else if(calificacion == 2)
                        {
                            Tarjeta.tarjetas.get(i).califPreg(true);
                        }
                        
                    }
                    System.out.println("¡Terminaste el mazo!");
                }
                else
                {
                    System.out.println("¡Ese tema no existe entre tus mazos!");
                }
            }   
        }
        else
        {
            System.out.println("¡No tienes tarjetas de estudio! haz unas");
        }
    }
}
