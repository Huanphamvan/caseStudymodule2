package account;

import java.util.List;

public interface IAccountManager <E>{
    void register (E e);
    List <E> showAll();
    void changePassWord (String userName , E e);
    int findName (String userName);
}

