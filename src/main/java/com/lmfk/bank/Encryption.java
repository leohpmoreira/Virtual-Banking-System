package com.lmfk.bank;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encryption {

    public static void loadUsers() {
        String[] dados;
        String username, password, type, manager;
        File arquivo = new File("users.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            BufferedReader dataR = new BufferedReader(new FileReader(arquivo));
            while (dataR.ready()) {
                String s = new String(Base64.getDecoder().decode(dataR.readLine()));
                dados = s.split("-");
                switch (dados[2]) {
                    case "Gerente" -> Main.users.add(new Manager(dados[0], dados[1], dados[2], dados[3]));
                    case "Cliente" -> Main.users.add(new Customer(dados[0], dados[1], dados[2], dados[3]));
                }
            }
            dataR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void storeUsers(User user) {
        File file = new File("users.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            String string = user.getName() + "-" + user.getPassword() + "-" + user.getType() + "-" + user.getManager();
            String base64 = Base64.getEncoder().encodeToString(string.getBytes());
            writer.write(base64);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
