# Java
Programare Avansata


**Lab3:**

-Compulsory + Optional finalizat cu toate cerintele

-Greedy: clasa ce contine un obiect sac, o lista de obiecte item si o metoda ce rezolva problema 

Metoda sorteaza lista de iteme dupa un comparator personalizat(verifica profitul fiecarui item si returneaza 0 daca sunt egale -1 daca primul>al doilea si 1 respectiv invers), creeaza o lista noua pentru itemele permise si o capacitate folosita pentru itemele acceptate,
foloseste o iteratie de iteme pentru a verifica daca greutatea itemului curent + greutatea celorlalte iteme acceptate este mai mica decat greutatea sacului, in caz afirmativ adauga itemul in lista itemelor acceptate, dupa ce se termina iteratia se seteaza lista itemlor acceptate drept lista itemelor din sac.

-Dynamic Programming:clasa ce contine un obiect sac, o lista de obiecte item, o capacitate de tip int si o metoda ce rezolva problema 

Metoda creaza 2 vectori pentru greutate, respectiv valoare, si introduce in acestea greutatea, respectiv valoarea, itemelor disponibile, se creaza o matrice ce are ca argumente nr itemelor si capacitatea fiecaruia si se initializeaza primul rand cu 0
Se modifica matricea astfel incat pe fiecare pozitie este valoarea maxima a greutatii obtinute din toate itemele precedente acestuia
Se creaza o lista de iteme acceptate in sac si se adauga in lista iteme dupa greutatea lor de la cea mai grea la cea mai usoara
Se seteaza itemele din sac dupa lista itemelor acceptate.


**Lab4:**

-Compulsory

Contine 4 clasa Resident,Hospital,Main,Problem

Clasa Problema contine multiple metoda pentru a instantia residentii si spitalele si pentru a creea mape atat pentru residenti si preferintelor cat si pentru spitale si preferintele lor, dar si o metoda de filtrare dupa cerintele problemei.
Clasa Main creaza un obiect problema, o lista pentru residenti, un treeset pentru spitale, cele 2 mape pentru preferinte, afiseaza mapele si apeleaza metoda obiectului problema pentru afisarea dupa filtre.
