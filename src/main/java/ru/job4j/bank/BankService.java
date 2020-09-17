package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        boolean flag = true;
        Optional<User> citizen = findByPassport(passport);
        if (citizen.isPresent()) {
            List<Account> accounts = users.get(citizen.get());
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

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(
                        el -> el.getPassport()
                                .equals(passport)
                ).findFirst();
    }

    public Optional<Account> findByRequisite(String passport,
                                             String requisite) {
        Optional<Account> rslOpt = null;
        Optional<User> userOpt = findByPassport(passport);
        if (userOpt.isPresent()) {
            rslOpt = users.get(userOpt.get())
                    .stream()
                    .filter(
                            el -> el.getRequisite().equals(requisite)
                    ).findFirst();
        }
        return rslOpt;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport,
                srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport,
                destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() - amount >= 0) {
            srcAccount.get().setBalance(srcAccount.get().getBalance()
                    - amount);
            destAccount.get().setBalance(destAccount.get().getBalance()
                    + amount);
            rsl = true;
        }
        return rsl;
    }
}
