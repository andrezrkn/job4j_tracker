package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        if (model.getId() == null) {
            storage.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        if (storage.containsKey(id)) {
            storage.remove(id);
            storage.put(id, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (storage.containsKey(id)) {
            storage.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (String key : storage.keySet()) {
            if (key.equals(id)) {
                return storage.get(id);
            }
        }
        return null;
    }


}
