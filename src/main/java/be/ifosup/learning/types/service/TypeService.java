package be.ifosup.learning.types.service;

import be.ifosup.learning.types.in.TypeIdIn;
import be.ifosup.learning.types.in.TypeIn;
import be.ifosup.learning.types.out.TypeOut;
import java.util.List;

public interface TypeService {
    List<TypeOut> listAll();

    TypeOut save(TypeIn typeIn);

    TypeOut update(Long id, TypeIdIn typeIdIn);

    TypeOut get(Long id);

    void delete(Long id);
}
