package account;

import readAndWrite.ReadAndWriteForAccount;

import java.util.List;

public class AccountManager implements IAccountManager<Account>{
    private List<Account> listAccount;
    private ReadAndWriteForAccount readAndWriteForAccount = new ReadAndWriteForAccount();
    public AccountManager(){
        listAccount = readAndWriteForAccount.readFileForAccount();
    }
    @Override
    public void register(Account account) {
        listAccount.add(account);
        readAndWriteForAccount.writeFileForAccount(listAccount);

    }

    @Override
    public List<Account> showAll() {
        return listAccount;
    }

    @Override
    public void changePassWord(String userName, Account account) {
        int index = findName(userName);
        if (index == -1){
            System.out.println("Không có tài khoản này nhé :");
        } else {
            listAccount.set(index,account);
            System.out.println("Đã đổi thành công");
        }
        readAndWriteForAccount.writeFileForAccount(listAccount);

    }

    @Override
    public int findName(String userName) {
        for (int i = 0; i < listAccount.size(); i++) {
            if (userName.equals(listAccount.get(i).getUsername())){
                return i;
            }
        }
        return -1 ;
    }
}
