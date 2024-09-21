package site.drogaprogramisty.pokemonraterbackend.pokemons;

import org.springframework.web.bind.annotation.*;
import site.drogaprogramisty.pokemonraterbackend.pokemons.dtos.AnswerRequestBody;
import site.drogaprogramisty.pokemonraterbackend.pokemons.dtos.QuestionResponse;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.entities.PokemonEntity;

import java.util.List;

@RestController
@CrossOrigin("*")
class PokemonController {
    private final PokemonRaterService pokemonRaterService;

    public PokemonController(PokemonRaterService pokemonRaterService) {
        this.pokemonRaterService = pokemonRaterService;
    }

    @GetMapping("/question")
    public QuestionResponse getQuestion() {
        return pokemonRaterService.generateQuestion();
    }

    @PostMapping("/answer")
    public void answer(@RequestBody AnswerRequestBody answerRequestBody) {
        pokemonRaterService.processAnswer(answerRequestBody.id(), answerRequestBody.winnerPokemonId());
    }

    @GetMapping("/leaderboard")
    public List<PokemonEntity> getLeaderboard() {
        return pokemonRaterService.getLeaderboard();
    }
}
