# Dôveryhodný systém - LibBook
## Informačný systém pre knižnicu

Tento softvér vytvoril Matej Delinčák. Softvér simuluje informačný systém virtuálnej knižnice. Dôveryhodný softvér je skrytý u mňa v login systéme. Ak sa užívateľ chce zaregistrovať, musí splniť určité požiadavky.

Pre otestovanie programu mam troch pracovných uživateľov:
- Dieťa: login: x heslo: x
- Dospelý: login: y heslo: x
- Pracovník: login: z heslo: x

Softvér je zatiaľ len v stave pracovnom, ale už fungujú principiálne veci a to:

**Užívateľ (dva typy - Dieťa a Dospelý):**
  - si môže rezervovať knihy, 
  - vypísať správy o tom ako dopadlo rezervovanie a násl, 
  - zobraziť knihy jemu dostupné,
  - zobraziť  knihy, ktoré vlastní
  - zobraziť recenziu (ak existuje) knihy,
  - vrátiť požičanú knihu
  
**Pracovník:**
  - zobraziť knihy,
  - zobraziť všetky účty,
  - potvrdiť rezervovanie knihy užívateľom (zobraziť účet žiadateľa),
  - alebo požiadavku zamietnuť
  
Do prostredia si môžete vytvoriť aj vlastný účet, ale s určitými podmienkami. Ale zatiaľ mám dočasne zakázané ukladanie nových užívateľov po vypnutí aplikácie z dôvodu rychlejšieho testovania.

V tejto aplikácií som zatiaľ využil:

**Dedenie**

Vytvoril som rôzne hierarchie objektov (ešte ich budem rozšírovať). Hierarchia užívateľov, služieb(zatiaľ len kníh) a systémov, či kontrolérov. Toto je jedna z nich: 

![Hierarchia](https://github.com/OOP-FIIT/oop-2020-str-12-pu1-povazanova-mateju25/blob/master/docs/Hierarchia.png)


**Polymorfizmus**

Polymorfizmus som uplatnil na triedach AdultBook a ChildBook v metóde *getInfo*. Pristupujem ku ním rovnako, ale každá vráti niečo iné.

**Agregácia**

Agregácia je uplatnená aj napríklad v objekte LibraryEvidenceSystem, viď. obrázok. Tento objekt agreguje tri rôzne objekty - systémy.

![Agregácia](https://github.com/OOP-FIIT/oop-2020-str-12-pu1-povazanova-mateju25/blob/master/docs/Agregácia.png)

**Oddelenie aplikačnej logiky od GUI**

Samotné GUI som umiestnil do vlastného package-u pod menom *gui*. V tejto zložke sa nachádzajú Controllery pre rôzne scény aplikácie. Pri stlačení nejakého tlačidla, sa vykoná prislušná funkcia, ktorej logika je umiestnená len v classe LibraryEvidenceSystem.

**Použitie návrhového vzoru Visitor**

Využil som ho na upresnenie právomocí uživateľov. Napríklad čitateľ nemá prístup k databáze účtov, len ku knihám. A keď ide o dieťa, to má sprítupnené len určité knihy. Na obrázku je znázornený prístup pracovníka do databázy účtov.

![Visitor](https://github.com/OOP-FIIT/oop-2020-str-12-pu1-povazanova-mateju25/blob/master/docs/Visitor.png)

**Vytvorenie vlastnej výnimky**

Vytvoril som vlastnú výminku, ktorá zobrazí okno pri nesprávnom vytvorení hesla (nie sú splenené určité požiadavky).

![Exception](https://github.com/OOP-FIIT/oop-2020-str-12-pu1-povazanova-mateju25/blob/master/docs/Exception.png)

**Použitie RTTI**

RTTI je využité napríklad aj v tom, že sa pracuje s knihou, ktorú si až užívateľ vyberie. Alebo keď sa vytvára nový účet, tak si vyberá ,aký typ účtu to bude. Metóda v kinhe *showInfo* vráti info o knihe, až na základe jej atribútu reserved (ten sa mení pri rezervovaní knihy).

**Použitie vhniezdenej triedy**

Vhniezdenú triedu som využil v classe Book. Definoval som v nej triedu Review, s ktorou bude pracovat jedine kniha.

![Vhniezdená trieda](https://github.com/OOP-FIIT/oop-2020-str-12-pu1-povazanova-mateju25/blob/master/docs/EnclosedClass.png)

**Serializáciu a deserializáciu**

Tento aspekt programu mam plne funkčný, ale momentálne je odstavený. Čiže program bude fungovať vždy rovnako po jeho spustení.

