package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        boolean flag = true;
        User citizen = findByPassport(passport);
        if (citizen != null) {
            List<Account> accounts = users.get(citizen);
            for (Account element : accounts) {
                if (element.getRequisite().equals(account.getRequisite())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        //for (User element : users.keySet()) {
        //    if (element.getPassport().equals(passport)) {
        //        citizen = element;
        //        break;
         //   }
       // }
        List<User> citizen = users.keySet()
                .stream()
                .filter(
                        el -> el.getPassport()
                                .equals(passport)
                ).collect(
                        Collectors.toList()
                );
        return citizen.get(0);
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = null;
        user = findByPassport(passport);
        if (user != null) {
            for (Account element : users.get(user)) {
                if (element.getRequisite().equals(requisite)) {
                    rsl = element;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean rsl = false;
        Account srcAccount, destAccount;
        srcAccount = null;
        destAccount = null;
        srcAccount = findByRequisite(srcPassport, srcRequisite);
        destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() - amount >= 0) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}