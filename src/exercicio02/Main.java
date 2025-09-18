package exercicio02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Empregado> lista = new ArrayList<>();
        lista.add(new Empregado("C", 3, 10));
        lista.add(new Empregado("D", 10, 10));
        lista.add(new Empregado("B", 10, 100));
        lista.add(new Empregado("A", 25, 1000));

        // forma A
        /*lista.stream()
                .map(e -> new Empregado(e.nome(), e.anosExperiencia(),
                        e.salario() * (e.anosExperiencia() >= 5 ? 1.2 : 1.1)))
                .sorted(Comparator.comparing(Empregado::nome))
                .forEach(System.out::println);*/

        // forma B - com predicado
        // predicaod --> filtro lógico para selecionar anos de experiência
        Predicate<Empregado> filtro = e -> e.anosExperiencia() >= 5;
        /*lista.stream()
                .map(e -> new Empregado(e.nome(), e.anosExperiencia(),
                        e.salario() * (filtro.test(e) ? 1.2 : 1.1)))
                .sorted(Comparator.comparing(Empregado::nome))
                .forEach(System.out::println);*/

        // para armazenar os dados numa lista
        List<Empregado> aux = lista.stream()
                .map(e -> new Empregado(e.nome(), e.anosExperiencia(),
                        e.salario() * (filtro.test(e) ? 1.2 : 1.1)))
                .sorted(Comparator.comparing(Empregado::nome))
                .toList();

        aux.forEach(System.out::println);
    }
}
