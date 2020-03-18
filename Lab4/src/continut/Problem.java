package continut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

public class Problem {
    /**
     * Algoritm de instantiere a residentilor din problema
     */
    public List<Resident> residentList(List<Resident> res) {
        Resident[] arr = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);
        res.addAll(Arrays.asList(arr));
        Collections.sort(res, (Comparator.comparing(Resident::getName)));
        return res;
    }

    /**
     * Algoritm de instantiere a spitalelor din problema
     */
    public TreeSet<Hospital> hospitalList(TreeSet<Hospital> h) {
        Hospital[] arr = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i, i + 1))
                .toArray(Hospital[]::new);
        h.addAll(Arrays.asList(arr));
        return h;
    }

    /**
     * Algoritm de instantiere a mapei residentilor cu preferintele lor din problema
     * Se creaza o lista de spitale pentru a salva spitalele din TreeSet si a crea liste preferentiate de spitale pentru fiecare resident in parte
     */
    public Map<Resident, List<Hospital>> resPrefMap(List<Resident> res, TreeSet<Hospital> h) {
        Map<Resident, List<Hospital>> map = new TreeMap<>();
        List<Hospital> hospitalList = new ArrayList<>(h);
        map.put(res.get(0), Arrays.asList(hospitalList.get(0), hospitalList.get(1), hospitalList.get(2)));
        map.put(res.get(1), Arrays.asList(hospitalList.get(0), hospitalList.get(1), hospitalList.get(2)));
        map.put(res.get(2), Arrays.asList(hospitalList.get(0), hospitalList.get(1)));
        map.put(res.get(3), Arrays.asList(hospitalList.get(0), hospitalList.get(2)));
        return map;
    }

    /**
     * Algoritm de instantiere a mapei spitalelor cu preferintele lor din problema
     * Se creaza cate o lista de residenti preferentiati pentru fiecare spital in parte
     * Se adauga in mapa in ordinea creata manual fiecare spital cu preferintele lui
     */
    public Map<Hospital, List<Resident>> hosPrefMap(List<Resident> res, TreeSet<Hospital> h) {

        Map<Hospital, List<Resident>> map = new TreeMap<>();
        List<Hospital> hospitalList = new ArrayList<>(h);
        List<Resident> prefList = new ArrayList<>();
        prefList.add(res.get(3));
        prefList.add(res.get(0));
        prefList.add(res.get(1));
        prefList.add(res.get(2));
        map.put(hospitalList.get(0), prefList);
        List<Resident> prefList1 = new ArrayList<>();
        prefList1.add(res.get(0));
        prefList1.add((res.get(2)));
        prefList1.add(res.get(1));
        map.put(hospitalList.get(1), prefList1);
        List<Resident> prefList2 = new ArrayList<>();
        prefList2.add(res.get(0));
        prefList2.add(res.get(1));
        prefList2.add(res.get(3));
        map.put(hospitalList.get(2), prefList2);
        return map;
    }

    public void AfisareFiltrari(List<Resident> res, TreeSet<Hospital> h, Map<Resident, List<Hospital>> resmap, Map<Hospital, List<Resident>> hosmap) {
        List<Hospital> target = Arrays.asList(h.first(), h.last()); // Se creaza o lista de spitale pentru a salva spitalele cautate (first este spitalul 0 si last este spitalul 2)
        List<Resident> result = res.stream()
                .filter(i -> resmap.get(i).containsAll(target)) // Filtru pentru a selecta doar residentii ce prefera cele 2 spitale
                .collect(Collectors.toList()); // Se colecteaza intr-o lista toti residenti acceptati
        System.out.println(result);
        System.out.println();

        for (Map.Entry<Hospital, List<Resident>> i : hosmap.entrySet()) // Se itereaza mapa pentru a verifica fiecare spital daca  are pe primul loc residentul 0 / se afiseaza doar spitalele acceptate
            if (i.getValue().toArray()[0] == res.get(0))
                System.out.print(i.getKey() + " ");
    }

}
