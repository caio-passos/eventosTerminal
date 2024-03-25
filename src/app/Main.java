package app;


import eventoPackage.EventoDAOImpl;
import eventoPackage.EventoData;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = DatabaseUtil.getConnection();


        //EventoData eventoData = new EventoData();

        if (con != null) {
            System.out.println("DB conectado");
//        }


        Scanner inicio = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema de eventos \n 1- Eventos \n 2- Usuarios\n");
        int valorInicio = inicio.nextInt();

            switch (valorInicio) {
                case 1:
                    EventoDAOImpl eventoDAO = new EventoDAOImpl();
                    List<EventoData> eventos = eventoDAO.getAll();

                    if (eventos != null && !eventos.isEmpty()) {
                        System.out.println("Lista de Eventos:");
                        for (EventoData evento : eventos) {
                            System.out.println(evento);
                        }
                    } else {
                        System.out.println("Nenhum evento encontrado");
                    }

                    //bloco para opções dos eventos
                    int valoropEvento = 0;
                    Scanner opEventos = new Scanner(System.in);
                    System.out.println("Deseja modificar, cadastrar ou remover um evento?");
                    System.out.println("1- Cadastrar novo evento\n2- Modificar um evento" +
                            "\n3- Remover um evento\n4- Participar de um evento\n5-Eventos passados");
                    valoropEvento = opEventos.nextInt();

                    switch (valoropEvento) {
                        case 1:
                            //cadastrar novo evento: metodo insert
                        case 2:
                            //modificar evento: metodo update
                        case 3:
                            //remover: metodo delete
                        case 4:
                            //Criar atribuição entre usuário e um evento
                        case 5:
                            //mostrar eventos passados
                            break;
                    }
                    //definir para eventos

                case 2:
                    //definir para Usuarios
                    int valoruser = 0;
                    Scanner opUsuarios = new Scanner(System.in);
                    System.out.println("Deseja modificar, cadastrar ou remover um usuário?");
                    System.out.println("1- Cadastrar novo usuário\n2- Remover um usuário");
                    valoruser = opUsuarios.nextInt();
                    switch (valoruser) {
                        case 1:
                            //cadastrar novos usuários
                        case 2:
                            //Remover um usuário (pelo nome)
                            break;
                    }
                default:
                    System.out.println("Opção invalida");
            }
            inicio.close();
        //consultar eventos cadastrados
            //decidir participar de eventos cadastrados
//        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//
            //EventosDAO eventosDAO = new EventoDAOImpl();

            //EventoData eventoData = eventosDAO.get(1)

            /* Delete
            EventosDAO eventosDAO = new EventoDAOImpl();

            EventoData eventoData = eventosDAO.get(4); //id no banco

            System.out.println(eventoData);

            int result = eventosDAO.delete(eventoData);

            System.out.println(result);
            */
//            //passando como LocalDateTime para inserir o horário do evento
//            LocalDateTime horarioEvento = LocalDateTime.of(2024,3,20,22,00,00);
//            EventoData eventoData = new EventoData(0, 2, "Arrocha concha", "show", "show de arrocha",
//                     "Um show na concha acustica para várias pessoas", "produção@produção", "7199999999", horarioEvento);
//            EventosDAO eventosDAO = new EventoDAOImpl();
//            try{
//
//                int result = eventosDAO.insert(eventoData);
//                System.out.println(result);
//            } catch(SQLException e){
//                System.out.println("Erro ao inserir evento: " + e.getMessage());
//            }
//            EventosDAO eventosDAO = new EventoDAOImpl ();
//            EventoData eventoData = new EventoData();


            /* getAll
            List<EventoData> eventosData;

            EventosDAO eventosDAO = new EventoDAOImpl();

            eventosData = eventosDAO.getAll();

          for (EventoData eventoData : eventosData){
              System.out.println(eventoData);
          }

             */
        }
    }
}