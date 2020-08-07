package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        boolean flag = true;
        User citizen = findByPassport(passport);
        List<Account> accounts = users.get(citizen);
        for (Account element : accounts) {
            if (element.getRequisite() == account.getRequisite()) {
                flag = false;
                break;
            }
        }
         if (flag) {
             accounts.add(account);
             users.remove(citizen);
             users.put(citizen, accounts);
         }
    }

    public User findByPassport(String passport) {
        User citizen = null;
        for (User element : users.keySet()) {
            if (element.getPassport().equals(passport)) {
                citizen = element;
                break;
            }
        }
        return citizen;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = null;
        for (Map.Entry<User, List<Account>> element : users.entrySet()) {
            if (element.getKey().getPassport() == passport) {
                user = element.getKey();
                break;
            }
        }
        if (user != null) {
            List<Account> req = new ArrayList<>();
            for (Account element : users.get(user)) {
                req.add(element);
            }
            for (Account element : req) {
                if (element.getRequisite() == requisite) {
                    rsl = element;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User srcUser, destUser;
        Account srcAccount, destAccount;
        srcUser = destUser = null;
        srcAccount = destAccount = null;
        for (Map.Entry<User, List<Account>> element : users.entrySet()) {
            if (element.getKey().getPassport() == srcPassport) {
                srcUser = element.getKey();
                break;
            }
        }
        if (srcUser != null) {
            List<Account> mass = users.get(srcUser);
            for (Account element : mass) {
                if (element.getRequisite() == srcRequisite) {
                    srcAccount = element;
                    break;
                }
            }
            if (srcAccount.getBalance() - amount >= 0) {
                for (Map.Entry<User, List<Account>> element : users.entrySet()) {
                    if (element.getKey().getPassport() == destPassport) {
                        destUser = element.getKey();
                        break;
                    }
                }
                if (destUser != null) {
                    mass = users.get(srcUser);
                    for (Account element : mass) {
                        if (element.getRequisite() == destRequisite) {
                            destAccount = element;
                            srcAccount.setBalance(srcAccount.getBalance() - amount);
                            destAccount.setBalance(destAccount.getBalance() + amount);
                            rsl = true;
                            break;
                        }
                    }
                }
            }
        }
        return rsl;
    }
}