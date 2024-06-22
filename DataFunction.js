const airportData = [
  {
    id: 1,
    name: "Dallas/Fort Worth International Airport",
    code: "LDZ",
  },
  {
    id: 2,
    name: "Tokyo Haneda Airport",
    code: "UPI",
  },
  {
    id: 3,
    name: "Heathrow Airport",
    code: "KWD",
  },
  {
    id: 4,
    name: "Heathrow Airport",
    code: "JGF",
  },
  {
    id: 5,
    name: "Dallas/Fort Worth International Airport",
    code: "CXM",
  },
  {
    id: 6,
    name: "Denver International Airport",
    code: "EKV",
  },
  {
    id: 7,
    name: "Tokyo Haneda Airport",
    code: "ZGS",
  },
  {
    id: 8,
    name: "Hartsfield-Jackson Atlanta International Airport",
    code: "CHF",
  },
  {
    id: 9,
    name: "Los Angeles International Airport",
    code: "RNN",
  },
  {
    id: 10,
    name: "Sydney Kingsford Smith Airport",
    code: "TGY",
  },
];

const aircraftData = [
  {
    id: 1,
    type: "Boeing 747",
    airlineName: "United Airlines",
    maxCapacity: 150,
    airportId: 1,
  },
  {
    id: 2,
    type: "Cessna 172",
    airlineName: "Singapore Airlines",
    maxCapacity: 312,
    airportId: 10,
  },
  {
    id: 3,
    type: "Airbus A320",
    airlineName: "Emirates",
    maxCapacity: 127,
    airportId: 10,
  },
  {
    id: 4,
    type: "Bombardier CRJ",
    airlineName: "Lufthansa",
    maxCapacity: 193,
    airportId: 4,
  },
  {
    id: 5,
    type: "Bombardier CRJ",
    airlineName: "Delta Airlines",
    maxCapacity: 216,
    airportId: 3,
  },
  {
    id: 6,
    type: "Bombardier CRJ",
    airlineName: "British Airways",
    maxCapacity: 29,
    airportId: 6,
  },
  {
    id: 7,
    type: "Embraer E190",
    airlineName: "Qatar Airways",
    maxCapacity: 406,
    airportId: 3,
  },
  {
    id: 8,
    type: "Cessna 172",
    airlineName: "Singapore Airlines",
    maxCapacity: 209,
    airportId: 2,
  },
  {
    id: 9,
    type: "Embraer E190",
    airlineName: "Qatar Airways",
    maxCapacity: 269,
    airportId: 7,
  },
  {
    id: 10,
    type: "Airbus A320",
    airlineName: "Lufthansa",
    maxCapacity: 62,
    airportId: 2,
  },
];

const cityData = [
  {
    id: 1,
    name: "New York",
    state: "North Carolina",
    population: 516456,
  },
  {
    id: 2,
    name: "Dallas",
    state: "Ohio",
    population: 914443,
  },
  {
    id: 3,
    name: "Los Angeles",
    state: "Georgia",
    population: 917285,
  },
  {
    id: 4,
    name: "Boston",
    state: "California",
    population: 434137,
  },
  {
    id: 5,
    name: "Las Vegas",
    state: "North Carolina",
    population: 452079,
  },
  {
    id: 6,
    name: "San Diego",
    state: "Illinois",
    population: 28963,
  },
  {
    id: 7,
    name: "Orlando",
    state: "California",
    population: 632535,
  },
  {
    id: 8,
    name: "Miami",
    state: "Ohio",
    population: 667071,
  },
  {
    id: 9,
    name: "Kansas",
    state: "Florida",
    population: 608315,
  },
  {
    id: 10,
    name: "Chicago",
    state: "Illinois",
    population: 138638,
  },
];

const passengerData = [
  {
    id: 1,
    firstName: "David",
    lastName: "Taylor",
    phoneNumber: "515-688-2170",
    homeCityId: 1,
  },
  {
    id: 2,
    firstName: "Bob",
    lastName: "Davis",
    phoneNumber: "168-134-7735",
    homeCityId: 2,
  },
  {
    id: 3,
    firstName: "Hannah",
    lastName: "Wilson",
    phoneNumber: "177-785-8020",
    homeCityId: 3,
  },
  {
    id: 4,
    firstName: "Bob",
    lastName: "Jones",
    phoneNumber: "131-434-0003",
    homeCityId: 4,
  },
  {
    id: 5,
    firstName: "Grace",
    lastName: "Moore",
    phoneNumber: "793-463-6500",
    homeCityId: 5,
  },
  {
    id: 6,
    firstName: "David",
    lastName: "Miller",
    phoneNumber: "318-884-6252",
    homeCityId: 6,
  },
  {
    id: 7,
    firstName: "David",
    lastName: "Smith",
    phoneNumber: "654-647-0835",
    homeCityId: 7,
  },
  {
    id: 8,
    firstName: "Grace",
    lastName: "Davis",
    phoneNumber: "511-086-6829",
    homeCityId: 8,
  },
  {
    id: 9,
    firstName: "Alice",
    lastName: "Johnson",
    phoneNumber: "557-556-1915",
    homeCityId: 9,
  },
  {
    id: 10,
    firstName: "Jack",
    lastName: "Miller",
    phoneNumber: "740-826-7353",
    homeCityId: 10,
  },
];

const flightData = [
  {
    id: 1,
    date: "8/2/2024",
    expDeparture: "9:00 AM",
    expArrival: "9:00 AM",
    fromAirportId: 9,
    toAirportId: 4,
    aircraftId: 9,
    passengerId: 4,
  },
  {
    id: 2,
    date: "6/30/2024",
    expDeparture: "6:15 PM",
    expArrival: "1:20 PM",
    fromAirportId: 3,
    toAirportId: 6,
    aircraftId: 9,
    passengerId: 5,
  },
  {
    id: 3,
    date: "8/15/2024",
    expDeparture: "9:00 AM",
    expArrival: "6:15 PM",
    fromAirportId: 5,
    toAirportId: 6,
    aircraftId: 1,
    passengerId: 3,
  },
  {
    id: 4,
    date: "7/2/2024",
    expDeparture: "9:00 AM",
    expArrival: "6:15 PM",
    fromAirportId: 8,
    toAirportId: 10,
    aircraftId: 4,
    passengerId: 7,
  },
  {
    id: 5,
    date: "3/8/2024",
    expDeparture: "1:20 PM",
    expArrival: "9:00 AM",
    fromAirportId: 4,
    toAirportId: 3,
    aircraftId: 6,
    passengerId: 5,
  },
  {
    id: 6,
    date: "12/15/2024",
    expDeparture: "1:20 PM",
    expArrival: "6:15 PM",
    fromAirportId: 10,
    toAirportId: 7,
    aircraftId: 1,
    passengerId: 9,
  },
  {
    id: 7,
    date: "10/3/2024",
    expDeparture: "9:00 AM",
    expArrival: "3:45 AM",
    fromAirportId: 9,
    toAirportId: 9,
    aircraftId: 3,
    passengerId: 1,
  },
  {
    id: 8,
    date: "6/2/2024",
    expDeparture: "6:15 PM",
    expArrival: "3:45 AM",
    fromAirportId: 7,
    toAirportId: 1,
    aircraftId: 4,
    passengerId: 4,
  },
  {
    id: 9,
    date: "9/6/2024",
    expDeparture: "9:00 AM",
    expArrival: "12:30 PM",
    fromAirportId: 4,
    toAirportId: 4,
    aircraftId: 8,
    passengerId: 8,
  },
  {
    id: 10,
    date: "7/13/2024",
    expDeparture: "3:45 AM",
    expArrival: "9:00 AM",
    fromAirportId: 1,
    toAirportId: 10,
    aircraftId: 3,
    passengerId: 5,
  },
];

async function asyncAirport() {
  try {
    const response = await fetch("http://localhost:8080/airports", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(airportData),
    });

    console.log("Response status: ", response.status);
  } catch (e) {
    console.error("Error: ", e);
  }
}

async function asyncCity() {
  try {
    const response = await fetch("http://localhost:8080/cities", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(cityData),
    });

    console.log("Response status: ", response.status);
  } catch (e) {
    console.error("Error: ", e);
  }
}

async function asyncAirportToCity(cityId, airportId) {
  try {
    const response = await fetch(
      `http://localhost:8080/city/${cityId}?airport=${airportId}`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
        body: JSON.stringify(airportData, cityData),
      }
    );

    console.log("Response status: ", response.status);
  } catch (e) {
    console.error("Error: ", e);
  }
}

async function asyncAircraft() {
  try {
    const response = await fetch("http://localhost:8080/aircraftList", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(aircraftData),
    });

    console.log("Response status: ", response.status);
  } catch (e) {
    console.error("Error: ", e);
  }
}

async function asyncPassenger() {
  try {
    const response = await fetch("http://localhost:8080/passengers", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(passengerData),
    });

    console.log("Response status: ", response.status);
  } catch (e) {
    console.error("Error: ", e);
  }
}

async function asyncFlight() {
  try {
    const response = await fetch("http://localhost:8080/flights", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(flightData),
    });

    console.log("Response status: ", response.status);
  } catch (e) {
    console.error("Error: ", e);
  }
}

asyncAirport();

async function citiesWithAirports() {
  await asyncCity();

  await asyncAirportToCity(1, 10);
  await asyncAirportToCity(2, 9);
  await asyncAirportToCity(3, 8);
  await asyncAirportToCity(4, 7);
  await asyncAirportToCity(5, 6);
  await asyncAirportToCity(6, 5);
  await asyncAirportToCity(7, 4);
  await asyncAirportToCity(8, 3);
  await asyncAirportToCity(9, 2);
  await asyncAirportToCity(10, 1);
}

citiesWithAirports();

asyncAircraft();

asyncPassenger();

asyncFlight();
