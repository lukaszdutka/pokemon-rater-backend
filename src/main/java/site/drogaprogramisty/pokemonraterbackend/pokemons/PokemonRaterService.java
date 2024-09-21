package site.drogaprogramisty.pokemonraterbackend.pokemons;

import site.drogaprogramisty.pokemonraterbackend.pokemons.dtos.QuestionResponse;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.PokemonRepository;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.QuestionRepository;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.entities.PokemonEntity;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.entities.QuestionEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

class PokemonRaterService {
    private final RandomIdPairGenerator randomIdPairGenerator;
    private final QuestionRepository questionRepository;
    private final PokemonRepository pokemonRepository;
    private final EloRatingCalculator ratingCalculator;

    public PokemonRaterService(RandomIdPairGenerator randomIdPairGenerator,
                               QuestionRepository questionRepository,
                               PokemonRepository pokemonRepository,
                               EloRatingCalculator ratingCalculator) {
        this.randomIdPairGenerator = randomIdPairGenerator;
        this.questionRepository = questionRepository;
        this.pokemonRepository = pokemonRepository;
        this.ratingCalculator = ratingCalculator;
    }

    public QuestionResponse generateQuestion() {
        UUID uuid = UUID.randomUUID();
        PokemonIdPair pair = randomIdPairGenerator.generate();

        questionRepository.insert(new QuestionEntity(uuid, pair.id(), pair.id2(), LocalDateTime.now()));

        String name1 = pokemonRepository.getById(pair.id()).get().getName();
        String name2 = pokemonRepository.getById(pair.id2()).get().getName();

        return new QuestionResponse(uuid.toString(), pair.id(), name1, pair.id2(), name2);
    }

    public void processAnswer(UUID id, int winnerPokemonId) {
        Optional<QuestionEntity> questionOptional = questionRepository.getById(id);
        if (questionOptional.isEmpty()) {
            throw new RuntimeException("id does not exist: " + id);
        }
        QuestionEntity question = questionOptional.get();

        if (winnerPokemonId != question.getFirstPokemonId() && winnerPokemonId != question.getSecondPokemonId()) {
            throw new RuntimeException("I see you sneaky bastard!");
        }

        Optional<PokemonEntity> first = pokemonRepository.getById(question.getFirstPokemonId());
        Optional<PokemonEntity> second = pokemonRepository.getById(question.getSecondPokemonId());
        if (first.isEmpty() || second.isEmpty()) {
            throw new RuntimeException("one of ids were invalid: " + question.getFirstPokemonId() + " or " + question.getSecondPokemonId());
        }
        PokemonEntity firstPokemon = first.get();
        PokemonEntity secondPokemon = second.get();


        if (winnerPokemonId == question.getFirstPokemonId()) {
            RatingPair ratingPair = ratingCalculator.calculateNewRatings(firstPokemon.getRating(), secondPokemon.getRating());
            firstPokemon.setRating(ratingPair.winnerRating());
            secondPokemon.setRating(ratingPair.loserRating());
        } else {
            RatingPair ratingPair = ratingCalculator.calculateNewRatings(secondPokemon.getRating(), firstPokemon.getRating());
            firstPokemon.setRating(ratingPair.loserRating());
            secondPokemon.setRating(ratingPair.winnerRating());
        }

        questionRepository.delete(id);
    }

    public List<PokemonEntity> getLeaderboard() {
        return pokemonRepository.getAllSortedByRating();
    }
}
