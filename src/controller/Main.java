package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
    
    public static void main(String[] args) {
        RedesController redes = new RedesController();
        
        String[] options = { "IP", "Ping", "Sair" };
        
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Redes", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            
            switch (choice) {
                case 0:
                    redes.ip();
                    break;
                case 1:
                    redes.ping();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }

}
