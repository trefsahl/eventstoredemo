EventSourcing
==============

Prosjektet er bygget opp rundt prinsippene bak Event Sourcing(ES) og Command Query Responsibility Segregation(CQRS).
ES => Prøve å fange intensjonen bak hver endring og kun ta vare på data som er endret.
CQRS => I praksis er det stor forskjell på datastrukturen som en klient ønsker å hente ut i forhold til datastrukturen som benyttes ved lagring. Teorien bak CQRS er at disse da også må behandles uavhengig.
For å utnytte ES til det fulle er det implementert Server Side Events (SSE) som sendes til en Angular HTML5 klient (Ikke IE9 kompatibel!)

OBS! Løsningen er implementert synkron for å gjøre den enkel å lese og debugge. En ekte ES implementasjon er asynkron og kommuniserer via kø'er!



