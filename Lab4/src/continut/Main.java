package continut;


import java.util.*;
import java.util.stream.Collectors;
import java.util.TreeSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Problem problem = new Problem();// Se creaza obiectul problema
        List<Resident> res = new ArrayList<>(); // Se creaza o lista pentru residenti
        res = problem.residentList(res); // Se instantiaza lista pentru residenti
        TreeSet<Hospital> h = new TreeSet<>(); // Se creaza o lista pentru Spitale
        h = problem.hospitalList(h); // Se instantiaza lista pentru Spitale

        Map<Resident, List<Hospital>> resmap = problem.resPrefMap(res, h); // Se creaza si instantiaza mapa pentru residenti si preferintele lor
        Map<Hospital, List<Resident>> hosmap = problem.hosPrefMap(res, h);// Se creaza si instantiaza mapa pentru spitale si preferintele lor

        System.out.println(resmap); // Se afiseaza residentii si preferintele lor
        System.out.println();
        System.out.println(hosmap); // Se afiseaza spitalele si preferintele lor
        System.out.println();

       problem.AfisareFiltrari(res,h,resmap,hosmap); // metoda apelata pentru a afisa filtrarile cerute
    }
}
