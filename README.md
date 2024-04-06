DATA1700 &ndash; Oblig 3
========================
OsloMet-brukernavn: alope0420

GitHub-brukernavn: alope0420

GitHub-repo URL: https://github.com/alope0420/data1700-oblig3

GitHub Pages (kun frontend): https://alope0420.github.io/data1700-oblig3/src/main/resources/static/

YouTube demonstration: https://youtu.be/VhhrzIPbYlo

Fullt navn: Alexander Benjamin Rød Opedal

Kort beskrivelse av applikasjon:<br>
Enkel applikasjon for kjøp av kinobilletter.
Frontenden består av HTML/CSS/JS
    og er stylet med Bootstrap for et responsivt og moderne design,
    mens backenden er Java-basert og kjører Spring Boot.

Brukeren velger film og antall billetter, oppgir litt personalia og trykker på &laquo;Kjøp billetter&raquo;.
Før innsending blir inndataene validert, og Bootstrap brukes til å markere eventuelle feil og mangler i rødt.
Det er egne tilleggsvalideringer for
    antall,
    telefonnummer
    og e-postadresse.
Hvis valideringen lykkes, blir dataene lagret i et objekt som sendes til backenden med en POST-forespørsel.
Backenden mottar billettobjektet via en RestController
    og lagrer det i et JpaRepository som utfører en INSERT-spørring mot H2-databasen.
Når frontenden får beskjed om at forespørselen var vellykket,
    sender den en GET-forespørsel for å hente ut den oppdaterte billett-tabellen fra databasen.
Denne mates så ut i en tabell nederst på nettsiden,
    og skjemaet tømmes, slik at brukeren kan gjøre en ny bestilling.
Brukeren kan trykke på &laquo;Slett alle billettene&raquo;
    for å sende en POST-forespørsel som medfører sletting av alle radene i databasen, og dermed også tabellen.

Utover kravene i oppgaveteksten har applikasjonen også følgende:
* Responsiv design
* Bootstrap &laquo;toasts&raquo; som gir tilbakemelding om vellykkede/mislykkede forespørsler
* Listen over filmer er kun lagret i databasen og blir hentet under innlasting av siden
* Knapp for mørk modus
* Knapp for automatisk utfylling av dummy-data i skjemaet (for testformål)
* Modal dialogboks for bekreftelse før sletting av alle billettene
* Innstillingsmeny som åpnes i et Bootstrap &laquo;offcanvas&raquo;
  * Denne inneholder en bryter for å deaktivere valideringene på frontenden, slik at man også kan teste valideringene på backenden