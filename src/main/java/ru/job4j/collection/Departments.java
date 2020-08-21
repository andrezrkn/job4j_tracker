package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        List<String> rsl = new ArrayList<>();
        for (String value : deps) {
            Collections.addAll(tmp, value.split("/"));
        }
                if (tmp.contains("K1")) {
                    rsl.add("K1");
                }
                if (tmp.contains("K2")) {
                    rsl.add("K2");
                }
                if (tmp.contains("SK1")) {
                    if (tmp.contains("K1")) {
                        rsl.add("K1/SK1");
                    }
                    if (tmp.contains("K2")) {
                        rsl.add("K2/SK1");
                    }
                }
                if (tmp.contains("SK2")) {
                    if (tmp.contains("K1")) {
                        rsl.add("K1/SK2");
                    }
                    if (tmp.contains("K2")) {
                        rsl.add("K2/SK2");
                    }
                }
                if (tmp.contains("SSK1")) {
                    if (tmp.contains("SK1")) {
                        if (tmp.contains("K1")) {
                            rsl.add("K1/SK1/SSK1");
                        }
                        if (tmp.contains("K2")) {
                            rsl.add("K2/SK1/SSK1");
                        }
                    }
                    if (tmp.contains("SK2")) {
                        if (tmp.contains("K1")) {
                            rsl.add("K1/SK2/SSK1");
                        }
                        if (tmp.contains("K2")) {
                            rsl.add("K2/SK2/SSK1");
                        }
                    }
                }
                if (tmp.contains("SSK2")) {
                    if (tmp.contains("SK1")) {
                        if (tmp.contains("K1")) {
                            rsl.add("K1/SK1/SSK2");
                        }
                        if (tmp.contains("K2")) {
                            rsl.add("K2/SK1/SSK2");
                        }
                    }
                    if (tmp.contains("SK2")) {
                        if (tmp.contains("K1")) {
                            rsl.add("K1/SK2/SSK2");
                        }
                        if (tmp.contains("K2")) {
                            rsl.add("K2/SK2/SSK2");
                        }
                    }
                }
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
