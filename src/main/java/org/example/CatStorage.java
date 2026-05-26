// -- Хранилище ---

package org.example;

import java.util.List;

public interface CatStorage {
    void save(List<Cat> cats);

    List<Cat> load();
}
