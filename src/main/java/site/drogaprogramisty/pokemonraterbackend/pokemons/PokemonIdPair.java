package site.drogaprogramisty.pokemonraterbackend.pokemons;

record PokemonIdPair(int id, int id2) {
    public PokemonIdPair {
        if (id == id2) {
            throw new RuntimeException("Ids should be different!");
        }
        if (id < 1 || id > 151) {
            throw new RuntimeException("invalid ids! Should be only within 1-151.");
        }
        if (id2 < 1 || id2 > 151) {
            throw new RuntimeException("invalid ids! Should be only within 1-151.");
        }
    }
}
