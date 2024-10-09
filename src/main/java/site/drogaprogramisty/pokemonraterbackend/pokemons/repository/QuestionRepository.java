package site.drogaprogramisty.pokemonraterbackend.pokemons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.entities.QuestionEntity;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<QuestionEntity, UUID> {
}
