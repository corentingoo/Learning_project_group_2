package be.ifosup.learning.types.service;

import be.ifosup.learning.types.in.TypeIn;
import be.ifosup.learning.types.out.TypeOut;
import java.util.List;

public interface TypeService {
    List<TypeOut> listAll();

    TypeOut save(TypeIn typeIn);

    TypeOut update(Long id, TypeIn typeIn);

    TypeOut get(Long id);

    void delete(Long id);
}
