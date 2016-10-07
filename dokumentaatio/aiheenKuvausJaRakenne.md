### Aihem��rittely

**Aihe** : Sudoku

Toteutetaan peli Sudoku, jonka tavoitteena on saada neli�n(9x9 ruutua) muotoinen ruudukko t�ytetty� numeroilla 1-9 siten, 
ett� samalla rivill� ja 3x3 ruutua kokoisessa ruudukossa esiintyy sama numero vain kerran. Peli selvitet��n valmiina annettujen numeroiden pohjalta p��tellen.
Jos aihe osoittautuu turhan v�h�iseksi ty�m��r�lt��n, harkitaan ruudukon laajentamista.

K�ytt�j�t: Pelaaja/k�ytt�j�

K�ytt�j�n toiminnot:
- asettaa tyhj��n ruutuun numero 1-9
- poistaa laittamansa numero

### Luokkakaavio

![Luokkakaavio] (http://yuml.me/diagram/scruffy/class/%5BPelialusta%5D1-81%5BRuutu%5D,%20%5BRuutu%5D9-1%5BRivi%5D,%20%5BRivi%5D18-1%5BPelialusta%5D,%20%5BRuudukko%5D1-9%5BRuutu%5D,%20%5BPelialusta%5D1-9%5BRuudukko%5D,%20%5BPelialusta%5D1-9%5BSarake%5D,%20%5B%3C%3CNumeromuodostelma%3E%3E%5D%3C-.-%5BRuudukko%5D,%20%5B%3C%3CNumeromuodostelma%3E%3E%5D%3C-.-%5BRivi%5D,%20%5B%3C%3CNumeromuodostelma%3E%3E%5D%3C-.-%5BSarake%5D,%20%5BSarake%5D1-9%5BRuutu%5D)
![Sekvenssikaavio tapahtumasta "Numeron asettaminen ep�onnistuneesti"] (https://github.com/roosmeri/MightySudoku/blob/master/dokumentaatio/sekvenssi2.png?raw=true)
![Sekvenssikaavio tapahtumasta "Numeron asettaminen onnistuneesti"] (https://github.com/roosmeri/MightySudoku/blob/master/dokumentaatio/sekvenssi.png?raw=true)