package site.drogaprogramisty.pokemonraterbackend.pokemons;

import java.security.SecureRandom;

class RandomIdPairGenerator {
    private final static SecureRandom random = new SecureRandom();

    public PokemonIdPair generate() {
        int id1 = randomId();
        int id2 = generateExcept(id1);
        return new PokemonIdPair(id1, id2);
    }



    private int randomId() {
        return random.nextInt(151) + 1; // 1-151
    }

    private int generateExcept(int except) {
        int id = randomId();
        if (id != except) {
            return id;
        }
        return generateExcept(except);
    }
}
