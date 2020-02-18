Busy flights solution, calls the Crazy air api and Tough jet api when it's endpoint is hit
e.g. Busy Flights:
     http://localhost:8282/busy-flights/get-flights?origin=LHR&destination=AMS&departureDate=2020-02-10 00:00:00&returnDate=2020-02-19 00:00:00&numberOfPassengers=4

also in the application.properties you will find 2 API keys which are required to validate the 
request sent.