package ru.job4j.bank;

import java.util.*;

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
        User user = null;
        Optional<User> userOpt = users.keySet()
                .stream()
                .filter(
                        el -> el.getPassport()
                                .equals(passport)
                ).findFirst();
        if (userOpt.isPresent()) {
            user = userOpt.get();
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Optional<Account> rslOpt = Optional.empty();
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            rslOpt = users.get(user)
                    .stream()
                    .filter(
                            el -> el.getRequisite().equals(requisite)
                    ).findFirst();
        }
            if (rslOpt.isPresent()) {
                rsl = rslOpt.get();

            }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() - amount >= 0) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
