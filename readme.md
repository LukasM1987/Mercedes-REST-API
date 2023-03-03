# Mercedes-Benz REST-API
> Use this application to create your own Mercedes.

## Table contest
* [How to download](#How-to-download)
* [How to run](#How-to-run)
* [JSON objects](#JSON-objects)
* [URL addresses](#URL-addresses)
* [How add cars to the order](#How-add-cars-to-the-order) 
* [Used technologies](#Used-technologies)
* [Contact](#contact)

## How to download
> Follow this steps:
- step 1 - If you don't have a Git you can download it from [_here_](https://git-scm.com/downloads)
- step 2 - Click right button mouse on place where you want put the project on disk
- step 3 - Use `Git Bash Here` command and paste this repository command: `git clone https://github.com/LukasM1987/Mercedes-REST-API`

## How to run
> Follow this steps:
- step 1 - Run application by using green triangle button on the top of IDE
- step 2 - Use a `Postman` application to get results
- step 3 - Paste `JSON` objects into `Postman` body, you will find objects below

## JSON objects
> Here are examples of `JSON` objects:
>### Color object
>`{
"colorName": "Black",
"price": 99.99
}`
>### Drive object
>`{
"type": "Rear wheels",
"price": 99.99
}`
>### Seat object
>`{
"type": "Heated",
"material": "Leather",
"color": "Black",
"price": 99.99
}`
>### Engine object
>`{
"type": "V6",
"hp": 354,
"price": 99.99
}`
>### Gear box object
> `{
"type": "Automatic",
"gearsQuantity": 5,
"price": 99.99
}`
>### Model object
> `{
"carClass": "C-Class",
"type": "Sedan",
"price": 99.99
}`
>### Engine exemplar object
>`{
"serialNumber": "3742848234672DSFG7",
"available": true,
"engineId": 1
}`
>### Gear box exemplar object
>`{
"serialNumber": "FJDJG8374FKGh37058",
"available": true,
"gearBoxId": 1
}`
>### Model exemplar object
>`{
"vin": "SDJFH5627SDFJ34874SFH",
"available": true,
"modelId": 1
}`
>### Car object
>`{
"available": true,
"modelExemplarId" : 1,
"engineExemplarId" : 1,
"gearBoxExemplarId" : 1,
"colorId" : 1,
"driveId" : 1,
"seatId" : 1
}`
>### User Object
>`{
"pesel": "provide your pesel here",
"name": "provide your name here",
"secondName": "provide your second name here",
"city": "provide your city here",
"street": "provide your street here if exist or provide null",
"house": "provide your house here",
"local": "provide your local here if exist or provide null"
}`
>### Order object
>`{
"userId": 1
}`
## URL addresses
>Color:
- Add color: `http://localhost:8080/colors/addColor`
- Get color: `http://localhost:8080/colors/getColor?id=1`
- Get colors: `http://localhost:8080/colors/getColors`
- Get color by name: `http://localhost:8080/colors/getColorByName?name=color_name`
- Delete color: `http://localhost:8080/colors/deleteColor?id=1`

>Drive:
- Add drive: `http://localhost:8080/drives/addDrive`
- Get drive: `http://localhost:8080/drives/getDrive?id=1`
- Get drives: `http://localhost:8080/drives/getDrives`
- Delete drive: `http://localhost:8080/drives/deleteDrive?id=1`

>Seat:
- Add seat: `http://localhost:8080/seats/addSeat`
- Get seat by id: `http://localhost:8080/seats/getSeatById?id=1`
- Get seat by type: `http://localhost:8080/seats/getSeatByType?type=seat_type`
- Get seats: `http://localhost:8080/seats/getSeats`
- Delete seat: `http://localhost:8080/seats/deleteSeat?id=1`

>Engine:
- Add engine: `http://localhost:8080/engines/addEngine`
- Get engine: `http://localhost:8080/engines/getEngine?id=1`
- Get engines: `http://localhost:8080/engines/getEngines`
- Delete engine: `http://localhost:8080/engines/deleteEngine?id=1`

>Gear box:
- Add gear box: `http://localhost:8080/gearBoxes/addGearBox`
- Get gear box: `http://localhost:8080/gearBoxes/getGearBox?id=1`
- Get gear boxes: `http://localhost:8080/gearBoxes/getGearBoxes`
- Delete gear box: `http://localhost:8080/gearBoxes/deleteGearBox?id=1`

>Model:
- Add model: `http://localhost:8080/models/addModel`
- Get model: `http://localhost:8080/models/getModel?id=1`
- Get models: `http://localhost:8080/models/getAllModels`
- Delete model: `http://localhost:8080/models/deleteModel?id=1`

>Engine exemplar:
- Add engine exemplar: `http://localhost:8080/engineExemplars/addEngineExemplar`
- Get engine exemplar by id: `http://localhost:8080/engineExemplars/getEngineExemplarById?id=1`
- Get engine exemplars: `http://localhost:8080/engineExemplars/getEnginesExemplars`
- Get engine exemplar by serial number: `http://localhost:8080/engineExemplars/getEngineExemplarBySerialNumber?serialNumber=serial_number`
- Get engine exemplar by available: `http://localhost:8080/engineExemplars/getEngineExemplarByAvailable?available=true`
- Update engine exemplar: `http://localhost:8080/engineExemplars/updateEngineExemplar`
- Delete engine exemplar: `http://localhost:8080/engineExemplars/deleteEngineExemplar?id=1`

>Gear box exemplar:
- Add gear box exemplar: `http://localhost:8080/gearBoxesExemplars/addGearBoxExemplar`
- Get gear box exemplar by id: `http://localhost:8080/gearBoxesExemplars/getGearBoxExemplarById?id=1`
- Get gear box exemplars: `http://localhost:8080/gearBoxesExemplars/getGearBoxesExemplars`
- Get gear box exemplar by serial number: `http://localhost:8080/gearBoxesExemplars/getGearBoxExemplarBySerialNumber?serialNumber=serial_number`
- Get gear box exemplar by available: `http://localhost:8080/gearBoxesExemplars/getGearBoxExemplarByAvailable?available=true`
- Update gear box exemplar: `http://localhost:8080/gearBoxesExemplars/updateGearBoxExemplar`
- Delete gear box exemplar: `http://localhost:8080/gearBoxesExemplars/deleteGearBoxExemplar?id=1`

>Model exemplar:
- Add model exemplar: `http://localhost:8080/modelExemplars/addModelExemplar`
- Get model exemplar by id: `http://localhost:8080/modelExemplars/getModelExemplarById?id=1`
- Get model exemplars: `http://localhost:8080/modelExemplars/getModelsExemplars`
- Get model exemplar by serial number: `http://localhost:8080/modelExemplars/getModelExemplarBySerialNumber?serialNumber=serial_number`
- Get model exemplar by available: `http://localhost:8080/modelExemplars/getModelExemplarByAvailable?available=true`
- Update model exemplar: `http://localhost:8080/modelExemplars/updateModelExemplar`
- Delete model exemplar: `http://localhost:8080/modelExemplars/deleteModelExemplar?id=1`

>Car:
- Add car: `http://localhost:8080/cars/addCar`
- Get car: `http://localhost:8080/cars/getCar?id=1`
- Delete car: `http://localhost:8080/cars/getCar?id=1`

>User:
- Add user: `http://localhost:8080/users/addUser`
- Get user by id: `http://localhost:8080/users/getUserById?id=1`
- Get user by pesel: `http://localhost:8080/users/getUserByPESEL?pesel=your_pesel`
- Get users: `http://localhost:8080/users/getUsers`
- Delete user: `http://localhost:8080/users/deleteUser`

>Order:
- Add order: `http://localhost:8080/orders/addOrder`
- Get Order: `http://localhost:8080/orders/getOrder?id=1`
- Delete Order: `http://localhost:8080/orders/deleteOrder?id=1`

## How add cars to the order
> Follow this step:
- step 1 - Paste this url address: `http://localhost:8080/orders/addCarToTheOrder?orderId=1&carId=1` into `Postman` bar
- step 2 - Chose `PUT` method on left site of the bar
- step 3 - Click `Send` button on the right

## Used Technologies
- Java 11
- Spring Boot
- SpringWEB
- Hibernate
- MySQL
- Postman
- Junit 4
- Lombok

## Contact
> Created by [Lukasz Marchel](https://lukasm1987.github.io/My-Web-Site/) - feel free to contact me!