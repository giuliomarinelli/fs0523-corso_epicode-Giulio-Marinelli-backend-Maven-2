-- Estrai tutti i clienti con nome Mario
SELECT * FROM clienti WHERE nome = 'Mario';

-- Estrai nome e cognome dei clienti nati nel 1982
SELECT nome, cognome FROM clienti WHERE anno_di_nascita = 1982;

-- Estrai il numero delle fatture con iva al 20%
SELECT * FROM fatture WHERE iva = 20;

-- Estrarre i prodotti attivati nel 2017 e che sono in produzione oppure in commercio (Per estrarre l’anno da una data si può usare
SELECT * FROM prodotti WHERE EXTRACT(YEAR FROM data_attivazione) = 2017 AND (in_produzione = true OR in_commercio = true);

-- Estrarre le fatture con importo inferiore a 1000 e i dati dei clienti ad esse collegate
SELECT * FROM fatture f INNER JOIN clienti c ON f.id_cliente = c.numero_cliente WHERE f.importo < 1000;

-- Riportare l’elenco delle fatture (numero, importo, iva e data) con in aggiunta il nome del fornitore
SELECT f.numero_fattura, f.importo, f.iva, f.data_fattura, fo.denominazione
	FROM fatture f INNER JOIN fornitori fo ON f.numero_fornitore = fo.numero_fornitore

-- Considerando soltanto le fatture con iva al 20 per cento, estrarre il numero di fatture per ogni anno (Per estrarre l’anno da una data si può usare EXTRACT(YEAR FROM data)
SELECT COUNT(*), EXTRACT(YEAR FROM data_fattura) FROM fatture WHERE iva = 20 GROUP BY EXTRACT(YEAR FROM data_fattura)

-- Riportare il numero di fatture e la somma dei relativi importi divisi per anno di fatturazione
SELECT EXTRACT (YEAR FROM data_fattura), COUNT(*), SUM(importo) FROM fatture GROUP BY EXTRACT (YEAR FROM data_fattura) ORDER BY EXTRACT (YEAR FROM data_fattura)

--Estrarre gli anni in cui sono state registrate più di 2 fatture con tipologia ‘A’
SELECT EXTRACT(YEAR FROM data_fattura) FROM fatture GROUP BY EXTRACT(YEAR FROM data_fattura), tipologia HAVING COUNT(*) > 2 AND tipologia = 'A';

-- Estrarre il totale degli importi delle fatture divisi per residenza dei clienti
SELECT SUM(f.importo), c.regione_residenza FROM fatture f INNER JOIN
	clienti c ON f.id_cliente = c.numero_cliente GROUP BY c.regione_residenza