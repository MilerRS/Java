package continut;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.TreeSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Resident[] r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);

        List<Resident> residentList = new ArrayList<>();

        residentList.addAll(Arrays.asList(r));

        Collections.sort(residentList, (Comparator.comparing(Resident::getName)));

        Hospital h0 = new Hospital("h0", 1);
        Hospital h1 = new Hospital("h1", 2);
        Hospital h2 = new Hospital("h2", 2);

        TreeSet<Hospital> h = new TreeSet<Hospital>();

        h.add(h0);
        h.add(h1);
        h.add(h2);

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        resPrefMap.put(r[0], Arrays.asList(h0,h1,h2));
        resPrefMap.put(r[1], Arrays.asList(h0,h1,h2));
        resPrefMap.put(r[2], Arrays.asList(h0,h1));
        resPrefMap.put(r[3], Arrays.asList(h0,h2));


        Map<Hospital, List<Resident>> hosPrefMap = new HashMap<>();
        List<Resident> prefList = new ArrayList<>();
        prefList.add(r[3]);
        prefList.add(r[0]);
        prefList.add(r[1]);
        prefList.add(r[2]);
        hosPrefMap.put(h0, prefList);
        List<Resident> prefList1 = new ArrayList<>();
        prefList1.add(r[0]);
        prefList1.add(r[2]);
        prefList1.add(r[1]);
        hosPrefMap.put(h1, prefList1);
        List<Resident> prefList2 = new ArrayList<>();
        prefList2.add(r[0]);
        prefList2.add(r[1]);
        prefList2.add(r[3]);
        hosPrefMap.put(h2, prefList2);

        System.out.println(resPrefMap);
        System.out.println();
        System.out.println(hosPrefMap);

        System.out.println();
        List<Hospital> target = Arrays.asList(h0, h2);
        List<Resident> result = residentList.stream()
                .filter(res -> resPrefMap.get(res).containsAll(target))
                .collect(Collectors.toList());
        System.out.println(result);

        List<Hospital> result1 = h.stream()
                .filter(res -> hosPrefMap.get(res).contains(r[0]))
                .collect(Collectors.toList());
        System.out.println(result1);
    }

}
