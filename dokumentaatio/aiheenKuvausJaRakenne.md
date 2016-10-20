### Aihem‰‰rittely

**Aihe** : Sudoku

Toteutetaan peli Sudoku, jonka tavoitteena on saada neliˆn(9x9 ruutua) muotoinen ruudukko t‰ytetty‰ numeroilla 1-9 siten, 
ett‰ samalla rivill‰ ja 3x3 ruutua kokoisessa ruudukossa esiintyy sama numero vain kerran. Peli selvitet‰‰n valmiina annettujen numeroiden pohjalta p‰‰tellen.

K‰ytt‰j‰t: Pelaaja/k‰ytt‰j‰

K‰ytt‰j‰n toiminnot:
- asettaa tyhj‰‰n ruutuun numero 1-9
- poistaa laittamansa numero

## Rakenteen tarkempi kuvaus

Sudokun logiikkapuoli koostuu Numeromuodostelma-rajapinnan toteuttavista luokista Rivi, Sarake(pystyrivi siis) ja Ruudukko, 
sudokun yht‰ ruutua kuvaavasta luokasta Ruutu, kaikki edell‰ mainitut pelin osaset sis‰lt‰v‰st‰ Pelialustasta ja myˆskin
pelin luovasta SudokuGeneraattori-luokasta.
Ruutu-oliolla on sijainti(eli x ja y arvot) ja arvo, eli numero v‰lilt‰ [1,9]. Alkutilanteessa ennen kuin pelaaja on asettanut numeroita
voi Ruutu-instanssin arvo olla nolla, eli ruutu on tyhj‰.  
Numeromuodostelma-rajapintaa toteuttavat oliot koostuvat aina yhdeks‰st‰ Ruutu-oliosta, jotka on talletettu kunkin Numeromuodostelman omaan ArrayList:iin.
Pelialusta luo ja tiet‰‰ kaikki Ruudut ja Numeromuodostelmat. Pelialustan kautta tapahtuu pelaajan ruutuun asettaman arvon oikeellisuuden tarkistus ja oikeellisen
arvon asetus Ruutu-olioon.
SudokuGeneraattori ottaa konstruktorin parametrin‰ Pelialustan(jossa siis Ruuduissa ei valmiita arvoja, kaikki nollaa) ja konstruktorissa tehd‰‰n uusi t‰ytett‰v‰
sudokupeli niin monesti, ett‰ sille on SudokuTarkastaja-luokan mukaan ainakin yksi ratkaisu. Generaattoriluokan metodi getAlusta() palauttaa Pelialustan 
valmiiden numeroiden kera k‰yttˆliittym‰‰n pelattavassa kunnossa, eli osa Ruuduista t‰ytettyn‰ ja osa tyhj‰n‰ pelaajan t‰ytett‰viss‰. 

### Luokkakaavio

![Luokkakaavio] (http://yuml.me/ec10cbd8.png)

### Sekvenssikaavioita
![Sekvenssikaavio tapahtumasta "Ep‰onnistunut arvon asetus"] (https://github.com/roosmeri/MightySudoku/blob/master/dokumentaatio/sekvenssi2.2.png?raw=true)
![Sekvenssikaavio tapahtumasta "Onnistunut arvon asetus"] (https://github.com/roosmeri/MightySudoku/blob/master/dokumentaatio/sekvenssi1.2.png?raw=true)