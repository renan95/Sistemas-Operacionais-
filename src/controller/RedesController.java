package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedesController {
    
    private String os() {
        return System.getProperty("os.name");
    }
    
    public void ip() {
        String command = "";
        if (os().contains("Windows")) {
            command = "ipconfig";
        } else if (os().contains("Linux")) {
            command = "ifconfig";
        } else {
            System.out.println("Sistema operacional não suportado.");
            return;
        }
        
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("IPv4")) {
                    String[] parts = line.split(":");
                    System.out.println(parts[0].trim() + ": " + parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void ping() {
        String command = "";
        if (os().contains("Windows")) {
            command = "ping -4 -n 10 www.google.com.br";
        } else if (os().contains("Linux")) {
            command = "ping -4 -c 10 www.google.com.br";
        } else {
            System.out.println("Sistema operacional não suportado.");
            return;
        }
        
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Média")) {
                    String[] parts = line.split("=");
                    System.out.println("Tempo médio: " + parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
