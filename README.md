This is my soultion for the travix problem.

It includes 3 projects:
Crazy Air API
Tough Jet API
Busy Flights API
SQL scripts to create the db structure i used for the project with some sample data



This is a working solution and can test these by sending these requests:
Crazy air:
http://localhost:9090/crazy-air/get-flights?origin=LHR&destination=AMS&departureDate=2020-02-10 00:00:00&returnDate=2020-02-19 00:00:00&passengerCount=4

Also requries a request header: api-key = p5Yvp3MKF5Xg2v9a

Tough jet:
http://localhost:8080/tough-jet/get-flights?from=LHR&to=AMS&outboundDate=2020-02-10 00:00:00&inboundDate=2020-02-19 00:00:00&numberOfAdults=4

Also requries a request header: api-key = VyC5ew2yZTdukFra

Busy Flights:
http://localhost:8282/busy-flights/get-flights?origin=LHR&destination=AMS&departureDate=2020-02-10 00:00:00&returnDate=2020-02-19 00:00:00&numberOfPassengers=4

N.B
I tried to create a dependency called Flights, this was supposed to sit between the 3 API's and would have shared common files
which would lighten the load on the other 3 projects and make it easier to add more suppliers in the future, but i was unable
to get the dependency to load on the other projects.

Also I was unable to figure out how to create unit tests to test the controllers and web client calls.
