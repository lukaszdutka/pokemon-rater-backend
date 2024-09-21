package site.drogaprogramisty.pokemonraterbackend.pokemons.dtos;

public record QuestionResponse(String id,
                               int firstPokemonId, String firstPokemonName,
                               int secondPokemonId, String secondPokemonName) {
}
