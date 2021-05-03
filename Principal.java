import java.util.Scanner;
//WIP
public class Principal
{
    public static void main(String[] args)
    {
        Principal.mostrarMenú();
    }

    public static void mostrarMenú()
    {
        while(true)
        {
            System.out.println("Ingrese 1 para empezar a estudiar.");
            System.out.println("Ingrese 2 para añadir preguntas.");
            System.out.println("Ingrese cualquier otro caracter para cerrar el programa.");
            Scanner scan = new Scanner(System.in);
            String decisionInicial = scan.next();
            if(decisionInicial.equals("1"))
            {
                Tecnicas.examinacion();
            }
            else if(decisionInicial.equals("2"))
            {
                int l = 0;
                while(true)
                {
                    System.out.println("Ingresa la pregunta de tu tarjeta, escribe exit para salir");
                    String pregunta = scan.nextLine();
                    l++;
                    if(l==1)
                    {
                        pregunta = scan.nextLine();
                    }
                    
                    while(true)
                    {
                        if(pregunta.isEmpty())
                        {
                            System.out.println("Ingrese una pregunta válida");
                            pregunta = scan.nextLine();
                        }
                        else
                        {
                            break;
                        }
                    }
                    
                    
                    if(pregunta.toLowerCase().equals("exit"))
                    {
                        break;
                    }

                    System.out.println("Ingresa la respuesta de la pregunta");
                    String respuesta = scan.nextLine();

                    while(true)
                    {
                        if(respuesta.isEmpty())
                        {
                            System.out.println("Ingrese una respuesta válida");
                            respuesta = scan.nextLine();
                        }
                        else
                        {
                            break;
                        }
                    }

                    System.out.println("Ingresa el tema de tu pregunta");
                    String tema = scan.nextLine();

                    while(true)
                    {
                        if(respuesta.isEmpty())
                        {
                            System.out.println("Ingrese un tema válido válida");
                            tema = scan.nextLine();
                        }
                        else
                        {
                            break;
                        }
                    }

                    Tarjeta temp = new Tarjeta(pregunta, respuesta, tema);
                }
            }
            else
            {
                break;
            }
        }
    }
}
