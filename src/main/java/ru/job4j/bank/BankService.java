package ru.job4j.bank;

import java.util.*;

/**
 * Класс BankService описывает банк с ограниченным функционалом, который может добавить
 * пользователя и счёт, найти по паспорту и реквизитам и сделать трансфер
 */
public class BankService {
    /**
     * Поле users состоит из карты, ключем которой является класс User, а значения это список из
     * аккаунтов
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * @param user добавляется в поле users, счёта у юзера нет
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * @param passport нужен для поиска пользователя, ищем по паспорту
     * @param account счет, который мы добавляем пользователю. Перед этим происходит проверка, что
     *                такого счета ещё нет
     */
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

    /**
     * Поиск пользователя по паспорту
     * @param passport с его помощью ищем юзера
     * @return user, паспорт которого совпадает с passport
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(
                        el -> el.getPassport()
                                .equals(passport)
                ).findFirst();
    }

    /**
     * Поиск счета по паспорту и реквизиту
     * @param passport нужен, чтобы найти пользователя, чтобы получить доступ к его счетам
     * @param requisite нужен, чтобы найти конкретный счет
     * @return счет, который мы ищем
     */
    public Optional<Account> findByRequisite(String passport,
                                             String requisite) {
        Optional<Account> rslOpt = Optional.empty();
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

    /**
     * Перевод денег с одного счёта на другой, перевод осуществится при наличии счетов отправителя
     * и получаетлся. Так же проверяется, что отправка не сделает счет получателя отрицательным
     * @param srcPassport паспорт отправителя, ищем по нему пользователя
     * @param srcRequisite счет отправителя, ищем по нему конкретный счет
     * @param destPassport паспорт получателя
     * @param destRequisite счет получаетля
     * @param amount сумма отправляемых денег
     * @return успешность отправки
     */
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
