package site.drogaprogramisty.pokemonraterbackend.pokemons.repository;

import org.springframework.stereotype.Repository;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.entities.QuestionEntity;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class QuestionRepository {

    private final Map<UUID, QuestionEntity> db = new ConcurrentHashMap<>();

    public void insert(QuestionEntity questionEntity) {
        db.put(questionEntity.getId(), questionEntity);
    }

    public Optional<QuestionEntity> getById(UUID id) {
        return Optional.ofNullable(db.get(id));
    }

    public void delete(UUID id) {
        db.remove(id);
    }
}
