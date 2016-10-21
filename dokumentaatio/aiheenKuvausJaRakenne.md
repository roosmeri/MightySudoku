### Aihemäärittely

**Aihe** : Sudoku

Toteutetaan peli Sudoku, jonka tavoitteena on saada neliön(9x9 ruutua) muotoinen ruudukko täytettyä numeroilla 1-9 siten, 
että samalla rivillä ja 3x3 ruutua kokoisessa ruudukossa esiintyy sama numero vain kerran. Peli selvitetään valmiina annettujen numeroiden pohjalta päätellen.
Peli ei ole täysin klassinen sudoku, sillä sen luomilla sudoku-peleillä voi olla useampi kuin yksi ratkaisu.

Käyttäjät: Pelaaja/käyttäjä

Käyttäjän toiminnot:
- asettaa tyhjään ruutuun numero 1-9
- poistaa laittamansa numero

## Rakenteen tarkempi kuvaus

Sudokun logiikkapuoli koostuu Numeromuodostelma-rajapinnan toteuttavista luokista Rivi, Sarake(pystyrivi siis) ja Ruudukko, 
sudokun yhtä ruutua kuvaavasta luokasta Ruutu, kaikki edellä mainitut pelin osaset sisältävästä Pelialustasta ja myöskin
pelin luovasta SudokuGeneraattori-luokasta.

Ruutu-oliolla on sijainti(eli x ja y arvot) ja arvo, eli numero väliltä [1,9]. Alkutilanteessa ennen kuin pelaaja on asettanut numeroita
voi Ruutu-instanssin arvo olla nolla, eli ruutu on tyhjä.  

Numeromuodostelma-rajapintaa toteuttavat oliot koostuvat aina yhdeksästä Ruutu-oliosta, jotka on talletettu kunkin Numeromuodostelman omaan ArrayList:iin.
Pelialusta luo ja tietää kaikki Ruudut ja Numeromuodostelmat. Pelialustan kautta tapahtuu pelaajan ruutuun asettaman arvon oikeellisuuden tarkistus ja oikeellisen
arvon asetus Ruutu-olioon.

SudokuGeneraattori ottaa konstruktorin parametrinä Pelialustan(jossa siis Ruuduissa ei valmiita arvoja, kaikki nollaa) ja konstruktorissa tehdään uusi täytettävä
sudokupeli niin monesti, että sille on SudokuTarkastaja-luokan mukaan ainakin yksi ratkaisu. Generaattoriluokan metodi getAlusta() palauttaa Pelialustan 
valmiiden numeroiden kera käyttöliittymään pelattavassa kunnossa, eli osa Ruuduista täytettynä ja osa tyhjänä pelaajan täytettävissä. 

Käyttöliittymä koostuu JFrame-luokan perivästä SudokuFrame ikkunasta, jossa on pääkomponentteina sudokuruudukko ja muutama valikkonappula. 
Komponenteilla on omat kuuntelijaluokkansa.

### Luokkakaavio

![Luokkakaavio] (http://yuml.me/ec10cbd8.png)

### Sekvenssikaavioita
![Sekvenssikaavio tapahtumasta "Epäonnistunut arvon asetus"] (https://github.com/roosmeri/MightySudoku/blob/master/dokumentaatio/sekvenssi2.2.png?raw=true)
![Sekvenssikaavio tapahtumasta "Onnistunut arvon asetus"] (https://github.com/roosmeri/MightySudoku/blob/master/dokumentaatio/sekvenssi1.2.png?raw=true)