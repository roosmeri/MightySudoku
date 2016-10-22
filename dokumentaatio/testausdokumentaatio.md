##Testausdokumentaatio

Projektissani Mighty Sudoku, testasin automaattisesti vain toimintalogiikkaa,
eli pelin perusrakennetta ja jätin käyttöliittymään liittyvät luokat JUnit testailun ulkopuolelle.
Toimintalogiikan testailu tuntui järkevältä sillä sieltä sai päätoiminnot testattua kätevämmin,
kuin luomastani JFramen aliluokasta SudokuFrame.

Automaattista testausta ei siis ole toteutettu luokille: 
- Kayttoliittyma
- SudokuFrame
- MenuNappulaKuuntelija
- SyoteKuuntelija

Koska käyttöliittymää ei testattu automaattisesti, testailin sitä käsin pelaillen useampaan otteeseen, 
kokeillen eri vaikeustasoja ja syöttäen esimerkiksi monesti saman numeron sudokuruutuun, tai poistaen ja syöttäen 
vääriä syötteitä. 
Käyttöliittymässä sudokuruukon ruudut ovat JTextFrameja.

Monta bugia paljastuikin näin satunnaisia asioita syöttelemällä käyttöliittymään: 

- jos ruutuun asetti kahdesti oikean numeron, siitä tulikin väärä, sillä tällöinhän numero oli jo rivillä/sarakkeella/aliruudukossa, koska se juuri asetettiin sinne aikaisemmin

- peli pelattiin loppuun,sudoku ratkesi ja SudokuFrame luokan metodi sulki kaikki ruudut ruudukossa ja kun uusi peli tästä aloitettiin, kaikki ruudut olivat vieläkin lukossa

- yhdessä vaiheessa syötteen kuuntelijana oli KeyListener, mutta se ei pysynyt perässä syötteen muutoksien kanssa ja esimerkiksi kaksimerkkinen syöte kelpasi ja saattoi näyttää vihreätäkin,
 jos syötteen ensimmäinen merkki sopi ruutuun


Tällä hetkellä sudokuruudukon ruutuun voi syöttää myös kirjaimia tai muita merkkejä, jotka eivät ole sopivia, mutta enteriä painaessa ne hylätään eivätkä ne vaikuta peliin.
