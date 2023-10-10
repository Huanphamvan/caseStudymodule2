package readAndWrite;

import account.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteForAccount {
    private File file1 = new File("Account.csv");
    public void writeFileForAccount (List<Account> listAccount) {
        try {
            FileWriter fileWriter = new FileWriter(file1);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = " ";
            for (Account account:listAccount) {
                line += account.getUsername()+ ","+account.getPassword()+"\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public List<Account>  readFileForAccount (){
        List<Account> listAccount = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine())!= null) {
                String[] str = line.split(",");
                Account account = new Account(str[0],str[1]);
                listAccount.add(account);

            }
            bufferedReader.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listAccount;
    }
}
