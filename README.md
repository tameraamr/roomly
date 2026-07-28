# Roomly

Sistema informativo su Web per la prenotazione di aule studio e spazi coworking.
Progetto personale (di gruppo) — corso di Sistemi Informativi su Web, Roma Tre (a.a. 2025/2026).

<img width="455" height="323" alt="image" src="https://github.com/user-attachments/assets/b6c079c0-e945-4471-aa29-e2efe27d76ef" />


## Stack tecnologico

- **Backend:** Spring Boot 4.1.0 (Java 17)
- **Persistenza:** JPA / Hibernate
- **Database:** PostgreSQL
- **Frontend server-side:** Thymeleaf
- **Frontend client-side:** React (elenco aule per sede, via API REST)
- **Sicurezza:** Spring Security (autenticazione form-based, password cifrate con BCrypt)

## Modello di dominio

Sede, Aula, Prenotazione, Utente, Recensione.

## Funzionalità principali

- Consultazione pubblica di sedi e aule (capienza, dotazioni)
- Registrazione e login utenti
- Prenotazione di un'aula in una fascia oraria, con controllo automatico di sovrapposizione
- Annullamento delle proprie prenotazioni
- Recensioni delle aule
- Gestione completa (CRUD) di sedi e aule (amministratore)

## Casi d'uso implementati

- Inserimento: creazione prenotazione
- Aggiornamento: annullamento prenotazione (cambio di stato)
- Cancellazione: eliminazione aula (amministratore)
- Lettura: elenco aule, dettaglio aula con recensioni, elenco proprie prenotazioni

## Avvio del progetto

1. Creare un database PostgreSQL chiamato `roomly`
2. Configurare `src/main/resources/application.properties` con le proprie credenziali del database
3. Avviare l'applicazione (`RoomlyApplication`), disponibile su `http://localhost:8080`
