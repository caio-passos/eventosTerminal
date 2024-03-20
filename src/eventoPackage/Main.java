package eventoPackage;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        EventoData eventoData = new EventoData(1, "showtop", "casashow", "show", "showdemusica", "showcomartistas",  1010, 1123);
//
//        System.out.println(eventoData);

        Connection con = Database.getConnection();

        if (con != null){
            System.out.println("DB conectado");
        }
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.

    }
}