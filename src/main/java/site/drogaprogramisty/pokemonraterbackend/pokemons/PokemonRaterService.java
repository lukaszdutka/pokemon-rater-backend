package site.drogaprogramisty.pokemonraterbackend.pokemons;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
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

    @Transactional
    public QuestionResponse generateQuestion() {
        PokemonIdPair pair = randomIdPairGenerator.generate();

        QuestionEntity question = new QuestionEntity(null, pair.id(), pair.id2(), LocalDateTime.now());
        questionRepository.save(question);

        List<PokemonEntity> twoPokemons = pokemonRepository.findAllById(List.of(pair.id(), pair.id2()));
        if (twoPokemons.size() != 2) {
            throw new RuntimeException("Bad pokemon ids: " + pair.id() + " or " + pair.id2());
        }
        String name1 = twoPokemons.stream()
                .filter(p -> p.getId() == pair.id()).findFirst().get().getName();
        String name2 = twoPokemons.stream()
                .filter(p -> p.getId() == pair.id2()).findFirst().get().getName();

        return new QuestionResponse(question.getId().toString(), pair.id(), name1, pair.id2(), name2);
    }

    @Transactional
    public void processAnswer(UUID id, int winnerPokemonId) {
        Optional<QuestionEntity> questionOptional = questionRepository.findById(id);
        if (questionOptional.isEmpty()) {
            return;
        }
        QuestionEntity question = questionOptional.get();

        if (winnerPokemonId != question.getFirstPokemonId() && winnerPokemonId != question.getSecondPokemonId()) {
            return;
        }

        PokemonEntity firstPokemon = pokemonRepository.findById(question.getFirstPokemonId())
                .orElseThrow(() -> new RuntimeException("Invalid pokemon id: " + question.getFirstPokemonId()));
        PokemonEntity secondPokemon = pokemonRepository.findById(question.getSecondPokemonId())
                .orElseThrow(() -> new RuntimeException("Invalid pokemon id: " + question.getSecondPokemonId()));


        if (winnerPokemonId == question.getFirstPokemonId()) {
            RatingPair ratingPair = ratingCalculator.calculateNewRatings(firstPokemon.getRating(), secondPokemon.getRating());
            firstPokemon.setRating(ratingPair.winnerRating());
            secondPokemon.setRating(ratingPair.loserRating());
            System.out.println("Wygrał: " + winnerPokemonId + " => " + firstPokemon.getName());
        } else {
            RatingPair ratingPair = ratingCalculator.calculateNewRatings(secondPokemon.getRating(), firstPokemon.getRating());
            firstPokemon.setRating(ratingPair.loserRating());
            secondPokemon.setRating(ratingPair.winnerRating());
            System.out.println("Wygrał: " + winnerPokemonId + " => " + secondPokemon.getName());
        }

        questionRepository.deleteById(id);
    }

    public List<PokemonEntity> getLeaderboard() {
        return pokemonRepository.findAll(Sort.by("rating").descending());
    }
}
