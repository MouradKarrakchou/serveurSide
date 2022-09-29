import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvManager {
    String csvPath;

    public CsvManager(String csvPath) {
        this.csvPath = csvPath;
    }

    //il faut vérifier que en position 0 de la liste on ai bien un client et pas mail,pwd
    public List<Client> getClientList() throws IOException {
        ArrayList<Client> clientList = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(csvPath));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            clientList.add(new Client(data[0], data[1]));
        }
        csvReader.close();
        return clientList;
    }

    public void addClient(Client client) throws IOException {
        FileWriter csvWriter = new FileWriter(csvPath);
        csvWriter.append(client.getMail()+","+client.getPwd());
        csvWriter.append("\n");
    }

}

