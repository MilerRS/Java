# Java
Programare Avansata

**Lab6:**

Nou adaugat:

-Buton reset functional in ControlPanel
-File chooser pentru functiile save si load functionale exact cum cere problema.
-Modificat ConfigPanel astfel incat contine 2 ComboBox: una pentru forma si cealalta pentru culoare si am implementat 2 ActionListener pentru cele 2 combori pentru desena dupa forma si culoarea din ui 


-Compulsory: Am creat clase pentru mainframe, configpanel,controlpanel,drawingpanel si pentru polygon si nodeform
Mainframe creaza panel pentru config control si draw si le adauga in frame
Configpanel instantiaza nr de sides si culorile folosite
Controlpanel contine 4 butoane functionabile de save, load si exit
Drawingpanel seteaza radius si color random (radius intre 1 si 30 iar culorile oricare)  iar sides le preia din UI, si deseneaza cu prin apelul clasei poligon cu parametrii specificati.
Am folosit un mouselistener pentru a specifica coordonatele exacte pentru a desena

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

Contine 4 clase Resident,Hospital,Main,Problem

Clasa Problema contine multiple metoda pentru a instantia residentii si spitalele si pentru a creea mape atat pentru residenti si preferintelor cat si pentru spitale si preferintele lor, dar si o metoda de filtrare dupa cerintele problemei.
Clasa Main creaza un obiect problema, o lista pentru residenti, un treeset pentru spitale, cele 2 mape pentru preferinte, afiseaza mapele si apeleaza metoda obiectului problema pentru afisarea dupa filtre.

**Lab5:**

-Compulsory
Contine 5 clase Document,Catalog, CatalogUtil,InvalidCatalogException,Main

Document:
variabilele id,nume,location pentru path sau url, si o mapa pentru taguri
+
Gettere si Settere pentru fiecare variabila 
+
o metoda de addtag pentru a adauga tagurile si valorile acestora in mapa;

Catalog:
variabilele name, path, lista de documente incluse in catalog;
+
Gettere si Settere pentru fiecare variabila 
+
o metoda de add pentru a adauga un document in catalog;
+
o metoda findById care afiseaza un document dupa id acestuia, metoda foloseste Stream API pentru filtrare si afisare.

CatalogUtil:
metoda save:   salveaza un catalog la adresa acestuia, foloseste IOException pentru erori.
metoda load:  incarca un catalog de la o adresa data, foloseste InvalidCatalogException, IOException, ClassNotFoundException pentru erori.
metoda view: creeaza un obiect desktop si se foloseste de metoda browse pentru a deschide documentul selectat.

InvalidCatalogException:
este o exceptie personalizata, arunca o exceptie atunci cand este selectat alt fisier fata de cel cautat din catalog.

Main:
contine 2 metode prin care se salveaza, respectiv incarca si se deschide un catalog si metoda main prin care se apeleaza acestea.
