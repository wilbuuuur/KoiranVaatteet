REST palvelut:

1. Näytä kaikki vaatteet->http://localhost:8080/rest/vaatteet
2. Lisää uusi vaate->http://localhost:8080/rest/vaatteet
3. Muokkaa vaatteita->http://localhost:8080/rest/vaatteet/{id}
4. Poista vaate->http://localhost:8080/rest/vaatteet/{id}


1. Näytä kaikki vaatteet
HTTP metodi: GET 
API kutsu: http://localhost:8080/rest/vaatteet
Request body
-
Response example below:

[{"id":2,"name":"vaate","type":"paita","price":99.99,"valmistaja":{"valmistajaid":1,"name":"Hurtta"}}]

2. Lisää uusi vaate
HTTP metodi: POST
Api kutsu: http://localhost:8080/rest/vaatteet
Request body:

[{"id":3,"name":"vaate2","type":"paita2","price":199.99,"valmistaja":{"valmistajaid":1,"name":"Hurtta"}}]

Response esimerkki (Status 200 OK):

[{"id":3,"name":"vaate2","type":"paita2","price":199.99,"valmistaja":{"valmistajaid":1,"name":"Hurtta"}}]

3. Muokkaa vaatteita

HTTP metodi: PUT

Request body:

API kutsu: http://localhost:8080/rest/vaatteet/2

[{"id":2,"name":"vaate_edit","type":"paita_edit","price":9.99,"valmistaja":{"valmistajaid":1,"name":"Hurtta"}}]

Response esimerkki (Status 200 OK):

[{"id":2,"name":"vaate_edit","type":"paita_edit","price":9.99,"valmistaja":{"valmistajaid":1,"name":"Hurtta"}}]

4.Poista vaate
HTTP metodi:DELETE

API kutsu: http://localhost:8080/rest/vaatteet/2

Request body:-

Response: Status 200 OK