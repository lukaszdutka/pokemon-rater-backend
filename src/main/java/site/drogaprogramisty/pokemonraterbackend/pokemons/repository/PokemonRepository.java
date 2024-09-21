package site.drogaprogramisty.pokemonraterbackend.pokemons.repository;

import org.springframework.stereotype.Repository;
import site.drogaprogramisty.pokemonraterbackend.pokemons.repository.entities.PokemonEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PokemonRepository {
    private final Map<Integer, PokemonEntity> db = new ConcurrentHashMap<>();

    public PokemonRepository() {
        initialise();
    }

    public Optional<PokemonEntity> getById(int id) {
        return Optional.ofNullable(db.get(id));
    }

    public List<PokemonEntity> getAllSortedByRating() {
        return db.values().stream()
                .sorted((p1, p2) -> p2.getRating() - p1.getRating())
                .toList();
    }

    private void initialise() {
        db.put(1, new PokemonEntity(1, "bulbasaur", 1000));
        db.put(2, new PokemonEntity(2, "ivysaur", 1000));
        db.put(3, new PokemonEntity(3, "venusaur", 1000));
        db.put(4, new PokemonEntity(4, "charmander", 1000));
        db.put(5, new PokemonEntity(5, "charmeleon", 1000));
        db.put(6, new PokemonEntity(6, "charizard", 1000));
        db.put(7, new PokemonEntity(7, "squirtle", 1000));
        db.put(8, new PokemonEntity(8, "wartortle", 1000));
        db.put(9, new PokemonEntity(9, "blastoise", 1000));
        db.put(10, new PokemonEntity(10, "caterpie", 1000));
        db.put(11, new PokemonEntity(11, "metapod", 1000));
        db.put(12, new PokemonEntity(12, "butterfree", 1000));
        db.put(13, new PokemonEntity(13, "weedle", 1000));
        db.put(14, new PokemonEntity(14, "kakuna", 1000));
        db.put(15, new PokemonEntity(15, "beedrill", 1000));
        db.put(16, new PokemonEntity(16, "pidgey", 1000));
        db.put(17, new PokemonEntity(17, "pidgeotto", 1000));
        db.put(18, new PokemonEntity(18, "pidgeot", 1000));
        db.put(19, new PokemonEntity(19, "rattata", 1000));
        db.put(20, new PokemonEntity(20, "raticate", 1000));
        db.put(21, new PokemonEntity(21, "spearow", 1000));
        db.put(22, new PokemonEntity(22, "fearow", 1000));
        db.put(23, new PokemonEntity(23, "ekans", 1000));
        db.put(24, new PokemonEntity(24, "arbok", 1000));
        db.put(25, new PokemonEntity(25, "pikachu", 1000));
        db.put(26, new PokemonEntity(26, "raichu", 1000));
        db.put(27, new PokemonEntity(27, "sandshrew", 1000));
        db.put(28, new PokemonEntity(28, "sandslash", 1000));
        db.put(29, new PokemonEntity(29, "nidoran-f", 1000));
        db.put(30, new PokemonEntity(30, "nidorina", 1000));
        db.put(31, new PokemonEntity(31, "nidoqueen", 1000));
        db.put(32, new PokemonEntity(32, "nidoran-m", 1000));
        db.put(33, new PokemonEntity(33, "nidorino", 1000));
        db.put(34, new PokemonEntity(34, "nidoking", 1000));
        db.put(35, new PokemonEntity(35, "clefairy", 1000));
        db.put(36, new PokemonEntity(36, "clefable", 1000));
        db.put(37, new PokemonEntity(37, "vulpix", 1000));
        db.put(38, new PokemonEntity(38, "ninetales", 1000));
        db.put(39, new PokemonEntity(39, "jigglypuff", 1000));
        db.put(40, new PokemonEntity(40, "wigglytuff", 1000));
        db.put(41, new PokemonEntity(41, "zubat", 1000));
        db.put(42, new PokemonEntity(42, "golbat", 1000));
        db.put(43, new PokemonEntity(43, "oddish", 1000));
        db.put(44, new PokemonEntity(44, "gloom", 1000));
        db.put(45, new PokemonEntity(45, "vileplume", 1000));
        db.put(46, new PokemonEntity(46, "paras", 1000));
        db.put(47, new PokemonEntity(47, "parasect", 1000));
        db.put(48, new PokemonEntity(48, "venonat", 1000));
        db.put(49, new PokemonEntity(49, "venomoth", 1000));
        db.put(50, new PokemonEntity(50, "diglett", 1000));
        db.put(51, new PokemonEntity(51, "dugtrio", 1000));
        db.put(52, new PokemonEntity(52, "meowth", 1000));
        db.put(53, new PokemonEntity(53, "persian", 1000));
        db.put(54, new PokemonEntity(54, "psyduck", 1000));
        db.put(55, new PokemonEntity(55, "golduck", 1000));
        db.put(56, new PokemonEntity(56, "mankey", 1000));
        db.put(57, new PokemonEntity(57, "primeape", 1000));
        db.put(58, new PokemonEntity(58, "growlithe", 1000));
        db.put(59, new PokemonEntity(59, "arcanine", 1000));
        db.put(60, new PokemonEntity(60, "poliwag", 1000));
        db.put(61, new PokemonEntity(61, "poliwhirl", 1000));
        db.put(62, new PokemonEntity(62, "poliwrath", 1000));
        db.put(63, new PokemonEntity(63, "abra", 1000));
        db.put(64, new PokemonEntity(64, "kadabra", 1000));
        db.put(65, new PokemonEntity(65, "alakazam", 1000));
        db.put(66, new PokemonEntity(66, "machop", 1000));
        db.put(67, new PokemonEntity(67, "machoke", 1000));
        db.put(68, new PokemonEntity(68, "machamp", 1000));
        db.put(69, new PokemonEntity(69, "bellsprout", 1000));
        db.put(70, new PokemonEntity(70, "weepinbell", 1000));
        db.put(71, new PokemonEntity(71, "victreebel", 1000));
        db.put(72, new PokemonEntity(72, "tentacool", 1000));
        db.put(73, new PokemonEntity(73, "tentacruel", 1000));
        db.put(74, new PokemonEntity(74, "geodude", 1000));
        db.put(75, new PokemonEntity(75, "graveler", 1000));
        db.put(76, new PokemonEntity(76, "golem", 1000));
        db.put(77, new PokemonEntity(77, "ponyta", 1000));
        db.put(78, new PokemonEntity(78, "rapidash", 1000));
        db.put(79, new PokemonEntity(79, "slowpoke", 1000));
        db.put(80, new PokemonEntity(80, "slowbro", 1000));
        db.put(81, new PokemonEntity(81, "magnemite", 1000));
        db.put(82, new PokemonEntity(82, "magneton", 1000));
        db.put(83, new PokemonEntity(83, "farfetchd", 1000));
        db.put(84, new PokemonEntity(84, "doduo", 1000));
        db.put(85, new PokemonEntity(85, "dodrio", 1000));
        db.put(86, new PokemonEntity(86, "seel", 1000));
        db.put(87, new PokemonEntity(87, "dewgong", 1000));
        db.put(88, new PokemonEntity(88, "grimer", 1000));
        db.put(89, new PokemonEntity(89, "muk", 1000));
        db.put(90, new PokemonEntity(90, "shellder", 1000));
        db.put(91, new PokemonEntity(91, "cloyster", 1000));
        db.put(92, new PokemonEntity(92, "gastly", 1000));
        db.put(93, new PokemonEntity(93, "haunter", 1000));
        db.put(94, new PokemonEntity(94, "gengar", 1000));
        db.put(95, new PokemonEntity(95, "onix", 1000));
        db.put(96, new PokemonEntity(96, "drowzee", 1000));
        db.put(97, new PokemonEntity(97, "hypno", 1000));
        db.put(98, new PokemonEntity(98, "krabby", 1000));
        db.put(99, new PokemonEntity(99, "kingler", 1000));
        db.put(100, new PokemonEntity(100, "voltorb", 1000));
        db.put(101, new PokemonEntity(101, "electrode", 1000));
        db.put(102, new PokemonEntity(102, "exeggcute", 1000));
        db.put(103, new PokemonEntity(103, "exeggutor", 1000));
        db.put(104, new PokemonEntity(104, "cubone", 1000));
        db.put(105, new PokemonEntity(105, "marowak", 1000));
        db.put(106, new PokemonEntity(106, "hitmonlee", 1000));
        db.put(107, new PokemonEntity(107, "hitmonchan", 1000));
        db.put(108, new PokemonEntity(108, "lickitung", 1000));
        db.put(109, new PokemonEntity(109, "koffing", 1000));
        db.put(110, new PokemonEntity(110, "weezing", 1000));
        db.put(111, new PokemonEntity(111, "rhyhorn", 1000));
        db.put(112, new PokemonEntity(112, "rhydon", 1000));
        db.put(113, new PokemonEntity(113, "chansey", 1000));
        db.put(114, new PokemonEntity(114, "tangela", 1000));
        db.put(115, new PokemonEntity(115, "kangaskhan", 1000));
        db.put(116, new PokemonEntity(116, "horsea", 1000));
        db.put(117, new PokemonEntity(117, "seadra", 1000));
        db.put(118, new PokemonEntity(118, "goldeen", 1000));
        db.put(119, new PokemonEntity(119, "seaking", 1000));
        db.put(120, new PokemonEntity(120, "staryu", 1000));
        db.put(121, new PokemonEntity(121, "starmie", 1000));
        db.put(122, new PokemonEntity(122, "mr-mime", 1000));
        db.put(123, new PokemonEntity(123, "scyther", 1000));
        db.put(124, new PokemonEntity(124, "jynx", 1000));
        db.put(125, new PokemonEntity(125, "electabuzz", 1000));
        db.put(126, new PokemonEntity(126, "magmar", 1000));
        db.put(127, new PokemonEntity(127, "pinsir", 1000));
        db.put(128, new PokemonEntity(128, "tauros", 1000));
        db.put(129, new PokemonEntity(129, "magikarp", 1000));
        db.put(130, new PokemonEntity(130, "gyarados", 1000));
        db.put(131, new PokemonEntity(131, "lapras", 1000));
        db.put(132, new PokemonEntity(132, "ditto", 1000));
        db.put(133, new PokemonEntity(133, "eevee", 1000));
        db.put(134, new PokemonEntity(134, "vaporeon", 1000));
        db.put(135, new PokemonEntity(135, "jolteon", 1000));
        db.put(136, new PokemonEntity(136, "flareon", 1000));
        db.put(137, new PokemonEntity(137, "porygon", 1000));
        db.put(138, new PokemonEntity(138, "omanyte", 1000));
        db.put(139, new PokemonEntity(139, "omastar", 1000));
        db.put(140, new PokemonEntity(140, "kabuto", 1000));
        db.put(141, new PokemonEntity(141, "kabutops", 1000));
        db.put(142, new PokemonEntity(142, "aerodactyl", 1000));
        db.put(143, new PokemonEntity(143, "snorlax", 1000));
        db.put(144, new PokemonEntity(144, "articuno", 1000));
        db.put(145, new PokemonEntity(145, "zapdos", 1000));
        db.put(146, new PokemonEntity(146, "moltres", 1000));
        db.put(147, new PokemonEntity(147, "dratini", 1000));
        db.put(148, new PokemonEntity(148, "dragonair", 1000));
        db.put(149, new PokemonEntity(149, "dragonite", 1000));
        db.put(150, new PokemonEntity(150, "mewtwo", 1000));
        db.put(151, new PokemonEntity(151, "mew", 1000));
    }
}
