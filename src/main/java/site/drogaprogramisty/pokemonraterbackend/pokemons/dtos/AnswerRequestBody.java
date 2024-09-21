package site.drogaprogramisty.pokemonraterbackend.pokemons.dtos;

import java.util.UUID;

public record AnswerRequestBody(UUID id, int winnerPokemonId) {
}
