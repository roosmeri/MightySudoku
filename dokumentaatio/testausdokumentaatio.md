##Testausdokumentaatio

Projektissani Mighty Sudoku, testasin automaattisesti vain toimintalogiikkaa,
eli pelin perusrakennetta ja j�tin k�ytt�liittym��n liittyv�t luokat JUnit testailun ulkopuolelle.
Toimintalogiikan testailu tuntui j�rkev�lt� sill� sielt� sai p��toiminnot testattua k�tev�mmin,
kuin luomastani JFramen aliluokasta SudokuFrame.

Automaattista testausta ei siis ole toteutettu luokille: 
- Kayttoliittyma
- SudokuFrame
- MenuNappulaKuuntelija
- SyoteKuuntelija

Koska k�ytt�liittym�� ei testattu automaattisesti, testailin sit� k�sin pelaillen useampaan otteeseen, 
kokeillen eri vaikeustasoja ja sy�tt�en esimerkiksi monesti saman numeron sudokuruutuun, tai poistaen ja sy�tt�en 
v��ri� sy�tteit�. 
K�ytt�liittym�ss� sudokuruukon ruudut ovat JTextFrameja.

Monta bugia paljastuikin n�in satunnaisia asioita sy�ttelem�ll� k�ytt�liittym��n: 

- jos ruutuun asetti kahdesti oikean numeron, siit� tulikin v��r�, sill� t�ll�inh�n numero oli jo rivill�/sarakkeella/aliruudukossa, koska se juuri asetettiin sinne aikaisemmin

- peli pelattiin loppuun,sudoku ratkesi ja SudokuFrame luokan metodi sulki kaikki ruudut ruudukossa ja kun uusi peli t�st� aloitettiin, kaikki ruudut olivat viel�kin lukossa

- yhdess� vaiheessa sy�tteen kuuntelijana oli KeyListener, mutta se ei pysynyt per�ss� sy�tteen muutoksien kanssa ja esimerkiksi kaksimerkkinen sy�te kelpasi ja saattoi n�ytt�� vihre�t�kin,
 jos sy�tteen ensimm�inen merkki sopi ruutuun


T�ll� hetkell� sudokuruudukon ruutuun voi sy�tt�� my�s kirjaimia tai muita merkkej�, jotka eiv�t ole sopivia, mutta enteri� painaessa ne hyl�t��n eiv�tk� ne vaikuta peliin.
