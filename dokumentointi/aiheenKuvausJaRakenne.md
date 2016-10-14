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

### Luokkakaavio:

![Luokkakaavio](https://raw.githubusercontent.com/sambo1111/shakki/master/dokumentointi/luokkakaavio_uusi.png)

### Sekvenssikaaviot:

#### Nappulan mahdollisten siirtopaikkojen näyttäminen käyttöliittymässä:

![Sekvenssikaavio1](https://raw.githubusercontent.com/sambo1111/shakki/master/dokumentointi/sekvenssikaavio1.png)

#### Nappulan siirtäminen:

![Sekvenssikaavio2](https://raw.githubusercontent.com/sambo1111/shakki/master/dokumentointi/sekvenssikaavio2.png)

