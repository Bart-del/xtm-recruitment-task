# XTM Recruitment Task Poznań 2021


### English below


## Spis Treści
* [O projekcie](#o-projekcie)
* [Technologie](#technologie)
* [Instalacja](#instalacja)
* [Jak to działa?](#jak-to-działa)
* [Potencjalne kierunki rozwoju](#potencjalne-kierunki-rozwoju)
* [Uwaga](#uwaga)

## O projekcie

Projekt powstał w ramach zadania rekrutacyjnego na stanowisko Intern Java Developer w firmie XTM. Zadanie brzmiało:

```
Opracuj backend prostej wypożyczalni samochodów.

Aplikacja powinna umożliwiać:
- dodanie nowego samochodu do oferty wypożyczalni
- usunięcie samochodu z oferty wypożyczalni
- edytowanie danych samochodu
- wypożyczenie samochodu przez klienta (tylko jeden klient może wypożyczyć ten sam samochód w danym momencie)
- oddanie wypożyczonego samochodu

Mile widziane:
użycie bazy danych

Aplikacja powinna posiadać REST API oraz uruchamiać się bez błędów. Pamiętaj również o testach jednostkowych i integracyjnych!

```

Wszystkie wymagania projektu zostały zrealizowane, a kod udostępniam na swoim koncie GitHub.

## Technologie

W projekcie użyłem następujących technologii:

* Java w wersji 17
* Framework Spring w wersji 2.6.1
* Spring Web do stworzenia REST API
* Spring Data JPA do integracji aplikacji z bazą danych Remote MySQL
* Lombok do ograniczenia boilerplate code
* AssertJ do testów

## Instalacja

Instalacja może przebiegać w różny sposób, w zależności od dostepnego środowiska. W przypadku tradycyjnych serwerów, na przykład tomcat najprostrzym sposobem jest:

* pobranie wygenrowanego pliku war,
* przeniesienie go do folderu tomcat/webapps/
* z poziomu terminala w folderze tomcat/bin uruchomić polecenie "catalina.bat run" w systemie Windows, natomiast w systemach Unixowych "catalina.sh run"

Jeżeli chcesz tylko przetestować projekt możesz również pobrać kod źródłowy i uruchomić aplikację w swoim IDE.

## Jak to działa?

Po instalacji i uruchomieniu aplikacji na serwerze użytkownik ma możliwość:
* dodania samochodu do oferty wypożyczalni
* usunięcia samochodu z oferty wypożyczalni
* modyfikacji danych samochodu
* wypożyczenie samochodu
* oddanie samochodu z wypożyczenia

Może to robić poprzez endpointy:
```
/cars/{id}
```
oraz
```
/cars/rent/{id}
/cars/return_rented_car/{id}
```

Aplikacja umieszcza i modyfikuje dane w bazie postawionej na remotemysql.com.

API zostało napisane w ramach zasad REST. Dlatego wywołanie konkretnej metody zależy od wybranej metody HTPP.

## Potencjalne kierunki rozwoju

Projekt w obecnym stanie nie jest zbyt rozbudowany, jednak może stanowić dobrą bazę do dalszego rozwoju. Przyszłe potencjalne funkcje mogą obejmować:
* Rozbudowa encji samochodu o dodatkowe dane,
* Stworzenie encji reprezentujej klientów,
* Zabezpieczenie backendu za pomocą Spring Security,
* Dodanie kolejnych funkcji biznesowych

## Uwaga

Hasło do bazy danych zostało umieszczone w pliku application.properties. 
Zdaję sobie sprawę z tego, że jest to ZŁA PRAKTYKA i ogólnie rzeczy biorąc nie należy tak robić. Na potrzeby tego niewielkiego projektu 
uznałem jednak, że ułatwi to podgląd działania kodu osobie, która będzie go weryfikować.


## Table of contents
* [General info](#about-project)
* [Technologies](#technologies)
* [Setup](#setup)
* [How it works](#how-it-works)
* [Future development](#future-development)

## About project

The project was created as part of a recruitment task for the position of Intern Java Developer at XTM. The task was:
```
Develop the backend of a simple car rental company.

The application should enable:
- adding a new car to the rental company's offer
- removing the car from the rental company's offer
- editing car data
- car rental by a customer (only one customer can rent the same car at a time)
- return of the rented car

Welcome:
database usage

The application should have REST API and run without errors. Also remember about unit and integration tests!
```

All project requirements have been fulfilled and the code is available on my GitHub account.

## Technologies

In the project, I used the following technologies:

* Java version 17
* Framework Spring version 2.6.1
* Spring Web to create a REST API
* Spring Data JPA to integrate the application with the Remote MySQL database
* Lombok to limit the boilerplate code
* AssertJ for testing

## Setup

Installation can take different steps depending on the available environment. For traditional servers, such as tomcat, the easiest way is to:

* download a generated war file,
* moving it to the tomcat / webapps / folder
* from the terminal level in the tomcat / bin folder run the command "catalina.bat run" in Windows, and in Unix systems "catalina.sh run"

If you just want to test the project, you can also download the source code and run the application in your IDE.

## How it works?

After installing and running the application on the server, the user has the option to:
* adding a car to the rental offer
* removing the car from the rental company's offer
* car data modification
* car rental
* returning the car from the rental

It can do this through endpoints:
```
/cars/{id}
```
and
```
/cars/rent/{id}
/cars/return_rented_car/{id}
```
The application places and modifies data in the database set on remotemysql.com

The API was written under the REST rules. Therefore, calling a particular method depends on the selected HTPP method.

## Future development

The project in its current state is not very extensive, but it can be a good basis for further development. Future potential features may include:
* Expansion of the car entity with additional data,
* Create an entity to represent clients,
* Backend protection with Spring Security,
* Adding more business functions

## Note

The database password has been placed in the application.properties file. I realize that this is BAD PRACTICE and, in general, you shouldn't do it. For the purposes of this small project, however, 
I decided that it would make it easier for the person who will verify the code to see how the code works.