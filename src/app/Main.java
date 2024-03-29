package app;

import eventoPackage.EventoDAOImpl;
import eventoPackage.EventoData;
import eventoPackage.EventosDAO;
import usuarioPackage.UsuarioDAO;
import usuarioPackage.UsuarioDAOImpl;
import usuarioPackage.UsuarioData;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static util.EventoUtil.listarEventos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = DatabaseUtil.getConnection();
        EventoDAOImpl eventoDAO = new EventoDAOImpl();
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        //EventoData eventoData = new EventoData();

        if (con != null) {
            System.out.println("DB conectado");
//        }
            Scanner inicio = new Scanner(System.in);
            System.out.println("Bem vindo ao sistema de eventos \n 1- Eventos \n 2- Usuarios\n");
            int valorInicio = inicio.nextInt();

            switch (valorInicio) {
                case 1:
                    listarEventos();
                    //bloco para opções dos eventos
                    int valoropEvento;
                    Scanner opEventos = new Scanner(System.in);
                    System.out.println("Deseja modificar, cadastrar ou remover um evento?");
                    System.out.println("""
                            1- Cadastrar novo evento
                            2- Modificar um evento
                            3- Remover um evento
                            4- Participar de um evento
                            5- Verificar participantes do evento
                            6- Eventos passados""");
                    valoropEvento = opEventos.nextInt();

                    //bloco eventos
                    switch (valoropEvento) {
                        case 1:
                            //bloco cadastrar novo evento
                            //tipos de Scanner para o insert
                            //nextLine() para Strings, nextInt() para inteiros
                            Scanner eventoInsert = new Scanner(System.in);
                            System.out.println("Digite o nome do evento:\n");
                            String nomeEvento = eventoInsert.nextLine();

                            System.out.println("Digite o local do evento:\n");
                            String localEvento = eventoInsert.nextLine();

                            System.out.println("Digite a categoria do evento:\n");
                            String categoriaEvento = eventoInsert.nextLine();

                            System.out.println("Digite a descrição do evento:\n");
                            String descricaoEvento = eventoInsert.nextLine();

                            System.out.println("Digite o e-mail da produção do evento:\n");
                            String emailProducao = eventoInsert.nextLine();

                            System.out.println("Digite o telefone da produção do evento:\n");
                            String telefoneProducao = eventoInsert.nextLine();

                            //verificação de data
                            // Formato para a data

                            String dataString, horarioString;
                            LocalDateTime dataHora = null;
                            boolean entradaCorreta = false;

                            while (!entradaCorreta) {
                                System.out.println("Digite a data do evento em dd-MM-yyyy:");
                                dataString = eventoInsert.nextLine();
                                System.out.println("Digite o horário do evento em HH:mm:");
                                horarioString = eventoInsert.nextLine();

                                try {
                                    // Separar a data em dia, mês e ano
                                    String[] dataSplit = dataString.split("-");
                                    int dia = Integer.parseInt(dataSplit[0]);
                                    int mes = Integer.parseInt(dataSplit[1]);
                                    int ano = Integer.parseInt(dataSplit[2]);

                                    // Separar o horário em horas e minutos
                                    String[] horarioSplit = horarioString.split(":");
                                    int hora = Integer.parseInt(horarioSplit[0]);
                                    int minuto = Integer.parseInt(horarioSplit[1]);

                                    // Criar o LocalDateTime usando os valores separados
                                    dataHora = LocalDateTime.of(ano, mes, dia, hora, minuto);
                                    entradaCorreta = true;
                                } catch (Exception e) {
                                    System.out.println("Formato de data ou hora inválido. Use o formato dd-MM-yyyy para a data e HH:mm para o horário.");
                                }
                            }
                            eventoInsert.close();
                            //definindo uma string primeiro para que o parser possa converter em DateTime para o banco
                            //id inicial do usuário será 0 para novos eventos.


                            int idUsuario = 0;
                            EventoData eventoData = new EventoData(nomeEvento, localEvento, categoriaEvento,
                                    descricaoEvento, emailProducao, telefoneProducao, dataHora, idUsuario);
                            idUsuario = eventoData.getIdUsuario();
                            EventoData eventoDataFix = new EventoData(nomeEvento, localEvento, categoriaEvento,
                                    descricaoEvento, emailProducao, telefoneProducao, dataHora, idUsuario);
                            eventoDAO.insert(eventoDataFix);

                            //cadastrar novo evento: metodo insert
                            return;
                        case 2:
                            //UPDATE UPDATE UPDATE
                            //modificar evento: metodo update
                            //primeiro printa todos os eventos,
                            listarEventos();
                            System.out.println("Digite qual evento gostaria de alterar:\n");
                            Scanner updateEvento = new Scanner(System.in);
                            int idEvento = updateEvento.nextInt();
                            updateEvento.nextLine();

                            System.out.println("Digite o novo nome do evento:");
                            String nomeNovo = updateEvento.nextLine();

                            System.out.println("Digite o novo local do evento:");
                            String localNovo = updateEvento.nextLine();

                            System.out.println("Digite a nova categoria do evento:");
                            String categoriaNova = updateEvento.nextLine();

                            System.out.println("Digite a nova descrição do evento:");
                            String descricaoNova = updateEvento.nextLine();

                            System.out.println("Digite o novo email de produção:");
                            String emailNovo = updateEvento.nextLine();

                            System.out.println("Digite o novo telefone de produção:");
                            String telefoneNovo = updateEvento.nextLine();

                            String UpdateDataString, UpdateHorarioString;
                            LocalDateTime horarioEvento = null;
                            Boolean entradaUpdateCorreta = false;
                            while (!entradaUpdateCorreta) {

                                System.out.println("Digite a data do evento em dd-MM-yyyy:");
                                UpdateHorarioString = updateEvento.nextLine();
                                System.out.println("Digite o horário do evento em HH:mm:");
                                UpdateDataString = updateEvento.nextLine();
                                try {
                                    // Separar a data em dia, mês e ano
                                    String[] dataSplit = UpdateDataString.split("-");
                                    int dia = Integer.parseInt(dataSplit[0]);
                                    int mes = Integer.parseInt(dataSplit[1]);
                                    int ano = Integer.parseInt(dataSplit[2]);

                                    // Separar o horário em horas e minutos
                                    String[] horarioSplit = UpdateHorarioString.split(":");
                                    int hora = Integer.parseInt(horarioSplit[0]);
                                    int minuto = Integer.parseInt(horarioSplit[1]);

                                    // Criar o LocalDateTime usando os valores separados
                                    horarioEvento = LocalDateTime.of(ano, mes, dia, hora, minuto);
                                    entradaUpdateCorreta = true;
                                } catch (Exception e) {
                                    System.out.println("Formato de data ou hora inválido. Use o formato dd-MM-yyyy para a data e HH:mm para o horário.");
                                }
                            }
                            int idUsuario1 = 0;

                            EventoData eventoDataAntigo = new EventoData(nomeNovo, localNovo, categoriaNova, descricaoNova, emailNovo, telefoneNovo, horarioEvento, idUsuario1);
                            int idUsuarioUpdate = eventoDataAntigo.getIdUsuario();
                            EventoData eventoDataUpdate = new EventoData(nomeNovo, localNovo, categoriaNova, descricaoNova, emailNovo, telefoneNovo, horarioEvento, idUsuarioUpdate);
                            eventoDAO.update(eventoDataUpdate);
                            System.out.println("Informações do evento atualizadas: \n" + eventoDataUpdate);
                            break;
                        case 3:
                            //remover: metodo delete

                            String descricaoEventoDel = "";
                            String categoriaEventoDel = "";
                            String localEventoDel = "";
                            String emailProducaoDel = "";
                            String telefoneProducaoDel = "";
                            LocalDateTime horarioEventoDel = LocalDateTime.of(2000, 1, 1, 0, 0);
                            horarioEventoDel.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                            System.out.println("Digite o nome do evento que gostaria de remover:\n");
                            Scanner scannerDelEvento = new Scanner(System.in);
                            String nomeEventoDeletado = scannerDelEvento.nextLine();
                            int idUsuarioDel = 0;
                            EventoData eventoDataDelete = new EventoData(nomeEventoDeletado, localEventoDel, categoriaEventoDel, descricaoEventoDel,
                                    emailProducaoDel, telefoneProducaoDel, horarioEventoDel, idUsuarioDel);
                            eventoDAO.delete(eventoDataDelete);
                            break;
                        case 4:
                            //Criar atribuição entre usuário e um evento
                            listarEventos();
                            System.out.println("Qual id de usuario deseja atribuir a um Evento?\n");
                            Scanner inputIdUser = new Scanner(System.in);
                            int idPass = inputIdUser.nextInt();
                            System.out.println("Qual o nome do  Evento que deseja atribuir esse usuario?: \n");
                            Scanner nomeEventoAtribui = new Scanner(System.in);
                            String nomeEventoPass = nomeEventoAtribui.nextLine();

                            usuarioDAO.atribuiUsuario(idPass, nomeEventoPass);
                            break;
                        case 5:
                            // listar usuário confirmado em evento
                            listarEventos();
                            System.out.println("Digite o id do participante para verificar se este\n " +
                                    "está confirmado em algum evento");
                            Scanner idConfirmadoEvento = new Scanner(System.in);
                            int idPassConfirmado = idConfirmadoEvento.nextInt();

                            List<UsuarioData.ConfirmadoInfo> confirmados = usuarioDAO.userConfirmado(idPassConfirmado);
                            if (!confirmados.isEmpty()) {
                                System.out.println("Esse usuário foi confirmado para esse evento");

                            } else {
                                System.out.println("Esse usuário não foi confirmado.");
                            }
                            idConfirmadoEvento.close();

                            break;
                        case 6:
                            //mostrar eventos passados
                            System.out.println("Aqui estão eventos passados");
                            eventoDAO.eventosPassados();
                            break;
                    }
                    break;
                //fim bloco cadastrar novo evento
                //definir para Usuarios
                case 2:
                    int valoruser;
                    Scanner opUsuarios = new Scanner(System.in);
                    System.out.println("Deseja modificar, cadastrar ou remover um usuário?");
                    System.out.println("1- Cadastrar novo usuário\n2- Remover um usuário");
                    valoruser = opUsuarios.nextInt();


                    switch (valoruser) {
                        case 1:
                            //cadastrar novos usuários
                            usuarioDAO = new UsuarioDAOImpl();
                            UsuarioData usuarioData = new UsuarioData();
                            usuarioDAO.insert(usuarioData);

                            break;
                        case 2:
                            //Remover um usuário (pelo nome)
                            String allUsers = usuarioDAO.toString();
                            System.out.println(allUsers + "\n");
                            System.out.println("Digite o nome do usuario a ser removido");
                            Scanner removeUser = new Scanner(System.in);
                            String removeUserPass = removeUser.nextLine();
                            usuarioDAO.delete(removeUserPass);
                            break;
                    }
                default:
                    System.out.println("Opção invalida");
            }
            inicio.close();
        }
    }
}
