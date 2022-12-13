package be.ifosup.learning.types.service;

import be.ifosup.learning.types.entities.Type;
import be.ifosup.learning.types.in.TypeIdIn;
import be.ifosup.learning.types.in.TypeIn;
import be.ifosup.learning.types.out.TypeOut;
import be.ifosup.learning.types.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private final TypeRepository typeRepository;


    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<TypeOut> listAll() {
        List<Type> typeRepositoryAll = typeRepository.findAll();
        List<TypeOut> typeOuts = typeRepositoryAll
                .stream()
                .map(type -> getTypeOut(type))
                .collect(Collectors.toList());

        return typeOuts;
    }

    @Override
    public TypeOut save(TypeIn typeIn) {
        Type type = Type.builder()
                .titre(typeIn.getTitre())
                .description(typeIn.getDescription())
                .build();
        Type save = typeRepository.save(type);
        return getTypeOut(save);
    }

    @Override
    public TypeOut update(Long id, TypeIdIn typeIdIn) {
        Type type = typeRepository.findById(id).get();
        Type toSave = Type.builder()
                .type_id(type.getType_id())
                .titre(typeIdIn.getTitre() == null ? type.getTitre() : typeIdIn.getTitre())
                .description(typeIdIn.getDescription() == null ? type.getDescription() : typeIdIn.getDescription())
                .build();

        Type saved = typeRepository.save(toSave);
        return getTypeOut(saved);
    }

    @Override
    public TypeOut get(Long id) {
        Type type = typeRepository.findById(id).get();
        TypeOut typeOut = getTypeOut(type);
        return typeOut;
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }

    private static TypeOut getTypeOut(Type type) {
        return TypeOut.builder()
                .type_id(type.getType_id())
                .titre(type.getTitre())
                .description(type.getDescription())
                .build();
    }
}
