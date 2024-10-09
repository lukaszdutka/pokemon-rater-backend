package site.drogaprogramisty.pokemonraterbackend.pokemons.repository.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int firstPokemonId;
    private int secondPokemonId;
    private LocalDateTime creationTime;

    public QuestionEntity() {

    }

    public QuestionEntity(UUID id, int firstPokemonId, int secondPokemonId, LocalDateTime creationTime) {
        this.id = id;
        this.firstPokemonId = firstPokemonId;
        this.secondPokemonId = secondPokemonId;
        this.creationTime = creationTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getFirstPokemonId() {
        return firstPokemonId;
    }

    public void setFirstPokemonId(int firstPokemonId) {
        this.firstPokemonId = firstPokemonId;
    }

    public int getSecondPokemonId() {
        return secondPokemonId;
    }

    public void setSecondPokemonId(int secondPokemonId) {
        this.secondPokemonId = secondPokemonId;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
