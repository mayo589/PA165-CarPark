
#CarPark Rest API for Car entity

#Get all cars
curl -i -X GET http://localhost:8080/pa165/rest/car

#Get car by ID
curl -i -X GET http://localhost:8080/pa165/rest/car/id/1

#Get car by VIN
curl -i -X GET http://localhost:8080/pa165/rest/car/vin/XCR-DFWRTJJH446ASF

#Add a new car
curl -X POST -i -H "Content-Type: application/json" --data '{"vin" : "XRE-159TRY1555", "color" : "cyan", "model" : "BMW M5"}' http://localhost:8080/pa165/rest/car/create

