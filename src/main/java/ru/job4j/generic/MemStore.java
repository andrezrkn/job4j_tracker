package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
            return storage.replace(id, model) != null;
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id) != null && storage.containsKey(id);
    }

    @Override
    public T findById(String id) {
        return storage.get(id) != null && storage.containsKey(id)
                ? storage.get(id) : null;
    }
}
