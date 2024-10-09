package site.drogaprogramisty.pokemonraterbackend.pokemons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.entities.PokemonEntity;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {

}
