### Aihe:
Kahden pelaajan shakki

### Kuvaus:
Pelissä on kaksi pelaajaa, jotka yrittävät syödä toistensa nappuloita pelilaudalla, joka muodostuu 8 x 8 ruudun kokoisesta ruudukosta. Pelaajilla on käytössä 16 nappulaa, joista jokaisella nappulatyypillä on oma liikkumistapansa. Esimerkiksi torni liikkuu vaaka-ja pystysuoria linjoja kun taas lähetti liikkuu diagonaalisesti.

Toisen nappulan syöminen tapahtuu siirtämällä oma nappula ruutuun, jossa toisen pelaajan nappula on sillä hetkellä.
Pelin voittaa se pelaaja, joka pystyy ensimmäiseksi syömään toisen pelaajan kuninkaan.

### Käyttäjät:
Kuka tahansa

### Toiminnot:
- Pelinappuloiden liikuttaminen
- Vastustajan nappulan "syöminen"
- Mahdollisten siirtojen näyttäminen nappulakohtaisesti
	* Siirtäminen onnistuu vain jos pelaaja valitsee sallitun ruudun

### Käyttöohje:

#### Yleistä:
Käyttöliittymän yläpalkissa on viestilaatikko, joka kertoo kumman pelaajan vuoro on siirtää nappulaa. Viestilaatikko myös ilmoittaa, kun jompikumpi pelaajista on voittanut pelin.

#### Nappuloiden liikuttaminen:
Pelinappulan sisältämää ruutua klikattaessa käyttöliittymä värittää keltaiseksi ne ruudut mihin klikatulla nappulalla voi liikkua. Jos käyttäjä klikkaa tämän jälkeen keltaisella merkittyä ruutun, siirretään valittu nappula tähän ruutuun. Jos käyttäjä klikkaa jotain muuta ruutua, toiminto peruuntuu ja käyttäjän tulee valita uusi nappula siirrettäväksi.

#### Nappuloiden syöminen:
Syöminen tapahtuu samalla tavalla kuin liikuttaminen. Siis jos käyttöliittymä näyttää keltaisella ruudun, jossa on vastustajan pelaaja, voidaan tähän ruutuun siirtyä, jolloin vastustajan nappula "syödään" pelilaudalta.

#### Pelin voittaminen:
Pelin voittaminen tapahtuu tässä vaiheessa syömällä vastustajan kuningas. Pelissä ei siis ole shakki -ja shakkimatti tarkistuksia.

#### Uuden pelin aloittaminen:
Uuden pelin voi aloittaa missä vaiheessa peliä tahansa painamalla käyttöliittymän vasemmassa yläkulmassa olevaa "uusi peli"-nappia, joka alustaa pelilaudan uudelleen.

### Rakennekuvaus:

#### Käyttöliittymä:

Käyttöliittymä koostuu seuraavista luokista: Kayttoliittyma, RuutuNappulanKuuntelija, UusiPeliNappulanKuuntelija ja KayttoliittymaTyokalut.

Kayttoliittyma-luokka kokoaa käyttöliittymän komponentit ja muodostaa käyttöliittymä-näkymän.

RuutuNappulanKuuntelija ja UusiPeliNappulanKuuntelija ovat ActionListener-rajapinnan toteuttavia luokkia, eli ne kuuntelevat käyttöliittymän nappuloihin kohdistuvia painalluksia ja suorittavat niihin liittyviä toimintoja käyttäen hyväksi Logiikka-luokkaa.

KayttoliittymaTyokalut-luokka tarjoaa yleisiä käyttöliittymän päivittämiseen liittyviä metodeja, esim. käyttöliittymän shakkiruutujen värityksen ja nappula-ikonien lisäämisen ruutuihin.


#### Logiikka:

Ohjelman pelilogiikka koostuu seuraavista luokista: Logiikka, NappulanLiikuttamisLogiikka, Pelilauta, Pelaaja ja rajapinnasta Nappula, jonka toteuttaa shakkipelin eri nappula-oliot.

Pelilauta-luokka sisältää itse shakkilaudan, joka on toteutettu 8x8 taulukkona, joka sisältää Nappula-olioita. Pelilauta luokassa siis tapahtuu pelilaudan alustaminen, nappulan poistaminen taulukosta ja nappulan siirtäminen taulukon indeksistä toiseen. Pelilauta ei kuitenkaan sisällä mitään nappulan liikuttamiseen liittyvää logiikkaa.

Pelaaja-luokka sisältää yksinkertaisuudessaan tiedon siitä, mikä pelaaja on kyseessä (siis. pelaaja1 ja pelaaja2)

Nappula-rajapinnan toteuttavat luokat sisältävät yhteyden pelaaja-luokkaan. Siis nappulat tuntevat pelaajan, mutta pelaaja ei tunne nappulaa.

NappulanLiikuttamisLogiikka sisältää suurimman osan pelin toiminnasta eli nappuloiden siirtomahdollisuuksien generoimisen. Tämän luokan tehtävänä on siis palauttaa valitun nappulan mahdolliset siirtopaikat 8x8 boolean-taulukkona, jossa arvon true sisältämään indeksiin voidaan liikkua pelilaudalla ja falsella ei voida liikkua.

Logiikka-luokka yhdistää kaiken pelilogiikan yhdeksi paketiksi ja toimii eräänlaisena liitoskohtana käyttöliittymän ja pelilogiikan välillä. Se siis tuntee luokat Pelilauta ja NappulanLiikuttamisLogiikka, joiden metodeja kutsutaan, kun käyttöliittymässä painellaan nappuloita. Logiikka-luokka sisältää myös yleistä pelilogiikkaa esim. pelivuorojen vaihtamisen.


### Luokkakaavio:

![Luokkakaavio](https://raw.githubusercontent.com/sambo1111/shakki/master/dokumentointi/luokkakaavio_uusi.png)

### Sekvenssikaaviot:

#### Nappulan mahdollisten siirtopaikkojen näyttäminen käyttöliittymässä:

![Sekvenssikaavio1](https://raw.githubusercontent.com/sambo1111/shakki/master/dokumentointi/sekvenssikaavio1.png)

#### Nappulan siirtäminen:

![Sekvenssikaavio2](https://raw.githubusercontent.com/sambo1111/shakki/master/dokumentointi/sekvenssikaavio2.png)

