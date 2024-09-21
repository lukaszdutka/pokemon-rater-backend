package site.drogaprogramisty.pokemonraterbackend.pokemons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.PokemonRepository;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.QuestionRepository;

@Configuration
class PokemonConfiguration {

    @Bean
    PokemonRaterService pokemonRaterService(
            QuestionRepository questionRepository,
            PokemonRepository pokemonRepository
    ) {
        RandomIdPairGenerator randomIdPairGenerator = new RandomIdPairGenerator();
        EloRatingCalculator ratingCalculator = new EloRatingCalculator();
        return new PokemonRaterService(
                randomIdPairGenerator,
                questionRepository,
                pokemonRepository,
                ratingCalculator
        );
    }
}
