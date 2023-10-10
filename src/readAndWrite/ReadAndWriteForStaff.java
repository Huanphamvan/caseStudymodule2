package readAndWrite;

import model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteForStaff {
    private File file = new File("staff.txt");
    public void writeFile (List<Staff> list){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Staff staff:list) {
               line += staff.getData() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Staff> readFile(){
        List<Staff>list= new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine())!= null){
                String [] data = line.split(",");
                Staff staff= new Staff(Integer.parseInt(data[0]),data[1],data[2],Boolean.parseBoolean(data[3]),data[4]);
                list.add(staff);

            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        return list;
    }


}
