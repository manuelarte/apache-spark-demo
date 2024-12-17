# Apache Spark Demo

Demo on how to use Apache Spark to calculate the dividends per company.
It reads the file [dividends.csv](./src/main/resources/dividends.csv), group them by company and sums up the dividends.

## How to run it

Build the jar
> ./gradlew shadowJar

Run
> ./gradlew run

You should see the following console output:
```
BBVA: DividendsRow(company=BBVA, amount=2492.37)
TELEFONICA: DividendsRow(company=TELEFONICA, amount=1350.84)
ENAGAS: DividendsRow(company=ENAGAS, amount=3001.28)
REPSOL: DividendsRow(company=REPSOL, amount=1340.64)
SANTANDER: DividendsRow(company=SANTANDER, amount=1056.84)
RED ELECTRICA: DividendsRow(company=RED ELECTRICA, amount=1148.29)
ENDESA: DividendsRow(company=ENDESA, amount=955.00)
EBRO FOODS: DividendsRow(company=EBRO FOODS, amount=819.18)
MAPFRE: DividendsRow(company=MAPFRE, amount=1546.46)

```
