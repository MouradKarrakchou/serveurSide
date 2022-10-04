import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvManager {
    String csvPath;

    public CsvManager(String csvPath) {
        this.csvPath = csvPath;
    }

    /**
     * Create and return a client list from the csv file
      * @return a client list
     * @throws IOException
     */
    public ArrayList<Client> getClientList() throws IOException {
        ArrayList<Client> clientList = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(csvPath));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if(!data[0].equals("mail")){
                clientList.add(new Client(data[0], data[1]));
            }
        }
        csvReader.close();
        return clientList;
    }

    /**
     * Add a client to the csv file
     * @param client
     * @throws IOException
     */
    public void addClient(Client client) throws IOException {
        FileWriter csvWriter = new FileWriter(csvPath, true);
        csvWriter.append(client.getMail()+","+client.getPwd());
        csvWriter.append("\n");
        csvWriter.close();
    }

}

