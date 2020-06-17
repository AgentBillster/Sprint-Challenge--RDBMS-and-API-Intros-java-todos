package com.sprint.sprintr.services;

import com.sprint.sprintr.models.Todos;

public interface TodoServices {
    Todos save(Todos todos, long userid);

    Todos update(Todos todos, long id);
}
